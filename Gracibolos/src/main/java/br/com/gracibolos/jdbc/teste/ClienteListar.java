package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

//funcionando
public class ClienteListar {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		try {
			for(Cliente p : dao.listar()){
			    System.out.println(	  			   "Id : "+p.getId()
			    						   + "\tStatus : "+p.getStatus()
			    						+"\tTipoPessoa : "+p.getTipopessoa()
			                        		  +"\tSexo : "+p.getSexo()
			                        +"\tDataNascimento : "+p.getDatanascimento()
			                        	 +"\tNomeRazao : "+p.getNomerazao()
			                        	   +"tCPF/CNPJ : "+p.getCpfcnpj()
			                        	     +"\tRG/IE : "+p.getRgie()
			                        	  +"\tEndereco : "+p.getEndereco()
			                        	    +"\tNumero : "+p.getNumero()
			                           +"\tComplemento : "+p.getComplemento()
			                           		+"\tBairro : "+p.getBairro()
			                           		+"\tEstado : "+p.getEstado()
			                           		+"\tCidade : "+p.getCidade()
			                           		   +"\tCEP : "+p.getCep()
			                           		   +"\tTel : "+p.getTel()
			                           		   +"\tCel : "+p.getCel()
			                           		 +"\tEmail : "+p.getEmail()
			                           		  +"\tSite : "+p.getSite()
			                          +"\tClienteDesde : "+p.getClientedesde()
			                          		   +"\tObs : "+p.getObs());			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
