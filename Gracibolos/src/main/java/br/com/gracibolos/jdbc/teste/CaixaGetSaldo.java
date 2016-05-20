package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;

public class CaixaGetSaldo {

	public static void main(String[] args) {
		// Auto-generated method stub
	
		CaixaDao dao = new CaixaDao();
		try {
			System.out.println("Saldo R$ "+dao.getSaldo());
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
