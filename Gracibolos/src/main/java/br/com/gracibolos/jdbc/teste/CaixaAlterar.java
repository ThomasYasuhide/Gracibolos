package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaAlterar {

	public static void main(String[] args) {
	
		Caixa c = new Caixa();	
		
		c.setEncomendaId(null);
		c.setFornecedorId(1);
		BigDecimal valor = new BigDecimal(336.00);
		c.setValor(valor);
		c.setGastoRecebimento(1);
		c.setForma("debito");
		c.setParcela(1);
		c.setDescricao(null);
		LocalDate data = LocalDate.of(2016, 05, 06);
		c.setData(data);
		c.setId(10L);
		
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
