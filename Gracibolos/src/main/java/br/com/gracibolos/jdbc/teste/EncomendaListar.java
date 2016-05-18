package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Encomenda@1c6c3b2..) não sei pq
public class EncomendaListar {

	public static void main(String[] args) {
		
		EncomendaDao dao = new EncomendaDao();
		Encomenda e = new Encomenda();
		
		
		try {
			e = dao.pesquisarId("23");
			//for(Encomenda e : dao.pesquisarId("23")){
				System.out.println(	  
								 		 "Id : "+e.getId()
						          +"\nStatus : "+e.getStatus()
						    + "\nResponsavel : "+e.getResponsavel()
						   	  +"\nDataInicio : "+e.getDataencomenda()
			            +"\nDataCancelamento : "+e.getDatacancelamento()
			                +"\nDataProducao : "+e.getDataproducao()
			             +"\nDataFaturamento : "+e.getDatafaturamento()
			              	+ "\nDataEntrega : "+e.getDataentrega()
			             +"\nEntregaRetirada : "+e.getDatafinalizado()
			             		   +"\nTotal : "+e.getTotalprodutos()
			             	   +"\nDescricao : "+e.getObs()
			             	   +"\nNomerazao : "+e.getNomerazao()
			             	   	 +"\ncpfcnpj : "+e.getCpfcnpj()
			                   +"\nClienteId : "+e.getClienteId()
			             	   
			             	   	 
			             	  );					
			//}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
