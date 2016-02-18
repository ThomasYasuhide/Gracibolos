package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

public class ProdutoProntoExcluir {

	public static void main(String[] args) {
		
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		ProdutoPronto produtoPronto = new ProdutoPronto();
		produtoPronto.setId(2);
		
		try {
			dao.excluir(produtoPronto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
