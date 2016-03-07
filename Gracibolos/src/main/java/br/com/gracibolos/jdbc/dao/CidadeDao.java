package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Cidade;

public class CidadeDao implements GenericoDao<Cidade>{

	  public List<Cidade> listar_cidades() throws Exception{
	    
	    List<Cidade> cidades = new ArrayList<Cidade>();
	    
	    try(Connection conn = ConnectionProvider.getInstance().getConnection()) 
	    {      
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
	  
	  
	  public List<Cidade> pesquisar_cidades(int id) throws Exception{
		    
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
	
	
	@Override
	public boolean inserir(Cidade cidade) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO cidade(nome, id_estado) VALUES (?, ?)";
		PreparedStatement ps = null;	
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, cidade.getNome());
			ps.setInt(2, cidade.getId_estado());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e1) 
		{
			System.out.println("Erro ao inserir cidade\n"+ e1);
		}
		return status;
	}
	
	
	@Override
	public boolean alterar(Cidade cidade) throws Exception{
		boolean status = false;
		String sql = "UPDATE cidade SET nome=?, id_estado=? where id=?";
		PreparedStatement ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, cidade.getNome());
			ps.setInt(2, cidade.getId_estado());
			ps.setInt(3, cidade.getId());
			
			if(ps.executeUpdate()!= 0){
				status = true;
			}
			ps.close();
			conn.close();		
		}
		catch (SQLException e1) 
		{
			System.out.println("Erro ao alterar as cidades\n"+e1);
		}	
		return status;
	}
	
	
	@Override
	public boolean excluir(Cidade cidade) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM cidade WHERE id = ?";
		PreparedStatement ps = null;
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cidade.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Houve um erro ao tentar deletar o cliente\n" + e);
		}
		return status;
	}
	
	
	@Override
	public List<Cidade> listar() throws Exception{
		return null;
	}
	
	
	@Override
	public List<Cidade> pesquisar(String pesquisa) throws Exception{
		return null;
	}
	  
	}
