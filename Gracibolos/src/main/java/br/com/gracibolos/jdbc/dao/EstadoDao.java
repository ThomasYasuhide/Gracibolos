package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Estado;

public class EstadoDao {
  
  public List<Estado> listar_estados(){
    
    List<Estado> estados = new ArrayList<Estado>();
    
    try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
      
      String sql = "SELECT * FROM estado";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      while(rs.next()){       
        Estado estado = new Estado();
        estado.setId(rs.getInt("id"));
        estado.setNome(rs.getString("nome"));
        estado.setSigla(rs.getString("uf"));
        
        estados.add(estado);
      }
      
      ps.close();
      rs.close();
      conn.close();
      
    } catch (Exception e) {

    }
    
    return estados;
    
  }
  
}