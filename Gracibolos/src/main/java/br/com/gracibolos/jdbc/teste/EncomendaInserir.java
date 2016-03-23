package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaInserir {

	public static void main(String[] args) {

		Encomenda encomenda = new Encomenda();
		
		//encomenda.setClienteId(7);	
		//encomenda.setStatusNome("teste");
//		encomenda.setResponsavel("responsavel");
//		encomenda.setDataInicio(LocalDate.now());
//		encomenda.setDataFaltaProd(LocalDate.now());
//		encomenda.setDataProducao(LocalDate.now());
//		encomenda.setDataFinalizado(LocalDate.now());
//		encomenda.setDataEntrega(LocalDate.now());
//		encomenda.setEntregaRetirada(true);
//		encomenda.setTotal(big);
//		encomenda.setDescricao("teste");
//		encomenda.setNumero(324);
		
		
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
