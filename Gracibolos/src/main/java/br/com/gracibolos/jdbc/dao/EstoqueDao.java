package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Estoque;

public class EstoqueDao implements GenericoDao<Estoque>{

	public boolean inserir(Estoque estoque) throws Exception {
		boolean status = false;
		String sql = "INSERT INTO estoque(qtd, precoUnit, venc, total, compraId, materiaPrimaId, medidaId)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		
		try{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, estoque.getQtd());
			ps.setBigDecimal(2, estoque.getPrecoUnit());
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, gravarEstaData);
			ps.setBigDecimal(4, estoque.getTotal());
			//ps.setCompra(5, estoque.getCompraId());
			//ps.setString(6, estoque.getMateriaPrimaId());
			//ps.setString(7, estoque.getMedidaId());
			
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

	public boolean alterar(Estoque estoque) throws Exception {
		boolean status = false;
		String sql = "UPDATE estoque SET qtd=?, precoUnit=?, venc=?, total=?, compraId=?, materiaPrimaId=?, medidaId=? where id=?";
		PreparedStatement  ps = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, estoque.getQtd());
			ps.setBigDecimal(2, estoque.getPrecoUnit());
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, gravarEstaData);
			ps.setBigDecimal(4, estoque.getTotal());
			//ps.setCompra(5, estoque.getCompraId());
			//ps.setString(6, estoque.getMateriaPrimaId());
			//ps.setString(7, estoque.getMedidaId());
			
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

	public boolean excluir(Estoque estoque) throws Exception {

		boolean status = false;
		
		String sql  = "DELETE FROM estoque WHERE id = ?";
		PreparedStatement ps;

		try{
			
			Connection conn = ConnectionProvider.getInstance().getConnection();			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, estoque.getId());
			
			status = ps.execute();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public List<Estoque> listar() throws Exception 
	{
		String sql = "SELECT * FROM estoque";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Estoque> listaDeEstoque= null;
		try
		{	    
			Connection conn = ConnectionProvider.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeEstoque = new ArrayList<Estoque>();
			while(rs.next())
			{
				Estoque estoque = new Estoque();
				
				estoque.setQtd(rs.getBigDecimal("qtd"));
				estoque.setPrecoUnit(rs.getBigDecimal("precoUnit"));
				estoque.setVenc(Calendar.getInstance());
				estoque.setTotal(rs.getBigDecimal("total"));
				//estoque.setCompraId(rs.getInt(""));
				//estoque.setMateriaPrimaId("");
				//estoque.setMedidaId("");
				
			
				
				listaDeEstoque.add(estoque);
				
				for(int i = 0;i<listaDeEstoque.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeEstoque.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar o estoque\n"+e);
		}
		return listaDeEstoque;
	}

	@Override
	public List<Estoque> pesquisar(String pesquisa) {
		return null;
	}

}
