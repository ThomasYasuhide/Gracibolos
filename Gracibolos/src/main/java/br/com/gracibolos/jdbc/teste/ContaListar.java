package br.com.gracibolos.jdbc.teste;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Conta@a8ceb6..) não sei pq
import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaListar {

	public static void main(String[] args) {

		ContaDao dao = new ContaDao();
		
		try {
			for(Conta c : dao.listar()){
			    System.out.println(	  				"Id : "+c.getId()
									   +"\tFornecedorId : "+c.getFornecedorId()
							          +"\tColaboradorId : "+c.getColaboradorId()                
									  		+"\tCaixaId : "+c.getCaixaId()
			    							 + "\tCodigo: "+c.getCodigo()
			    					  +"\tDataVencimento: "+c.getDataVencimento()
			    					  +"\tDataPagamento : "+c.getDataPagamento()
			    					  		   +"\tValor: "+c.getValor());
			    					   
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
