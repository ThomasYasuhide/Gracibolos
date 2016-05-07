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
import br.com.gracibolos.jdbc.model.Encomenda;

public class EncomendaDao implements GenericoDao<Encomenda>{

	/*
	 * INCLUIR ENCOMENDA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma nova encomenda e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(Encomenda encomenda) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " INSERT INTO encomenda(status, dataencomenda, dataentrega, cliente, responsavel,"
				+ "datafaturamento , dataproducao, datafinalizado, datacancelado, total, obs)"
				   + " VALUES (?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			//seta os atributos do objeto encomenda
			ps = conn.prepareStatement(sql);
			ps.setInt(1, encomenda.getStatus());
			if(encomenda.getDataencomenda()!=null){
				ps.setDate(2, Date.valueOf(encomenda.getDataencomenda()));
			}else{
				ps.setNull(2, Types.DATE);
			}
			if(encomenda.getDataentrega()!=null){
				ps.setDate(3, Date.valueOf(encomenda.getDataentrega()));
			}else{
				ps.setNull(3, Types.DATE);
			}
			
			ps.setInt(4, encomenda.getClienteid());
			ps.setString(5, encomenda.getResponsavel());
			if(encomenda.getDatafaturamento()!=null){
				ps.setDate(6, Date.valueOf(encomenda.getDatafaturamento()));
			}else{
				ps.setNull(6, Types.DATE);
			}
			if(encomenda.getDataproducao()!=null){
				ps.setDate(7, Date.valueOf(encomenda.getDataproducao()));
			}else{
				ps.setNull(7, Types.DATE);
			}
			if(encomenda.getDatafinalizado()!=null){
				ps.setDate(8, Date.valueOf(encomenda.getDatafinalizado()));
			}else{
				ps.setNull(8, Types.DATE);
			}
			if(encomenda.getDatacancelamento()!=null){
				ps.setDate(9, Date.valueOf(encomenda.getDatacancelamento()));
			}else{
				ps.setNull(9, Types.DATE);
			}
			ps.setBigDecimal(10, encomenda.getTotalprodutos());
			ps.setString(11, encomenda.getObs());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();	
			conn.close();			
					
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir usuário\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}

	/*
	 * ALTERAR ENCOMENDA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada encomenda e alterar os dados do banco de dados.
	 * 
	 * */
	
	public boolean alterar(Encomenda encomenda) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " UPDATE encomenda SET cliente=?, status=?, responsavel=?, dataencomenda=?, dataentrega=?,"
				   + " datafaturamento=?, dataproducao=?, datafinalizado=?, datacancelamento=?, total=?, obs=? WHERE id=?";
		
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta os atributos do objeto encomenda, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			ps.setLong(1, encomenda.getClienteid());
			ps.setLong(2, encomenda.getStatus());
			ps.setString(3, encomenda.getResponsavel());
			
			if(encomenda.getDataencomenda() != null){
				ps.setDate(4, Date.valueOf(encomenda.getDataencomenda()));
			}else{
				ps.setNull(4, Types.DATE);
			}
			
			if(encomenda.getDataentrega() != null){
				ps.setDate(5, Date.valueOf(encomenda.getDataentrega()));
			}else{
				ps.setNull(5, Types.DATE);
			}
			
			if(encomenda.getDatafaturamento() != null){
				ps.setDate(6, Date.valueOf(encomenda.getDatafaturamento()));
			}else{
				ps.setNull(6, Types.DATE);
			}

			if(encomenda.getDataproducao() != null){
				ps.setDate(7, Date.valueOf(encomenda.getDataproducao()));
			}else{
				ps.setNull(7, Types.DATE);
			}
			
			if(encomenda.getDatafinalizado() != null){
				ps.setDate(8, Date.valueOf(encomenda.getDatafinalizado()));
			}else{
				ps.setNull(8, Types.DATE);
			}
			
			if(encomenda.getDatacancelamento() != null){
				ps.setDate(9, Date.valueOf(encomenda.getDatacancelamento()));
			}else{
				ps.setNull(9, Types.DATE);
			}
			
			ps.setBigDecimal(10, encomenda.getTotalprodutos());
			ps.setString(11, encomenda.getObs());		
			ps.setLong(12, encomenda.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a encomenda\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}

	/*
	 * EXCLUIR ENCOMENDA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada encomenda e excluir do banco de dados.
	 * 
	 * */	
	
