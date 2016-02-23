package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.MedidaDao;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaInserir {

	public static void main(String[] args) {
		
		Medida medida = new Medida();
		
		medida.setIngrediente("");
		medida.setMedida("");
		medida.setGramas(null);
		medida.setLitros(null);
		
		MedidaDao dao = new MedidaDao();
		
		try {
			if(dao.inserir(medida) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
