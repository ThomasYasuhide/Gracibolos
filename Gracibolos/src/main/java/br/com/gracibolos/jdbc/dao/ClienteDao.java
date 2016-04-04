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
import br.com.gracibolos.jdbc.model.Cliente;

public class ClienteDao implements GenericoDao<Cliente>{

	/*
	 * INCLUIR CLIENTE
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo cliente e persistir no banco de dados.
	 * 
	 * */
	
	@Override
	public boolean inserir(Cliente cliente) throws Exception {
		
		boolean status = false;
		PreparedStatement ps = null;
		
		//string query do banco
		String sql = "INSERT INTO cliente(status, tipopessoa, sexo, datanascimento, nomerazao, cpfcnpj, rgie, endereco, "
				+ "numero, complemento, bairro, estado, cidade, cep, tel, cel, email, site, clientedesde, obs) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta os atributos do objeto cliente
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cliente.getStatus());
			ps.setInt(2, cliente.getTipopessoa());
			
			if(cliente.getSexo() != null){
				ps.setInt(3, cliente.getSexo());
			}else{
				ps.setNull(3, Types.INTEGER);
			}
			
			if(cliente.getDatanascimento() != null){
				ps.setDate(4, Date.valueOf(cliente.getDatanascimento()));
			}else{
				ps.setNull(4, Types.DATE);
			}
			
			ps.setString(5, cliente.getNomerazao());
			ps.setString(6, cliente.getCpfcnpj());
			ps.setString(7, cliente.getRgie());
			ps.setString(8, cliente.getEndereco());
			ps.setString(9, cliente.getNumero());
			ps.setString(10, cliente.getComplemento());
			ps.setString(11, cliente.getBairro());
			ps.setInt(12, cliente.getEstado());
			ps.setInt(13, cliente.getCidade());
			ps.setString(14, cliente.getCep());
			ps.setString(15, cliente.getTel());
			ps.setString(16, cliente.getCel());
			ps.setString(17, cliente.getEmail());
			ps.setString(18, cliente.getSite());
			
			if(cliente.getClientedesde() != null){
				ps.setDate(19, Date.valueOf(cliente.getClientedesde()));
			}else{
				ps.setNull(19, Types.DATE);
			}
			
			ps.setString(20, cliente.getObs());
			
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
			System.out.println("Houve um erro ao inserir o cliente");
			throw new Exception("Houve um erro ao inserir o cliente");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR CLIENTE
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado cliente e alterar os dados do banco de dados.
	 * 
	 * */
	
