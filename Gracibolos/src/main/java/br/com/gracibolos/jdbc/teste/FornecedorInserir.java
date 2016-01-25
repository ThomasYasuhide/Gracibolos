package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class FornecedorInserir {
	
	public static void main(String[] args) {
		
		Fornecedor f1 = new Fornecedor();
		
		f1.setNomeRs("AcquaLog");
		f1.setCpfCnpj("76575675");
		f1.setRgIe("345562");
		f1.setCep(3654450);
		f1.setNumero("54");
		f1.setTelefone1("53243535");
		f1.setTelefone2("2325466");
		f1.setTelefone3("");
		f1.setCel1("23423242");
		f1.setCel2("87878777");
		f1.setSite("acqualog.com.br");
		f1.setEmail1("acqualog@hotmail.com");
		f1.setEmail2("acqualog2@gmail.com");	
		f1.setContato1("guilherme");
		f1.setContato2("breno");				
		f1.setComplemento("");
		f1.setObs("Empresa d'água");
		//f1.setCompraCollection(compraCollection);
		//f1.setContaCollection(contaCollection);
		//f1.setSuporteCollection(suporteCollection);
		
		FornecedorDao dao = new FornecedorDao();
		
		if(dao.inserir(f1) == true){
			System.out.println("inserido com sucesso");
		}else{
			System.out.println("falha");
		}	
		
	}

}
