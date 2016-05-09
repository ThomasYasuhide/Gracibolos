package br.com.gracibolos.jdbc.teste;

import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.DashboardDao;
import br.com.gracibolos.jdbc.model.Gasto;
import br.com.gracibolos.jdbc.model.Recebimento;

public class Dashboard {
	
	public static void main(String[] args) 
	{
		DashboardDao dao = new DashboardDao();
		LocalDate data = LocalDate.now();
		Gasto g = new Gasto();
		Recebimento r = new Recebimento();
		// Obtém o ano atual
		g = dao.getGR(String.valueOf(data.getYear())).getGasto();
		r = dao.getGR(String.valueOf(data.getYear())).getRec();
		
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
