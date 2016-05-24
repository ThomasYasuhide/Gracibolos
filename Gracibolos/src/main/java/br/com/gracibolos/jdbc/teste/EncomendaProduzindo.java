package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;

public class EncomendaProduzindo {

	public static void main(String[] args) {
		// Auto-generated method stub
		EncomendaDao dao = new EncomendaDao();
		try {
			dao.alterarProduzindo("57");
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

}
