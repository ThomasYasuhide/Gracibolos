package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;


/*funcionando em partes
 *falta fazer a conversão do valor e da foto
 */
public class ProdutoInserir {

	public static void main(String[] args) {

		Produto p1 = new Produto();
		
		
		p1.setTipoProdutoNome("A");
		p1.setNome("Cobertura");
		p1.setValor(null);
		p1.setReceita("teste");
		p1.setFoto(null);
		
		ProdutoDao dao = new ProdutoDao();
		
		try {
			if(dao.inserir(p1) == true){
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
