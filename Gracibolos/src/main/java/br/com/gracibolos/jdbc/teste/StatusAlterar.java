package br.com.gracibolos.jdbc.teste;

//testar
import br.com.gracibolos.jdbc.dao.StatusDao;
import br.com.gracibolos.jdbc.model.Status;

public class StatusAlterar {

	public static void main(String[] args) {

		Status status = new Status();
		
		status.setId(3L);
		status.setNome("");
		
		StatusDao dao = new StatusDao();
		
		try {
			if(dao.alterar(status) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
