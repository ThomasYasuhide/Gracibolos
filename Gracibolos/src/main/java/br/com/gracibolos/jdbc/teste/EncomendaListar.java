package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando, porem est� listando (br.com.gracibolos.jdbc.model.Encomenda@1c6c3b2..) n�o sei pq
public class EncomendaListar {

	public static void main(String[] args) {
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			for(Encomenda e : dao.listar()){
				System.out.println(	  
								 		 "Id : "+e.getId()
							   +"\tClienteId : "+e.getClienteid()
						          +"\tStatus : "+e.getStatus()
						    + "\tResponsavel : "+e.getResponsavel()
						   	  +"\tDataInicio : "+e.getDataencomenda()
			            +"\tDataCancelamento : "+e.getDatacancelamento()
			                +"\tDataProducao : "+e.getDataproducao()
			             +"\tDataFaturamento : "+e.getDatafaturamento()
			              	+ "\tDataEntrega : "+e.getDataentrega()
			             +"\tEntregaRetirada : "+e.getDatafinalizado()
			             		   +"\tTotal : "+e.getTotalprodutos()
			             	   +"\tDescricao : "+e.getObs()
			             	   	 
			             	  );					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
