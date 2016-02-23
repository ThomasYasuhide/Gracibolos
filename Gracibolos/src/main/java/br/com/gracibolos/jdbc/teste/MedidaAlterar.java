package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.MedidaDao;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaAlterar {

	public static void main(String[] args) {
		
		Medida medida = new Medida();
		
		medida.setId(3);
		medida.setIngrediente("");
		medida.setMedida("");
		medida.setGramas(null);
		medida.setLitros(null);
		
		MedidaDao dao = new MedidaDao();
		
		try {
			if(dao.alterar(medida) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
