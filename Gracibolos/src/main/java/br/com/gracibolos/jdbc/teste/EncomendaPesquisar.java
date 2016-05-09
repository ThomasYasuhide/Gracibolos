package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

public class EncomendaPesquisar {

	public static void main(String[] args) {
		EncomendaDao dao = new EncomendaDao();
		Encomenda e = null;
		Gerador g = new Gerador();
		Long[] ids = g.IdsEnc();
		Long id = g.ranIdLong(ids);
		
		try {
				e = dao.pesquisarId(id);
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
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
