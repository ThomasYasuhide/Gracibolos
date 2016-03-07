package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.CompraDao;
import br.com.gracibolos.jdbc.model.Compra;

//funcionando
public class CompraInserir {

	public static void main(String[] args) {

		Compra c = new Compra();
		BigDecimal bd = new BigDecimal(340.00);
		
		c.setFornecedorId(1);
		c.setStatusNome("teste");
		c.setTipo("a");
		c.setNumero("6");
		c.setData(LocalDate.now());
		c.setTotal(bd);
		
		
		CompraDao dao = new CompraDao();
		
		try {
			if(dao.inserir(c) == true){
				
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
