package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Saldo;

public class CaixaUpdateSaldo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Saldo s = new Saldo();
		CaixaDao dao = new CaixaDao();
		BigDecimal saldo = new BigDecimal(0);
		s.setSaldo(saldo);
		try {
			if(dao.updateSaldo(s)){
				System.out.println("saldo atualizado");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
