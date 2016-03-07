package br.com.gracibolos.jdbc.teste;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.ItemReceita@a8ceb6..) não sei pq
import br.com.gracibolos.jdbc.dao.ItemReceitaDao;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaListar {

	public static void main(String[] args) {

		ItemReceitaDao dao = new ItemReceitaDao();
		
		try {
			for(ItemReceita p : dao.listar()){
			    System.out.println(	  			   "Id : "+p.getId()
			    					+"\tMateriaPrimaId : "+p.getMateriaPrimaId()
								         +"\tProdutoId : "+p.getProdutoId()
								       	  +"\tMedidaId : "+p.getMedidaId()
			    							  + "\tQtd : "+p.getQtd()
			                        		 +"\tTotal : "+p.getTotal());			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
