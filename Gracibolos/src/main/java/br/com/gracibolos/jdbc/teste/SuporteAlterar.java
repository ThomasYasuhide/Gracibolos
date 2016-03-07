package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.SuporteDao;
import br.com.gracibolos.jdbc.model.Suporte;

public class SuporteAlterar {

	public static void main(String[] args) {
		
		Suporte suporte = new Suporte();
		BigDecimal valor = new BigDecimal(13.99);
		
		suporte.setId(1L);
		suporte.setFornecedorId(1);
		suporte.setEncomendaId(1);
		suporte.setCodigo("2342423");
		suporte.setStatus("ok");
		suporte.setValor(valor);		
		
		SuporteDao dao = new SuporteDao();
		
		try {
			if(dao.alterar(suporte) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

}
