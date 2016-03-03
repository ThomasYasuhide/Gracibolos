package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
import br.com.gracibolos.jdbc.model.Estoque;

//funcionando
public class EstoqueExcluir {

	public static void main(String[] args) {

		EstoqueDao dao = new EstoqueDao();

		Estoque estoque = new Estoque();
		estoque.setId(2L);
		
		try {
			if(dao.excluir(estoque) == true){
				System.out.println("Excluido com sucesso!");
			}
			else
			{
				System.out.println("Erro ao excluir o estoque");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
