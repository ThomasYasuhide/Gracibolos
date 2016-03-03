package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;


//funcionando
public class FornecedorListar {

	public static void main(String[] args) {

		FornecedorDao dao = new FornecedorDao();
		
		try {
			for(Fornecedor f : dao.listar()){
				System.out.println(	  
								 "Id : "+f.getId()
						   + "\tTipoPessoa : "+f.getTipopessoa()
			            +"\tNomeRazao : "+f.getNomerazao()
			               +"\tCPF/CNPJ : "+f.getCpfcnpj()
			                 +"\tRG/IE : "+f.getRgie()
			                 +"\tEndereço : "+f.getEndereco()
			              +"\tNumero : "+f.getNumero()
			          +"\tComplemento: "+f.getComplemento()
			              	+"\tBairro : "+f.getBairro()
			              	+"\tEstado : "+f.getEstado()
			              	+"\tCidade : "+f.getCidade()
			              	+"\tCEP : "+f.getCep()
			              	+"\tTel : "+f.getTel()
			              +"\tCel : "+f.getCel()
			              +"\tEmail : "+f.getEmail()
			              	+"\tSite : "+f.getSite()
			                  +"\tObs: "+f.getObs());
						
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
