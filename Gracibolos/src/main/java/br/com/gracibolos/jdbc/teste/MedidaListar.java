package br.com.gracibolos.jdbc.teste;

//funcionando, porem está listando (br.com.gracibolos.jdbc.model.Medida@a8ceb6..) não sei pq
import br.com.gracibolos.jdbc.dao.MedidaDao;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaListar {

	public static void main(String[] args) {
		
		MedidaDao dao = new MedidaDao();
		
		try {
			for(Medida p : dao.listar()){
			    System.out.println(	 		   "Id : "+p.getId()
			    					+"\tIngrediente: "+p.getIngrediente()
			                            +"\tMedida : "+p.getMedida()
			                            +"\tGramas : "+p.getGramas()
			                            +"\tLitros : "+p.getLitros());			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}