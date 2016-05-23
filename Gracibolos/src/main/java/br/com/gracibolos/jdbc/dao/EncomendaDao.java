package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.ItemEncomenda;
import br.com.gracibolos.jdbc.model.Status;

public class EncomendaDao{

	/*
	 * INCLUIR ENCOMENDA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma nova encomenda e persistir no banco de dados.
	 * 
	 * */
	
	@SuppressWarnings("static-access")
	public Status inserir(Encomenda encomenda) throws Exception{
		//boolean status = false;
		
		//string query do banco
		String sql = " INSERT INTO encomenda(status, dataencomenda, dataentrega, cliente, responsavel,"
				+ "datafaturamento , dataproducao, datafinalizado, datacancelado, total, obs)"
				   + " VALUES (?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Status status = new Status();
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {			
			
			//seta os atributos do objeto encomenda
			//PASSA O PARA ps QUE EU QUERO O RETORNO DA CHAVE
			ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
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
			
			
			//Insiro a encomenda
			if(ps.executeUpdate() != 0) {
				status.setStatus1(true);
			}else{
				status.setStatus1(false);
			}
			
			//Aqui eu pego o retorno da chave inserida
			rs = ps.getGeneratedKeys();
			rs.next();
			Long lastid = rs.getLong(1);
			status.setNumeroEncomenda(lastid);//Aqui eu pego o numero da encomenda
			System.out.println("inserido id : "+lastid);
			
			//---INSIRO OS ITENS DA ENCOMENDA----------------------------------------------------
			String sqlIe = " INSERT INTO itemEncomenda(produtoId, encomendaId, qtd)"
					   + " VALUES (?, ?, ?)";
			
			//Inserir todos os itens da encomenda
			try {
				for(ItemEncomenda ie : encomenda.getListItemEncomenda())
				{			
					ps = conn.prepareStatement(sqlIe);
					ps.setLong(1, ie.getProdutoId());
					ps.setLong(2, lastid);//encomendaId
					ps.setInt(3, ie.getQuantidade());	
					
					//Insiro os itens da encomenda
					if(ps.executeUpdate() != 0) {
						status.setStatus2(true);
					}else{
						status.setStatus2(false);
					}
				}
						
				rs.close();
				ps.close();	
				conn.close();		
			} catch (Exception e) {
				System.out.println("sem itens\n"+e);
			}
			
				
					
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir encomenda\n"+e);
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
	
	private static LocalDate hoje = LocalDate.now();
	
	public boolean alterarProduzindo(String id)throws Exception{
		
		boolean status = false;
		
		//string query do banco
		String sql = " UPDATE encomenda SET status=4, dataproducao='"+hoje+"' WHERE id="+id;
		
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta os atributos do objeto encomenda, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a produção encomenda\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	public boolean alterarFinalizado(String id)throws Exception{
		
		boolean status = false;
		
		//string query do banco
		String sql = " UPDATE encomenda SET status=5, datafinalizado='"+hoje+"' WHERE id="+id;
		
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta os atributos do objeto encomenda, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a finalização encomenda\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}

	public boolean alterar(Encomenda encomenda) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " UPDATE encomenda SET cliente=?, status=?, responsavel=?, dataencomenda=?, dataentrega=?,"
				   + " datafaturamento=?, dataproducao=?, datafinalizado=?, datacancelado=?, total=?, obs=? WHERE id=?";
		
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
	
	
	public List<Encomenda> pesquisar(String pesquisa) throws Exception {
		return null;
	}
	
	public Encomenda pesquisarId(String pesquisa) throws Exception{
		
		//string query do banco
		String sql = "SELECT encomenda.id, encomenda.cliente, encomenda.status, encomenda.responsavel, encomenda.dataencomenda, encomenda.dataentrega"
				+ ", encomenda.datafaturamento, encomenda.dataproducao, encomenda.datafinalizado, encomenda.datacancelado, encomenda.total"
				+ ", encomenda.obs, cliente.nomerazao, cliente.id as clienteId, cliente.cpfcnpj "
				+ "FROM encomenda "
				+ "INNER JOIN cliente ON encomenda.cliente = cliente.id "
				+ "WHERE encomenda.id = "+pesquisa;
		
		String sqlItem = "SELECT itemencomenda.id, itemencomenda.produtoId, itemencomenda.encomendaId, itemencomenda.qtd, produto.nome as nomeProduto," 
				+" produto.codigo, produto.valor, produto.id as produtoIdproduto"
				+" FROM gracibolos.itemencomenda"
				+" inner join gracibolos.produto on itemencomenda.produtoId = produto.id"
				+" where itemencomenda.encomendaId = "+pesquisa;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Encomenda encomenda=null;
		List<ItemEncomenda> listaDeItemEncomenda= null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) 
		{	
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			//da um get nos atributos do objeto encomenda
			encomenda = new Encomenda();
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
			encomenda.setNomerazao(rs.getString("nomerazao"));
			encomenda.setClienteId(rs.getLong("clienteId"));
			encomenda.setCpfcnpj(rs.getString("cpfcnpj"));
			
			
			//------Itens da encomenda---------------------------------------------------------
			ps = conn.prepareStatement(sqlItem);
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
				itemEncomenda.setValor(rs.getBigDecimal("valor"));//Produto
				
				listaDeItemEncomenda.add(itemEncomenda);
				
			}
			
			encomenda.setListItemEncomenda(listaDeItemEncomenda);
			
			ps.close();
			conn.close();			
		} 
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Erro ao listar as encomendas\n"+e);
		}
		//retorna o array
		return encomenda;
	}
	
