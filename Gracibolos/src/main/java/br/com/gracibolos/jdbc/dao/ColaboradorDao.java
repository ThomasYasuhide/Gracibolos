package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Colaborador;

public class ColaboradorDao {

	/*
	 * LISTAR COLABORADORES
	 * 
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos colaboradores pesquisados.
	 * 
	 * */
	
	public List<Colaborador> pesquisa_colaborador(String pesquisa){
		
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		
		PreparedStatement ps;
		String sql = "SELECT * FROM colaborador WHERE cpf = ? OR nome LIKE ? OR rg = ?";
		ResultSet rs;
		
		try {
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			ps.setString(3, pesquisa);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
							
				Colaborador colaborador = new Colaborador();
				colaborador.setId(rs.getInt("id"));
				colaborador.setStatus(rs.getByte("status"));
				colaborador.setUsuario(rs.getString("usuario"));
				colaborador.setSenha(rs.getString("senha"));
				colaborador.setNivel(rs.getInt("nivel"));
				colaborador.setNome(rs.getString("nome"));
				colaborador.setCpf(rs.getString("cpf"));
				colaborador.setRg(rs.getString("rg"));
				colaborador.setEndereco(rs.getString("endereco"));
				colaborador.setNumero(rs.getString("numero"));
				colaborador.setComplemento(rs.getString("complemento"));
				colaborador.setBairro(rs.getString("bairro"));
				colaborador.setCep(rs.getString("cep"));
				colaborador.setTel(rs.getString("tel"));
				colaborador.setCel(rs.getString("cel"));
				colaborador.setEmail(rs.getString("email"));
				colaborador.setObs(rs.getString("obs"));
				
				colaboradores.add(colaborador);
			}
			
			rs.close();
			conn.close();
					
		} catch (Exception e) {
			
		}
		
		return colaboradores;
		
	}
	
	/*
	 * INCLUIR COLABORADOR
	 * 
	 * Este método tem como principal objetivo receber os dados de um novo colaborador e persistir no banco de dados.
	 * 
	 * */
	public boolean incluir_colaborador(Colaborador colaborador){
		
		boolean status = false;
		
		PreparedStatement ps;
		String sql = "INSERT INTO colaborador (id, status, usuario, senha, nivel, nome, cpf, rg, numero, complemento, cep, tel, cel, email, obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, colaborador.getId());
			ps.setByte(2, colaborador.getStatus());
			ps.setString(3, colaborador.getUsuario());
			ps.setString(4, colaborador.getSenha());
			ps.setInt(5, colaborador.getNivel());
			ps.setString(6, colaborador.getNome());
			ps.setString(7, colaborador.getCpf());
			ps.setString(8, colaborador.getRg());
			ps.setString(9, colaborador.getNumero());
			ps.setString(10, colaborador.getComplemento());
			ps.setString(11, colaborador.getCep());
			ps.setString(12, colaborador.getTel());
			ps.setString(13, colaborador.getCel());
			ps.setString(14, colaborador.getEmail());
			ps.setString(15, colaborador.getObs());
			
			status = ps.execute();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			
		}
		
		return status;
	}
	
}



/*
	
	public void inserir(Apontamento apontamento) {
		//Requisição SQL
		String sql = "INSERT INTO apontamento (UsuarioID, TarefaID, Inicio, Fim, Total, Observacao, Status) VALUES(?,?,?,?,calculadiferenca(?,?),?,?)";

		PreparedStatement ps;

		//Tenta realizar uma conexão com o banco de dados
		try(Connection conn = ConnectionFactory.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, apontamento.getUserID());
			ps.setInt(2, apontamento.getTarefaID());
			ps.setTimestamp(3, Timestamp.valueOf(apontamento.getInicio())); //Transforma LocalDateTime para Timestamp
			ps.setTimestamp(4, Timestamp.valueOf(apontamento.getFim())); //Transforma LocalDateTime para Timestamp
			ps.setTimestamp(5, Timestamp.valueOf(apontamento.getFim())); //Transforma LocalDateTime para Timestamp
			ps.setTimestamp(6, Timestamp.valueOf(apontamento.getInicio())); //Transforma LocalDateTime para Timestamp
			ps.setString(7, apontamento.getObs());
			ps.setString(8, "Pendente");  //Todo apontamento criado entra como pendente automatico
			
			ps.execute();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void atualizar(Apontamento apontamento){
		//Requisição SQL
		String sql = "UPDATE apontamento SET TarefaID = ?, inicio = ?, fim = ?, total = calculadiferenca(?,?), Observacao = ?, Status = ? WHERE apontamentoID = ?";
		
		PreparedStatement ps;
		
		System.out.println(Timestamp.valueOf(apontamento.getFim()));
		
		//Tenta realizar uma conexão com o banco de dados
		try(Connection conn = ConnectionFactory.getConnection()){
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, apontamento.getTarefaID());
			ps.setTimestamp(2, Timestamp.valueOf(apontamento.getInicio())); //Transforma LocalDateTime para Timestamp
			ps.setTimestamp(3, Timestamp.valueOf(apontamento.getFim())); //Transforma LocalDateTime para Timestamp
			ps.setTimestamp(4, Timestamp.valueOf(apontamento.getFim())); //Transforma LocalDateTime para Timestamp
			ps.setTimestamp(5, Timestamp.valueOf(apontamento.getInicio())); //Transforma LocalDateTime para Timestamp
			ps.setString(6, apontamento.getObs());
			ps.setString(7, "Pendente");
			ps.setInt(8, apontamento.getId());
			

			ps.execute();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Apontamento apontamento){
		//Requisição SQL
		String sql = "DELETE FROM apontamento WHERE apontamentoID = ?";

		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try(Connection conn = ConnectionFactory.getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, apontamento.getId());

			ps.execute();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	

*/