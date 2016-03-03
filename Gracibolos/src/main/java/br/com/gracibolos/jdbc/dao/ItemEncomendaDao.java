package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.ItemEncomenda;


public class ItemEncomendaDao implements GenericoDao<ItemEncomenda>{

	public boolean inserir(ItemEncomenda itemEncomenda) throws Exception{
		boolean status = false;
		String sql = " INSERT INTO itemEncomenda(produtoId, encomendaId, qtd)"
				   + " VALUES (?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, itemEncomenda.getProdutoId());
			ps.setInt(2, itemEncomenda.getEncomendaId());
			ps.setInt(3, itemEncomenda.getQtd());			
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir Item da Encomenda\n"+e);
		}
		return status;
	}

	public boolean alterar(ItemEncomenda itemEncomenda) throws Exception{
		boolean status = false;
		String sql = "UPDATE itemEncomenda SET produtoId=?, encomendaId=?, qtd=? where id=?";
		PreparedStatement  ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{						
			ps = conn.prepareStatement(sql);
			ps.setInt(1, itemEncomenda.getProdutoId());
			ps.setInt(2, itemEncomenda.getEncomendaId());
			ps.setInt(3, itemEncomenda.getQtd());			
			ps.setLong(4, itemEncomenda.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar o Item da Encomenda\n"+e);
		}
		return status;
	}

	public boolean excluir(ItemEncomenda itemEncomenda) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM itemEncomenda WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, itemEncomenda.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o item da encomenda");
		}
		
		return status;
	}

	public List<ItemEncomenda> listar() throws Exception{
		String sql = "SELECT * FROM itemEncomenda";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemEncomenda> listaDeItemEncomenda= null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeItemEncomenda = new ArrayList<ItemEncomenda>();
			while(rs.next())
			{
				ItemEncomenda itemEncomenda = new ItemEncomenda();
				itemEncomenda.setId(rs.getLong("id"));
				itemEncomenda.setProdutoId(rs.getInt("produtoId"));
				itemEncomenda.setEncomendaId(rs.getInt("encomendaId"));
				itemEncomenda.setQtd(rs.getInt("qtd"));				
				
				listaDeItemEncomenda.add(itemEncomenda);
				
				for(int i = 0;i<listaDeItemEncomenda.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeItemEncomenda.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar Item da Encomenda\n"+e);
		}
		return listaDeItemEncomenda;
	}

	
	@Override
	public List<ItemEncomenda> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
