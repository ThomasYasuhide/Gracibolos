package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaListar {

	public static void main(String[] args) {
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			for(Encomenda e : dao.listar()){
				System.out.println(	  
								 		 "Id : "+e.getId()
						     + "\tResponsavel: "+e.getResponsavel()
						   	   +"\tDataInicio: "+e.getDataInicio()
			               +"\tDataFaltaProd : "+e.getDataFaltaProd()
			                 +"\tDataProducao: "+e.getDataProducao()
			              +"\tDataFinalizado : "+e.getDataFinalizado()
			              	+ "\tDataEntrega : "+e.getDataEntrega()
			             +"\tEntregaRetirada : "+e.getEntregaRetirada()
			             		   +"\tTotal : "+e.getTotal()
			             	   +"\tDescricao : "+e.getDescricao()
			             	   	  +"\tNumero : "+e.getNumero()
			             	   +"\tClienteId : "+e.getClienteId()
			             	  +"\tStatusNome : "+e.getStatusNome());					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
