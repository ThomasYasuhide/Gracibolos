package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Caixa@1c6c3b2..) não sei pq
public class CaixaListarEntre {

	public static void main(String[] args) {
		
		CaixaDao dao = new CaixaDao();
		
		try {
			for(Caixa c : dao.pesquisarEntre("2016/01/01", "2016/01/30")){
			    System.out.println(	     		 //"Id : "+c.getId()
			    					   "\tEncomendaId: "+c.getEncomendaId()
			    				    + "\tFornecedorId: "+c.getFornecedorId()
			                        		+"\tValor: "+c.getValor()
			                        		+"\tGasto: "+c.getGastoRecebimento()
			                        	   //+"\tForma : "+c.getForma()
			                        	 //+"\tParcela : "+c.getParcela()			                              
			                            //+"\tDescrição :"+c.getDescricao()
			    							 +"\tData :"+c.getData());		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
