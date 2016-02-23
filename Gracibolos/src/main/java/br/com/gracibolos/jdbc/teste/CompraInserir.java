package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.CompraDao;
import br.com.gracibolos.jdbc.model.Compra;

//funcionando
public class CompraInserir {

	public static void main(String[] args) {

		Compra c = new Compra();
		
		c.setTipo("a");
		c.setNumero("3");
		c.setData(Calendar.getInstance());
		c.setTotal(null);
		c.setFornecedorId(2);
		c.setStatusNome("teste");
		
		CompraDao dao = new CompraDao();
		
		try {
			if(dao.inserir(c) == true){
				
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
