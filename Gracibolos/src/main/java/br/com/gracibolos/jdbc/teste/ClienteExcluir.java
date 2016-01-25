package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;

public class ClienteExcluir {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		
		dao.excluir(5);

	}

}
