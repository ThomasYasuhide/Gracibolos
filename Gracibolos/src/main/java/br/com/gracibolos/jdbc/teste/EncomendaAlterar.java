package br.com.gracibolos.jdbc.teste;

//import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaAlterar {

	public static void main(String[] args) {
		
		Encomenda encomenda = new Encomenda();
		//BigDecimal big = new BigDecimal(45.90);
		Gerador g = new Gerador();
		int[] ids = g.IdsCli();
		int id = g.ranIdInt(ids);
		
		encomenda.setId(2L);
		encomenda.setClienteid(id);	
		encomenda.setStatus(2);
		encomenda.setResponsavel("responsavel");
		encomenda.setDataencomenda(LocalDate.now());
		encomenda.setDatacancelamento(LocalDate.now());
		encomenda.setDataproducao(LocalDate.now());
		encomenda.setDatafinalizado(LocalDate.now());
		encomenda.setDataentrega(LocalDate.now());
		encomenda.setDatafaturamento(LocalDate.now());
		encomenda.setTotalprodutos(null);
		encomenda.setObs("completo");
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			if(dao.alterar(encomenda) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
