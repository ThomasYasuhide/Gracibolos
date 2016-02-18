package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoListar {

	public static void main(String[] args) {
		
		ProdutoDao dao = new ProdutoDao();
		
		
		try {
			for( Produto p : dao.listar()){			
				/*
				System.out.println(	  
					
						 				  "Id : "+p.getId()
						 			+ "\tNome : "+p.getNome()
						 		   + "\tValor : "+p.getValor()
						 		 + "\tReceita : "+p.getReceita()
						 			+ "\tFoto : "+p.getFoto()
						   + "\tProdutoPronto : "+p.getProdutoProntoCollection()
						   + "\tItemEncomenda : "+p.getItemEncomendaCollection()
						 + "\tTipoProdutoNome : "+p.getTipoProdutoNome()
						 	 + "\tItemReceita : "+p.getItemReceitaCollection());
					*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
