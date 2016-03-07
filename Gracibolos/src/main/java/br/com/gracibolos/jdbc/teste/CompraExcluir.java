package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CompraDao;
import br.com.gracibolos.jdbc.model.Compra;

//funcionando
public class CompraExcluir {

	public static void main(String[] args) {

		CompraDao dao = new CompraDao();
		
		Compra c = new Compra();
		c.setId(7L);
		
		
		try {
			if(dao.excluir(c) == true){
				
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluido compra");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
