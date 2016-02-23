package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteDao implements GenericoDao<Suporte>{

	public boolean inserir(Suporte suporte) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO suporte(codigo, status, valor, encomendaId, fornecedorId)"
				   + " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, suporte.getCodigo());			
			ps.setString(2, suporte.getStatus());
			ps.setBigDecimal(3, suporte.getValor());
			ps.setInt(4, suporte.getEncomendaId());
			ps.setInt(5, suporte.getFornecedorId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir suporte\n"+e);
		}
		return status;
	}

	public boolean alterar(Suporte suporte) throws Exception{
		boolean status = false;
		String sql = "UPDATE suporte SET codigo=?, status=?, valor=?, encomendaId=?,"
				   + " fornecedorId=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, suporte.getCodigo());			
			ps.setString(2, suporte.getStatus());
			ps.setBigDecimal(3, suporte.getValor());
			ps.setInt(4, suporte.getEncomendaId());
			ps.setInt(5, suporte.getFornecedorId());
			ps.setInt(6, suporte.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar suportes\n"+e);
		}
		return status;
	}

	public boolean excluir(Suporte suporte) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM suporte WHERE id = ?";		
		PreparedStatement ps = null;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, suporte.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o suporte");
		}
		
		return status;
	}

	public List<Suporte> listar() throws Exception{
		String sql = "SELECT * FROM suporte";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Suporte> listaDeSuporte= null;
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeSuporte = new ArrayList<Suporte>();
			while(rs.next())
			{
				Suporte suporte = new Suporte();
				suporte.setId(rs.getInt("id"));
				suporte.setCodigo(rs.getString("codigo"));
				suporte.setStatus(rs.getString("status"));
				suporte.setValor(rs.getBigDecimal("valor"));
				suporte.setEncomendaId(null);
				suporte.setFornecedorId(null);
				listaDeSuporte.add(suporte);
				
				for(int i = 0;i<listaDeSuporte.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeSuporte.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar os suportes\n"+e);
		}
		return listaDeSuporte;
	}


	@Override
	public List<Suporte> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
