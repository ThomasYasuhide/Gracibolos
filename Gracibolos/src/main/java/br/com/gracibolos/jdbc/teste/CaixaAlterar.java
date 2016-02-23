package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//não funcionando
public class CaixaAlterar {

	public static void main(String[] args) {
		
		Caixa c = new Caixa();
		
		c.setId(1);
		c.setEncomendaId(null);
		c.setValor(null);
		c.setGasto(true);
		c.setRecebimento(true);
		c.setForma("quadrada");
		c.setDescricao("testee");
		
		CaixaDao dao = new CaixaDao();
		
		try {
			if(dao.alterar(c) == true){
				
				System.out.println("Alterado com sucesso");
			}
			else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
