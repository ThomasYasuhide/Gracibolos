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
import br.com.gracibolos.jdbc.model.Compra;

public class CompraDao implements GenericoDao<Compra>{

	public boolean inserir(Compra compra) throws Exception{
		boolean status = false;
		String sql = " INSERT INTO compra(tipo, numero, data, total, fornecedorId,"
				   + " statusNome)"
				   + " VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, compra.getTipo());
			ps.setString(2, compra.getNumero());			
			Date data = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, data);			
			ps.setBigDecimal(4, compra.getTotal());
			ps.setInt(5, compra.getFornecedorId());
			ps.setString(6, compra.getStatusNome());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir compra\n"+e);
		}
		return status;
	}

	public boolean alterar(Compra compra) throws Exception{
		boolean status = false;
		String sql = "UPDATE compra SET tipo=?, numero=?, data=?, total=?,"
				   + " fornecedorId=?, statusNome=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, compra.getTipo());
			ps.setString(2, compra.getNumero());			
			Date data = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, data);			
			ps.setBigDecimal(4, compra.getTotal());
			ps.setInt(5, compra.getFornecedorId());
			ps.setString(6, compra.getStatusNome());
			ps.setInt(7, compra.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a compra\n"+e);
		}
		return status;
	}

	public boolean excluir(Compra compra) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM compra WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, compra.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o compra");
		}
		
		return status;
	}

	public List<Compra> listar() throws Exception{
		
		String sql = "SELECT * FROM compra";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Compra> listaDeCompra= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeCompra = new ArrayList<Compra>();
			while(rs.next())
			{
				Compra compra = new Compra();
				compra.setId(rs.getInt("id"));
				compra.setTipo(rs.getString("tipo"));
				compra.setNumero(rs.getString("numero"));
				compra.setData(Calendar.getInstance());
				compra.setTotal(rs.getBigDecimal("total"));
				compra.setFornecedorId(rs.getInt("fornecedorId"));
				compra.setStatusNome(rs.getString("statusNome"));
				
				listaDeCompra.add(compra);
				
				for(int i = 0;i<listaDeCompra.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeCompra.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar as compras\n"+e);
		}
		return listaDeCompra;
	}

	
	@Override
	public List<Compra> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
