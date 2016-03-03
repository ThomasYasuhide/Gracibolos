package br.com.gracibolos.jdbc.teste;

//funcionando
import br.com.gracibolos.jdbc.dao.MedidaDao;
import br.com.gracibolos.jdbc.model.Medida;

public class MedidaExcluir {

	public static void main(String[] args) {

		Medida medida = new Medida();
		
		medida.setId(2L);
		
		MedidaDao dao = new MedidaDao();
		
		try {
			if(dao.excluir(medida) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluir medida");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
