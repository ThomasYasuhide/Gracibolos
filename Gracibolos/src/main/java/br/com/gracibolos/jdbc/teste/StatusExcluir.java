package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.StatusDao;
import br.com.gracibolos.jdbc.model.Status;

public class StatusExcluir {

	public static void main(String[] args) {

		Status status = new Status();
		status.setId(3);
		
		StatusDao dao = new StatusDao();
		
		try {
			if(dao.excluir(status) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluir o status");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
