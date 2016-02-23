package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaAlterar {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setId(1);
		conta.setCodigo("");
		conta.setDataVencimento(Calendar.getInstance());
		conta.setDataPagamento(Calendar.getInstance());
		conta.setValor(null);
		conta.setCaixaId(null);
		conta.setFornecedorId(null);
		conta.setColaboradorId(null);
		
		ContaDao dao = new ContaDao();
		
		try {
			if(dao.alterar(conta)== true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
