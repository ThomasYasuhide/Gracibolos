package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoAlterar {

	public static void main(String[] args) {
		
		Produto p1 = new Produto();
		BigDecimal custo = new BigDecimal(25.69);
		BigDecimal valor = new BigDecimal(32.00);
		//BigDecimal peso = new BigDecimal(4.00);	
		
		p1.setId(1L);
		p1.setStatus(1);
		p1.setTipo(3L);
		p1.setCodigo("sdafaf5");
		p1.setNome("FlorestaNegra");
		p1.setCusto(custo);
		p1.setValor(valor);
		p1.setUnidade(5L);
		//p1.setPeso(peso);
		//p1.setReceita("adsfgahakj d9aja0fdja9");
		
		
		ProdutoDao dao = new ProdutoDao();
		
		try {
			if(dao.alterar(p1) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
