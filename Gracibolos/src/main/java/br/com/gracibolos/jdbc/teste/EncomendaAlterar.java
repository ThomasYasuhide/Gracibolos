package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaAlterar {

	public static void main(String[] args) {
		
		Encomenda encomenda = new Encomenda();
//		BigDecimal big = new BigDecimal(45.90);
		
		encomenda.setId(1L);
		//encomenda.setClienteId("1L");	
		//encomenda.setStatusNome("1L");
//		encomenda.setResponsavel("responsavel");
//		encomenda.setDataInicio(LocalDate.now());
//		encomenda.setDataFaltaProd(LocalDate.now());
//		encomenda.setDataProducao(LocalDate.now());
//		encomenda.setDataFinalizado(LocalDate.now());
//		encomenda.setDataEntrega(LocalDate.now());
//		encomenda.setEntregaRetirada(true);
//		encomenda.setTotal(big);
//		encomenda.setDescricao("completo");
//		encomenda.setNumero(87);
		
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
