package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemReceitaDao;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaListar {

	public static void main(String[] args) {

		ItemReceitaDao dao = new ItemReceitaDao();
		
		try {
			for(ItemReceita p : dao.listar()){
			    System.out.println(	  			   "Id : "+p.getId()
			    							  + "\tQtd : "+p.getQtd()
			                        		 +"\tTotal : "+p.getTotal()
			                        	  +"\tMedidaId : "+p.getMedidaId()
			                        +"\tMateriaPrimaId : "+p.getMateriaPrimaId()
			                        	 +"\tProdutoId : "+p.getProdutoId());
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
