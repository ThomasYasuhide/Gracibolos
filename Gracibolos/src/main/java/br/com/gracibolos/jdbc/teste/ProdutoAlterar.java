package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

/*funcionando em partes
 *falta fazer a conversão do valor e da foto
 */

public class ProdutoAlterar {

	public static void main(String[] args) {
		
		Produto p1 = new Produto();
		
		p1.setId(3);
		p1.setTipoProdutoNome("B");
		p1.setNome("Cobertura");
		p1.setValor(null);
		p1.setReceita("teste2");
		p1.setFoto(null);
		
		ProdutoDao dao = new ProdutoDao();
		
		try {
			if(dao.alterar(p1) == true){
				System.out.println("alterado com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
