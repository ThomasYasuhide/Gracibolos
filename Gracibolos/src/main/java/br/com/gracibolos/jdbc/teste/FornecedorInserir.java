package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;

//funcionando
public class FornecedorInserir {
	
	public static void main(String[] args) {
		
		Fornecedor f1 = new Fornecedor();
		
		f1.setTipopessoa(1);
		f1.setNomerazao("");
		f1.setCpfcnpj("");
		f1.setRgie("");
		f1.setEndereco("");
		f1.setNumero("54");
		f1.setComplemento("14");
		f1.setBairro("");
		f1.setEstado(2);
		f1.setCidade(3);		
		f1.setCep(365450);
		f1.setTel("");
		f1.setCel("");
		f1.setEmail("");		
		f1.setSite("acqualog.com.br");		
		f1.setObs("Empresa da água");
		
		FornecedorDao dao = new FornecedorDao();
		
		try {
			if(dao.inserir(f1) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

}
