package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaInserir {

	public static void main(String[] args) {

		Conta conta = new Conta();
		BigDecimal big = new BigDecimal(200.32);
		
		conta.setFornecedorId(1); 
		conta.setColaboradorId(6);
		conta.setCaixaId(2);
		conta.setCodigo("123");
		conta.setDataVencimento(LocalDate.now());
		conta.setDataPagamento(LocalDate.now());
		conta.setValor(big);
		
		
		
		ContaDao dao = new ContaDao();
		  
		try {
			if(dao.inserir(conta)== true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
