package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Cidade;

public class CidadeDao {

  public List<Cidade> listar_cidades(){
    
    List<Cidade> cidades = new ArrayList<Cidade>();
    
    try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
      
      String sql = "SELECT * FROM cidade";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      while(rs.next()){
        Cidade cidade = new Cidade();
        cidade.setId(rs.getInt("id"));
        cidade.setNome(rs.getString("nome"));
        cidade.setId_estado(rs.getInt("estado"));
        
        cidades.add(cidade);
      }
      
    } catch (Exception e) {

    }
    
    return cidades;
    
  }
  
  
  public List<Cidade> pesquisar_cidades(int id){
	    
	    List<Cidade> cidades = new ArrayList<Cidade>();
	    
	    try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
	      
	      String sql = "SELECT * FROM cidade where estado = ?";
	      PreparedStatement ps = conn.prepareStatement(sql);
	      ps.setInt(1, id);
	      ResultSet rs = ps.executeQuery();
	      
	      while(rs.next()){
	        Cidade cidade = new Cidade();
	        cidade.setId(rs.getInt("id"));
	        cidade.setNome(rs.getString("nome"));
	        cidade.setId_estado(rs.getInt("estado"));
	        
	        cidades.add(cidade);
	      }
	      
	    } catch (Exception e) {

	    }
	    
	    return cidades;
	    
	  }
  
}
