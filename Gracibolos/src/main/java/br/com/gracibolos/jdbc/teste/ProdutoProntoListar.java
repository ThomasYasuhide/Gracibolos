package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

public class ProdutoProntoListar {

	public static void main(String[] args) {

		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		for(ProdutoPronto pp : dao.listar()){
			System.out.println(	  
									"Id : "+pp.getId()
						 + "\tFinalizado: "+pp.getFinalizado()
					   	+"\tDataValidade: "+pp.getDataValidade()
                    		 +"\tCodigo : "+pp.getCodigo()
                         +"\tEncomendaId: "+pp.getEncomendaId()
                      +		"\tProdutoId: "+pp.getProdutoId());
					
		}

	}

}
