package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

public class ProdutoProntoInserir {

	public static void main(String[] args) {

		ProdutoPronto pPronto = new ProdutoPronto();
		
		pPronto.setFinalizado(Calendar.getInstance());
		pPronto.setDataValidade(Calendar.getInstance());
		pPronto.setCodigo("1");
		pPronto.setEncomendaId(null);
		pPronto.setProdutoId(null);
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		try {
			if(dao.inserir(pPronto) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
