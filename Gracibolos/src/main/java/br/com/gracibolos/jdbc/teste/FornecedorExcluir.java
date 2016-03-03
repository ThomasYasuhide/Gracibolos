package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Fornecedor;

//funcionando
public class FornecedorExcluir {

	public static void main(String[] args) {
		
		FornecedorDao dao = new FornecedorDao();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(2);
		
		try {
			if(dao.excluir(fornecedor) == true){
				System.out.println("Excluido com sucesso!");
			}
			else
			{
				System.out.println("Erro ao excluir fornecedor");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
