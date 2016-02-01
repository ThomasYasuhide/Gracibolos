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
import br.com.gracibolos.jdbc.model.Cliente;

public class ClienteDao implements GenericoDao<Cliente>{

	public boolean inserir(Cliente cliente) {
		boolean status = false;
		String sql = "INSERT INTO cliente(nomeRs, cpfCnpj, rgIe, cep, numero, tel1, tel2, email, "
				+ "status, sexo, aniversario, complemento, site, clienteDesde, obs) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		
		try{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNomeRs());
			ps.setString(2, cliente.getCpfCnpj());
			ps.setString(3, cliente.getRgIe());
			ps.setLong(4, cliente.getCep());
			ps.setString(5, cliente.getNumero());
			ps.setString(6, cliente.getTel1());
			ps.setString(7, cliente.getTel2());
			ps.setString(8, cliente.getEmail());
			ps.setString(9, cliente.getStatus());
			ps.setString(10, String.valueOf(cliente.getSexo()));
			
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(11, gravarEstaData);
			
			ps.setString(12, cliente.getComplemento());
			ps.setString(13, cliente.getSite());
			
			Date gravarEstaData2 = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(14, gravarEstaData2);
			
			ps.setString(15, cliente.getObs());
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();	
			conn.close();			
					
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro ao inserir usuário\n"+e);
		}
		return status;
	}

	public boolean alterar(Cliente cliente) {
		boolean status = false;
		String sql = "UPDATE cliente SET nomeRs=?, cpfCnpj=?, rgIe=?, cep=?, numero=?, tel1=?, tel2=?, email=?,"
				+ " status=?, sexo=?, aniversario=?, complemento=?, site=?, clienteDesde=?, obs=? where id=?";
		PreparedStatement  ps = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNomeRs());
			ps.setString(2, cliente.getCpfCnpj());
			ps.setString(3, cliente.getRgIe());
			ps.setLong(4, cliente.getCep());
			ps.setString(5, cliente.getNumero());
			ps.setString(6, cliente.getTel1());
			ps.setString(7, cliente.getTel2());
			ps.setString(8, cliente.getEmail());
			ps.setString(9, cliente.getStatus());
			ps.setString(10, String.valueOf(cliente.getSexo()));
			
			Date gravarEstaData = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(11, gravarEstaData);
			
			ps.setString(12, cliente.getComplemento());
			ps.setString(13, cliente.getSite());
			
			Date gravarEstaData2 = new Date (Calendar.getInstance().getTimeInMillis());
			ps.setDate(14, gravarEstaData2);
			
			ps.setString(15, cliente.getObs());
			ps.setInt(16, cliente.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			ps.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao alterar os clientes\n"+e);
		}
		return status;
	}

	public boolean excluir(Cliente cliente) {
		
		boolean status = false;
		
		String sql  = "DELETE FROM cliente WHERE id = ?";
		PreparedStatement ps;

		try{
			
			Connection conn = ConnectionProvider.getInstance().getConnection();			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cliente.getId());
			
			status = ps.execute();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public List<Cliente> listar() 
	{
		String sql = "SELECT * FROM cliente";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cliente> listaDeClientes = null;
		try
		{
			Connection conn = ConnectionProvider.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			listaDeClientes = new ArrayList<Cliente>();
			while(rs.next())
			{
				Cliente cliente = new Cliente();
				cliente.setNomeRs(rs.getString("nomeRs"));
				cliente.setCpfCnpj(rs.getString("cpfCnpj"));
				cliente.setRgIe(rs.getString("rgIe"));
				cliente.setCep(rs.getInt("cep"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setTel1(rs.getString("tel1"));
				cliente.setTel2(rs.getString("tel2"));
				cliente.setEmail(rs.getString("email"));
				cliente.setStatus(rs.getString("status"));
				//cliente.setSexo(rs.getString("sexo").charAt(0));
				cliente.setAniversario(Calendar.getInstance());
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setSite(rs.getString("site"));
				cliente.setClienteDesde(Calendar.getInstance());
				cliente.setObs(rs.getString("obs"));
				
				listaDeClientes.add(cliente);
				
				for(int i = 0;i<listaDeClientes.size();i++){  //enquanto i for menor, não maior  
				     System.out.println(listaDeClientes.get(i));    
				}  
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Erro ao listar usuário\n"+e);
		}
		return listaDeClientes;
	}

	@Override
	public List<Cliente> pesquisar(String pesquisa) {
		return null;
	}

}
