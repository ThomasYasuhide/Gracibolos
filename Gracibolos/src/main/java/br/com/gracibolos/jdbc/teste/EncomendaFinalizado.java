package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;

public class EncomendaFinalizado {

	public static void main(String[] args) {
		EncomendaDao dao = new EncomendaDao();
		try {
			dao.alterarFinalizado("58");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
