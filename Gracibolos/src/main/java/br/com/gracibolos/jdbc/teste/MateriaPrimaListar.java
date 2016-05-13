package br.com.gracibolos.jdbc.teste;

//funcionando, porem est� listando (br.com.gracibolos.jdbc.model.MateriaPrima@1c6c3b2..) n�o sei pq
import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaListar {

	public static void main(String[] args) {

		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			for(MateriaPrima mp : dao.pesquisar("leite")){
			    System.out.println(	    	  		 "Id : "+mp.getId()
			    				       		   + "\tNome : "+mp.getNome()
			    						 	 +"\tEstoque : "+mp.getEstoque()
			                        	  	 +"\tUnidade : "+mp.getUnidade()
			                        	  +"\tFabrica��o : "+mp.getFabricacao()
			                        	  +"\tVencimento : "+mp.getVencimento()
			                        	   +"\tDescricao : "+mp.getDescricao());
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
