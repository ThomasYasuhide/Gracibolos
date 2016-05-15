package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

public class ItemEncomendaListar {

	public static void main(String[] args) {
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			for(ItemEncomenda i : dao.pesquisar("55")){
			    System.out.println(	     "itemEncomenda id  : "+i.getId()//itemEncomenda id
							+ "\nProduto produtoId : "+i.getProdutoIdProduto()//Produto produtoId
			    					+"\nitemEncomenda produtoId : "+i.getProdutoId()//itemEncomenda produtoId
			    					+"\nitemEncomenda encomendaId : "+i.getEncomendaId()//itemEncomenda encomendaId
			    					 + "\nitemEncomenda quantidade : "+i.getQuantidade()//itemEncomenda quantidade
			    						+ "\nproduto none : "+i.getNomeProduto()//produto none			
			    						+ "\nproduto valor : "+i.getValor()//produto valor
			    						
			    
			    +"\n");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
