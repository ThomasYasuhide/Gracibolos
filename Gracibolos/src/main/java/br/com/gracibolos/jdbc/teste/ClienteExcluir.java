package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

//funcionando
public class ClienteExcluir {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setId(2);
		
		try {
			if(dao.excluir(cliente) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluir cliente");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
