package br.com.gracibolos.jdbc.teste;

//funcionando
import java.time.LocalDate;
import br.com.gracibolos.jdbc.dao.ProdutoProntoDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.Produto;
import br.com.gracibolos.jdbc.model.ProdutoPronto;

public class ProdutoProntoInserir {

	public static void main(String[] args) {

		ProdutoPronto pPronto = new ProdutoPronto();
		
		//seto os IDs do (produto e encomenda)
		//e converto de Long para int na hora de usar o get
		Produto p = new Produto();
		p.setId(1L);
		
		Encomenda e = new Encomenda();
		e.setId(1L);
		
		pPronto.setProdutoId(p.getId().intValue());
		pPronto.setEncomendaId(e.getId().intValue());
		pPronto.setFinalizado(LocalDate.now());
		pPronto.setDataValidade(LocalDate.now());
		pPronto.setCodigo("22");		
		
		ProdutoProntoDao dao = new ProdutoProntoDao();
		
		try {
			if(dao.inserir(pPronto) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
	}

}
