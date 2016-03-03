package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.ItemReceitaDao;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaInserir {

	public static void main(String[] args) {

		ItemReceita receita = new ItemReceita();
		
		BigDecimal big = new BigDecimal(30.00);		

		receita.setMateriaPrimaId(1);
		receita.setProdutoId(1);
		receita.setMedidaId(1);
		receita.setQtd(13);
		receita.setTotal(big);	
		
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
