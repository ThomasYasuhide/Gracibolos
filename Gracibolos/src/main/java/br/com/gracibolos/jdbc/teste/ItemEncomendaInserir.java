package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaInserir {

	public static void main(String[] args) {
	
		ItemEncomenda itemEncomenda = new ItemEncomenda();
		Gerador g = new Gerador();
		
		for(int i=0;i<50;i++){
			itemEncomenda.setProdutoId(g.ranIdLong(g.idsProduto()));
			itemEncomenda.setEncomendaId(g.ranIdLong(g.IdsEnc()));
			itemEncomenda.setQuantidade(g.randBetween(1, 10));		
			
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

}
