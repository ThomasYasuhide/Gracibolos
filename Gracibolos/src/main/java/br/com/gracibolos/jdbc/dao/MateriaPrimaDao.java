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
		String sql = "INSERT INTO materiaprima (codigo, nome, estoque, unidade, fabricacao, vencimento, descricao)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{		
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getCodigo());
			ps.setString(2, materiaPrima.getNome());
			ps.setDouble(3, materiaPrima.getEstoque());
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
		String sql = " UPDATE materiaprima SET codigo=?, nome=?, estoque=?, unidade=?, fabricacao=?,"
				   + " vencimento=?, descricao=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setString(1, materiaPrima.getCodigo());
			ps.setString(2, materiaPrima.getNome());
			ps.setDouble(3, materiaPrima.getEstoque());
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
		
		//Tenta realizar uma conexão com o banco de dados
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
		
		String sql = "SELECT id, codigo,  nome, estoque, unidade, fabricacao, vencimento, descricao FROM materiaprima";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MateriaPrima> materiasprimas= null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			materiasprimas = new ArrayList<MateriaPrima>();
			while(rs.next()) {
				MateriaPrima materiaPrima = new MateriaPrima();
				materiaPrima.setId(rs.getLong("id"));
				materiaPrima.setNome(rs.getString("nome"));
				materiaPrima.setEstoque(rs.getDouble("estoque"));
				materiaPrima.setUnidade(rs.getLong("unidade"));
				materiaPrima.setFabricacao(rs.getDate("fabricacao").toLocalDate());
				materiaPrima.setVencimento(rs.getDate("vencimento").toLocalDate());
				materiaPrima.setDescricao(rs.getString("descricao"));
				
				materiasprimas.add(materiaPrima);
			}
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar materiaPrima\n"+e);
		}
		
		return materiasprimas;
	}

	
	@Override
	public List<MateriaPrima> pesquisar(String pesquisa) throws Exception{
		
		List<MateriaPrima> materiasPrimas = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, codigo,  nome, estoque, unidade, fabricacao, vencimento, descricao FROM materiaprima WHERE codigo = ? OR nome LIKE ?";
				
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
						
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
							
				MateriaPrima mp = new MateriaPrima();
				
				mp.setId(rs.getLong("id"));
				mp.setCodigo(rs.getString("codigo"));
				mp.setNome(rs.getString("nome"));
				mp.setEstoque(rs.getDouble("estoque"));
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
			System.out.println("Houve um erro ao pesquisar o matéria prima");
		}
		
		return materiasPrimas;
	}

}
