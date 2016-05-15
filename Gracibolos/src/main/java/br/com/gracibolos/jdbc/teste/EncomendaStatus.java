package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

public class EncomendaStatus {

	public static void main(String[] args) {
		EncomendaDao dao = new EncomendaDao();
		
		
		try {
			
			for(Encomenda e : dao.emAberto()){
				System.out.println(	  
								 		 "Id : "+e.getId()
						          +"\nStatus : "+e.getStatus()
						    + "\nResponsavel : "+e.getResponsavel()
						   	  +"\nDataInicio : "+e.getDataencomenda()
			            +"\nDataCancelamento : "+e.getDatacancelamento()
			                +"\nDataProducao : "+e.getDataproducao()
			             +"\nDataFaturamento : "+e.getDatafaturamento()
			              	+ "\nDataEntrega : "+e.getDataentrega()
			             +"\nEntregaRetirada : "+e.getDatafinalizado()
			             		   +"\nTotal : "+e.getTotalprodutos()
			             	   +"\nDescricao : "+e.getObs()
			             	   +"\nNomerazao : "+e.getNomerazao()
			             	   	 +"\ncpfcnpj : "+e.getCpfcnpj()
			                   +"\nClienteId : "+e.getClienteId()
			             	   			             	   	 
					);
					for(ItemEncomenda ie : e.getListItemEncomenda()){
						
						System.out.println(
									
								"\n\tId : "+ie.getId()
						+"\n\tprodutoId : "+ie.getProdutoId()
					  +"\n\tencomendaId : "+ie.getEncomendaId()
				 +"\n\tProdutoIdProduto : "+ie.getProdutoIdProduto()
			 			  	 +"\n\tNome : "+ie.getNomeProduto()
			 			  	  +"\n\tQtd : "+ie.getQuantidade()
			 			  	+"\n\tValor : "+ie.getValor()
								);
	
					}//Fim do for dos itens
			}//fim do for encomenda
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
