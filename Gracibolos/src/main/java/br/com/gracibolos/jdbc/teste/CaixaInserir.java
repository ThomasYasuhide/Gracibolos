package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaInserir {
	
	public static void main(String[] args) {
		
		CaixaDao dao = new CaixaDao();
		
		Caixa c = new Caixa();
		BigDecimal big = new BigDecimal(30.00);
		c.setGastoRecebimento(0);
		c.setEncomendaId(null);
		c.setFornecedorId(146);
		c.setValor(big);
		c.setForma(1);
		c.setParcela(1);
		//c.setData(LocalDate.now());
		c.setDescricao("teste");
		
		try {
			if(dao.inserir(c)== true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
