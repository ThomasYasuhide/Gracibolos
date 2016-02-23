package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoDao implements GenericoDao<Produto>{

	public boolean inserir(Produto produto) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO produto(tipoProdutoNome, nome, valor, receita, foto)"
				   + " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getTipoProdutoNome());
			ps.setString(2, produto.getNome());
			ps.setBigDecimal(3, produto.getValor());
			ps.setString(4, produto.getReceita());
			ps.setBytes(5, produto.getFoto());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir produto\n"+e);
		}
		return status;
	}

	public boolean alterar(Produto produto) throws Exception{
		boolean status = false;
		String sql = "UPDATE produto SET tipoProdutoNome=?, nome=?, valor=?, receita=?, foto=? where id=?";
		
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getTipoProdutoNome());
			ps.setString(2, produto.getNome());
			ps.setBigDecimal(3, produto.getValor());
			ps.setString(4, produto.getReceita());
			ps.setBytes(5, produto.getFoto());
			ps.setInt(6, produto.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar o produto\n"+e);
		}
		return status;
	}

	public boolean excluir(Produto produto) throws Exception{

		boolean status = false;
		
		String sql  = "DELETE FROM produto WHERE id = ?";
		PreparedStatement ps;

		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{	
			ps = conn.prepareStatement(sql);
			ps.setInt(1, produto.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}

		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar deletar o produto\n" + e);
		}
		
		return status;
	}

	public List<Produto> listar() throws Exception{
		
		String sql = "SELECT * FROM produto";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Produto> listaDeProduto = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeProduto = new ArrayList<Produto>();
			while(rs.next())
			{
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setTipoProdutoNome("tipoProdutoNome");
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getBigDecimal("valor"));
				produto.setReceita(rs.getString("receita"));
				produto.setFoto(rs.getBytes("foto"));
				
				listaDeProduto.add(produto);
				
				for(int i = 0; i<listaDeProduto.size(); i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeProduto.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar produtos\n"+e);
		}
		return listaDeProduto;
	}

	@Override
	public List<Produto> pesquisar(String pesquisa) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}


}
