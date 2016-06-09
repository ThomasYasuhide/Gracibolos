package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;

public class EncomendaNumero {

	public static void main(String[] args) {
		EncomendaDao dao = new EncomendaDao();
		System.out.println(dao.numeroEncomenda());
	}

}
