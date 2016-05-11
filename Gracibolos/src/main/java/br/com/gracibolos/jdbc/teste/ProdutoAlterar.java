package br.com.gracibolos.jdbc.teste;

//funcionando
import java.math.BigDecimal;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

public class ProdutoAlterar {

	public static void main(String[] args) {
		
		Produto p1 = new Produto();
		BigDecimal custo = new BigDecimal(0);
		BigDecimal valor = new BigDecimal(32.00);
		//BigDecimal peso = new BigDecimal(4.00);	
		
		p1.setId(1L);
		p1.setFoto("a-melhor-torta-de-morango-e-creme-3.jpg");
		p1.setStatus(1);
		p1.setTipo(1);
		p1.setCodigo("morango");
		p1.setNome("Torta de morango");
		p1.setCusto(null);
		p1.setValor(valor);
		p1.setUnidade(null);
		p1.setPeso(null);
		p1.setEstoque(0);
		p1.setObs("Teste de observação Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.");
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
