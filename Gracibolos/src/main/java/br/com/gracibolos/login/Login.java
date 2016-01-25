package br.com.gracibolos.login;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    
    public static Colaborador login(Colaborador colaborador){
        
        Connection conn = ConnectionProvider.getInstance().getConnection();
        
        String query = "select * from colaborador WHERE usuario = ? AND senha = ? AND status != 0";
               
        PreparedStatement psm;
        
        try {
            psm = conn.prepareStatement(query);
            psm.setString(1, colaborador.getUsuario());
            psm.setString(2, colaborador.getSenha());
            ResultSet rs = psm.executeQuery();
            
            if(rs.next()){
                System.out.println("Usuário encontrado");
                
                colaborador.setId(rs.getInt("id"));
                colaborador.setNome(rs.getString("nome"));
                colaborador.setNivel(rs.getByte("nivel"));
            }else {
                System.out.println("Usuário ou senha inválida");
            }
            
            rs.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Houve algum erro na consulta ao usuário");
        }
        
        return colaborador;
    }
    
}
