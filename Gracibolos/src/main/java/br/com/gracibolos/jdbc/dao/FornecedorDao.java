package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class FornecedorDao implements GenericoDao<Fornecedor>{

	public boolean inserir(Fornecedor fornecedor) {
		boolean status = false;
		String sql = "INSERT INTO fornecedor(nomeRs, cpfCnpj, rgIe, cep, numero, telefone1, telefone2, telefone3, "
				+ "cel1, cel2, site, email1, email2, contato1, contato2, complemento, obs, compraCollection, "
				+ "contaCollection, suporteCollection, "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		
		try{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, fornecedor.getNomeRs());
			ps.setString(2, fornecedor.getCpfCnpj());
			ps.setString(3, fornecedor.getRgIe());
			ps.setLong(4, fornecedor.getCep());
			ps.setString(5, fornecedor.getNumero());
			ps.setString(6, fornecedor.getTelefone1());
			ps.setString(7, fornecedor.getTelefone2());
			ps.setString(8, fornecedor.getTelefone3());
			ps.setString(9, fornecedor.getCel1());
			ps.setString(10, fornecedor.getCel2());
			ps.setString(11, fornecedor.getSite());
			ps.setString(12, fornecedor.getEmail1());
			ps.setString(13, fornecedor.getEmail2());
			ps.setString(14, fornecedor.getContato1());
			ps.setString(15, fornecedor.getContato2());
			ps.setString(16, fornecedor.getComplemento());
			ps.setString(17, fornecedor.getObs());
			//ps.setCompraCollection(18, fornecedor.getCompraCollection());
			//ps.setString(19, fornecedor.getContaCollection());
			//ps.setString(20, fornecedor.getSuporteCollection());
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir fornecedor\n"+e);
		}
		return status;
	
	}

	public boolean alterar(Fornecedor fornecedor) {
		boolean status = false;
		String sql = "UPDATE fornecedor SET nomeRs=?, cpfCnpj=?, rgIe=?, cep=?, numero=?, telefone1=?, telefone2=?,"
				+ " telefone3=?, cel1=?, cel2=?, site=?, email1=?, email2=?, contato1=?, contato2=?, complemento=?,"
				+ "obs=?, compraCollection=?, contaCollection=?, suporteCollection=? where id=?";
		PreparedStatement  ps = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, fornecedor.getNomeRs());
			ps.setString(2, fornecedor.getCpfCnpj());
			ps.setString(3, fornecedor.getRgIe());
			ps.setLong(4, fornecedor.getCep());
			ps.setString(5, fornecedor.getNumero());
			ps.setString(6, fornecedor.getTelefone1());
			ps.setString(7, fornecedor.getTelefone2());
			ps.setString(8, fornecedor.getTelefone3());
			ps.setString(9, fornecedor.getCel1());
			ps.setString(10, fornecedor.getCel2());
			ps.setString(11, fornecedor.getSite());
			ps.setString(12, fornecedor.getEmail1());
			ps.setString(13, fornecedor.getEmail2());
			ps.setString(14, fornecedor.getContato1());
			ps.setString(15, fornecedor.getContato2());
			ps.setString(16, fornecedor.getComplemento());
			ps.setString(17, fornecedor.getObs());
			//ps.setString(18, fornecedor.getCompraCollection());
			//ps.setString(19, fornecedor.getContaCollection());
			//ps.setString(20, fornecedor.getSuporteCollection());
			ps.setInt(21, fornecedor.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar os clientes\n"+e);
		}
		return status;
	}

	public void excluir(Integer id) {
		
		String sql  = "DELETE FROM fornecedor WHERE id = ?";
		PreparedStatement ps;

		try{
			
			Connection conn = ConnectionProvider.getInstance().getConnection();			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Fornecedor> listar() 
	{
		String sql = "SELECT * FROM fornecedor";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Fornecedor> listaDeFornecedor= null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeFornecedor = new ArrayList<Fornecedor>();
			while(rs.next())
			{
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNomeRs(rs.getString("nomeRs"));
				fornecedor.setCpfCnpj(rs.getString("cpfCnpj"));
				fornecedor.setRgIe(rs.getString("rgIe"));
				fornecedor.setCep(rs.getInt("cep"));
				fornecedor.setNumero(rs.getString("numero"));
				fornecedor.setTelefone1(rs.getString("telefone1"));
				fornecedor.setTelefone2(rs.getString("telefone2"));
				fornecedor.setTelefone3(rs.getString("telefone3"));
				fornecedor.setCel1(rs.getString("cel1"));
				fornecedor.setCel2(rs.getString("cel2"));
				fornecedor.setSite(rs.getString("site"));
				fornecedor.setEmail1(rs.getString("email1"));
				fornecedor.setEmail2(rs.getString("email2"));
				fornecedor.setContato1(rs.getString("contato1"));
				fornecedor.setContato2(rs.getString("contato2"));				
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setObs(rs.getString("obs"));
				//fornecedor.setCompraCollection(compraCollection);
				//fornecedor.setContaCollection(contaCollection);
				//fornecedor.setSuporteCollection(suporteCollection);
				
				listaDeFornecedor.add(fornecedor);
				
				for(int i = 0;i<listaDeFornecedor.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeFornecedor.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar usuário\n"+e);
		}
		return listaDeFornecedor;
	}

}
