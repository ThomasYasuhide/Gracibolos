package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoDao implements GenericoDao<Produto>{

	/*
	 * INCLUIR PRODUTO
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo produto e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(Produto produto) throws Exception{
		
		boolean status = false;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO produto(foto, status, fabricacao, vencimento, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){	
			
			ps = conn.prepareStatement(sql);
			ps.setBlob(1, produto.getFoto());
			ps.setInt(2, produto.getStatus());
			
			if(produto.getFabricacao() != null){
				ps.setDate(3, Date.valueOf(produto.getFabricacao()));
			}else{
				ps.setNull(3, Types.DATE);
			}
			
			if(produto.getVencimento() != null){
				ps.setDate(4, Date.valueOf(produto.getVencimento()));
			}else{
				ps.setNull(4, Types.DATE);
			}
			
			ps.setString(5, produto.getCodigo());
			ps.setString(6, produto.getNome());
			ps.setLong(7, produto.getTipo());
			ps.setDouble(8, produto.getPeso());
			ps.setLong(9, produto.getUnidade());
			ps.setLong(10, produto.getEstoque());
			ps.setBigDecimal(11, produto.getCusto());
			ps.setBigDecimal(12, produto.getValor());
			ps.setString(13, produto.getObs());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Houve um erro ao inserir o produto");
			throw new Exception("Houve um erro ao inserir o produto");
		}
		
		return status;
	}
	
	/*
	 * ALTERAR PRODUTO
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado produto e alterar os dados do banco de dados.
	 * 
	 * */
	
	public boolean alterar(Produto produto) throws Exception{
		
		boolean status = false;
		PreparedStatement  ps = null;
		String sql = "UPDATE produto SET foto=?, status=?, fabricacao=?, vencimento=?, codigo=?, nome=?, tipo=?, peso=?, unidade=?, estoque=?, custo=?, valor=?, obs=? where id=?";
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setBlob(1, produto.getFoto());
			ps.setInt(2, produto.getStatus());
			
			if(produto.getFabricacao() != null){
				ps.setDate(3, Date.valueOf(produto.getFabricacao()));
			}else{
				ps.setNull(3, Types.DATE);
			}
			
			if(produto.getVencimento() != null){
				ps.setDate(4, Date.valueOf(produto.getVencimento()));
			}else{
				ps.setNull(4, Types.DATE);
			}
			
			ps.setString(5, produto.getCodigo());
			ps.setString(6, produto.getNome());
			ps.setLong(7, produto.getTipo());
			ps.setDouble(8, produto.getPeso());
			ps.setLong(9, produto.getUnidade());
			ps.setLong(10, produto.getEstoque());
			ps.setBigDecimal(11, produto.getCusto());
			ps.setBigDecimal(12, produto.getValor());
			ps.setString(13, produto.getObs());
			ps.setLong(14, produto.getId());
			
			ps.close();
			conn.close();
		}catch (SQLException e){
			System.out.println("Houve um erro ao alterar o produto");
			throw new Exception("Houve um erro ao alterar o produto");
		}
		return status;
	}

	/*
	 * EXCLUIR PRODUTO
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado produto e excluir do banco de dados.
	 * 
	 * */
	
	public boolean excluir(Produto produto) throws Exception{

		boolean status = false;
		PreparedStatement ps = null;
		
		String sql  = "DELETE FROM produto WHERE id = ?";

		try(Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, produto.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}

		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar deletar o produto");
			throw new Exception("Houve um erro ao tentar deletar o produto");
		}
		
		return status;
	}
	
	/*
	 * LISTAR CLIENTES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos produtos.
	 * 
	 * */
	
	public List<Produto> listar() throws Exception{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> produtos = null;
		String sql = "SELECT id, foto, status, fabricacao, vencimento, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs FROM produto";
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			produtos = new ArrayList<Produto>();
			
			while(rs.next())
			{
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setFoto(rs.getBlob("foto"));
				produto.setStatus(rs.getInt("status"));
				produto.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				produto.setVencimento(rs.getDate("vencimento").toLocalDate());
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setTipo(rs.getLong("tipo"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setUnidade(rs.getLong("unidade"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCusto(rs.getBigDecimal("custo"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setObs(rs.getString("obs"));
				
				produtos.add(produto);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch (SQLException e) 
		{
			System.out.println("Houve um erro ao listar os produtos");
			throw new Exception("Houve um erro ao listar os produtos");
		}
		return produtos;
	}

	@Override
	public List<Produto> pesquisar(String pesquisa) throws Exception{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> produtos = null;
		
		String sql = "SELECT id, foto, status, fabricacao, vencimento, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs FROM produto WHERE codigo = ? OR nome LIKE ?";
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			
			rs = ps.executeQuery();
			
			produtos = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setFoto(rs.getBlob("foto"));
				produto.setStatus(rs.getInt("status"));
				produto.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				produto.setVencimento(rs.getDate("vencimento").toLocalDate());
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setTipo(rs.getLong("tipo"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setUnidade(rs.getLong("unidade"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCusto(rs.getBigDecimal("custo"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setObs(rs.getString("obs"));
				
				produtos.add(produto);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch (SQLException e) {
			System.out.println("Houve um erro ao pesquisar os produtos");
			throw new Exception("Houve um erro ao pesquisar os produtos");
		}
		
		return produtos;
	}


}