	public boolean excluir(Encomenda encomenda) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql  = "DELETE FROM encomenda WHERE id = ?";
		PreparedStatement ps;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta o id da encomenda, e excluir o objeto
			ps = conn.prepareStatement(sql);
			ps.setLong(1, encomenda.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
		}
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Erro ao deletar encomenda \n" + e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}

	/*
	 * LISTAR ENCOMENDA
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todas as encomendas.
	 * 
	 */
	
	public List<Encomenda> listar() throws Exception{
		
		//string query do banco
		String sql = "SELECT id, cliente, status, responsavel, dataencomenda, dataentrega, datafaturamento, dataproducao, datafinalizado, datacancelado, total, obs FROM encomenda";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Encomenda> encomendas= null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			encomendas = new ArrayList<Encomenda>();
			
			while(rs.next()) {
				//da um get nos atributos do objeto encomenda
				Encomenda encomenda = new Encomenda();
				encomenda.setId(rs.getLong("id"));
				encomenda.setClienteid(rs.getInt("cliente"));	
				encomenda.setStatus(rs.getInt("status"));
				encomenda.setResponsavel(rs.getString("responsavel"));
				if(rs.getDate("dataencomenda")!=null)
					encomenda.setDataencomenda(rs.getDate("dataencomenda").toLocalDate());
				if(rs.getDate("dataentrega")!=null)
					encomenda.setDataentrega(rs.getDate("dataentrega").toLocalDate());
				if(rs.getDate("datafaturamento")!=null)
					encomenda.setDatafaturamento(rs.getDate("datafaturamento").toLocalDate());
				if(rs.getDate("dataproducao")!=null)
					encomenda.setDataproducao(rs.getDate("dataproducao").toLocalDate());
				if(rs.getDate("datafinalizado")!=null)
					encomenda.setDatafinalizado(rs.getDate("datafinalizado").toLocalDate());
				if(rs.getDate("datacancelado")!=null)
					encomenda.setDatacancelamento(rs.getDate("datacancelado").toLocalDate());
				encomenda.setTotalprodutos(rs.getBigDecimal("total"));
				encomenda.setObs(rs.getString("obs"));
				
				//adiciona o objeto encomenda no arrayList
				encomendas.add(encomenda);
				
				//AQUI NÃO ESTÁ FALTANDO UM FOR PARA PERCORRER O ARRAY ENCOMENDAS??
				 
			}
			
			ps.close();
			conn.close();			
		}
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Erro ao listar as encomendas\n"+e);
		}
		
		//retorna o array 
		return encomendas;
	}
	
	/*
	 * PESQUISAR ENCOMENDA
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados das encomendas pesquisados.
	 * 
	 * */

	@Override
	public List<Encomenda> pesquisar(String pesquisa) throws Exception{
		
		//string query do banco
		String sql = "SELECT id, cliente, status, responsavel, dataencomenda, dataentrega, datafaturamento, dataproducao, datafinalizado, datacancelado, total, obs FROM encomenda WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Encomenda> encomendas = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			
			rs = ps.executeQuery();
			encomendas = new ArrayList<Encomenda>();
			
			while(rs.next()) {
				//da um get nos atributos do objeto encomenda
				Encomenda encomenda = new Encomenda();
				encomenda.setId(rs.getLong("id"));
				encomenda.setClienteid(rs.getInt("cliente"));	
				encomenda.setStatus(rs.getInt("status"));
				encomenda.setResponsavel(rs.getString("responsavel"));
				encomenda.setDataencomenda(rs.getDate("dataencomenda").toLocalDate());
				encomenda.setDataentrega(rs.getDate("dataentrega").toLocalDate());
				encomenda.setDatafaturamento(rs.getDate("datafaturamento").toLocalDate());
				encomenda.setDataproducao(rs.getDate("dataproducao").toLocalDate());
				encomenda.setDatafinalizado(rs.getDate("datafinalizado").toLocalDate());
				encomenda.setDatacancelamento(rs.getDate("datacancelado").toLocalDate());
				encomenda.setTotalprodutos(rs.getBigDecimal("total"));
				encomenda.setObs(rs.getString("obs"));
				
				//adiciona o objeto encomenda no arrayList
				encomendas.add(encomenda);
				 
			}
			
			ps.close();
			conn.close();			
		} 
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Erro ao listar as encomendas\n"+e);
		}
		
		//retorna o array
		return encomendas;
	}

}
