package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Saldo;

public class CaixaGetSaldo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Saldo s = new Saldo();
		CaixaDao dao = new CaixaDao();
		try {
			s = dao.getSaldo();
			System.out.println("Saldo R$ "+s.getSaldo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
