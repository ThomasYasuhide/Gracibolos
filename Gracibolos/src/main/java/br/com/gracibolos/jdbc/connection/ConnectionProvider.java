package br.com.gracibolos.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String addr = "localhost";
    private final String db = "gracibolos";   
    private final String username = "root";
    private final String password = "";
    
    private static ConnectionProvider instance = null;
    
	private static void ConnectionProvider() {
    	
    }
    
    public Connection getConnection(){
        Connection conn = null;
		
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:mysql://"+ addr +"/"+db,username,password);
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível encontrar a classe ConnectionProvider.");
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar-se ao banco.");
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