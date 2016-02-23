package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.Produto;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

//Não está funcionando
public class ProdutoProntoInserir {

	public static void main(String[] args) {

		ProdutoPronto pPronto = new ProdutoPronto();
		Produto p = new Produto();
		p.setId(4);
		Encomenda e = new Encomenda();
		e.setId(4);
		
		pPronto.setProdutoId(p.getId());
		pPronto.setEncomendaId(e.getId());
		pPronto.setFinalizado(Calendar.getInstance());
		pPronto.setDataValidade(Calendar.getInstance());
		pPronto.setCodigo("22");
		
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		try {
			if(dao.inserir(pPronto) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

}
