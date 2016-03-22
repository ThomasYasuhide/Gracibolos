package br.com.gracibolos.jdbc.teste;

//funcionando
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaInserir {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
				
		mp.setNome("Nestle");
		mp.setEstoque(23.0);
		mp.setUnidade(1L);
		mp.setFabricacao(LocalDate.now());
		mp.setVencimento(LocalDate.now());
		mp.setDescricao("leite condensado");
		
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
