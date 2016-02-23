package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemReceitaDao;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaInserir {

	public static void main(String[] args) {

		ItemReceita receita = new ItemReceita();
		
		receita.setQtd(null);
		receita.setTotal(null);
		receita.setMedidaId(1);
		receita.setMateriaPrimaId(1);
		receita.setProdutoId(1);
		
		ItemReceitaDao dao = new ItemReceitaDao();
		
		try {
			if(dao.inserir(receita)== true)
			{
				System.out.println("inserido com sucesso");
			}
			else 
			{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