	//Contagem de encomendas em aberto
	public int contagemEmAberto() 
	{
		String sql = "SELECT id FROM encomenda where status between 3 AND 4";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int tam = 0;
		  
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
		  ps = conn.prepareStatement(sql);
		  rs = ps.executeQuery();
		  rs.last();
		  tam = rs.getRow();
		}catch (Exception e) {
			//handle exception
		}
		return tam;
	}
	
	public List<Encomenda> finalizadas() throws Exception{
		
		//ENCOMENDAS FINALIZADAS
				String sql = "SELECT encomenda.id, encomenda.cliente, encomenda.status, encomenda.responsavel, encomenda.dataencomenda, encomenda.dataentrega"
						+ ", encomenda.datafaturamento, encomenda.dataproducao, encomenda.datafinalizado, encomenda.datacancelado, encomenda.total"
						+ ", encomenda.obs, cliente.nomerazao, cliente.id as clienteId, cliente.cpfcnpj "
						+ "FROM encomenda "
						+ "INNER JOIN cliente ON encomenda.cliente = cliente.id "
						+ "WHERE encomenda.status = 5 ";
											//5 - finalizadas
				return getListEncomenda(sql);
	}
	
	public List<Encomenda> emAberto() throws Exception{
		
		//ENCOMENDAS EM ABERTO
		String sql = "SELECT encomenda.id, encomenda.cliente, encomenda.status, encomenda.responsavel, encomenda.dataencomenda, encomenda.dataentrega"
				+ ", encomenda.datafaturamento, encomenda.dataproducao, encomenda.datafinalizado, encomenda.datacancelado, encomenda.total"
				+ ", encomenda.obs, cliente.nomerazao, cliente.id as clienteId, cliente.cpfcnpj "
				+ "FROM encomenda "
				+ "INNER JOIN cliente ON encomenda.cliente = cliente.id "
				+ "WHERE encomenda.status = 1 or encomenda.status = 3 or encomenda.status = 4";
									//3 - FATURADA , 4 - PRODUZINDO
		return getListEncomenda(sql);
	}
	
	public static List<Encomenda> getListEncomenda(String sql) throws Exception{
		
		ArrayList<Encomenda> listEnc = new ArrayList<>();
		//Encomenda
		PreparedStatement ps = null;
		ResultSet rs = null;
		Encomenda encomenda=null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) 
		{	
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				//da um get nos atributos do objeto encomenda
				encomenda = new Encomenda();
			
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
				encomenda.setNomerazao(rs.getString("nomerazao"));
				encomenda.setClienteId(rs.getLong("clienteId"));
				encomenda.setCpfcnpj(rs.getString("cpfcnpj"));
			
				//------Itens da encomenda---------------------------------------------------------
				 		
				
				
				listEnc.add(encomenda);
				
			}//while encomenda
			
			conn.close();
			ps.close();
						
		} 
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Erro ao listar as encomendas\n"+e);
		}
		//retorna o array
		return listEnc;
	}
}
