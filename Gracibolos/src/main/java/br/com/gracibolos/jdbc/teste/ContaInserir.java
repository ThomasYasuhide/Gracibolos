package br.com.gracibolos.jdbc.teste;


import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaInserir {

	public static void main(String[] args) {

		Conta conta = new Conta();
		
		conta.setCodigo("123");
		conta.setDataVencimento(LocalDate.now());
		conta.setDataPagamento(LocalDate.now());
		conta.setValor(null);
		conta.setCaixaId(1);
		conta.setFornecedorId(2); 
		conta.setColaboradorId(2);
		
		ContaDao dao = new ContaDao();
		  
		try {
			if(dao.inserir(conta)== true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
