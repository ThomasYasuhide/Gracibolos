package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoExcluir {

	public static void main(String[] args) {
		
		ProdutoDao dao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setId(2);
				
		dao.excluir(produto);
	}

}
