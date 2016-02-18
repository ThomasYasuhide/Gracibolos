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
import br.com.gracibolos.jdbc.model.ProdutoPronto;

public class ProdutoProntoDao implements GenericoDao<ProdutoPronto>{

	public boolean inserir(ProdutoPronto pPronto) throws Exception {
		boolean status = false;
		String sql = "INSERT INTO produtoPronto(finalizado, dataValidade, codigo, encomendaId, produtoId,"
				+ " VALUES (?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		
		try{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(1, gravarEstaData);
			
			Date gravarEstaData2 = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, gravarEstaData2);
			
			ps.setString(3, pPronto.getCodigo());
			//ps.setString(4, pPronto.getEncomendaId());
			//ps.setString(5, pPronto.getProdutoId()());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir produto Pronto\n"+e);
		}
		return status;
	}

	public boolean alterar(ProdutoPronto pPronto) throws Exception {
		boolean status = false;
		String sql = "UPDATE produtoPronto SET finalizado=?, dataValidade=?, codigo=?, encomendaId=?,"
				+ " produtoId=? where id=?";
		
		PreparedStatement  ps = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(1, gravarEstaData);
			
			Date gravarEstaData2 = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(2, gravarEstaData2);
			
			ps.setString(3, pPronto.getCodigo());
			//ps.setString(4, pPronto.getEncomendaId());
			//ps.setString(5, pPronto.getProdutoId()());
			ps.setInt(6, pPronto.getId());
						
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar os produtos Prontos\n"+e);
		}
		return status;
	}

	public boolean excluir(ProdutoPronto produtoPronto) throws Exception {

		boolean status = false;
		
		String sql  = "DELETE FROM produtoPronto WHERE id = ?";
		PreparedStatement ps;

		try{			
			Connection conn = ConnectionProvider.getInstance().getConnection();			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, produtoPronto.getId());
			
			status = ps.execute();
			
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public List<ProdutoPronto> listar() throws Exception {
		
		String sql = "SELECT * FROM produtoPronto";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProdutoPronto> listaDeProdutoPronto = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeProdutoPronto = new ArrayList<ProdutoPronto>();
			while(rs.next())
			{
				ProdutoPronto pPronto = new ProdutoPronto();
				
				pPronto.setId(rs.getInt("id"));
				pPronto.setFinalizado(Calendar.getInstance());
				pPronto.setDataValidade(Calendar.getInstance());
				pPronto.setCodigo(rs.getString("codigo"));
				pPronto.setEncomendaId(null);
				pPronto.setProdutoId(null);
				
				listaDeProdutoPronto.add(pPronto);
				
				for(int i = 0;i<listaDeProdutoPronto.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeProdutoPronto.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar os produtos Prontos\n"+e);
		}
		return listaDeProdutoPronto;
	}

	@Override
	public List<ProdutoPronto> pesquisar(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
	}

}
