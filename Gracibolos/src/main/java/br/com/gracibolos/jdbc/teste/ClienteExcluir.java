package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

public class ClienteExcluir {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setId(5);
		
		dao.excluir(cliente);

	}

}
