package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Compra;

public class CompraDao implements GenericoDao<Compra>{

	/*
	 * INCLUIR COMPRA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma nova compra e persistir no banco de dados.
	 * 
	 * */
	
	public boolean inserir(Compra compra) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = " INSERT INTO compra(fornecedorId, statusNome, tipo, numero, data,"
				   + " total)"
				   + " VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto compra
			ps = conn.prepareStatement(sql);
			ps.setInt(1, compra.getFornecedorId());
			ps.setString(2, compra.getStatusNome());
			ps.setString(3, compra.getTipo());
			ps.setString(4, compra.getNumero());			
			ps.setDate(5, Date.valueOf(compra.getData()));			
			ps.setBigDecimal(6, compra.getTotal());
			
			
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
			System.out.println("Erro ao inserir compra\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR COMPRA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada compra e alterar os dados do banco de dados.
	 * 
	 * */
	
	public boolean alterar(Compra compra) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "UPDATE compra SET fornecedorId=?, statusNome=?, tipo=?, numero=?,"
				   + " data=?, total=? where id=?";
		PreparedStatement  ps = null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			//seta os atributos do objeto compra, fazendo a alteração.
			ps = conn.prepareStatement(sql);
			ps.setInt(1, compra.getFornecedorId());
			ps.setString(2, compra.getStatusNome());
			ps.setString(3, compra.getTipo());
			ps.setString(4, compra.getNumero());			
			ps.setDate(5, Date.valueOf(compra.getData()));			
			ps.setBigDecimal(6, compra.getTotal());
			ps.setLong(7, compra.getId());
			
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
			System.out.println("Erro ao alterar a compra\n"+e);
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * EXCLUIR COMPRA
	 * 
	 * Este método tem como principal objetivo receber os dados de uma determinada commpra e excluir do banco de dados.
	 * 
	 * */

	public boolean excluir(Compra compra) throws Exception{
		boolean status = false;
		
		//string query do banco
		String sql = "DELETE FROM compra WHERE id = ?";
		
		PreparedStatement ps;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			//seta o id da compra, e excluir o objeto
			ps = conn.prepareStatement(sql);
			ps.setLong(1, compra.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}

			//fecha as conexões
			ps.close();
			conn.close();		
		}
		//trata, caso de uma exceção
		catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o compra");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * LISTAR CAIXA
	 * Este método tem como principal objetivo realizar uma consulta ao banco e retornar todas as compras.
	 * 
	 */

	public List<Compra> listar() throws Exception{
		
		//string query do banco
		String sql = "SELECT * FROM compra";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Compra> listaDeCompra= null;
		
		//chama uma instância da Connection e tenta realizar uma conexão com o banco através do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()){			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeCompra = new ArrayList<Compra>();
			while(rs.next())
			{
				//da um get nos atributos do objeto compra
				Compra compra = new Compra();
				compra.setId(rs.getLong("id"));
				compra.setFornecedorId(rs.getInt("fornecedorId"));
				compra.setStatusNome(rs.getString("statusNome"));
				compra.setTipo(rs.getString("tipo"));
				compra.setNumero(rs.getString("numero"));
				compra.setData(rs.getDate("data").toLocalDate());
				compra.setTotal(rs.getBigDecimal("total"));
				
				//adiciona o objeto compra no arrayList
				listaDeCompra.add(compra);
				
				//enquanto o arraylist tiver objeto compra, ele vai listando
				for(int i = 0;i<listaDeCompra.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeCompra.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		//trata, caso de uma exceção
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar as compras\n"+e);
		}
		//retorna o array
		return listaDeCompra;
	}

	
	@Override
	public List<Compra> pesquisar(String pesquisa) throws Exception{
		return null;
	}

}
