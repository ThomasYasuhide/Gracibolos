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

	/*
	 * INCLUIR CONTA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma nova conta e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(Conta conta) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "INSERT INTO conta(fornecedorId, colaboradorId, caixaId,"
				   + " codigo, dataVencimento, dataPagamento, valor)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto conta
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
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir conta\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR CONTA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada conta e alterar os dados do banco de dados.
	 * 
	 * */
	
	public boolean alterar(Conta conta) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "UPDATE conta SET fornecedorId=?, colaboradorId=?, caixaId=?, codigo=?,"
				   + " dataVencimento=?, dataPagamento=?, valor=? where id=?";
		
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto conta, fazendo a alteração.
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
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar o conta\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * EXCLUIR CONTA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada conta e excluir do banco de dados.
	 * 
	 * */

	public boolean excluir(Conta conta) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "DELETE FROM conta WHERE id = ?";
		
		PreparedStatement ps;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta o id da conta, e excluir o objeto
			ps = conn.prepareStatement(sql);
			ps.setLong(1, conta.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();	
		} 
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar a conta");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * LISTAR CONTA
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todas as contas.
	 * 
	 */

	public List<Conta> listar() throws Exception{
		
		//string query do banco
		String sql = "SELECT * FROM conta";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Conta> listaDeConta= null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeConta = new ArrayList<Conta>();
			while(rs.next())
			{				
				//da um get nos atributos do objeto conta
				Conta conta = new Conta();
				conta.setId(rs.getLong("id"));
				conta.setFornecedorId(rs.getInt("fornecedorId"));
				conta.setColaboradorId(rs.getInt("colaboradorId"));
				conta.setCaixaId(rs.getInt("caixaId"));
				conta.setCodigo(rs.getString("codigo"));
				conta.setDataVencimento(rs.getDate("dataVencimento").toLocalDate());
				conta.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
				conta.setValor(rs.getBigDecimal("valor"));
				
				//adiciona o objeto caixa no arrayList
				listaDeConta.add(conta);
				
				//enquanto o arraylist tiver objeto conta, ele vai listando
				for(int i = 0;i<listaDeConta.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeConta.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar contas\n"+e);
		}
		//retorna o array
		return listaDeConta;
	}
	
	@Override
	public List<Conta> pesquisar(String pesquisa) throws Exception{
		return null;
	}

}
