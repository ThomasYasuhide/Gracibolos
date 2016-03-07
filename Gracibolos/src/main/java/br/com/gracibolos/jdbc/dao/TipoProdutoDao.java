package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.TipoProduto;

public class TipoProdutoDao implements GenericoDao<TipoProduto>{

	public boolean inserir(TipoProduto tipoProduto) throws Exception{
		Boolean teste = false;
		String sql = "INSERT INTO tipoproduto (nome) VALUES (?)";
		PreparedStatement ps = null;		

		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, tipoProduto.getNome());
			
			if(ps.executeUpdate() != 0) {
				teste = true;
			}
			ps.close();	
			conn.close();		
		}
		catch (SQLException e) 
		{		
			System.out.println("Erro ao inserir status\n"+e);
		}
		return teste;
	}

	public boolean alterar (TipoProduto tipoProduto) throws Exception{
		Boolean teste = false;
		String sql = "UPDATE tipoproduto SET nome=? WHERE id=?";
		PreparedStatement ps = null;		
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, tipoProduto.getNome());
			ps.setLong(2, tipoProduto.getId());
			
			if(ps.executeUpdate() != 0) {
				teste = true;
			}
			ps.close();	
			conn.close();		
		}
		catch (SQLException e) 
		{		
			System.out.println("Erro ao alterar status\n"+e);
		}
		return teste;
	}

	public boolean excluir(TipoProduto tipoProduto) throws Exception{
		boolean teste = false;
		String sql = "DELETE FROM tipoproduto WHERE id = ?";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, tipoProduto.getId());
			
			if(ps.executeUpdate() != 0){
				teste = true;
			}
			ps.close();
			conn.close();
		}
		catch (Exception e) 
		{
			System.out.println("Houve um erro ao tentar deletar a medida");
		}
		return teste;
	}

	public List<TipoProduto> listar() throws Exception{
		String sql = "SELECT * FROM tipoproduto";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TipoProduto> listaDeTipoProduto = null;
		try (Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeTipoProduto = new ArrayList<TipoProduto>();
			while(rs.next())
			{
				TipoProduto tipoProduto = new TipoProduto();
				tipoProduto.setId(rs.getLong("id"));
				tipoProduto.setNome(rs.getString("nome"));
				
				listaDeTipoProduto.add(tipoProduto);
				for(int i=0; i < listaDeTipoProduto.size(); i++){
					System.out.println(listaDeTipoProduto.get(i));    
				}				
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar medida\n"+e);
		}
		return listaDeTipoProduto;
	}

	@Override
	public List<TipoProduto> pesquisar(String pesquisa) throws Exception{
		return null;
	}


}
