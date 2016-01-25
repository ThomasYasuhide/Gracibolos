package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

public class ClienteAlterar {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		
		c1.setId(6);		 	
		c1.setNomeRs("Lucas");
		c1.setCpfCnpj("4564452");//BIGINT
		c1.setRgIe("23434");
		c1.setCep(43544);
		c1.setNumero("");
		c1.setTel1("95454-2345");
		c1.getTel2();
		c1.setEmail("lucas@hotmail.com");
		c1.setSexo('M');
		
		
		ClienteDao dao = new ClienteDao();
		
		if(dao.alterar(c1) == true){
			System.out.println("alterado com sucesso!");
		}else{
			System.out.println("Não foi possivel alterar");
		}

	}

}
