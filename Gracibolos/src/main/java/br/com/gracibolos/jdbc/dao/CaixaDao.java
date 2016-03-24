package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Caixa;

public class CaixaDao implements GenericoDao<Caixa>{

	public boolean inserir(Caixa caixa) throws Exception{
		boolean status = false;
		String sql = " INSERT INTO caixa(encomendaId, valor, gasto, recebimento, forma,"
				   + " parcela, descricao)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, caixa.getEncomendaId());
			ps.setBigDecimal(2, caixa.getValor());
			ps.setBigDecimal(3, caixa.getGasto());
			ps.setBoolean(4, caixa.getRecebimento());
			ps.setString(5, caixa.getForma());
			ps.setInt(6, caixa.getParcela());
			ps.setString(7, caixa.getDescricao());
						
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();								
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir caixa\n"+e);
		}
		return status;
	}

	public boolean alterar(Caixa caixa) throws Exception{
		boolean status = false;
		String sql = " UPDATE caixa SET encomendaId=?, valor=?, gasto=?, recebimento=?, forma=?,"
				   + " parcela=?, descricao=? where id=?";
		PreparedStatement  ps = null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, caixa.getEncomendaId());
			ps.setBigDecimal(2, caixa.getValor());
			ps.setBigDecimal(3, caixa.getGasto());
			ps.setBoolean(4, caixa.getRecebimento());
			ps.setString(5, caixa.getForma());
			ps.setInt(6, caixa.getParcela());
			ps.setString(7, caixa.getDescricao());
			ps.setLong(8, caixa.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar o caixa\n"+e);
		}
		return status;
	}

	public boolean excluir(Caixa caixa) throws Exception{
		boolean status = false;
		String sql = "DELETE FROM caixa WHERE id = ?";
		
		PreparedStatement ps;
		
		//Tenta realizar uma conexão com o banco de dados
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{
			ps = conn.prepareStatement(sql);
			ps.setLong(1, caixa.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}			
			ps.close();
			conn.close();
	
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o caixa");
		}
		
		return status;
	}

	public List<Caixa> listar() throws Exception{
		
		String sql = "SELECT * FROM caixa";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Caixa> listaDeCaixa= null;
		try(Connection conn = ConnectionProvider.getInstance().getConnection())
		{			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeCaixa = new ArrayList<Caixa>();
			while(rs.next())
			{
				Caixa caixa = new Caixa();
				caixa.setId(rs.getLong("id"));
				caixa.setEncomendaId(rs.getInt("encomendaId"));
				caixa.setValor(rs.getBigDecimal("valor"));
				caixa.setGasto(rs.getBigDecimal("gasto"));
				caixa.setRecebimento(rs.getBoolean("recebimento"));
				caixa.setForma(rs.getString("forma"));
				caixa.setParcela(rs.getInt("parcela"));
				caixa.setDescricao(rs.getString("descricao"));				
				
				listaDeCaixa.add(caixa);
				
				for(int i = 0;i<listaDeCaixa.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeCaixa.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar caixa\n"+e);
		}
		return listaDeCaixa;
	}

	
	@Override
	public List<Caixa> pesquisar(String pesquisa) throws Exception{
		List<Caixa> caixas = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, encomendaId, valor, gasto, recebimento, forma, parcela, descricao FROM caixa WHERE encomendaId = ? OR recebimento LIKE ?";
				
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
						
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
							
				Caixa caixa = new Caixa();
				
				caixa.setId(rs.getLong("id"));
				caixa.setEncomendaId(rs.getInt("encomendaId"));
				caixa.setValor(rs.getBigDecimal("valor"));
				caixa.setGasto(rs.getBigDecimal("gasto"));
				caixa.setRecebimento(rs.getBoolean("recebimento"));				
				caixa.setParcela(rs.getInt("parcela"));
				caixa.setForma(rs.getString("forma"));
				caixa.setDescricao(rs.getString("descricao"));
				caixas.add(caixa);
			}
			
			ps.close();
			rs.close();
			conn.close();
					
		} catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o matéria prima");
		}
		
		return caixas;
	}

}
