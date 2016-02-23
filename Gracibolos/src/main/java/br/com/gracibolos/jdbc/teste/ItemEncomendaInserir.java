package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaInserir {

	public static void main(String[] args) {
	
		ItemEncomenda itemEncomenda = new ItemEncomenda();
		
		itemEncomenda.setQtd(543);
		itemEncomenda.setProdutoId(3);
		itemEncomenda.setEncomendaId(1);
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			if(dao.inserir(itemEncomenda) == true){
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
