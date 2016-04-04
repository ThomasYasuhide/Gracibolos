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
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaDao implements GenericoDao<MateriaPrima>{

	/*
	 * INCLUIR MATÉRIA-PRIMA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma nova matéria-prima e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "INSERT INTO materiaprima (codigo, nome, estoque, unidade, fabricacao, vencimento, descricao)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto materiaPrima
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getCodigo());
			ps.setString(2, materiaPrima.getNome());
			ps.setDouble(3, materiaPrima.getEstoque());
			ps.setLong(4, materiaPrima.getUnidade());
			
			if(materiaPrima.getFabricacao() != null){
				ps.setDate(5, Date.valueOf(materiaPrima.getFabricacao()));
			}else{
				ps.setNull(5, Types.DATE);
			}
			
			if(materiaPrima.getVencimento() != null){
				ps.setDate(6, Date.valueOf(materiaPrima.getVencimento()));
			}else{
				ps.setNull(6, Types.DATE);
			}
			
			ps.setString(7, materiaPrima.getDescricao());
			
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
			System.out.println("Erro ao inserir materiaPrima\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR MATÉRIA-PRIMA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada matéria-prima e alterar os dados do banco de dados.
	 * 
	 * */
	
	public boolean alterar(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " UPDATE materiaprima SET codigo=?, nome=?, estoque=?, unidade=?, fabricacao=?,"
				   + " vencimento=?, descricao=? where id=?";
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto matéria-prima, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getCodigo());
			ps.setString(2, materiaPrima.getNome());
			ps.setDouble(3, materiaPrima.getEstoque());
			ps.setLong(4, materiaPrima.getUnidade());
			
			if(materiaPrima.getFabricacao() != null){
				ps.setDate(5, Date.valueOf(materiaPrima.getFabricacao()));
			}else{
				ps.setNull(5, Types.DATE);
			}
			
			if(materiaPrima.getVencimento() != null){
				ps.setDate(6, Date.valueOf(materiaPrima.getVencimento()));
			}else{
				ps.setNull(6, Types.DATE);
			}
			
			ps.setString(7, materiaPrima.getDescricao());
			ps.setLong(8, materiaPrima.getId());
			
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
			System.out.println("Erro ao alterar a materiaPrima\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * EXCLUIR  MATÉRIA-PRIMA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada matéria-prima e excluir do banco de dados.
	 * 
	 * */

	public boolean excluir(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "DELETE FROM materiaprima WHERE id = ?";
		
		PreparedStatement ps;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			//seta o id da matéria-prima, e excluir o objeto
			ps = conn.prepareStatement(sql);
			ps.setLong(1, materiaPrima.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();
			conn.close();
	
		}
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar a materiaPrima");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}

	/*
	 * LISTAR MATÉRIA-PRIMA
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todas as matérias-primas.
	 * 
	 */	
	
	public List<MateriaPrima> listar() throws Exception{
		
		//string query do banco
		String sql = "SELECT id, codigo,  nome, estoque, unidade, fabricacao, vencimento, descricao FROM materiaprima";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MateriaPrima> materiasprimas= null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			materiasprimas = new ArrayList<MateriaPrima>();
			while(rs.next()) 
			{			
				//da um get nos atributos do objeto matéria-prima
				MateriaPrima materiaPrima = new MateriaPrima();
				materiaPrima.setId(rs.getLong("id"));
				materiaPrima.setCodigo(rs.getString("codigo"));
				materiaPrima.setNome(rs.getString("nome"));
				materiaPrima.setEstoque(rs.getDouble("estoque"));
				materiaPrima.setUnidade(rs.getLong("unidade"));
				materiaPrima.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				materiaPrima.setVencimento(rs.getDate("vencimento").toLocalDate());
				materiaPrima.setDescricao(rs.getString("descricao"));
				
				//adiciona o objeto materiaPrima no arrayList
				materiasprimas.add(materiaPrima);
			}
			
			//fecha as conexões
			ps.close();
			conn.close();
			
		}
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Erro ao listar materiaPrima\n"+e);
		}
		//retorna o array
		return materiasprimas;
	}

	/*
	 * PESQUISAR MATÉRIA-PRIMA
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos matérias-primas pesquisados.
	 * 
	 * */
	
	@Override
	public List<MateriaPrima> pesquisar(String pesquisa) throws Exception{
		
		List<MateriaPrima> materiasPrimas = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = "SELECT id, codigo,  nome, estoque, unidade, fabricacao, vencimento, descricao FROM materiaprima WHERE codigo = ? OR nome LIKE ?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				//da um get nos atributos do objeto materiaprima
				MateriaPrima materiaprima = new MateriaPrima();
				
				materiaprima.setId(rs.getLong("id"));
				materiaprima.setCodigo(rs.getString("codigo"));
				materiaprima.setNome(rs.getString("nome"));
				materiaprima.setEstoque(rs.getDouble("estoque"));
				materiaprima.setUnidade(rs.getLong("unidade"));
				materiaprima.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				materiaprima.setVencimento(rs.getDate("vencimento").toLocalDate());
				materiaprima.setDescricao(rs.getString("descricao"));
				
				//adiciona o objeto materiaprima no arrayList
				materiasPrimas.add(materiaprima);
			}
			
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
					
		} 
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o matéria prima");
		}
		//retorna o array
		return materiasPrimas;
	}

}
