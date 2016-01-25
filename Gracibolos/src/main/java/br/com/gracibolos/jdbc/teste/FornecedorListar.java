package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class FornecedorListar {

	public static void main(String[] args) {

		FornecedorDao dao = new FornecedorDao();
		
		for(Fornecedor f : dao.listar()){
			System.out.println(	  
							 "Id : "+f.getId()
					   + "\tNome : "+f.getNomeRs()
                    +"\tCPF/CNPJ : "+f.getCpfCnpj()
                       +"\tRG/IE : "+f.getRgIe()
                         +"\tCEP : "+f.getCep()
                      +"\tNumero : "+f.getNumero()
                      	+"\tTel1 : "+f.getTelefone1()
                      	+"\tTel2 : "+f.getTelefone2()
                      	+"\tTel3 : "+f.getTelefone3()
                      	+"\tCel1 : "+f.getCel1()
                      	+"\tCel2 : "+f.getCel2()
                      	+"\tSite : "+f.getSite()
                      +"\tEmail1 : "+f.getEmail1()
                      +"\tEmail2 : "+f.getEmail2()
                    +"\tContato1 : "+f.getContato1()
                     +"\tContato2: "+f.getContato2()
                  +"\tComplemento: "+f.getComplemento()
                          +"\tObs: "+f.getObs()
                      +"\tCompra : "+f.getCompraCollection()
                       +"\tConta : "+f.getContaCollection()
                     +"\tSuporte : "+f.getSuporteCollection());
					
		}
	}

}
