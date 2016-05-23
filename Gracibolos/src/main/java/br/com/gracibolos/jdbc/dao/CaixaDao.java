package br.com.gracibolos.jdbc.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Caixa;

public class CaixaDao implements GenericoDao<Caixa>{

	/*
	 * INCLUIR CAIXA
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo pagamento e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(Caixa caixa) throws Exception{
		
		if(updateSaldo(getSaldo().add(caixa.getValor()))){
			System.out.println("Valor incluso");
		}else{
			System.out.println("Erro ao incluir saldo");
		}
		
		boolean status = false;
		
		//string query do banco
		String sql = " INSERT INTO caixa(gastoRecebimento, fornecedorId, encomendaId, valor, saldo,"
				   + " forma, parcela, dataTransacao, dataOperacao, descricao)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			//seta os atributos do objeto caixa
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, caixa.getGastoRecebimento());
			
			if(caixa.getFornecedorId()!=null){
				ps.setInt(2, caixa.getFornecedorId());
			}else{
				ps.setNull(2, Types.INTEGER);
			}
			
			if(caixa.getEncomendaId()!=null){
				ps.setLong(3, caixa.getEncomendaId());
			}else{
				ps.setNull(3, Types.INTEGER);
			}
			
			ps.setBigDecimal(4, caixa.getValor());
			ps.setBigDecimal(5, caixa.getSaldo());			
			ps.setString(6, caixa.getForma());			
			ps.setInt(7, caixa.getParcela());
			ps.setDate(8, Date.valueOf(caixa.getDataTransacao()));
			if(caixa.getDataOperacao()!=null){
				ps.setDate(9, Date.valueOf(caixa.getDataOperacao()));	
			}else{
				ps.setNull(9, Types.DATE);
			}				
			ps.setString(10, caixa.getDescricao());			
						
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
			System.out.println("Erro ao inserir caixa\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR CAIXA
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado caixa e alterar os dados do banco de dados.
	 * 
	 * */

