package br.com.gracibolos.jdbc.teste;

//funcionando
import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteExcluir {

	public static void main(String[] args) {

		Suporte suporte = new Suporte();
		suporte.setId(2L);
		
		SuporteDao dao = new SuporteDao();
		
		try {
			if(dao.excluir(suporte) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluido suporte");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