	@Override
	public boolean alterar(Cliente cliente) throws Exception {
		
		boolean status = false;
		PreparedStatement  ps = null;
		
		//string query do banco
		String sql = "UPDATE cliente SET status=?, tipopessoa=?, sexo=?, datanascimento=?, nomerazao=?, cpfcnpj=?, rgie=?, endereco=?,"
				+ " numero=?, complemento=?, bairro=?, estado=?, cidade=?, cep=?, tel=?, cel=?, email=?, site=?, clientedesde=?, obs=? where id=?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())	{
			
			//seta os atributos do objeto cliente, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cliente.getStatus());
			ps.setInt(2, cliente.getTipopessoa());
			
			if(cliente.getSexo() != null){
				ps.setInt(3, cliente.getSexo());
			}else{
				ps.setNull(3, Types.INTEGER);
			}
			
			if(cliente.getDatanascimento() != null){
				ps.setDate(4, Date.valueOf(cliente.getDatanascimento()));
			}else{
				ps.setNull(4, Types.DATE);
			}
			
			ps.setString(5, cliente.getNomerazao());
			ps.setString(6, cliente.getCpfcnpj());
			ps.setString(7, cliente.getRgie());
			ps.setString(8, cliente.getEndereco());
			ps.setString(9, cliente.getNumero());
			ps.setString(10, cliente.getComplemento());
			ps.setString(11, cliente.getBairro());
			ps.setInt(12, cliente.getEstado());
			ps.setInt(13, cliente.getCidade());
			ps.setString(14, cliente.getCep());
			ps.setString(15, cliente.getTel());
			ps.setString(16, cliente.getCel());
			ps.setString(17, cliente.getEmail());
			ps.setString(18, cliente.getSite());

			if(cliente.getClientedesde() != null){
				ps.setDate(19, Date.valueOf(cliente.getClientedesde()));
			}else{
				ps.setNull(19, Types.DATE);
			}
			
			ps.setString(20, cliente.getObs());
			ps.setLong(21, cliente.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();
			conn.close();
			
		}
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao alterar o colaborador");
			throw new Exception("Houve um erro ao alterar o colaborador");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * EXCLUIR CLIENTE
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado cliente e excluir do banco de dados.
	 * 
	 * */
	
	@Override
	public boolean excluir(Cliente cliente) throws Exception {
		
		boolean status = false;
		PreparedStatement ps = null;
		
		//string query do banco
		String sql  = "DELETE FROM cliente WHERE id = ?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta o id do caixa, e excluir o objeto
			ps = conn.prepareStatement(sql);			
			ps.setLong(1, cliente.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conexões
			ps.close();
			conn.close();

		} 
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Houve um erro ao tentar deletar o colaborador");
			throw new Exception("Houve um erro ao tentar deletar o colaborador");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * LISTAR CLIENTES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos clientes.
	 * 
	 * */
	
	@Override
	public List<Cliente> listar() throws Exception {
		
		List<Cliente> Clientes = new ArrayList<Cliente>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = "SELECT id, status, tipopessoa, sexo, datanascimento, nomerazao, cpfcnpj, rgie, endereco, "
				+ "numero, complemento, bairro, estado, cidade, cep, tel, cel, email, site, clientedesde, obs FROM cliente";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//da um get nos atributos do objeto cliente
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setStatus(rs.getInt("status"));
				cliente.setTipopessoa(rs.getInt("tipopessoa"));
				cliente.setSexo(rs.getInt("sexo"));
				
				if(rs.getDate("datanascimento") != null){
					cliente.setDatanascimento(rs.getDate("datanascimento").toLocalDate());
				}
				
				cliente.setNomerazao(rs.getString("nomerazao"));
				cliente.setCpfcnpj(rs.getString("cpfcnpj"));
				cliente.setRgie(rs.getString("rgie"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setEstado(rs.getInt("estado"));
				cliente.setCidade(rs.getInt("cidade"));
				cliente.setCep(rs.getString("cep"));
				cliente.setTel(rs.getString("tel"));
				cliente.setCel(rs.getString("cel"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSite(rs.getString("site"));

				if(rs.getDate("clientedesde") != null){
					cliente.setClientedesde(rs.getDate("clientedesde").toLocalDate());
				}
				
				cliente.setObs(rs.getString("obs"));
				
				//adiciona o objeto cliente no arrayList
				Clientes.add(cliente);
				
			}
			
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
		}
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao listar os clientes");
			throw new Exception("Houve um erro ao listar os clientes");
		}
		//retorna o array
		return Clientes;
	}
	
	/*
	 * PESQUISAR CLIENTES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos clientes pesquisados.
	 * 
	 * */
	
	@Override
	public List<Cliente> pesquisar(String pesquisa) throws Exception {
		
		List<Cliente> Clientes = new ArrayList<Cliente>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = "SELECT id, status, tipopessoa, sexo, datanascimento, nomerazao, cpfcnpj, rgie, endereco, "
				+ "numero, complemento, bairro, estado, cidade, cep, tel, cel, email, site, clientedesde, obs FROM cliente WHERE cpfcnpj = ? OR nomerazao LIKE ? OR rgie = ?";
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			ps.setString(3, pesquisa);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				//da um get nos atributos do objeto cliente
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setStatus(rs.getInt("status"));
				cliente.setTipopessoa(rs.getInt("tipopessoa"));
				cliente.setSexo(rs.getInt("sexo"));
				
				if(rs.getDate("datanascimento") != null){
					cliente.setDatanascimento(rs.getDate("datanascimento").toLocalDate());
				}
				
				cliente.setNomerazao(rs.getString("nomerazao"));
				cliente.setCpfcnpj(rs.getString("cpfcnpj"));
				cliente.setRgie(rs.getString("rgie"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setEstado(rs.getInt("estado"));
				cliente.setCidade(rs.getInt("cidade"));
				cliente.setCep(rs.getString("cep"));
				cliente.setTel(rs.getString("tel"));
				cliente.setCel(rs.getString("cel"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSite(rs.getString("site"));

				if(rs.getDate("clientedesde") != null){
					cliente.setClientedesde(rs.getDate("clientedesde").toLocalDate());
				}
				
				cliente.setObs(rs.getString("obs"));
				
				//adiciona o objeto cliente no arrayList
				Clientes.add(cliente);
			}
			
			//fecha as conexões
			ps.close();
			rs.close();
			conn.close();
		}
		//trata, caso de uma exceção
		catch (SQLException e) {
			System.out.println("Houve um erro ao pesquisar o cliente");
			throw new Exception("Houve um erro ao pesquisar o cliente");
		}
		//retorna o array
		return Clientes;
	}

}
