package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemReceitaDao;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaExcluir {

	public static void main(String[] args) {
		
		ItemReceita receita = new ItemReceita();		
		receita.setId(2);
		
		ItemReceitaDao dao = new ItemReceitaDao();
		
		try {
			if(dao.excluir(receita) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao Excluir item da receita");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
