package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class FornecedorExcluir {

	public static void main(String[] args) {
		
		FornecedorDao dao = new FornecedorDao();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(1);
		
		dao.excluir(fornecedor);

	}

}
