package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando, porem est� listando (br.com.gracibolos.jdbc.model.Caixa@1c6c3b2..) n�o sei pq
public class CaixaListarEntre {

	public static void main(String[] args) {
		
		CaixaDao dao = new CaixaDao();
		
		try {
			for(Caixa c : dao.pesquisarEntre("2016/01/01", "2016/01/30")){
			    System.out.println(	     		 //"Id : "+c.getId()
			    					   "\tEncomendaId: "+c.getEncomendaId()
			                        		+"\tValor: "+c.getValor()
			                        		+"\tGasto: "+c.getGastoRecebimento()
		                        	     //+"\tForma : "+c.getForma()
		                        	   //+"\tParcela : "+c.getParcela()			                              
		                             //+"\tDescri��o :"+c.getDescricao()
    							   +"\tDataTransa��o :"+c.getDataTransacao()
									+"\tfornecedorId :"+c.getFornecedorId()
	    							 +"\tIdFornecedor :"+c.getFornecedorIdFornecedor()
							 	    	+"\tNomerazao :"+c.getNomerazao()
			    		);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
