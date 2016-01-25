package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

public class ClienteListar {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		for(Cliente p : dao.listar()){
            System.out.println(	  "Id : "+p.getId()
            					+ "\tNome : "+p.getNomeRs()
                                +"\tCPF/CNPJ : "+p.getCpfCnpj()
                                +"\tRG/IE : "+p.getRgIe()
                                +"\tCEP : "+p.getCep()
                                +"\tTel : "+p.getTel1());
		
		
		}
	}

}
