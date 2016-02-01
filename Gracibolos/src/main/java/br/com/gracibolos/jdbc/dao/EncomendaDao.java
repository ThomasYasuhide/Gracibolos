package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Encomenda;

public class EncomendaDao implements GenericoDao<Encomenda>{

	public boolean inserir(Encomenda encomenda) {
		boolean status = false;
		String sql = "INSERT INTO encomenda(responsavel, dataInicio, dataFaltaProd, dataProducao, dataFinalizado, dataEntrega,"
				+ " entregaRetirada, total, descricao, numero, suporteCollection, produtoprontoCollection, caixaCollection, itemencomendaCollection)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		
		try{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, encomenda.getResponsavel());
			
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, gravarEstaData);
			
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir usuário\n"+e);
		}
		return status;
	}

	public boolean alterar(Encomenda encomenda) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluir(Encomenda encomenda) {
		// TODO Auto-generated method stub
		return false;
		
	}

	public List<Encomenda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Encomenda> pesquisar(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
	}

}
