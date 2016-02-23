package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;


/*funcionando em partes
 *falta fazer a conversão do valor e da foto
 */
public class FornecedorListar {

	public static void main(String[] args) {

		FornecedorDao dao = new FornecedorDao();
		
		try {
			for(Fornecedor f : dao.listar()){
				System.out.println(	  
								 "Id : "+f.getId()
						   + "\tNome : "+f.getTipopessoa()
			            +"\tCPF/CNPJ : "+f.getNomerazao()
			               +"\tRG/IE : "+f.getCpfcnpj()
			                 +"\tCEP : "+f.getRgie()
			                 +"\tCEP : "+f.getEndereco()
			              +"\tNumero : "+f.getNumero()
			              +"\tComplemento: "+f.getComplemento()
			              	+"\tTel1 : "+f.getBairro()
			              	+"\tTel2 : "+f.getEstado()
			              	+"\tTel3 : "+f.getCidade()
			              	+"\tCel1 : "+f.getCep()
			              	+"\tCel2 : "+f.getTel()
			                +"\tEmail2 : "+f.getCel()
			                +"\tEmail1 : "+f.getEmail()
			              	+"\tSite : "+f.getSite()
			                  +"\tObs: "+f.getObs());
						
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
