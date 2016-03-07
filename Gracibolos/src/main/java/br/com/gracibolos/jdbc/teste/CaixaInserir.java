package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaInserir {

	public static void main(String[] args) {
		
		Caixa c = new Caixa();
		BigDecimal valor = new BigDecimal(33);
		
		c.setEncomendaId(1);
		c.setValor(valor);
		c.setGasto(true);
		c.setRecebimento(true);
		c.setForma("quadrada");
		c.setDescricao("testee");
		
		CaixaDao dao = new CaixaDao();
		
		try {
			if(dao.inserir(c) == true){
				
				System.out.println("inserido com sucesso");
			}
			else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
