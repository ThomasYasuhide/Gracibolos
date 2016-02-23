package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaExcluir {

	public static void main(String[] args) {
		
		EncomendaDao dao = new EncomendaDao();
		
		Encomenda encomenda = new Encomenda();
		encomenda.setId(3);
		
		try {
			if(dao.excluir(encomenda) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao Excluir encomenda");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
