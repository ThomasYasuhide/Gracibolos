package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Status;

public class StatusDao implements GenericoDao<Status>{

	public boolean inserir(Status status) throws Exception{
		Boolean teste = false;
		String sql = "INSERT INTO status (nome) VALUES (?)";
		PreparedStatement ps = null;		

		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, status.getNome());
			
			if(ps.executeUpdate() != 0) {
				teste = true;
			}
			ps.close();	
			conn.close();		
		}
		catch (SQLException e) 
		{		
			System.out.println("Erro ao inserir status\n"+e);
		}
		return teste;
	}

	public boolean alterar(Status status) throws Exception{
		Boolean teste = false;
		String sql = "UPDATE status SET nome=? WHERE id=?";
		PreparedStatement ps = null;		
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, status.getNome());
			ps.setLong(2, status.getId());
			
			if(ps.executeUpdate() != 0) {
				teste = true;
			}
			ps.close();	
			conn.close();		
		}
		catch (SQLException e) 
		{		
			System.out.println("Erro ao alterar status\n"+e);
		}
		return teste;
	}

	public boolean excluir(Status status) throws Exception{
		boolean teste = false;
		String sql = "DELETE FROM status WHERE id = ?";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, status.getId());
			
			if(ps.executeUpdate() != 0){
				teste = true;
			}
			ps.close();
			conn.close();
		}
		catch (Exception e) 
		{
			System.out.println("Houve um erro ao tentar deletar a medida");
		}
		return teste;
	}

	public List<Status> listar() throws Exception{
		String sql = "SELECT * FROM status";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Status> listaDeStatus = null;
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeStatus = new ArrayList<Status>();
			while(rs.next())
			{
				Status status = new Status();
				status.setId(rs.getLong("id"));
				status.setNome(rs.getString("nome"));
				
				listaDeStatus.add(status);
				for(int i=0; i < listaDeStatus.size(); i++){
					System.out.println(listaDeStatus.get(i));    
				}				
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar medida\n"+e);
		}
		return listaDeStatus;
	}

	@Override
	public List<Status> pesquisar(String pesquisa) throws Exception{
		return null;
	}

}
