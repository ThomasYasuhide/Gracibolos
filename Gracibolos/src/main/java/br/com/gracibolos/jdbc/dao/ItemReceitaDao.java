package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaDao implements GenericoDao<ItemReceita>{

	public boolean inserir(ItemReceita itemReceita) throws Exception{
		boolean status = false;
		String sql = " INSERT INTO itemReceita(qtd, total, medidaId, materiaPrimaId, produtoId)"
				   + " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, itemReceita.getQtd());
			ps.setBigDecimal(2, itemReceita.getTotal());
			ps.setInt(3, itemReceita.getMedidaId());
			ps.setInt(4, itemReceita.getMateriaPrimaId());
			ps.setInt(5, itemReceita.getProdutoId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir item da Receita\n"+e);
		}
		return status;
	}

	public boolean alterar(ItemReceita itemReceita) throws Exception{
		boolean status = false;
		String sql = " UPDATE itemReceita SET qtd=?, total=?, medidaId=?, materiaPrimaId=?,"
				   + " produtoId=? where id=?";
		PreparedStatement  ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{		
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, itemReceita.getQtd());
			ps.setBigDecimal(2, itemReceita.getTotal());
			ps.setInt(3, itemReceita.getMedidaId());
			ps.setInt(4, itemReceita.getMateriaPrimaId());
			ps.setInt(5, itemReceita.getProdutoId());
			ps.setInt(6, itemReceita.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar item da Receita\n"+e);
		}
		return status;
	}

	public boolean excluir(ItemReceita itemReceita) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM itemReceita WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, itemReceita.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o itemReceita");
		}
		
		return status;
	}

	public List<ItemReceita> listar() throws Exception{
		String sql = "SELECT * FROM itemReceita";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemReceita> listaDeItemReceita= null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeItemReceita = new ArrayList<ItemReceita>();
			while(rs.next())
			{
				ItemReceita itemReceita = new ItemReceita();
				itemReceita.setId(rs.getInt("id"));
				itemReceita.setQtd(rs.getBigDecimal("qtd"));
				itemReceita.setTotal(rs.getBigDecimal("total"));
				itemReceita.setMedidaId(rs.getInt("medidaId"));
				itemReceita.setMateriaPrimaId(rs.getInt("materiaPrimaId"));
				itemReceita.setProdutoId(rs.getInt("produtoId"));
				
				listaDeItemReceita.add(itemReceita);
				
				for(int i = 0;i<listaDeItemReceita.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeItemReceita.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar item da Receita\n"+e);
		}
		return listaDeItemReceita;
	}

	
	@Override
	public List<ItemReceita> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
