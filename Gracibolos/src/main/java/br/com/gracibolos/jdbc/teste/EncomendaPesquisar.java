package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

public class EncomendaPesquisar {

	public static void main(String[] args) {
		EncomendaDao dao = new EncomendaDao();
		Encomenda e = null;
		//Gerador g = new Gerador();
		//Long[] ids = g.IdsEnc();
		//Long id = g.ranIdLong(ids);
		
		try {
				e = dao.pesquisarId("23");
				System.out.println(	  
								"encomendaId : "+e.getId()
							   +"\nClienteId : "+e.getClienteid()
							   +"\nNomerazao : "+e.getNomerazao()
							     +"\nCpfcnpj : "+e.getCpfcnpj()
						          +"\nStatus : "+e.getStatus()
						    + "\nResponsavel : "+e.getResponsavel()
						   	  +"\nDataInicio : "+e.getDataencomenda()
			            +"\nDataCancelamento : "+e.getDatacancelamento()
			                +"\nDataProducao : "+e.getDataproducao()
			             +"\nDataFaturamento : "+e.getDatafaturamento()
			              	+ "\nDataEntrega : "+e.getDataentrega()
			             +"\nEntregaRetirada : "+e.getDatafinalizado()
			             		   +"\nTotal : "+e.getTotalprodutos()
			             	   +"\tDescricao : "+e.getObs()
			             	   	 
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
						
					}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
