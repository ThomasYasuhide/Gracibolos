package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaExcluir {

	public static void main(String[] args) {
		
		CaixaDao dao = new CaixaDao();
		Caixa caixa = new Caixa();
		caixa.setId(1);
		
		try {
			if(dao.excluir(caixa) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao Excluido cliente");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
