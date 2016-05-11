package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

//funcionando
//import java.math.BigDecimal;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoInserir {

	public static void main(String[] args) {

		Produto p1 = new Produto();
		BigDecimal custo = new BigDecimal(15.69);
		BigDecimal valor = new BigDecimal(25.00);
		BigDecimal peso = new BigDecimal(4.00);		
		//byte [] foto = new  byte [ 100 ]; 
	
		p1.setStatus(1);
		p1.setTipo(2);
		p1.setCodigo("cf");
		p1.setNome("Coxinha de frango");
		p1.setCusto(null);
		p1.setValor(valor);
		p1.setUnidade(null);
		p1.setPeso(null);
		p1.setEstoque(0);
		//p1.setReceita("jaiojdiiofaojiofjaiojfoijjafo");
		p1.setFoto(null);
		p1.setObs("o cento");
		
		ProdutoDao dao = new ProdutoDao();
		
		try {
			if(dao.inserir(p1) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
