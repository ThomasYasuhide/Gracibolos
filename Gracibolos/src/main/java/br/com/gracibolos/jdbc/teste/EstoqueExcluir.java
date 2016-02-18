package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
import br.com.gracibolos.jdbc.model.Estoque;
public class EstoqueExcluir {

	public static void main(String[] args) {

		EstoqueDao dao = new EstoqueDao();

		Estoque estoque = new Estoque();
		estoque.setId(4);
		
		try {
			dao.excluir(estoque);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
