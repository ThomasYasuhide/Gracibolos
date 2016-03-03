package br.com.gracibolos.jdbc.teste;

//testar
import br.com.gracibolos.jdbc.dao.StatusDao;
import br.com.gracibolos.jdbc.model.Status;

public class StatusInserir {

	public static void main(String[] args) {
		
		Status status = new Status();
		
		status.setNome("teste");
		
		StatusDao dao = new StatusDao();
		
		try {
			if(dao.inserir(status) == true){
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
