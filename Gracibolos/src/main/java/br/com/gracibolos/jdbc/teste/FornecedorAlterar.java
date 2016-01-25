package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class FornecedorAlterar {

	public static void main(String[] args) {
		
		Fornecedor f1 = new Fornecedor();
		
		f1.setId(1);
		f1.setNomeRs("");
		f1.setCpfCnpj("1231412");
		f1.setRgIe("1231232");
		f1.setCep(3678000);
		f1.setNumero("54");
		f1.setTelefone1("");
		f1.setTelefone2("");
		f1.setTelefone3("");
		f1.setCel1("");
		f1.setCel2("");
		f1.setSite("");
		f1.setEmail1("");
		f1.setEmail2("");
		f1.setContato1("");
		f1.setContato2("");				
		f1.setComplemento("");
		f1.setObs("");
		//f1.setCompraCollection(compraCollection);
		//f1.setContaCollection(contaCollection);
		//f1.setSuporteCollection(suporteCollection);
		
		FornecedorDao dao = new FornecedorDao();
		
		if(dao.alterar(f1) == true){
			System.out.println("inserido com sucesso");
		}else{
			System.out.println("falha");
		}	

	}

}
