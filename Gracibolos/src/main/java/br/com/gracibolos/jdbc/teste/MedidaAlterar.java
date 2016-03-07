package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.MedidaDao;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaAlterar {

	public static void main(String[] args) {
		
		Medida medida = new Medida();
		BigDecimal gramas = new BigDecimal(222);
		BigDecimal litros = new BigDecimal(1);
		
		medida.setId(1L);
		medida.setIngrediente("farinha");
		medida.setMedida("jarra");
		medida.setGramas(gramas);
		medida.setLitros(litros);
		
		MedidaDao dao = new MedidaDao();
		
		try {
			if(dao.alterar(medida) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
