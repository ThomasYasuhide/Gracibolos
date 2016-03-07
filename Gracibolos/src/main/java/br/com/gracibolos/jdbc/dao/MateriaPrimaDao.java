package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaDao implements GenericoDao<MateriaPrima>{

	public boolean inserir(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO materiaPrima (marca, tipo, qtd, descricao, foto)"
				   + " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{		
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getMarca());
			ps.setString(2, materiaPrima.getTipo());
			ps.setBigDecimal(3, materiaPrima.getQtd());
			ps.setString(4, materiaPrima.getDescricao());
			ps.setBytes(5, materiaPrima.getFoto());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir materiaPrima\n"+e);
		}
		return status;
	}

	public boolean alterar(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		String sql = "UPDATE materiaPrima SET marca=?, tipo=?, qtd=?, descricao=?,"
				   + " foto=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getMarca());
			ps.setString(2, materiaPrima.getTipo());
			ps.setBigDecimal(3, materiaPrima.getQtd());
			ps.setString(4, materiaPrima.getDescricao());
			ps.setBytes(5, materiaPrima.getFoto());
			ps.setLong(6, materiaPrima.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a materiaPrima\n"+e);
		}
		return status;
	}

	public boolean excluir(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM materiaPrima WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, materiaPrima.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar a materiaPrima");
		}
		
		return status;
	}

	public List<MateriaPrima> listar() throws Exception{
		String sql = "SELECT * FROM materiaPrima";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MateriaPrima> listaDeMateriaPrima= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeMateriaPrima = new ArrayList<MateriaPrima>();
			while(rs.next())
			{
				MateriaPrima materiaPrima = new MateriaPrima();
				materiaPrima.setId(rs.getLong("id"));
				materiaPrima.setMarca(rs.getString("marca"));
				materiaPrima.setTipo(rs.getString("tipo"));
				materiaPrima.setQtd(rs.getBigDecimal("qtd"));
				materiaPrima.setDescricao(rs.getString("descricao"));
				materiaPrima.setFoto(rs.getBytes("foto"));
				
				listaDeMateriaPrima.add(materiaPrima);
				
				for(int i = 0;i<listaDeMateriaPrima.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeMateriaPrima.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar materiaPrima\n"+e);
		}
		return listaDeMateriaPrima;
	}

	
	@Override
	public List<MateriaPrima> pesquisar(String pesquisa) throws Exception{
		return null;
	}

}
