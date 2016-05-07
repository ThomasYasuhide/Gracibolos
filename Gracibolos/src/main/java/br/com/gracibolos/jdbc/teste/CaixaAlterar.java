package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaAlterar {

	public static void main(String[] args) {
	
		Caixa c = new Caixa();
		BigDecimal valor = new BigDecimal(336.00);
		
		Date data = new Date();
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse("06/05/2016");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		c.setEncomendaId(null);
		c.setFornecedorId(1);
		c.setValor(valor);
		c.setGastoRecebimento(1);
		c.setForma("debito");
		c.setParcela(1);
		c.setDescricao(null);
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
