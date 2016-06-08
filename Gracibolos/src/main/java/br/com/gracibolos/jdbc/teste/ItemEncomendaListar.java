package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

public class ItemEncomendaListar {

	public static void main(String[] args) {
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			//for(ItemEncomenda i : dao.pesquisar("55")){
			for(ItemEncomenda i : dao.listar()){
				i.setValor(i.getValorp());
				BigDecimal m = new BigDecimal(i.getQuantidade());
				i.setTotal(i.getValorp().multiply(m));
				System.out.println(	     " id  : "+i.getId()//itemEncomenda id
							+ "\n produtoId : "+i.getProdutoIdProduto()//Produto produtoId
			    					+"\n produtoId : "+i.getProdutoId()//itemEncomenda produtoId
			    					+"\n encomendaId : "+i.getEncomendaId()//itemEncomenda encomendaId
			    					 + "\n quantidade : "+i.getQuantidade()//itemEncomenda quantidade
			    						+ "\n none : "+i.getNomeProduto()//produto none			
			    						+ "\n item valor : "+i.getValor()//produto valor
			    						+ "\n produto valor : "+i.getValorp()//produto valor
			    						+ "\n total : "+i.getTotal()//produto valor
			    						
			    
			    +"\n");	
			    //Correção do valor e do total
				//dao.alterar(i);
			    
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
