package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class FornecedorDao implements GenericoDao<Fornecedor>{

	/*
	 * INCLUIR FORNECEDOR
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo fornecedor e persistir no banco de dados.
	 * 
	 * */
	
	@Override
	public boolean inserir(Fornecedor fornecedor) {
		
		boolean status = false;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO fornecedor(tipopessoa, nomerazao, cpfcnpj, rgie, endereco, numero, complemento, bairro, estado, cidade, cep, tel, cel, email, site, obs) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fornecedor.getTipopessoa());
			ps.setString(2, fornecedor.getNomerazao());
			ps.setString(3, fornecedor.getCpfcnpj());
			ps.setString(4, fornecedor.getRgie());
			ps.setString(5, fornecedor.getEndereco());
			ps.setString(6, fornecedor.getNumero());
			ps.setString(7, fornecedor.getComplemento());
			ps.setString(8, fornecedor.getBairro());
			ps.setInt(9, fornecedor.getEstado());
			ps.setInt(10, fornecedor.getCidade());
			ps.setInt(11, fornecedor.getCep());
			ps.setString(12, fornecedor.getTel());
			ps.setString(13, fornecedor.getCel());
			ps.setString(14, fornecedor.getEmail());
			ps.setString(15, fornecedor.getSite());
			ps.setString(16, fornecedor.getObs());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Houve um erro ao inserir o fornecedor");
		}
		
		return status;
	}
	
	/*
	 * ALTERAR FORNECEDOR
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado fornecedor e alterar os dados do banco de dados.
	 * 
	 * */
	
	@Override
	public boolean alterar(Fornecedor fornecedor) {
		
		boolean status = false;
		PreparedStatement  ps = null;
		String sql = "UPDATE fornecedor SET tipopessoa=?, nomerazao=?, cpfcnpj=?, rgie=?, endereco=?, numero=?, complemento=?, bairro=?, estado=?, cidade=?, cep=?, tel=?, cel=?, email=?, site=?, obs=? where id=?";
				
		try(Connection conn = ConnectionProvider.getInstance().getConnection())	{
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fornecedor.getTipopessoa());
			ps.setString(2, fornecedor.getNomerazao());
			ps.setString(3, fornecedor.getCpfcnpj());
			ps.setString(4, fornecedor.getRgie());
			ps.setString(5, fornecedor.getEndereco());
			ps.setString(6, fornecedor.getNumero());
			ps.setString(7, fornecedor.getComplemento());
			ps.setString(8, fornecedor.getBairro());
			ps.setInt(9, fornecedor.getEstado());
			ps.setInt(10, fornecedor.getCidade());
			ps.setInt(11, fornecedor.getCep());
			ps.setString(12, fornecedor.getTel());
			ps.setString(13, fornecedor.getCel());
			ps.setString(14, fornecedor.getEmail());
			ps.setString(15, fornecedor.getSite());
			ps.setString(16, fornecedor.getObs());
			ps.setLong(17, fornecedor.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
			
		}
		catch (SQLException e) {
			System.out.println("Houve um erro ao alterar o fornecedor");
		}
		
		return status;
	}
	
	/*
	 * EXCLUIR FORNECEDOR
	 * 
	 * Este método tem como principal objetivo receber os dados de um determinado fornecedor e excluir do banco de dados.
	 * 
	 * */
	
	@Override
	public boolean excluir(Fornecedor fornecedor) {
		
		boolean status = false;
		PreparedStatement ps = null;
		String sql  = "DELETE FROM fornecedor WHERE id = ?";
		
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, fornecedor.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar deletar o fornecedor");
		}
		
		return status;
	}
	
	/*
	 * LISTAR FORNECEDORES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos fornecedores.
	 * 
	 * */
	
	@Override
	public List<Fornecedor> listar() {
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, tipopessoa, nomerazao, cpfcnpj, rgie, endereco, "
				+ "numero, complemento, bairro, estado, cidade, cep, tel, cel, email, site, obs FROM fornecedor";
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setTipopessoa(rs.getInt("tipopessoa"));
				fornecedor.setNomerazao(rs.getString("nomerazao"));
				fornecedor.setCpfcnpj(rs.getString("cpfcnpj"));
				fornecedor.setRgie(rs.getString("rgie"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setNumero(rs.getString("numero"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setEstado(rs.getInt("estado"));
				fornecedor.setCidade(rs.getInt("cidade"));
				fornecedor.setCep(rs.getInt("cep"));
				fornecedor.setTel(rs.getString("tel"));
				fornecedor.setCel(rs.getString("cel"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setSite(rs.getString("site"));
				fornecedor.setObs(rs.getString("obs"));
				
				fornecedores.add(fornecedor);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Houve um erro ao listar os clientes");
		}
		
		return fornecedores;
	}
	
	/*
	 * PESQUISAR FORNECEDORES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos fornecedores pesquisados.
	 * 
	 * */
	
	@Override
	public List<Fornecedor> pesquisar(String pesquisa) {
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, tipopessoa, nomerazao, cpfcnpj, rgie, endereco, "
				+ "numero, complemento, bairro, estado, cidade, cep, tel, cel, email, site, obs FROM fornecedor WHERE cpfcnpj = ? OR nomerazao LIKE ? OR rgie = ?";
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			ps.setString(3, pesquisa);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setTipopessoa(rs.getInt("tipopessoa"));
				fornecedor.setNomerazao(rs.getString("nomerazao"));
				fornecedor.setCpfcnpj(rs.getString("cpfcnpj"));
				fornecedor.setRgie(rs.getString("rgie"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setNumero(rs.getString("numero"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setEstado(rs.getInt("estado"));
				fornecedor.setCidade(rs.getInt("cidade"));
				fornecedor.setCep(rs.getInt("cep"));
				fornecedor.setTel(rs.getString("tel"));
				fornecedor.setCel(rs.getString("cel"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setSite(rs.getString("site"));
				fornecedor.setObs(rs.getString("obs"));
				
				fornecedores.add(fornecedor);
			}
			
			ps.close();
			rs.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Houve um erro ao pesquisar o fornecedor");
		}
		
		return fornecedores;
	}

}
