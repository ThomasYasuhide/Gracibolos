package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

//funcionando, porem est� listando (br.com.gracibolos.jdbc.model.ProdutoPronto@a8ceb6..) n�o sei pq
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
			e.printStackTrace();
		}

	}

}
