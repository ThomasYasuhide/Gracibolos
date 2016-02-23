package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

//funcionando
public class ProdutoProntoAlterar {

	public static void main(String[] args) {
		
		ProdutoPronto pPronto = new ProdutoPronto();
		
		pPronto.setId(1);
		pPronto.setProdutoId(3);
		pPronto.setEncomendaId(1);
		pPronto.setFinalizado(Calendar.getInstance());
		pPronto.setDataValidade(Calendar.getInstance());
		pPronto.setCodigo("6");
		
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		try {
			if(dao.alterar(pPronto) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
