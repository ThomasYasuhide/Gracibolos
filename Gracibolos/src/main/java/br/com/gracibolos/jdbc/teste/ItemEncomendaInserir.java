package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaInserir {

	public static void main(String[] args) {
	
		ItemEncomenda itemEncomenda = new ItemEncomenda();
		
		itemEncomenda.setProdutoId(3);
		itemEncomenda.setEncomendaId(1);
		itemEncomenda.setQuantidade(543);		
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			if(dao.inserir(itemEncomenda) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
