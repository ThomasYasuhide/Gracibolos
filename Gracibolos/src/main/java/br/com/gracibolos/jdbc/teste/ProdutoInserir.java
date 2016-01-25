package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;
import br.com.gracibolos.jdbc.model.TipoProduto;

public class ProdutoInserir {

	public static void main(String[] args) {

		Produto p1 = new Produto();
		
		TipoProduto tp = new TipoProduto();
		//tp.setNome("tipo 1");
		
		p1.setNome("Cobertura");
		p1.setValor(null);
		p1.setReceita("teste");
		p1.setFoto(null);
		//p1.setProdutoProntoCollection(null);
		//p1.setItemEncomendaCollection(null);
		p1.setTipoProdutoNome(tp);
		//p1.setItemReceitaCollection(null);
		
		ProdutoDao dao = new ProdutoDao();
		
		if(dao.inserir(p1) == true){
			System.out.println("inserido com sucesso");
		}else{
			System.out.println("falha");
		}
	}

}
