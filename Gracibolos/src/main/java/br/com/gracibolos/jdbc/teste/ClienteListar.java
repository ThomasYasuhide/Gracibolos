package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

//funcionando
public class ClienteListar {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		try {
			for(Cliente p : dao.listar()){
			    System.out.println(	  "Id : "+p.getId()
			    					+ "\tNome : "+p.getStatus()
			                        +"\tCPF/CNPJ : "+p.getTipopessoa()
			                        +"\tRG/IE : "+p.getSexo()
			                        +"\tCEP : "+p.getDatanascimento()
			                        +"\tTel : "+p.getNomerazao()
			                        +""+p.getCpfcnpj()
			                        +""+p.getRgie()
			                        +""+p.getEndereco()
			                        +""+p.getNumero()
			                        +""+p.getComplemento()
			                        +""+p.getBairro()
			                        +""+p.getEstado()
			                        +""+p.getCidade()
			                        +""+p.getCep()
			                        +""+p.getTel()
			                        +""+p.getCel()
			                        +""+p.getEmail()
			                        +""+p.getSite()
			                        +""+p.getClientedesde()
			                        +""+p.getObs());			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
