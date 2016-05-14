package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaAlterar {

	public static void main(String[] args) {

		ItemEncomenda itemEncomenda = new ItemEncomenda();
		
		itemEncomenda.setId(1L);
		itemEncomenda.setProdutoId(3l);
		itemEncomenda.setEncomendaId(1l);
		itemEncomenda.setQuantidade(53);		
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		try {
			if(dao.alterar(itemEncomenda) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
