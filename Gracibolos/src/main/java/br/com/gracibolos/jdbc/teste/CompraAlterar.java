package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.CompraDao;
import br.com.gracibolos.jdbc.model.Compra;

//funcionando
public class CompraAlterar {

	public static void main(String[] args) {

		Compra c = new Compra();
		
		c.setId(1);
		c.setTipo("b");
		c.setNumero("4");
		c.setData(Calendar.getInstance());
		c.setTotal(null);
		c.setFornecedorId(3);
		c.setStatusNome("teste");
		
		CompraDao dao = new CompraDao();
		
		try {
			if(dao.alterar(c) == true){
				
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
