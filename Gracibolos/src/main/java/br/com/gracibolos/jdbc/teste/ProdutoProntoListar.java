package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

//funcionando
public class ProdutoProntoListar {

	public static void main(String[] args) {

		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		try {
			for(ProdutoPronto pp : dao.listar()){
				System.out.println(	  
										"Id : "+pp.getId()
							   +"\tProdutoId: "+pp.getProdutoId()
							 +"\tEncomendaId: "+pp.getEncomendaId()									
							 + "\tFinalizado: "+pp.getFinalizado()
						   	+"\tDataValidade: "+pp.getDataValidade()
			            		 +"\tCodigo : "+pp.getCodigo());                        
						
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
