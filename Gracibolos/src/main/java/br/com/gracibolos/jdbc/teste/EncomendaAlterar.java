package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaAlterar {

	public static void main(String[] args) {
		
		Encomenda encomenda = new Encomenda();
		
		encomenda.setId(1);
		encomenda.setResponsavel("breno");
		encomenda.setDataInicio(Calendar.getInstance());
		encomenda.setDataFaltaProd(Calendar.getInstance());
		encomenda.setDataProducao(Calendar.getInstance());
		encomenda.setDataFinalizado(Calendar.getInstance());
		encomenda.setDataEntrega(Calendar.getInstance());
		encomenda.setEntregaRetirada(false);
		encomenda.setTotal(null);
		encomenda.setDescricao("ok");
		encomenda.setNumero(4354);
		encomenda.setClienteId(7);	
		encomenda.setStatusNome("teste");
		
		EncomendaDao dao = new EncomendaDao();
		
		try {
			if(dao.alterar(encomenda) == true){
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
