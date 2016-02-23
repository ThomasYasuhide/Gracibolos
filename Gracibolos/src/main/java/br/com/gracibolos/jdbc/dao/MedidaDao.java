package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaDao implements GenericoDao<Medida>{

	public boolean inserir(Medida medida) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO medida(ingrediente, medida, gramas, litros)"
				   + " VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{		
			ps = conn.prepareStatement(sql);
			ps.setString(1, medida.getIngrediente());
			ps.setString(2, medida.getMedida());			
			ps.setBigDecimal(3, medida.getGramas());
			ps.setBigDecimal(4, medida.getLitros());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir medida\n"+e);
		}
		return status;
	}

	public boolean alterar(Medida medida) throws Exception{
		boolean status = false;
		String sql = "UPDATE medida SET ingrediente=?, medida=?, gramas=?, litros=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, medida.getIngrediente());
			ps.setString(2, medida.getMedida());			
			ps.setBigDecimal(3, medida.getGramas());
			ps.setBigDecimal(4, medida.getLitros());
			ps.setInt(5, medida.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a medida\n"+e);
		}
		return status;
	}

	public boolean excluir(Medida medida) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM medida WHERE id = ?";		
		PreparedStatement ps = null;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, medida.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
	
		} 
		catch (Exception e) 
		{
			System.out.println("Houve um erro ao tentar deletar a medida");
		}
		
		return status;
	}

	public List<Medida> listar() throws Exception{
		String sql = "SELECT * FROM medida";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Medida> listaDeMedida= null;
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeMedida = new ArrayList<Medida>();
			while(rs.next())
			{
				Medida medida = new Medida();
				medida.setId(rs.getInt("id"));
				medida.setIngrediente(rs.getString("ingrediente"));
				medida.setMedida(rs.getString("medida"));
				medida.setGramas(rs.getBigDecimal("gramas"));
				medida.setLitros(rs.getBigDecimal("litros"));
				
				listaDeMedida.add(medida);
				
				for(int i = 0;i<listaDeMedida.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeMedida.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar medida\n"+e);
		}
		return listaDeMedida;
	}
	
	@Override
	public List<Medida> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
