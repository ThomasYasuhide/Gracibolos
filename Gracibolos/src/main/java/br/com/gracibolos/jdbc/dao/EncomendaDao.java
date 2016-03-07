package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Encomenda;

public class EncomendaDao implements GenericoDao<Encomenda>{

	public boolean inserir(Encomenda encomenda) throws Exception{
		boolean status = false;
		String sql = " INSERT INTO encomenda(clienteId, statusNome, responsavel, dataInicio, dataFaltaProd, dataProducao,"
				   + " dataFinalizado, dataEntrega, entregaRetirada, total, descricao, numero)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, encomenda.getClienteId());
			ps.setString(2, encomenda.getStatusNome());
			ps.setString(3, encomenda.getResponsavel());
			ps.setDate(4, Date.valueOf(encomenda.getDataInicio()));
			ps.setDate(5, Date.valueOf(encomenda.getDataFaltaProd()));
			ps.setDate(6, Date.valueOf(encomenda.getDataProducao()));
			ps.setDate(7, Date.valueOf(encomenda.getDataFinalizado()));
			ps.setDate(8, Date.valueOf(encomenda.getDataEntrega()));			
			ps.setBoolean(9, encomenda.getEntregaRetirada());
			ps.setBigDecimal(10, encomenda.getTotal());
			ps.setString(11, encomenda.getDescricao());
			ps.setInt(12, encomenda.getNumero());			
			
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

	public boolean alterar(Encomenda encomenda) throws Exception{
		boolean status = false;
		String sql = " UPDATE encomenda SET clienteId=?, statusNome=?, responsavel=?, dataInicio=?, dataFaltaProd=?,"
				   + " dataProducao=?, dataFinalizado=?, dataEntrega=?, entregaRetirada=?, total=?, descricao=?, numero=? where id=?";
		
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, encomenda.getClienteId());
			ps.setString(2, encomenda.getStatusNome());
			ps.setString(3, encomenda.getResponsavel());
			ps.setDate(4, Date.valueOf(encomenda.getDataInicio()));
			ps.setDate(5, Date.valueOf(encomenda.getDataFaltaProd()));
			ps.setDate(6, Date.valueOf(encomenda.getDataProducao()));
			ps.setDate(7, Date.valueOf(encomenda.getDataFinalizado()));
			ps.setDate(8, Date.valueOf(encomenda.getDataEntrega()));			
			ps.setBoolean(9, encomenda.getEntregaRetirada());
			ps.setBigDecimal(10, encomenda.getTotal());
			ps.setString(11, encomenda.getDescricao());
			ps.setInt(12, encomenda.getNumero());			
			ps.setLong(13, encomenda.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a encomenda\n"+e);
		}
		return status;
	}

	public boolean excluir(Encomenda encomenda) throws Exception{
		boolean status = false;
		
		String sql  = "DELETE FROM encomenda WHERE id = ?";
		PreparedStatement ps;

		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{		
			ps = conn.prepareStatement(sql);
			ps.setLong(1, encomenda.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao deletar encomenda \n" + e);
		}		
		return status;
	}

	public List<Encomenda> listar() throws Exception{
		String sql = "SELECT * FROM encomenda";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Encomenda> listaDeEncomenda= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeEncomenda = new ArrayList<Encomenda>();
			while(rs.next())
			{
				Encomenda encomenda = new Encomenda();
				encomenda.setId(rs.getLong("id"));
				encomenda.setClienteId(rs.getInt("clienteId"));	
				encomenda.setStatusNome(rs.getString("statusNome"));
				encomenda.setResponsavel(rs.getString("responsavel"));
				encomenda.setDataInicio(rs.getDate("dataInicio").toLocalDate());
				encomenda.setDataFaltaProd(rs.getDate("dataFaltaProd").toLocalDate());
				encomenda.setDataProducao(rs.getDate("dataProducao").toLocalDate());
				encomenda.setDataFinalizado(rs.getDate("dataFinalizado").toLocalDate());
				encomenda.setDataEntrega(rs.getDate("dataEntrega").toLocalDate());
				encomenda.setEntregaRetirada(rs.getBoolean("entregaRetirada"));
				encomenda.setTotal(rs.getBigDecimal("total"));
				encomenda.setDescricao(rs.getString("descricao"));
				encomenda.setNumero(rs.getInt("numero"));
				
				
				listaDeEncomenda.add(encomenda);
				
				for(int i = 0;i<listaDeEncomenda.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeEncomenda.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar as encomendas\n"+e);
		}
		return listaDeEncomenda;
	}

	@Override
	public List<Encomenda> pesquisar(String pesquisa) throws Exception{
		return null;
	}

}
