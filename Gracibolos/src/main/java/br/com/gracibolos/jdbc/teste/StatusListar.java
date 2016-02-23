package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.StatusDao;
import br.com.gracibolos.jdbc.model.Status;

public class StatusListar {

	public static void main(String[] args) {
		
		StatusDao dao = new StatusDao();
		
		try {
			for(Status p : dao.listar()){
			    System.out.println(	  	  "Id : "+p.getId()
			    					+ "\tNome : "+p.getNome());		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
