package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteListar {

	public static void main(String[] args) {
		
		SuporteDao dao = new SuporteDao();
		
		try {
			for(Suporte s : dao.listar()){
			    System.out.println(	    	  		  "Id : "+s.getId()
			    				       		  + "\tCodigo : "+s.getCodigo()
			    						 	   +"\tStatus : "+s.getStatus()
			                        	  		+"\tValor : "+s.getValor()
			                        	   +"\tEncomendaId: "+s.getEncomendaId()
			                        	 +"\tFornecedorId : "+s.getFornecedorId());
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
