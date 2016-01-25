package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
public class EstoqueExcluir {

	public static void main(String[] args) {

		EstoqueDao dao = new EstoqueDao();

		dao.excluir(4);
	}

}
