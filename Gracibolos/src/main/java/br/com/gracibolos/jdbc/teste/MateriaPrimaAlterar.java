package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaAlterar {

	public static void main(String[] args) {

MateriaPrima mp = new MateriaPrima();
		
		mp.setId(2);
		mp.setMarca("");
		mp.setTipo("");
		mp.setQtd(null);
		mp.setDescricao("");
		mp.setFoto(null);
		
		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			if(dao.alterar(mp) == true){
				System.out.println("alterado com sucesso!");
			}else{
				System.out.println("Não foi possivel alterar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
