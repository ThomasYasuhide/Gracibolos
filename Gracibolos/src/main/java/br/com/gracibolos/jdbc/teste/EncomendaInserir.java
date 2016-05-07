package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaInserir {

	public static void main(String[] args) {
		
		Encomenda encomenda;
		Gerador g = new Gerador();
		int[] ids = g.IdsCli();
		BigDecimal total;
		
		encomenda = new Encomenda();
		int idCli = g.ranIdInt(ids);
		encomenda.setClienteid(idCli);	
		encomenda.setStatus(g.randBetween(1, 4));//vai de 1 - 4
		encomenda.setResponsavel(null);
		encomenda.setDatafaturamento(LocalDate.now());
		encomenda.setDataproducao(LocalDate.now());
		encomenda.setDatafinalizado(LocalDate.now());
		encomenda.setDatacancelamento(LocalDate.now());
		
		total = new BigDecimal(g.randBetween(8, 250));
		encomenda.setTotalprodutos(total);
		encomenda.setObs("teste");
		
		
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			if(dao.inserir(encomenda) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
