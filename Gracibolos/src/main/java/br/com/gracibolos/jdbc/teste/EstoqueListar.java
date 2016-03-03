package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
import br.com.gracibolos.jdbc.model.Estoque;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Estoque@a8ceb6..) não sei pq
public class EstoqueListar {

	public static void main(String[] args) {

		EstoqueDao dao = new EstoqueDao();
		
		try {
			for(Estoque e : dao.listar()){
				
				System.out.println(	  
									"Id : "+e.getId()
				    + "\tMateriaPrimaId : "+e.getMateriaPrimaId()
						  + "\tMedidaId : "+e.getMedidaId()
						  + "\tCompraId : "+e.getCompraId()
							   + "\tQtd : "+e.getQtd()
						 + "\tPrecoUnit : "+e.getPrecoUnit()
							  + "\tVenc : "+e.getVenc()
							 + "\tTotal : "+e.getTotal());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
