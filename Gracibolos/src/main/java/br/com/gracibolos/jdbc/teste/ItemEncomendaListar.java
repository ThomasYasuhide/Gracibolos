package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.ItemEncomenda@a8ceb6..) não sei pq
public class ItemEncomendaListar {

	public static void main(String[] args) {
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			for(ItemEncomenda i : dao.listar()){
			    System.out.println(	     "Id  : "+i.getId()
			    					+"\tProdutoId : "+i.getProdutoId()
			    					+"\tEncomendaId : "+i.getEncomendaId()
			    					 + "\tQtd : "+i.getQtd());	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
