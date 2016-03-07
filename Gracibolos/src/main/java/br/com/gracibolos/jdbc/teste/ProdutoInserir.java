package br.com.gracibolos.jdbc.teste;

//funcionando
//import java.math.BigDecimal;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoInserir {

	public static void main(String[] args) {

		Produto p1 = new Produto();
//		BigDecimal custo = new BigDecimal(15.69);
//		BigDecimal valor = new BigDecimal(25.00);
//		BigDecimal peso = new BigDecimal(4.00);		
//		byte [] foto = new  byte [ 100 ]; 
		
//		p1.setStatus(true);
//		p1.setTipo(2);
//		p1.setCodigo("82329af");
//		p1.setNome("FlorestaNegra");
//		p1.setCusto(custo);
//		p1.setValor(valor);
//		p1.setUnidade(5);
//		p1.setPeso(peso);
//		p1.setReceita("jaiojdiiofaojiofjaiojfoijjafo");
//		p1.setFoto(foto);
		
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
