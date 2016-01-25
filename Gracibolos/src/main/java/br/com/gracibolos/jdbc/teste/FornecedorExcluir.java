package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;

public class FornecedorExcluir {

	public static void main(String[] args) {
		
		FornecedorDao dao = new FornecedorDao();
		
		dao.excluir(1);

	}

}
