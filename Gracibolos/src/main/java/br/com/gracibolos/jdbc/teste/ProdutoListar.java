package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Produto@1c6c3b2..) não sei pq
public class ProdutoListar {

	public static void main(String[] args) {
		
		ProdutoDao dao = new ProdutoDao();
		
		
		try {
			for( Produto p : dao.listar()){
				System.out.println(	  
					
												"Id : "+p.getId()
						 				 +"\tStatus : "+p.getStatus()
						 				   +"\tTipo : "+p.getTipo()
						 				 +"\tCodigo : "+p.getCodigo()
						 			   	   +"\tNome : "+p.getNome()
						 				  +"\tCusto : "+p.getCusto()
						 				  +"\tValor : "+p.getValor()
						 				+"\tUnidade : "+p.getUnidade()
						 				+"\tUnidade : "+p.getUnidade()
						 				   +"\tPeso : "+p.getPeso()
						 				//+"\tReceita : "+p.getReceita()
						 				  + "\tFoto : "+p.getFoto());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
