package br.com.gracibolos.jdbc.dao;

import java.math.BigDecimal;
import java.sql.Connection;
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
		String sql = "INSERT INTO produto(foto, status, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs, receita) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){	

			/*
			System.out.println(produto.getStatus());
			System.out.println(produto.getFoto());
			System.out.println(produto.getCodigo());
			System.out.println(produto.getNome());
			System.out.println(produto.getTipo());
			System.out.println(produto.getPeso());
			System.out.println(produto.getUnidade());
			System.out.println(produto.getEstoque());
			System.out.println(produto.getCusto());
			System.out.println(produto.getValor());
			System.out.println(produto.getObs());
			*/
			
			//seta os atributos do objeto produto
			ps = conn.prepareStatement(sql);			
			ps.setString(1, produto.getFoto());
			ps.setInt(2, produto.getStatus());
			ps.setString(3, produto.getCodigo());
			ps.setString(4, produto.getNome());
			ps.setLong(5, produto.getTipo());
			
			if(produto.getPeso() != null){
				ps.setBigDecimal(6, produto.getPeso());
			}else{
				ps.setBigDecimal(6, new BigDecimal("0.000"));
			}
			
			if(produto.getUnidade() != null){
				ps.setLong(7, produto.getUnidade());
			}else{
				ps.setNull(7, Types.INTEGER);
			}
			
			ps.setLong(8, produto.getEstoque());
			
			if(produto.getCusto() != null){
				ps.setBigDecimal(9, produto.getCusto());
			}else{
				ps.setBigDecimal(9, new BigDecimal("0.00"));
			}
			
			ps.setBigDecimal(10, produto.getValor());
			ps.setString(11, produto.getObs());
			ps.setString(12, produto.getReceita());
			
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
		/*
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
		*/
		
		boolean status = false;
		PreparedStatement  ps = null;
		
		//string query do banco
		String sql = "UPDATE produto SET foto=?, status=?, codigo=?, nome=?, tipo=?, peso=?, unidade=?, estoque=?, custo=?, valor=?, obs=? where id=?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())	{
			
			//seta os atributos do objeto produto, fazendo a alteração.
			ps = conn.prepareStatement(sql);			
			ps.setString(1, produto.getFoto());			
			ps.setInt(2, produto.getStatus());
			ps.setString(3, produto.getCodigo());
			ps.setString(4, produto.getNome());
			ps.setLong(5, produto.getTipo());
			ps.setBigDecimal(6, produto.getPeso());
			ps.setLong(7, produto.getUnidade());
			ps.setLong(8, produto.getEstoque());
			ps.setBigDecimal(9, produto.getCusto());
			ps.setBigDecimal(10, produto.getValor());
			ps.setString(11, produto.getObs());
			//ps.setString(12, produto.getReceita());
			ps.setLong(12, produto.getId());
			
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
		String sql = "SELECT id, foto, status, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs, receita FROM produto";
		
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
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setTipo(rs.getLong("tipo"));
				produto.setPeso(rs.getBigDecimal("peso"));
				produto.setUnidade(rs.getLong("unidade"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCusto(rs.getBigDecimal("custo"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setObs(rs.getString("obs"));
				produto.setReceita(rs.getString("receita"));
				
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
		String sql = "SELECT id, foto, status, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs, receita FROM produto WHERE id="+id;
		
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
			produto.setCodigo(rs.getString("codigo"));
			produto.setNome(rs.getString("nome"));
			produto.setTipo(rs.getLong("tipo"));
			produto.setPeso(rs.getBigDecimal("peso"));
			produto.setUnidade(rs.getLong("unidade"));
			produto.setEstoque(rs.getInt("estoque"));
			produto.setCusto(rs.getBigDecimal("custo"));
			produto.setValor(rs.getBigDecimal("valor"));
			produto.setObs(rs.getString("obs"));	
			produto.setReceita(rs.getString("receita"));
			
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
		String sql = "SELECT id, foto, status, codigo, nome, tipo, peso, unidade, estoque, custo, valor, obs, receita FROM produto WHERE codigo = ? OR nome LIKE ?";
		
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
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setTipo(rs.getLong("tipo"));
				produto.setPeso(rs.getBigDecimal("peso"));
				produto.setUnidade(rs.getLong("unidade"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCusto(rs.getBigDecimal("custo"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setObs(rs.getString("obs"));
				produto.setReceita(rs.getString("receita"));
				
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
