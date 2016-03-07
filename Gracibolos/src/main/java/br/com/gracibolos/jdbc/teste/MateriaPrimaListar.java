package br.com.gracibolos.jdbc.teste;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.MateriaPrima@1c6c3b2..) não sei pq
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
			e.printStackTrace();
		}

	}

}
