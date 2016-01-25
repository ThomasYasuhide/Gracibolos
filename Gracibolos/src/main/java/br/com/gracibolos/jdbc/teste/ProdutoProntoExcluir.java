package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;

public class ProdutoProntoExcluir {

	public static void main(String[] args) {
		
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		dao.excluir(2);
		
		

	}

}
