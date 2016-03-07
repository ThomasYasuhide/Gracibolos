package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Encomenda@1c6c3b2..) não sei pq
public class EncomendaListar {

	public static void main(String[] args) {
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			for(Encomenda e : dao.listar()){
				System.out.println(	  
								 		 "Id : "+e.getId()
							   +"\tClienteId : "+e.getClienteId()
						      +"\tStatusNome : "+e.getStatusNome()
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
			             	  );					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
