package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.CompraDao;
import br.com.gracibolos.jdbc.model.Compra;

//funcionando
public class CompraAlterar {

	public static void main(String[] args) {

		Compra c = new Compra();
		BigDecimal bd = new BigDecimal(350.00);
		
		c.setId(6L);
		c.setFornecedorId(1);
		c.setStatusNome("teste");
		c.setTipo("a");
		c.setNumero("3");
		c.setData(LocalDate.now());
		c.setTotal(bd);
		
		CompraDao dao = new CompraDao();
		
		try {
			if(dao.alterar(c) == true){
				
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
