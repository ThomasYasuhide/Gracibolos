package br.com.gracibolos.jdbc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class ItemEncomendaInserir {

	public static void main(String[] args) {
	
		ItemEncomendaDao dao = new ItemEncomendaDao();
		ItemEncomenda itemEncomenda;
		Gerador g = new Gerador();
		List<ItemEncomenda> list = new ArrayList<ItemEncomenda>(); 
		
		for(int i=0;i<3;i++){
			itemEncomenda = new ItemEncomenda();
			itemEncomenda.setProdutoId(g.ranIdLong(g.idsProduto()));
			//itemEncomenda.setEncomendaId(g.ranIdLong(g.IdsEnc()));
			itemEncomenda.setEncomendaId(61l);
			itemEncomenda.setQuantidade(g.randBetween(1, 4));		
			
			list.add(itemEncomenda);
		
		}
		try {
			int qtd = 0;
			qtd = dao.inserirList(list);
			if(qtd != 0){
				System.out.println(qtd+" inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
