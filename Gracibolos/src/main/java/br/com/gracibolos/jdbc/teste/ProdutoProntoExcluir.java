package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

//funcionando
public class ProdutoProntoExcluir {

	public static void main(String[] args) {
		
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		ProdutoPronto produtoPronto = new ProdutoPronto();
		produtoPronto.setId(2);
		
		try {
			if(dao.excluir(produtoPronto) == true)
			{
				System.out.println("Excluido com sucesso!");
			}
			else
			{
				System.out.println("Erro ao excluir o produto pronto");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
