package br.com.gracibolos.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String addr = "localhost";
    private final String db = "gracibolos";   
    private final String username = "root";
    private final String password = "";
    
    private static ConnectionProvider instance = null;
    
	private ConnectionProvider() {
    	
    }
    
    public Connection getConnection() throws Exception {
        Connection conn = null;
		
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:mysql://"+ addr +"/"+db,username,password);
        } catch (Exception e) {
            System.out.println("Não foi possível conectar-se ao banco de dados.");
            throw new Exception("Não foi possivel conectar-se ao banco de dados.");
        }
        
        return conn;

    }
    
    public static synchronized ConnectionProvider getInstance(){
        
        if(instance == null){
            instance = new ConnectionProvider();
        }
        return instance;
        
    }
    
}