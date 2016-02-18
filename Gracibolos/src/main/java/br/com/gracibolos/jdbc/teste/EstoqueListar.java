package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
import br.com.gracibolos.jdbc.model.Estoque;

public class EstoqueListar {

	public static void main(String[] args) {

		EstoqueDao dao = new EstoqueDao();
		
		try {
			for(Estoque e : dao.listar()){
				
				System.out.println(	  
									"Id : "+e.getId()
								+ "\tQtd: "+e.getQtd()
						 + "\tPrecoUnit : "+e.getPrecoUnit()
							  + "\tVenc : "+e.getVenc()
							 + "\tTotal : "+e.getTotal()
						  + "\tCompraId : "+e.getCompraId()
					+ "\tMateriaPrimaId : "+e.getMateriaPrimaId()
						  + "\tMedidaId : "+e.getMedidaId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
