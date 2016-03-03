package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

//funcionando
public class ProdutoExcluir {

	public static void main(String[] args) {
		
		ProdutoDao dao = new ProdutoDao();
		
		Produto produto = new Produto();
		produto.setId(2L);
				
		try {
			if(dao.excluir(produto) == true){
				System.out.println("Excluido com sucesso!");
			}
			else{
				System.out.println("Erro ao excluir o produto");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
