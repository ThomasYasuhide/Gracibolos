package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaListar {

	public static void main(String[] args) {

		ContaDao dao = new ContaDao();
		
		try {
			for(Conta c : dao.listar()){
			    System.out.println(	  				"Id : "+c.getId()
			    							 + "\tCodigo: "+c.getCodigo()
			    					  +"\tDataVencimento: "+c.getDataVencimento()
			    					  +"\tDataPagamento : "+c.getDataPagamento()
			    					  		   +"\tValor: "+c.getValor()        
			    					  		+"\tCaixaId : "+c.getCaixaId()
			    					   +"\tFornecedorId : "+c.getFornecedorId()
			                          +"\tColaboradorId : "+c.getColaboradorId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
