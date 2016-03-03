package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaExcluir {

	public static void main(String[] args) {
		
		ItemEncomendaDao dao = new ItemEncomendaDao();
		
		ItemEncomenda itemEncomenda = new ItemEncomenda();
		itemEncomenda.setId(1L);
		
		try {
			if(dao.excluir(itemEncomenda) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao Excluir itemEncomenda");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
