package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaDao implements GenericoDao<Conta>{

	public boolean inserir(Conta conta) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO conta(fornecedorId, colaboradorId, caixaId,"
				   + " codigo, dataVencimento, dataPagamento, valor)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, conta.getFornecedorId());
			ps.setInt(2, conta.getColaboradorId());
			ps.setInt(3, conta.getCaixaId());
			ps.setString(4, conta.getCodigo());
			ps.setDate(5, Date.valueOf(conta.getDataVencimento()));			
			ps.setDate(6, Date.valueOf(conta.getDataPagamento()));			
			ps.setBigDecimal(7, conta.getValor());			
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir conta\n"+e);
		}
		return status;
	}

	public boolean alterar(Conta conta) throws Exception{
		boolean status = false;
		String sql = "UPDATE conta SET fornecedorId=?, colaboradorId=?, caixaId=?, codigo=?,"
				   + " dataVencimento=?, dataPagamento=?, valor=? where id=?";
		
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, conta.getFornecedorId());
			ps.setInt(2, conta.getColaboradorId());
			ps.setInt(3, conta.getCaixaId());
			ps.setString(4, conta.getCodigo());
			ps.setDate(5, Date.valueOf(conta.getDataVencimento()));			
			ps.setDate(6, Date.valueOf(conta.getDataPagamento()));			
			ps.setBigDecimal(7, conta.getValor());
			ps.setLong(8, conta.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar o conta\n"+e);
		}
		return status;
	}

	public boolean excluir(Conta conta) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM conta WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){

			ps = conn.prepareStatement(sql);
			ps.setLong(1, conta.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar a conta");
		}
		
		return status;
	}

	public List<Conta> listar() throws Exception{

		String sql = "SELECT * FROM conta";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Conta> listaDeConta= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeConta = new ArrayList<Conta>();
			while(rs.next())
			{
				Conta conta = new Conta();
				conta.setId(rs.getLong("id"));
				conta.setFornecedorId(rs.getInt("fornecedorId"));
				conta.setColaboradorId(rs.getInt("colaboradorId"));
				conta.setCaixaId(rs.getInt("caixaId"));
				conta.setCodigo(rs.getString("codigo"));
				conta.setDataVencimento(rs.getDate("dataVencimento").toLocalDate());
				conta.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
				conta.setValor(rs.getBigDecimal("valor"));
				
				
				
				listaDeConta.add(conta);
				
				for(int i = 0;i<listaDeConta.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeConta.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar contas\n"+e);
		}
		return listaDeConta;
	}
	
	@Override
	public List<Conta> pesquisar(String pesquisa) throws Exception{
		return null;
	}

}
