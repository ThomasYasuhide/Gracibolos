package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaDao implements GenericoDao<MateriaPrima>{

	public boolean inserir(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		String sql = "INSERT INTO materiaprima (nome, estoque, peso, unidade, fabricacao, vencimento, descricao)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{		
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getNome());
			ps.setDouble(2, materiaPrima.getEstoque());
			ps.setDouble(3, materiaPrima.getPeso());
			ps.setLong(4, materiaPrima.getUnidade());
			
			if(materiaPrima.getFabricacao() != null){
				ps.setDate(5, Date.valueOf(materiaPrima.getFabricacao()));
			}else{
				ps.setNull(5, Types.DATE);
			}
			
			if(materiaPrima.getVencimento() != null){
				ps.setDate(6, Date.valueOf(materiaPrima.getVencimento()));
			}else{
				ps.setNull(6, Types.DATE);
			}
			
			ps.setString(7, materiaPrima.getDescricao());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir materiaPrima\n"+e);
		}
		return status;
	}

	public boolean alterar(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		String sql = " UPDATE materiaprima SET nome=?, estoque=?, peso=?, unidade=?, fabricacao=?,"
				   + " vencimento=?, descricao=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getNome());
			ps.setDouble(2, materiaPrima.getEstoque());
			ps.setDouble(3, materiaPrima.getPeso());
			ps.setLong(4, materiaPrima.getUnidade());
			
			if(materiaPrima.getFabricacao() != null){
				ps.setDate(5, Date.valueOf(materiaPrima.getFabricacao()));
			}else{
				ps.setNull(5, Types.DATE);
			}
			
			if(materiaPrima.getVencimento() != null){
				ps.setDate(6, Date.valueOf(materiaPrima.getVencimento()));
			}else{
				ps.setNull(6, Types.DATE);
			}
			
			ps.setString(7, materiaPrima.getDescricao());
			ps.setLong(8, materiaPrima.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar a materiaPrima\n"+e);
		}
		return status;
	}

	public boolean excluir(MateriaPrima materiaPrima) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM materiaprima WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conex�o com o banco de dados
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, materiaPrima.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar a materiaPrima");
		}
		
		return status;
	}

	public List<MateriaPrima> listar() throws Exception{
		String sql = "SELECT * FROM materiaprima";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MateriaPrima> listaDeMateriaPrima= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeMateriaPrima = new ArrayList<MateriaPrima>();
			while(rs.next())
			{
				MateriaPrima materiaPrima = new MateriaPrima();
				materiaPrima.setId(rs.getLong("id"));
				materiaPrima.setNome(rs.getString("nome"));
				materiaPrima.setEstoque(rs.getDouble("estoque"));
				materiaPrima.setPeso(rs.getDouble("peso"));
				materiaPrima.setUnidade(rs.getLong("unidade"));
				materiaPrima.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				materiaPrima.setVencimento(rs.getDate("vencimento").toLocalDate());
				materiaPrima.setDescricao(rs.getString("descricao"));
				
				listaDeMateriaPrima.add(materiaPrima);
				
				for(int i = 0;i<listaDeMateriaPrima.size();i++){  //enquanto i for menor, n�o maior  
				     System.out.println(listaDeMateriaPrima.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar materiaPrima\n"+e);
		}
		return listaDeMateriaPrima;
	}

	
	@Override
	public List<MateriaPrima> pesquisar(String pesquisa) throws Exception{
		
		List<MateriaPrima> materiasPrimas = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, nome, estoque, peso, unidade, fabricacao, vencimento, descricao FROM materiaprima WHERE unidade = ? OR nome LIKE ? OR vencimento = ?";
				
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
						
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			ps.setString(3, pesquisa);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
							
				MateriaPrima mp = new MateriaPrima();
				
				mp.setId(rs.getLong("id"));
				mp.setNome(rs.getString("nome"));
				mp.setEstoque(rs.getDouble("estoque"));
				mp.setPeso(rs.getDouble("peso"));
				mp.setUnidade(rs.getLong("unidade"));
				mp.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				mp.setVencimento(rs.getDate("vencimento").toLocalDate());
				mp.setDescricao(rs.getString("descricao"));
				materiasPrimas.add(mp);
			}
			
			ps.close();
			rs.close();
			conn.close();
					
		} catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o mat�ria prima");
		}
		
		return materiasPrimas;
	}

}
