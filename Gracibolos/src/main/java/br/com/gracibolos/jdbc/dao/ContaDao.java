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
import br.com.gracibolos.jdbc.model.Conta;

public class ContaDao implements GenericoDao<Conta>{

	public boolean inserir(Conta conta) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO conta(codigo, dataVencimento, dataPagamento,"
				   + " valor, caixaId, fornecedorId, colaboradorId)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, conta.getCodigo());

			Date dataVencimento = new Date(Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, dataVencimento);
			
			Date dataPagamento = new Date(Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, dataPagamento);
			
			ps.setBigDecimal(4, conta.getValor());
			ps.setInt(5, conta.getCaixaId());
			ps.setInt(6, conta.getFornecedorId());
			ps.setInt(7, conta.getColaboradorId());
			
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
		String sql = "UPDATE conta SET codigo=?, dataVencimento=?, dataPagamento=?, valor=?,"
				   + " caixaId=?, fornecedorId=?, colaboradorId=? where id=?";
		
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, conta.getCodigo());

			Date dataVencimento = new Date(Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, dataVencimento);
			
			Date dataPagamento = new Date(Calendar.getInstance().getTimeInMillis());
			ps.setDate(3, dataPagamento);
			
			ps.setBigDecimal(4, conta.getValor());
			ps.setInt(5, conta.getCaixaId());
			ps.setInt(6, conta.getFornecedorId());
			ps.setInt(7, conta.getColaboradorId());
			ps.setInt(8, conta.getId());
			
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
				conta.setId(rs.getInt("id"));
				conta.setCodigo(rs.getString("codigo"));
				conta.setDataVencimento(Calendar.getInstance());
				conta.setDataPagamento(Calendar.getInstance());
				conta.setValor(rs.getBigDecimal("valor"));
				conta.setCaixaId(rs.getInt("caixaId"));
				conta.setFornecedorId(rs.getInt("fornecedorId"));
				conta.setColaboradorId(rs.getInt("colaboradorId"));
				
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
		// TODO Auto-generated method stub
		return null;
	}

}
