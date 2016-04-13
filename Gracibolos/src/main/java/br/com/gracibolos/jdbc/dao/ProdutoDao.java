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
        
		//string query do banco
		String sql = "INSERT INTO produto(foto, status, fabricacao, vencimento, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){	
			
			//seta os atributos do objeto produto
			ps = conn.prepareStatement(sql);			
			ps.setString(1, produto.getFoto());
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
			ps.setBigDecimal(8, produto.getPeso());
			ps.setLong(9, produto.getUnidade());
			ps.setLong(10, produto.getEstoque());
			ps.setBigDecimal(11, produto.getCusto());
			ps.setBigDecimal(12, produto.getValor());
			ps.setString(13, produto.getObs());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();	
			conn.close();			
					
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Houve um erro ao inserir o produto");
			throw new Exception("Houve um erro ao inserir o produto");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR PRODUTO
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado produto e alterar os dados do banco de dados.
	 * 
	 * */
	
	public boolean alterar(Produto produto) throws Exception{
		
		System.out.println(produto.getId());
		System.out.println(produto.getStatus());
		System.out.println(produto.getFoto());
		System.out.println(produto.getFabricacao());
		System.out.println(produto.getVencimento());
		System.out.println(produto.getCodigo());
		System.out.println(produto.getNome());
		System.out.println(produto.getTipo());
		System.out.println(produto.getPeso());
		System.out.println(produto.getUnidade());
		System.out.println(produto.getEstoque());
		System.out.println(produto.getCusto());
		System.out.println(produto.getValor());
		System.out.println(produto.getObs());
		
		boolean status = false;
		PreparedStatement  ps = null;
		
		//string query do banco
		String sql = "UPDATE produto SET foto=?, status=?, fabricacao=?, vencimento=?, codigo=?, nome=?, tipo=?, peso=?, unidade=?, estoque=?, custo=?, valor=?, obs=? where id=?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())	{
			
			//seta os atributos do objeto produto, fazendo a alteração.
			ps = conn.prepareStatement(sql);			
			ps.setString(1, produto.getFoto());			
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
			ps.setBigDecimal(8, produto.getPeso());
			ps.setLong(9, produto.getUnidade());
			ps.setLong(10, produto.getEstoque());
			ps.setBigDecimal(11, produto.getCusto());
			ps.setBigDecimal(12, produto.getValor());
			ps.setString(13, produto.getObs());
			ps.setLong(14, produto.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();
			conn.close();
			
		}
		//trata, caso de uma exceção
		catch (SQLException e){
			System.out.println("Houve um erro ao alterar o produto");
			throw new Exception("Houve um erro ao alterar o produto");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
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
		
		//string query do banco
		String sql  = "DELETE FROM produto WHERE id = ?";

		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta o id do produto, e excluir o objeto
			ps = conn.prepareStatement(sql);			
			ps.setLong(1, produto.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();
			conn.close();

		} 
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Houve um erro ao tentar deletar o produto");
			throw new Exception("Houve um erro ao tentar deletar o produto");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * LISTAR PRODUTOS
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos produtos.
	 * 
	 * */
	
	public List<Produto> listar() throws Exception{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> produtos = null;
		
		//string query do banco
		String sql = "SELECT id, foto, status, fabricacao, vencimento, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs FROM produto";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();			
			produtos = new ArrayList<Produto>();
			
			while(rs.next())
			{
				//da um get nos atributos do objeto produto
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setFoto(rs.getString("foto"));
				produto.setStatus(rs.getInt("status"));
				produto.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				produto.setVencimento(rs.getDate("vencimento").toLocalDate());
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setTipo(rs.getLong("tipo"));
				produto.setPeso(rs.getBigDecimal("peso"));
				produto.setUnidade(rs.getLong("unidade"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCusto(rs.getBigDecimal("custo"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setObs(rs.getString("obs"));
				
				//adiciona o objeto produto no arrayList
				produtos.add(produto);
				
			}
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
			
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Houve um erro ao listar os produtos");
			throw new Exception("Houve um erro ao listar os produtos");
		}
		//retorna o array
		return produtos;
	}
	
	public Produto pesquisarPorId(int id) throws Exception{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		//string query do banco
		String sql = "SELECT id, foto, status, fabricacao, vencimento, codigo, nome, tipo, "
				+ "peso, unidade, estoque, custo, valor, obs FROM produto WHERE id="+id;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();			
			rs.next();	
			
			//da um get nos atributos do objeto produto
			Produto produto = new Produto();
			produto.setId(rs.getLong("id"));
			produto.setFoto(rs.getString("foto"));
			produto.setStatus(rs.getInt("status"));
			produto.setFabricacao(rs.getDate("fabricacao").toLocalDate());
			produto.setVencimento(rs.getDate("vencimento").toLocalDate());
			produto.setCodigo(rs.getString("codigo"));
			produto.setNome(rs.getString("nome"));
			produto.setTipo(rs.getLong("tipo"));
			produto.setPeso(rs.getBigDecimal("peso"));
			produto.setUnidade(rs.getLong("unidade"));
			produto.setEstoque(rs.getInt("estoque"));
			produto.setCusto(rs.getBigDecimal("custo"));
			produto.setValor(rs.getBigDecimal("valor"));
			produto.setObs(rs.getString("obs"));	
			
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
			
			return produto;	
		}
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Houve um erro ao encontrar o produto");
			throw new Exception("Houve um erro ao tentar encontrar o produto");
		}
	
	}
	
	/*
	 * PESQUISAR PRODUTOS
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos produtos.
	 * 
	 * */
	
	@Override
	public List<Produto> pesquisar(String pesquisa) throws Exception{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> produtos = null;
		
		//string query do banco
		String sql = "SELECT id, foto, status, fabricacao, vencimento, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs FROM produto WHERE codigo = ? OR nome LIKE ?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			
			rs = ps.executeQuery();
			
			produtos = new ArrayList<Produto>();
			
			while(rs.next()) {
				
				//da um get nos atributos do objeto produto
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setFoto(rs.getString("foto"));
				produto.setStatus(rs.getInt("status"));
				produto.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				produto.setVencimento(rs.getDate("vencimento").toLocalDate());
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setTipo(rs.getLong("tipo"));
				produto.setPeso(rs.getBigDecimal("peso"));
				produto.setUnidade(rs.getLong("unidade"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCusto(rs.getBigDecimal("custo"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setObs(rs.getString("obs"));
				
				//adiciona o objeto produto no arrayList
				produtos.add(produto);
				
			}
			
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
			
		}
		
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Houve um erro ao pesquisar os produtos");
			throw new Exception("Houve um erro ao pesquisar os produtos");
		}
		//retorna o array
		return produtos;
	}


}
