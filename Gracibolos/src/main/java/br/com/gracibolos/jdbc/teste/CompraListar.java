package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CompraDao;
import br.com.gracibolos.jdbc.model.Compra;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Compra@a8ceb6) não sei pq
public class CompraListar {

	public static void main(String[] args) {

		CompraDao dao = new CompraDao();

		try {
			for(Compra c : dao.listar()){
			    System.out.println(	  "		 Id : "+c.getId()
							   +"\tFornecedorId : "+c.getFornecedorId()
				                 +"\tStatusNome : "+c.getStatusNome()
			    					  + "\tTipo : "+c.getTipo()
			                         +"\tNumero : "+c.getNumero()
			                           +"\tData : "+c.getData()
			                           +"\tTotal: "+c.getTotal());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