	public boolean alterar(Caixa caixa) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " UPDATE caixa SET gastoRecebimento=?, fornecedorId=?, encomendaId=?, valor=?, saldo=?,"
				   + "  forma=?, parcela=?, dataTransacao=?, dataOperacao=?, descricao=? where id=?";
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto caixa, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			ps.setInt(1, caixa.getGastoRecebimento());	
			if(caixa.getFornecedorId()!=null){
				ps.setInt(2, caixa.getFornecedorId());
			}else{
				ps.setNull(2, Types.INTEGER);
			}
			if(caixa.getEncomendaId()!=null){
				ps.setLong(3, caixa.getEncomendaId());
			}else{
				ps.setNull(3, Types.INTEGER);
			}
			ps.setBigDecimal(4, caixa.getValor());
			ps.setBigDecimal(5, caixa.getSaldo());			
			ps.setString(6, caixa.getForma());			
			ps.setInt(7, caixa.getParcela());
			ps.setDate(8, Date.valueOf(caixa.getDataTransacao()));
			if(caixa.getDataOperacao()!=null){
				ps.setDate(9, Date.valueOf(caixa.getDataOperacao()));
			}else{
				ps.setNull(9, Types.DATE);
			}				
			ps.setString(10, caixa.getDescricao());	
			ps.setLong(11, caixa.getId());
			
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
			System.out.println("Erro ao alterar o caixa\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * EXCLUIR CAIXA
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado caixa e excluir do banco de dados.
	 * 
	 * */

	public boolean excluir(Caixa caixa) throws Exception{
		//Atualização do saldo---------------------------
		
		if(updateSaldo(getSaldo().subtract(caixa.getValor()))){
			System.out.println("Saldo atualizado");
		}else{
			System.out.println("Erro ao atualizado saldo");
		}
		
		boolean status = false;
		//string query do banco
		String sql = "DELETE FROM caixa WHERE id = ?";
		
		PreparedStatement ps;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			//seta o id do caixa, e excluir o objeto
			ps = conn.prepareStatement(sql);
			ps.setLong(1, caixa.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();
			conn.close();		
		}
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o caixa");
		}		
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * LISTAR CAIXA
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os caixas.
	 * 
	 * NÃO ESTÁ IMPLEMENTADO 
	 */
	
	public List<Caixa> listar() throws Exception{
		
		//string query do banco
		String sql = "SELECT id, tipoId, numeroId, recebidoGasto, forma, parcela, descricao FROM caixa";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Caixa> listaDeCaixa= null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeCaixa = new ArrayList<Caixa>();
			while(rs.next())
			{
				//da um get nos atributos do objeto caixa
				Caixa caixa = new Caixa();
				
				
				
				
				//adiciona o objeto caixa no arrayList
				listaDeCaixa.add(caixa);
				
				//enquanto o arraylist tiver objeto caixa, ele vai listando
				for(int i = 0;i<listaDeCaixa.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeCaixa.get(i));    
				}  
			}
			
			//fecha as conexões
			ps.close();
			conn.close();
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar caixa\n"+e);
		}
		//retorna o array
		return listaDeCaixa;
	}

	/*
	 * PESQUISAR CAIXA
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos caixa pesquisados.
	 * 
	 * */
	
	@Override
	public List<Caixa> pesquisar(String pesquisa) throws Exception {
		return null;
	}
	
	public static boolean updateSaldo(BigDecimal saldo) throws Exception{
		
		boolean status = false;
		String sql = "update caixa set saldo = ? where caixa.id=1";
		PreparedStatement ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, saldo);
			if(ps.executeUpdate()!=0){
				status = true; 
			}
		} catch (Exception e) {
			System.out.println("Houve um erro ao atualizar o saldo \n"+e);
		}
		return status;
	}
	
	public BigDecimal getSaldo() throws Exception {
		
		String sql = "SELECT caixa.id, caixa.saldo FROM gracibolos.caixa where caixa.id=1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		BigDecimal saldo = new BigDecimal(0);
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			ps = conn.prepareStatement(sql);//
			rs = ps.executeQuery();//Armazena o resultado da pesquisa
			if(rs.first()){//pega o primeiro registro 
				//s.setId(rs.getLong("id"));
				saldo = rs.getBigDecimal("saldo");
			}else{
				System.out.println("Saldo não encontrado");
			}	
			
		} catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o saldo \n"+e);
		}
		return saldo;
	}
	
	public List<Caixa> pesquisarEntre(String inicio, String fim) throws Exception{
		
		List<Caixa> caixas = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = " SELECT caixa.id, caixa.gastoRecebimento, caixa.fornecedorId, caixa.encomendaId, caixa.valor, caixa.saldo,"
				   + " caixa.forma, caixa.parcela, caixa.dataTransacao, caixa.dataOperacao, caixa.descricao,"
				   + " fornecedor.id as fornecedorIdFornecedor, fornecedor.nomerazao"
			 	   + " FROM gracibolos.caixa left join gracibolos.fornecedor on caixa.fornecedorId = fornecedor.id"
				   + " where caixa.dataTransacao between '"+inicio+"' AND '"+fim+"'" 
				   + " order by caixa.dataTransacao";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				//da um get nos atributos do objeto caixa
				Caixa caixa = new Caixa();	
					
				caixa.setId(rs.getLong("id"));
				caixa.setGastoRecebimento(rs.getInt("gastoRecebimento"));
				caixa.setFornecedorId(rs.getInt("fornecedorId"));
				caixa.setEncomendaId(rs.getLong("encomendaId"));
				caixa.setValor(rs.getBigDecimal("valor"));
				//caixa.setSaldo(rs.getBigDecimal("saldo"));					
				caixa.setForma(rs.getString("forma"));
				caixa.setParcela(rs.getInt("parcela"));
				if(rs.getDate("dataTransacao")!=null)
					caixa.setDataTransacao(rs.getDate("dataTransacao").toLocalDate());
				if(rs.getDate("dataOperacao")!=null)
					caixa.setDataOperacao(rs.getDate("dataOperacao").toLocalDate());	
				caixa.setDescricao(rs.getString("descricao"));	
				caixa.setFornecedorIdFornecedor(rs.getLong("fornecedorIdFornecedor"));
				caixa.setNomerazao(rs.getString("nomerazao"));
				//adiciona o objeto caixa no arrayList
				caixas.add(caixa);
			}
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
		//trata, caso de uma exceção			
		} catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o caixa entre datas \n"+e);
		}
		//retorna o array
		return caixas;
	}

}
