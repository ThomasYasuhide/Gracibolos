package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

//funcionando
public class ProdutoListar {

	public static void main(String[] args) {
		
		ProdutoDao dao = new ProdutoDao();
		
		
		try {
			for( Produto p : dao.listar()){
				System.out.println(	  
					
						 				  "Id : "+p.getId()
						 + "\tTipoProdutoNome : "+p.getTipoProdutoNome()
									+ "\tNome : "+p.getNome()
						           + "\tValor : "+p.getValor()
						 	  	 + "\tReceita : "+p.getReceita()
						 			+ "\tFoto : "+p.getFoto());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
