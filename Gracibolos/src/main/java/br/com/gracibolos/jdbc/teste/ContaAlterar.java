package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaAlterar {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		BigDecimal big = new BigDecimal(200.32);
		
		conta.setId(2L);
		conta.setFornecedorId(1); 
		conta.setColaboradorId(6);
		conta.setCaixaId(2);
		conta.setCodigo("12233");
		conta.setDataVencimento(LocalDate.now());
		conta.setDataPagamento(LocalDate.now());
		conta.setValor(big);
		
		ContaDao dao = new ContaDao();
		
		try {
			if(dao.alterar(conta)== true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
