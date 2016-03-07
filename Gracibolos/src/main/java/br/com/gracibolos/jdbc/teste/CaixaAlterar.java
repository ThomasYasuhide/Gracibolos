package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaAlterar {

	public static void main(String[] args) {
		
		Caixa c = new Caixa();
		BigDecimal valor = new BigDecimal(33);
		
		c.setId(1L);
		c.setEncomendaId(1);
		c.setValor(valor);
		c.setGasto(true);
		c.setRecebimento(true);
		c.setForma("redonda");
		c.setDescricao("testee");
		
		CaixaDao dao = new CaixaDao();
		
		try {
			if(dao.alterar(c) == true){
				
				System.out.println("Alterado com sucesso");
			}
			else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
