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
		
		return true;
	}

	public boolean alterar(ItemEncomenda itemEncomenda) throws Exception{
		boolean status = false;
		String sql = "UPDATE itemEncomenda SET produtoId=?, encomendaId=?, qtd=?, valor=?, total=? where id=?";
		PreparedStatement  ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{						
			ps = conn.prepareStatement(sql);
			ps.setLong(1, itemEncomenda.getProdutoId());
			ps.setLong(2, itemEncomenda.getEncomendaId());
			ps.setInt(3, itemEncomenda.getQuantidade());
			ps.setBigDecimal(4, itemEncomenda.getValor());
			ps.setBigDecimal(5, itemEncomenda.getTotal());
			ps.setLong(6, itemEncomenda.getId());
			
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
	
		
		return null;
	}

	
	@Override
	public List<ItemEncomenda> pesquisar(String encomenda) throws Exception{
		
		String sqlItem = "SELECT itemencomenda.id, itemencomenda.produtoId, itemencomenda.encomendaId, itemencomenda.qtd, itemencomenda.valor, itemencomenda.total, produto.nome as nomeProduto," 
				+" produto.codigo, produto.id as produtoIdproduto"
				+" FROM gracibolos.itemencomenda"
				+" inner join gracibolos.produto on itemencomenda.produtoId = produto.id"
				+" where itemencomenda.encomendaId = "+encomenda;
		
		//Itens
		PreparedStatement psItens = null;
		ResultSet rsItens = null;
		List<ItemEncomenda> listaDeItemEncomenda= null;
		Connection conn = ConnectionProvider.getInstance().getConnection();
		psItens = conn.prepareStatement(sqlItem);
		rsItens = psItens.executeQuery();
		listaDeItemEncomenda = new ArrayList<ItemEncomenda>();
		
		while(rsItens.next())
		{
			ItemEncomenda itemEncomenda = new ItemEncomenda();
			
			itemEncomenda.setId(rsItens.getLong("id"));//itemEncomenda
			itemEncomenda.setProdutoId(rsItens.getLong("produtoId"));//itemEncomenda
			itemEncomenda.setProdutoIdProduto(rsItens.getLong("produtoIdproduto"));//Produto
			itemEncomenda.setEncomendaId(rsItens.getLong("encomendaId"));//itemEncomenda
			itemEncomenda.setQuantidade(rsItens.getInt("qtd"));//itemEncomenda
			itemEncomenda.setNomeProduto(rsItens.getString("nomeProduto"));//Produto
			itemEncomenda.setValor(rsItens.getBigDecimal("valor"));//Produto
			itemEncomenda.setTotal(rsItens.getBigDecimal("total"));
			
			listaDeItemEncomenda.add(itemEncomenda);
			
		}//while itens
		
		rsItens = null;
		psItens = null;
		
		return listaDeItemEncomenda;
	}

}
