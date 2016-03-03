package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Estoque;

public class EstoqueDao implements GenericoDao<Estoque>{

	public boolean inserir(Estoque estoque) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO estoque(materiaPrimaId, medidaId, compraId, qtd, precoUnit, venc, total)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{						
			ps = conn.prepareStatement(sql);
			ps.setInt(1, estoque.getMateriaPrimaId());
			ps.setInt(2, estoque.getMedidaId());
			ps.setInt(3, estoque.getCompraId());
			ps.setInt(4, estoque.getQtd());
			ps.setBigDecimal(5, estoque.getPrecoUnit());			
			ps.setDate(6, Date.valueOf(estoque.getVenc()));
			ps.setBigDecimal(7, estoque.getTotal());			
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir o estoque\n"+e);
		}
		return status;
	}

	public boolean alterar(Estoque estoque) throws Exception{
		boolean status = false;
		String sql = "UPDATE estoque SET materiaPrimaId=?, medidaId=?, compraId=?, qtd=?, precoUnit=?, venc=?, total=? where id=?";
		PreparedStatement  ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			ps = conn.prepareStatement(sql);
			ps.setInt(1, estoque.getMateriaPrimaId());
			ps.setInt(2, estoque.getMedidaId());
			ps.setInt(3, estoque.getCompraId());
			ps.setInt(4, estoque.getQtd());
			ps.setBigDecimal(5, estoque.getPrecoUnit());			
			ps.setDate(6, Date.valueOf(estoque.getVenc()));
			ps.setBigDecimal(7, estoque.getTotal());
			ps.setLong(8, estoque.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar o estoque\n"+e);
		}
		return status;
	}

	public boolean excluir(Estoque estoque) throws Exception{
		boolean status = false;
		
		String sql  = "DELETE FROM estoque WHERE id = ?";
		PreparedStatement ps = null;

		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, estoque.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("Erro ao deletar o estoque\n" + e);
		}
		
		return status;
	}

	public List<Estoque> listar() throws Exception
	{
		String sql = "SELECT * FROM estoque";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Estoque> listaDeEstoque= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	    			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeEstoque = new ArrayList<Estoque>();
			while(rs.next())
			{
				Estoque estoque = new Estoque();
				
				estoque.setId(rs.getLong("id"));
				estoque.setMateriaPrimaId(rs.getInt("materiaPrimaId"));
				estoque.setMedidaId(rs.getInt("medidaId"));		
				estoque.setCompraId(rs.getInt("compraId"));
				estoque.setQtd(rs.getInt("qtd"));
				estoque.setPrecoUnit(rs.getBigDecimal("precoUnit"));
				estoque.setVenc(rs.getDate("venc").toLocalDate());
				estoque.setTotal(rs.getBigDecimal("total"));
				
						
				listaDeEstoque.add(estoque);
				
				for(int i = 0; i<listaDeEstoque.size(); i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeEstoque.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar o estoque\n" + e);
		}
		return listaDeEstoque;
	}

	@Override
	public List<Estoque> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
