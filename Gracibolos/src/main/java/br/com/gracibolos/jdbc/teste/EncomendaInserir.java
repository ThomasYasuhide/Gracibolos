package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaInserir {

	public static void main(String[] args) {

		Encomenda encomenda = new Encomenda();
		
		encomenda.setResponsavel("responsavel");
		encomenda.setDataInicio(Calendar.getInstance());
		encomenda.setDataFaltaProd(Calendar.getInstance());
		encomenda.setDataProducao(Calendar.getInstance());
		encomenda.setDataFinalizado(Calendar.getInstance());
		encomenda.setDataEntrega(Calendar.getInstance());
		encomenda.setEntregaRetirada(true);
		encomenda.setTotal(null);
		encomenda.setDescricao("teste");
		encomenda.setNumero(324);
		encomenda.setClienteId(7);	
		encomenda.setStatusNome("teste");
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			if(dao.inserir(encomenda) == true){
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
