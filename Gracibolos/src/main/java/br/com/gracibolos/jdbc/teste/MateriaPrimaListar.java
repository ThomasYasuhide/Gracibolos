package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaListar {

	public static void main(String[] args) {

		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			for(MateriaPrima mp : dao.listar()){
			    System.out.println(	    	  "Id : "+mp.getId()
			    				       + "\tMarca : "+mp.getMarca()
			    						 +"\tTipo : "+mp.getTipo()
			                        	  +"\tQtd : "+mp.getQtd()
			                        +"\tDescricao : "+mp.getDescricao()
			                        	 +"\tFoto : "+mp.getFoto());
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}