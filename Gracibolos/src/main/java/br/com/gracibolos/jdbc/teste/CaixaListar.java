package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Caixa@1c6c3b2..) não sei pq
public class CaixaListar {

	public static void main(String[] args) {
		
		CaixaDao dao = new CaixaDao();
		
		try {
			for(Caixa c : dao.listar()){
			    System.out.println(	     		 "Id : "+c.getId()
			    					 + "\tEncomendaId: "+c.getEncomendaId()
			                        		+"\tValor: "+c.getValor()
			                        		+"\tGasto: "+c.getGasto()
			                         +"\tRecebimento : "+c.getRecebimento()
			                               +"\tForma : "+c.getForma()
			                           +"\tDescrição :"+c.getDescricao());		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
