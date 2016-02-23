package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteInserir {

	public static void main(String[] args) {

		Suporte suporte = new Suporte();
		
		suporte.setCodigo("");
		suporte.setStatus("");
		suporte.setValor(null);
		suporte.setEncomendaId(1);
		suporte.setFornecedorId(1);
		
		SuporteDao dao = new SuporteDao();
		
		try {
			if(dao.inserir(suporte) == true){
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
