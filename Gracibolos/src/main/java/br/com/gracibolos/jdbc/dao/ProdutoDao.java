package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoDao implements GenericoDao<Produto>{

	public boolean inserir(Produto produto) {
		boolean status = false;
		String sql = "INSERT INTO produto(nome, valor, receita, foto, produtoProntoCollection,"
				+ " itemEncomendaCollection, tipoProdutoNome, itemReceitaCollection,"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		
		try{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setBigDecimal(2, produto.getValor());
			ps.setString(3, produto.getReceita());
			ps.setBytes(4, produto.getFoto());
//			ps.setString(5, produto.getProdutoProntoCollection());
//			ps.setString(6, produto.getItemEncomendaCollection());
//			ps.setString(7, produto.getTipoProdutoNome());
//			ps.setString(8, produto.getItemEncomendaCollection());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir produto\n"+e);
		}
		return status;
	}

	public boolean alterar(Produto produto) {
		boolean status = false;
		String sql = "UPDATE cliente SET nome=?, valor=?, receita=?, foto=?, produtoProntoCollection=?,"
				+ " itemEncomendaCollection=?, tipoProdutoNome=?, itemReceitaCollection=? where id=?";
		
		PreparedStatement  ps = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setBigDecimal(2, produto.getValor());
			ps.setString(3, produto.getReceita());
			ps.setBytes(4, produto.getFoto());
//			ps.setString(5, produto.getProdutoProntoCollection());
//			ps.setString(6, produto.getItemEncomendaCollection());
//			ps.setString(7, produto.getTipoProdutoNome());
//			ps.setString(8, produto.getItemEncomendaCollection());
			ps.setInt(9, produto.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar os produtos\n"+e);
		}
		return status;
	}

	public void excluir(Integer id) {
		String sql  = "DELETE FROM produto WHERE id = ?";
		PreparedStatement ps;

		try{			
			Connection conn = ConnectionProvider.getInstance().getConnection();			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> listar() {
		
		String sql = "SELECT * FROM produto";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> listaDeProduto = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeProduto = new ArrayList<Produto>();
			while(rs.next())
			{
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setReceita(rs.getString("receita"));
				produto.setFoto(rs.getBytes("foto"));
				//produto.setProdutoProntoCollection(null);
				//produto.setItemEncomendaCollection(null);
				produto.setTipoProdutoNome(null);
				//produto.setItemReceitaCollection(null);
				
				listaDeProduto.add(produto);
				
				for(int i = 0;i<listaDeProduto.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeProduto.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar produtos\n"+e);
		}
		return listaDeProduto;
	}


}
