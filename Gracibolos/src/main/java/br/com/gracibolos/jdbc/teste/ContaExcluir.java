package br.com.gracibolos.jdbc.teste;

//funcionando
import br.com.gracibolos.jdbc.dao.ContaDao;
import br.com.gracibolos.jdbc.model.Conta;

public class ContaExcluir {

	public static void main(String[] args) {

		ContaDao dao = new ContaDao();
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		try {
			if(dao.excluir(conta) == true){
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
