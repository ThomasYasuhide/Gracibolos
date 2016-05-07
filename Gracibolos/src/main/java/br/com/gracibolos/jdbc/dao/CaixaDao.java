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
import br.com.gracibolos.jdbc.model.Caixa;

public class CaixaDao implements GenericoDao<Caixa>{
	
	private Date sqlDate;

	/*
	 * INCLUIR CAIXA
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo pagamento e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(Caixa caixa) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " INSERT INTO gracibolos.caixa(encomendaId, fornecedorId, valor, gastoRecebimento, forma,"
				   + " parcela, descricao, data)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		sqlDate = new Date(caixa.getData().getTime());
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			//seta os atributos do objeto caixa
			ps = conn.prepareStatement(sql);
			
			if(caixa.getEncomendaId()!=null){
				ps.setInt(1, caixa.getEncomendaId());
			}else{
				ps.setNull(1, Types.INTEGER);
			}
			if(caixa.getFornecedorId()!=null){
				ps.setInt(2, caixa.getFornecedorId());
			}else{
				ps.setNull(2, Types.INTEGER);
			}
			ps.setBigDecimal(3, caixa.getValor());
			ps.setInt(4, caixa.getGastoRecebimento());
			ps.setString(5, caixa.getForma());
			ps.setInt(6, caixa.getParcela());
			ps.setString(7, caixa.getDescricao());
			ps.setDate(8, sqlDate);
						
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
		String sql = " UPDATE caixa SET encomendaId=?, fornecedorId=?, valor=?, gastoRecebimento=?, forma=?,"
				   + " parcela=?, descricao=?, data=? where id=?";
		PreparedStatement  ps = null;
		sqlDate = new Date(caixa.getData().getTime());
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto caixa, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			
			if(caixa.getEncomendaId()!=null){
				ps.setInt(1, caixa.getEncomendaId());
			}else{
				ps.setNull(1, Types.INTEGER);
			}
			if(caixa.getFornecedorId()!=null){
				ps.setInt(2, caixa.getFornecedorId());
			}else{
				ps.setNull(2, Types.INTEGER);
			}
			ps.setBigDecimal(3, caixa.getValor());
			ps.setInt(4, caixa.getGastoRecebimento());
			ps.setString(5, caixa.getForma());
			ps.setInt(6, caixa.getParcela());
			ps.setString(7, caixa.getDescricao());
			ps.setDate(8, sqlDate);
			ps.setLong(9, caixa.getId());
			
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Caixa> pesquisarEntre(String inicio, String fim) throws Exception{
		
		List<Caixa> caixas = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = "SELECT * FROM gracibolos.caixa WHERE data between '"+inicio+"' AND '"+fim+"'";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				//da um get nos atributos do objeto caixa
				Caixa caixa = new Caixa();	
					
				caixa.setId(rs.getLong("id"));
				caixa.setEncomendaId(rs.getInt("encomendaId"));
				caixa.setFornecedorId(rs.getInt("fornecedorId"));
				caixa.setValor(rs.getBigDecimal("valor"));
				caixa.setGastoRecebimento(rs.getInt("gastoRecebimento"));
				caixa.setForma(rs.getString("forma"));
				caixa.setParcela(rs.getInt("parcela"));
				caixa.setDescricao(rs.getString("descricao"));
				caixa.setData(rs.getDate("data"));			
			
				//adiciona o objeto caixa no arrayList
				caixas.add(caixa);
			}
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
		//trata, caso de uma exceção			
		} catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o caixa\n"+e);
		}
		//retorna o array
		return caixas;
	}

}
