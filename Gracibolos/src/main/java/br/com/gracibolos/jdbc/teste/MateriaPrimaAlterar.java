package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaAlterar {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
		BigDecimal big = new BigDecimal(25);
		byte[] foto = new byte[12];
		
		mp.setId(1L);
		mp.setMarca("Nestle");
		mp.setTipo("B");
		mp.setQtd(big);
		mp.setDescricao("chocolate");
		mp.setFoto(foto);
		
		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			if(dao.alterar(mp) == true){
				System.out.println("alterado com sucesso!");
			}else{
				System.out.println("Não foi possivel alterar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
