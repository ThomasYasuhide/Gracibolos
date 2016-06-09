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
	
	@Override
	public boolean inserir(ItemEncomenda e) throws Exception {
		return false;
	}

	public int inserirList(List<ItemEncomenda> list) throws Exception{
		int cont=0;
		//---INSIRO OS ITENS DA ENCOMENDA----------------------------------------------------
		String sqlIe = " INSERT INTO itemEncomenda(produtoId, encomendaId, qtd, valor, total)"
				   + " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		//Inserir todos os itens da encomenda
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){
			for(ItemEncomenda ie : list)
			{			
				ps = conn.prepareStatement(sqlIe);
				ps.setLong(1, ie.getProdutoId());
				ps.setLong(2, ie.getEncomendaId());//encomendaId
				ps.setInt(3, ie.getQuantidade());	
				ps.setBigDecimal(4, ie.getValor());
				ps.setBigDecimal(5, ie.getTotal());
				
				//Insiro os itens da encomenda
				if(ps.executeUpdate() != 0) {
					++cont;
					//status.setStatus2(true);
				}else{
					//status.setStatus2(false);
				}
			}
			ps.close();	
			conn.close();
			
		} catch (Exception e) {
			System.out.println("sem itens\n"+e);
		}
		return cont;
	}
	
	@Override
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
	
	@Override
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
	
	@Override
	public List<ItemEncomenda> listar() throws Exception{
		String sql = "SELECT itemencomenda.id, itemencomenda.produtoId, itemencomenda.encomendaId, itemencomenda.qtd, "
				+ "itemencomenda.valor, itemencomenda.total, produto.nome as nomeProduto," 
				+" produto.codigo, produto.id as produtoIdproduto, produto.valor as valorp"
				+" FROM gracibolos.itemencomenda"
				+" inner join gracibolos.produto on itemencomenda.produtoId = produto.id";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemEncomenda> listaDeItemEncomenda= null;
		Connection conn = ConnectionProvider.getInstance().getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		listaDeItemEncomenda = new ArrayList<ItemEncomenda>();
		
		while(rs.next())
		{
			ItemEncomenda itemEncomenda = new ItemEncomenda();
			
			itemEncomenda.setId(rs.getLong("id"));//itemEncomenda
			itemEncomenda.setProdutoId(rs.getLong("produtoId"));//itemEncomenda
			itemEncomenda.setProdutoIdProduto(rs.getLong("produtoIdproduto"));//Produto
			itemEncomenda.setEncomendaId(rs.getLong("encomendaId"));//itemEncomenda
			itemEncomenda.setQuantidade(rs.getInt("qtd"));//itemEncomenda
			itemEncomenda.setNomeProduto(rs.getString("nomeProduto"));//Produto
			itemEncomenda.setValor(rs.getBigDecimal("valor"));//itemEncomenda
			itemEncomenda.setValorp(rs.getBigDecimal("valorp"));//produto
			itemEncomenda.setTotal(rs.getBigDecimal("total"));//itemEncomenda
			
			listaDeItemEncomenda.add(itemEncomenda);
			
		}//while itens
		
		rs = null;
		ps = null;
		
		return listaDeItemEncomenda;
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
			itemEncomenda.setValor(rsItens.getBigDecimal("valor"));//itemEncomenda
			itemEncomenda.setTotal(rsItens.getBigDecimal("total"));//itemEncomenda
			
			listaDeItemEncomenda.add(itemEncomenda);
			
		}//while itens
		
		rsItens = null;
		psItens = null;
		
		return listaDeItemEncomenda;
	}
}
