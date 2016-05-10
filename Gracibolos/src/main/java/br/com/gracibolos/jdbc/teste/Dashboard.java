package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.DashboardDao;
import br.com.gracibolos.jdbc.model.Gasto;
import br.com.gracibolos.jdbc.model.Recebimento;

public class Dashboard {
	public static void main(String[] args) 
	{
		String ano = "2016";
		Gasto g = new Gasto();
		Recebimento r = new Recebimento();
		DashboardDao dao = new DashboardDao();
		g = dao.getGR(ano).getGasto();
		r = dao.getGR(ano).getRec();
		
		System.out.println("Janeiro : "+g.getJaneiro()+" - "+r.getJaneiro()+
						  "\nFevereiro : "+g.getFevereiro()+" - "+r.getFevereiro()+
						 "\nMarço : "+g.getMarco()+" - "+r.getMarco()+
						 "\nAbril : "+g.getAbril()+" - "+r.getAbril()+
						 "\nMaio : "+g.getMaio()+" - "+r.getMaio()+
						 "\nJunho : "+g.getJunho()+" - "+r.getJunho()+
						 "\nJulho : "+g.getJulho()+" - "+r.getJulho()+
						 "\nAgosto : "+g.getAgosto()+" - "+r.getAgosto()+
						 "\nSetembro : "+g.getSetembro()+" - "+r.getSetembro()+
						 "\nOutubro : "+g.getOutubro()+" - "+r.getOutubro()+
						 "\nNovembro : "+g.getNovembro()+" - "+r.getNovembro()+
						 "\nDezembro : "+g.getDezembro()+" - "+r.getDezembro()
				);
	}
}
