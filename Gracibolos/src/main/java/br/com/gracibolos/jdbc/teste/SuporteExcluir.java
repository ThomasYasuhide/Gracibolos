package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteExcluir {

	public static void main(String[] args) {

		Suporte suporte = new Suporte();
		suporte.setId(3);
		
		SuporteDao dao = new SuporteDao();
		
		try {
			if(dao.excluir(suporte) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluido suporte");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
