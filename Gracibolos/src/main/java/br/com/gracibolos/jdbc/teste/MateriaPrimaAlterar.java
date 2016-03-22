package br.com.gracibolos.jdbc.teste;

//funcionando
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaAlterar {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
		
		mp.setId(1L);
		mp.setNome("Nestle");
		mp.setEstoque(21.93);
		mp.setUnidade(3L);
		mp.setFabricacao(LocalDate.now());
		mp.setVencimento(LocalDate.now());
		mp.setDescricao("leite condensado");
		
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
