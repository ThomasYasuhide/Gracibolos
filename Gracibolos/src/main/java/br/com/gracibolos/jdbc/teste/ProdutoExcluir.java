package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;

public class ProdutoExcluir {

	public static void main(String[] args) {
		
		ProdutoDao dao = new ProdutoDao();
		
		dao.excluir(2);
	}

}
