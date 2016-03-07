package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaInserir {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
		BigDecimal big = new BigDecimal(30);
		byte[] foto = new byte[12];
		
		mp.setMarca("Nestle");
		mp.setTipo("A");
		mp.setQtd(big);
		mp.setDescricao("leite condensado");
		mp.setFoto(foto);
		
		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			if(dao.inserir(mp)== true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
