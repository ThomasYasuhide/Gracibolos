package br.com.gracibolos.jdbc.teste;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.MateriaPrima@1c6c3b2..) não sei pq
import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaListar {

	public static void main(String[] args) {

		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			for(MateriaPrima mp : dao.listar()){
			    System.out.println(	    	  		 "Id : "+mp.getId()
			    				       		   + "\tNome : "+mp.getNome()
			    						 	 +"\tEstoque : "+mp.getEstoque()
			    						 	 	+"\tPeso : "+mp.getPeso()
			                        	  	 +"\tUnidade : "+mp.getUnidade()
			                        	  +"\tFabricação : "+mp.getFabricacao()
			                        	  +"\tVencimento : "+mp.getVencimento()
			                        	   +"\tDescricao : "+mp.getDescricao());
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
