package br.com.gracibolos.jdbc.teste;

import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.DashboardDao;
import br.com.gracibolos.jdbc.model.Meses;

public class Dashboard {
	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		//System.out.println(ld.getYear());
		//String ano = String.valueOf(ld.getYear());
		String ano = "2014";
		
		Meses gasto = new Meses();
		Meses rec = new Meses();
		
		DashboardDao dao = new DashboardDao();
		
		gasto = dao.buscarGastoRecebimento("0", ano);//Aqui eu busquei os gastos "0" deste ano
		rec = dao.buscarGastoRecebimento("1", ano);//Aqui eu busquei os recebimentos "0" deste ano
		
		System.out.println("Janeiro : "+gasto.getJaneiro()+" - "+rec.getJaneiro()+
						  "\nFevereiro : "+gasto.getFevereiro()+" - "+rec.getFevereiro()+
						 "\nMarço : "+gasto.getMarco()+" - "+rec.getMarco()+
						 "\nAbril : "+gasto.getAbril()+" - "+rec.getAbril()+
						 "\nMaio : "+gasto.getMaio()+" - "+rec.getMaio()+
						 "\nJunho : "+gasto.getJunho()+" - "+rec.getJunho()+
						 "\nJulho : "+gasto.getJulho()+" - "+rec.getJulho()+
						 "\nAgosto : "+gasto.getAgosto()+" - "+rec.getAgosto()+
						 "\nSetembro : "+gasto.getSetembro()+" - "+rec.getSetembro()+
						 "\nOutubro : "+gasto.getOutubro()+" - "+rec.getOutubro()+
						 "\nNovembro : "+gasto.getNovembro()+" - "+rec.getNovembro()+
						 "\nDezembro : "+gasto.getDezembro()+" - "+rec.getDezembro()
				);
	}
	
}
