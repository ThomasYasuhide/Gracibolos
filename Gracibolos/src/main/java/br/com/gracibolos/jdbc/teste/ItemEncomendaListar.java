package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaListar {

	public static void main(String[] args) {
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			for(ItemEncomenda i : dao.listar()){
			    System.out.println(	     "Id : "+i.getId()
			    					 + "\tQtd: "+i.getQtd()
			                        +"\tValor: "+i.getProdutoId()
			                        +"\tGasto: "+i.getEncomendaId());	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
