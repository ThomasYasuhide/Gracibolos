package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.MedidaDao;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaInserir {

	public static void main(String[] args) {
		
		Medida medida = new Medida();
		BigDecimal gramas = new BigDecimal(457);
		BigDecimal litros = new BigDecimal(2);
		
		medida.setIngrediente("farinha");
		medida.setMedida("jarra");
		medida.setGramas(gramas);
		medida.setLitros(litros);
		
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
