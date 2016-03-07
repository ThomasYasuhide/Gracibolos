package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteInserir {

	public static void main(String[] args) {

		Suporte suporte = new Suporte();
		BigDecimal valor = new BigDecimal(10.99);
		
		suporte.setFornecedorId(1);
		suporte.setEncomendaId(1);
		suporte.setCodigo("84948465");
		suporte.setStatus("ok");
		suporte.setValor(valor);		
		
		SuporteDao dao = new SuporteDao();
		
		try {
			if(dao.inserir(suporte) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
