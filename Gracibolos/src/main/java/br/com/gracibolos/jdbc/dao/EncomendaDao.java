package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Encomenda;

public class EncomendaDao implements GenericoDao<Encomenda>{

	public boolean inserir(Encomenda encomenda) throws Exception{
		boolean status = false;
		String sql = " INSERT INTO encomenda(responsavel, dataInicio, dataFaltaProd, dataProducao, dataFinalizado, dataEntrega,"
				   + " entregaRetirada, total, descricao, numero, clienteId, statusNome)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, encomenda.getResponsavel());
			
			Date dataInicio = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, dataInicio);			
			Date dataFaltaProd = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, dataFaltaProd);
			Date dataProducao = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(4, dataProducao);
			Date dataFinalizado = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(5, dataFinalizado);
			Date dataEntrega = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(6, dataEntrega);
			
			ps.setBoolean(7, encomenda.getEntregaRetirada());
			ps.setBigDecimal(8, encomenda.getTotal());
			ps.setString(9, encomenda.getDescricao());
			ps.setInt(10, encomenda.getNumero());
			ps.setInt(11, encomenda.getClienteId());
			ps.setString(12, encomenda.getStatusNome());
			
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
		String sql = " UPDATE encomenda SET responsavel=?, dataInicio=?, dataFaltaProd=?, dataProducao=?, dataFinalizado=?,"
				   + " dataEntrega=?, entregaRetirada=?, total=?, descricao=?, numero=?, clienteId=?, statusNome=? where id=?";
		
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, encomenda.getResponsavel());
			
			Date dataInicio = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, dataInicio);			
			Date dataFaltaProd = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, dataFaltaProd);
			Date dataProducao = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(4, dataProducao);
			Date dataFinalizado = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(5, dataFinalizado);
			Date dataEntrega = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(6, dataEntrega);
			
			ps.setBoolean(7, encomenda.getEntregaRetirada());
			ps.setBigDecimal(8, encomenda.getTotal());
			ps.setString(9, encomenda.getDescricao());
			ps.setInt(10, encomenda.getNumero());
			ps.setInt(11, encomenda.getClienteId());
			ps.setString(12, encomenda.getStatusNome());
			ps.setInt(13, encomenda.getId());
			
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
			ps.setInt(1, encomenda.getId());
			
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
				encomenda.setId(rs.getInt("id"));
				encomenda.setResponsavel(rs.getString("responsavel"));
				encomenda.setDataInicio(Calendar.getInstance());
				encomenda.setDataFaltaProd(Calendar.getInstance());
				encomenda.setDataProducao(Calendar.getInstance());
				encomenda.setDataFinalizado(Calendar.getInstance());
				encomenda.setDataEntrega(Calendar.getInstance());
				encomenda.setEntregaRetirada(rs.getBoolean("entregaRetirada"));
				encomenda.setTotal(rs.getBigDecimal("total"));
				encomenda.setDescricao(rs.getString("descricao"));
				encomenda.setNumero(rs.getInt("numero"));
				encomenda.setClienteId(rs.getInt("clienteId"));	
				encomenda.setStatusNome(rs.getString("statusNome"));
				
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
		// TODO Auto-generated method stub
		return null;
	}

}
