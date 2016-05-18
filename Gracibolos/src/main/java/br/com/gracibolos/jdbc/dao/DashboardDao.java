package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Ano;
import br.com.gracibolos.jdbc.model.Meses;

public class DashboardDao {
	
	public Meses buscarGastoRecebimento(String gr, String ano)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Ano> meses = new ArrayList<Ano>();
		//string query do banco
		String sql = "SELECT MONTH (caixa.dataTransacao) AS num, "
				+ "MONTHNAME (caixa.dataTransacao) as nome, "
				+ "sum(caixa.valor) as total  from caixa "
				+ "WHERE caixa.gastoRecebimento="+gr+" AND YEAR (caixa.dataTransacao) = "+ano+" "
				+ "GROUP BY num,nome";
		try (Connection conn = ConnectionProvider.getInstance().getConnection()) 
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Ano a = null;
			
			while(rs.next())
			{
				a = new Ano();
				a.setNum(rs.getInt("num"));// Mês em numero
				a.setNome(rs.getString("nome"));// jan, fev, mar, abr, ...
				a.setTotal(rs.getDouble("total"));// valor
				meses.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Aqui eu tenho os gets e sets dos meses: jan, fev ,mar, abr...
		Meses anoMes = new Meses();
		
		// Aqui eu percorro todos os meses settando os valore no objeto Meses
		for(Ano a : meses){	
			//Janeiro
			if("January".equals(a.getNome())){	
				anoMes.setJaneiro(a.getTotal());
			}
			//Fevereiro
			if("February".equals(a.getNome())){	
				anoMes.setFevereiro(a.getTotal());
			}
			//Marco
			if("March".equals(a.getNome())){	
				anoMes.setMarco(a.getTotal());
			}
			//Abril
			if("April".equals(a.getNome())){	
				anoMes.setAbril(a.getTotal());
			}
			//Maio
			if("May".equals(a.getNome())){	
				anoMes.setMaio(a.getTotal());
			}
			//junho
			if("June".equals(a.getNome())){	
				anoMes.setJunho(a.getTotal());
			}
			//julho
			if("July".equals(a.getNome())){	
				anoMes.setJulho(a.getTotal());
			}
			//Agosto
			if("August".equals(a.getNome())){	
				anoMes.setAgosto(a.getTotal());
			}
			//Setembro
			if("September".equals(a.getNome())){	
				anoMes.setSetembro(a.getTotal());
			}
			//Outubro
			if("October".equals(a.getNome())){	
				anoMes.setOutubro(a.getTotal());
			}
			//Novembro
			if("November".equals(a.getNome())){	
				anoMes.setNovembro(a.getTotal());
			}
			//Dezembro
			if("December".equals(a.getNome())){	
				anoMes.setDezembro(a.getTotal());
			}
		}
		return anoMes;
	}
}
