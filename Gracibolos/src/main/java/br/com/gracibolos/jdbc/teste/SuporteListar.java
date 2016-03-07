package br.com.gracibolos.jdbc.teste;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Suporte@a8ceb6..) não sei pq
import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteListar {

	public static void main(String[] args) {
		
		SuporteDao dao = new SuporteDao();
		
		try {
			for(Suporte s : dao.listar()){
			    System.out.println(	    	  		  "Id : "+s.getId()
								         +"\tFornecedorId : "+s.getFornecedorId()
								      	   +"\tEncomendaId: "+s.getEncomendaId()
			    				       		  + "\tCodigo : "+s.getCodigo()
			    						 	   +"\tStatus : "+s.getStatus()
			                        	  		+"\tValor : "+s.getValor());			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
