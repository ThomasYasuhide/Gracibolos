package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Colaborador;

public class ColaboradorDao implements GenericoDao<Colaborador> {

	/*
	 * INCLUIR COLABORADOR
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo colaborador e persistir no banco de dados.
	 * 
	 * */
	
	@Override
	public boolean inserir(Colaborador colaborador) {
		boolean status = false;
		
		PreparedStatement ps;
		String sql = "INSERT INTO colaborador (id, status, nivel, usuario, senha, nome, cpf, rg, endereco, numero, complemento, bairro, cep, tel, cel, email, obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){

			ps = conn.prepareStatement(sql);
			ps.setInt(1, colaborador.getId());
			ps.setByte(2, colaborador.getStatus());
			ps.setInt(3, colaborador.getNivel());
			ps.setString(4, colaborador.getUsuario());
			ps.setString(5, colaborador.getSenha());
			ps.setString(6, colaborador.getNome());
			ps.setString(7, colaborador.getCpf());
			ps.setString(8, colaborador.getRg());
			ps.setString(9, colaborador.getEndereco());
			ps.setString(10, colaborador.getNumero());
			ps.setString(11, colaborador.getComplemento());
			ps.setString(12, colaborador.getBairro());
			ps.setString(13, colaborador.getCep());
			ps.setString(14, colaborador.getTel());
			ps.setString(15, colaborador.getCel());
			ps.setString(16, colaborador.getEmail());
			ps.setString(17, colaborador.getObs());
			
			status = ps.execute();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Houve um erro ao inserir o colaborador");
		}
		
		return status;
	}


	@Override
	public boolean alterar(Colaborador colaborador) {
		boolean status = false;
		
		PreparedStatement ps;
		String sql = "UPDATE colaborador SET status = ?, nivel = ?, usuario = ?, senha = ?, nome = ?, cpf = ?, rg = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, tel = ?, cel = ?, email = ?, obs = ? WHERE id = ?";

		try (Connection conn = ConnectionProvider.getInstance().getConnection()){

			ps = conn.prepareStatement(sql);
			
			ps.setByte(1, colaborador.getStatus());
			ps.setInt(2, colaborador.getNivel());
			ps.setString(3, colaborador.getUsuario());
			ps.setString(4, colaborador.getSenha());
			ps.setString(5, colaborador.getNome());
			ps.setString(6, colaborador.getCpf());
			ps.setString(7, colaborador.getRg());
			ps.setString(8, colaborador.getEndereco());
			ps.setString(9, colaborador.getNumero());
			ps.setString(10, colaborador.getComplemento());
			ps.setString(11, colaborador.getBairro());
			ps.setString(12, colaborador.getCep());
			ps.setString(13, colaborador.getTel());
			ps.setString(14, colaborador.getCel());
			ps.setString(15, colaborador.getEmail());
			ps.setString(16, colaborador.getObs());
			ps.setInt(17, colaborador.getId());
			
			status = ps.execute();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Houve um erro ao alterar o colaborador");
		}
		
		return status;
	}


	@Override
	public boolean excluir(Colaborador colaborador) {
		boolean status = false;
		
		String sql = "DELETE FROM colaborador WHERE id = ?";
	
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){

			ps = conn.prepareStatement(sql);
			ps.setInt(1, colaborador.getId());
	
			status = ps.execute();
	
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o colaborador");
		}
		
		return status;
	}
	
	/*
	 * LISTAR COLABORADORES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos colaboradores.
	 * 
	 * */

	@Override
	public List<Colaborador> listar() {
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		
		PreparedStatement ps;
		String sql = "SELECT id, status, nivel, usuario, senha, nome, cpf, rg, endereco, numero, complemento, bairro, cep, estado, cidade, tel, cel, email, obs FROM colaborador";
		ResultSet rs;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
						
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()){
							
				Colaborador colaborador = new Colaborador();
				colaborador.setId(rs.getInt("id"));
				colaborador.setStatus(rs.getByte("status"));
				colaborador.setNivel(rs.getInt("nivel"));
				colaborador.setUsuario(rs.getString("usuario"));
				colaborador.setSenha(rs.getString("senha"));
				colaborador.setNome(rs.getString("nome"));
				colaborador.setCpf(rs.getString("cpf"));
				colaborador.setRg(rs.getString("rg"));
				colaborador.setEndereco(rs.getString("endereco"));
				colaborador.setNumero(rs.getString("numero"));
				colaborador.setComplemento(rs.getString("complemento"));
				colaborador.setBairro(rs.getString("bairro"));
				colaborador.setCep(rs.getString("cep"));
				colaborador.setEstado(rs.getInt("estado"));
				colaborador.setCidade(rs.getInt("cidade"));
				colaborador.setTel(rs.getString("tel"));
				colaborador.setCel(rs.getString("cel"));
				colaborador.setEmail(rs.getString("email"));
				colaborador.setObs(rs.getString("obs"));
				
				colaboradores.add(colaborador);
			}
			
			ps.close();
			rs.close();
			conn.close();
					
		} catch (Exception e) {
			System.out.println("Houve um erro ao listar os colaboradores");
		}
		
		return colaboradores;
	}

	/*
	 * LISTAR COLABORADORES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos colaboradores pesquisados.
	 * 
	 * */
	
	@Override
	public List<Colaborador> pesquisar(String pesquisa) {
		
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		
		PreparedStatement ps;
		String sql = "SELECT id, status, nivel, usuario, senha, nome, cpf, rg, endereco, numero, complemento, bairro, cep, estado, cidade, tel, cel, email, obs FROM colaborador WHERE cpf = ? OR nome LIKE ? OR rg = ?";
		ResultSet rs;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
						
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			ps.setString(3, pesquisa);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
							
				Colaborador colaborador = new Colaborador();
				colaborador.setId(rs.getInt("id"));
				colaborador.setStatus(rs.getByte("status"));
				colaborador.setNivel(rs.getInt("nivel"));
				colaborador.setUsuario(rs.getString("usuario"));
				colaborador.setSenha(rs.getString("senha"));
				colaborador.setNome(rs.getString("nome"));
				colaborador.setCpf(rs.getString("cpf"));
				colaborador.setRg(rs.getString("rg"));
				colaborador.setEndereco(rs.getString("endereco"));
				colaborador.setNumero(rs.getString("numero"));
				colaborador.setComplemento(rs.getString("complemento"));
				colaborador.setBairro(rs.getString("bairro"));
				colaborador.setCep(rs.getString("cep"));
				colaborador.setEstado(rs.getInt("estado"));
				colaborador.setCidade(rs.getInt("cidade"));
				colaborador.setTel(rs.getString("tel"));
				colaborador.setCel(rs.getString("cel"));
				colaborador.setEmail(rs.getString("email"));
				colaborador.setObs(rs.getString("obs"));
				
				colaboradores.add(colaborador);
			}
			
			ps.close();
			rs.close();
			conn.close();
					
		} catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o colaborador");
		}
		
		return colaboradores;
	}
	
}