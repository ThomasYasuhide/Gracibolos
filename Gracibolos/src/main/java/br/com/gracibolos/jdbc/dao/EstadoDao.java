package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Estado;

public class EstadoDao {
  
  /*
   * LISTAR ESTADO
   * Este m�todo tem como principal objetivo realizar uma consulta ao banco e retornar todos os estados.
   * 
   */	
	
  public List<Estado> listar_estados(){
	    
    List<Estado> estados = new ArrayList<Estado>();
    
    //chama uma inst�ncia da Connection e tenta realizar uma conex�o com o banco atrav�s do AutoCloseable
    try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
      
      //string query do banco	
      String sql = "SELECT * FROM estado";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      while(rs.next()){
    	
    	//da um get nos atributos do objeto estado
        Estado estado = new Estado();
        estado.setId(rs.getInt("id"));
        estado.setNome(rs.getString("nome"));
        estado.setSigla(rs.getString("uf"));
        
      //adiciona o objeto estado no arrayList
        estados.add(estado);
      }
      
      //fecha todas as conex�es
      ps.close();
      rs.close();
      conn.close();      
    } 
  //trata, caso de uma exce��o
    catch (Exception e) {

    }
  //retorna o array
    return estados;
    
  }
  
}