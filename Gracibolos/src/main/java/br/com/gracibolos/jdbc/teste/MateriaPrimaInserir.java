package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaInserir {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
		
		mp.setMarca("");
		mp.setTipo("");
		mp.setQtd(null);
		mp.setDescricao("");
		mp.setFoto(null);
		
		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			if(dao.inserir(mp)== true){
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
