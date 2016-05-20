package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.CaixaDao;

public class CaixaUpdateSaldo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// Auto-generated method stub
		
		CaixaDao dao = new CaixaDao();
		BigDecimal saldo = new BigDecimal(0);
		BigDecimal valor = new BigDecimal(100);
		
		try {
			saldo = dao.getSaldo();
			//if(dao.updateSaldo(saldo.add(valor))){
			if(dao.updateSaldo(saldo.subtract(valor))){
				System.out.println("saldo atualizado");
			}
			
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

}
