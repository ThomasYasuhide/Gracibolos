package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Ano;
import br.com.gracibolos.jdbc.model.Gasto;
import br.com.gracibolos.jdbc.model.GastoRecebimento;
import br.com.gracibolos.jdbc.model.Recebimento;

public class DashboardDao {
	
	private static Gasto gasto;
	private static Recebimento rec;
	
	public GastoRecebimento getGR(String ano)
	{
		gasto = buscarGasto(ano);
		rec = buscarRecebimento(ano);
		GastoRecebimento gr = new GastoRecebimento(gasto, rec);
		return gr;
	}
	
	private static Recebimento buscarRecebimento(String ano)
	{
		List<Ano> gL = buscar("1",ano);
		Recebimento r = new Recebimento();
		if(buscar("1",ano).size()==0){
			return r;
		}else{
			if(gL.get(0).getTotal()!=0)
				r.setJaneiro(gL.get(0).getTotal()); 
			if(gL.get(1).getTotal()!=0)
				r.setFevereiro(gL.get(1).getTotal());
			if(gL.get(2).getTotal()!=0)
				r.setMarco(gL.get(2).getTotal()); 
			if(gL.get(3).getTotal()!=0)
				r.setAbril(gL.get(3).getTotal()); 
			if(gL.get(4).getTotal()!=0)
				r.setMaio(gL.get(4).getTotal()); 
			if(gL.get(5).getTotal()!=0)
				r.setJunho(gL.get(5).getTotal());
			if(gL.get(6).getTotal()!=0)
				r.setJulho(gL.get(6).getTotal());
			if(gL.get(7).getTotal()!=0)
				r.setAgosto(gL.get(7).getTotal());
			if(gL.get(8).getTotal()!=0)
				r.setSetembro(gL.get(8).getTotal());
			if(gL.get(9).getTotal()!=0)
				r.setOutubro(gL.get(9).getTotal());
			if(gL.get(10).getTotal()!=0)	
				r.setNovembro(gL.get(10).getTotal());
			if(gL.get(11).getTotal()!=0)	
				r.setDezembro(gL.get(11).getTotal());
		}
		return r;
	}
	
	private static Gasto buscarGasto(String ano)
	{
		List<Ano> gL = buscar("0",ano);
		Gasto g = new Gasto();
		//System.out.println(buscar("0",ano).size());
		if(buscar("0",ano).size() == 0)
		{
			return g;
		}else{
			if(gL.get(0).getTotal()!=0)
				g.setJaneiro(gL.get(0).getTotal());
			if(gL.get(1).getTotal()!=0)
				g.setFevereiro(gL.get(1).getTotal());
			if(gL.get(2).getTotal()!=0)
				g.setMarco(gL.get(2).getTotal()); 
			if(gL.get(3).getTotal()!=0)
				g.setAbril(gL.get(3).getTotal()); 
			if(gL.get(4).getTotal()!=0)
				g.setMaio(gL.get(4).getTotal()); 
			if(gL.get(5).getTotal()!=0)
				g.setJunho(gL.get(5).getTotal());
			if(gL.get(6).getTotal()!=0)
				g.setJulho(gL.get(6).getTotal());
			if(gL.get(7).getTotal()!=0)
				g.setAgosto(gL.get(7).getTotal());
			if(gL.get(8).getTotal()!=0)
				g.setSetembro(gL.get(8).getTotal());
			if(gL.get(9).getTotal()!=0)
				g.setOutubro(gL.get(9).getTotal());
			if(gL.get(10).getTotal()!=0)	
				g.setNovembro(gL.get(10).getTotal());
			if(gL.get(11).getTotal()!=0)	
				g.setDezembro(gL.get(11).getTotal());
		}
		return g;
	}
	
	private static List<Ano> buscar(String gr, String ano)
	{
		//Gasto g = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ano a = null;
		List<Ano> meses = new ArrayList<Ano>();
		//string query do banco
		String sql = "select MONTH (caixa.data) as num, "
				+ "MONTHNAME (caixa.data) as nome, "
				+ "sum(caixa.valor) as total  from caixa "
				+ "WHERE caixa.gastoRecebimento="+gr+" AND YEAR (caixa.data) = "+ano+" "
				+ "group by num,nome";
		try (Connection conn = ConnectionProvider.getInstance().getConnection()) {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				a = new Ano();
				a.setNum(rs.getInt("num"));
				a.setNome(rs.getString("nome"));
				a.setTotal(rs.getDouble("total"));
				meses.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return meses;
	}
}
