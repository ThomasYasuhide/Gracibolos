package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaExcluir {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
		
		mp.setId(2);
		
		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			if(dao.excluir(mp) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluir materia prima");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
