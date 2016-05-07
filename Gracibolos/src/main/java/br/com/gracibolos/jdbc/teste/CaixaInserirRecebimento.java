package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

//funcionando
public class CaixaInserirRecebimento {

	public static void main(String[] args) 
	{
		CaixaDao dao = new CaixaDao();
		Gerador gc = new Gerador();
		Caixa c = null;
		Long[] idsEnc = gc.IdsEnc();
		//int[] idsForn = gc.IdsForn();
		int i;
		int qtd = 400;
		//
		for(i=0; i<qtd;i++)
		{	
			c = new Caixa();
			//encomendaId
			Long id = gc.ranIdLong(idsEnc);
			c.setEncomendaId(id);
			//fornecedorId
			c.setFornecedorId(null);
			//valor
			BigDecimal valor = new BigDecimal(gc.randBetween(1, 100));
			c.setValor(valor);
			//gastoRecebimento
			//gasto = 0, recebimento = 1
			c.setGastoRecebimento(1);
			//forma
			c.setForma(gc.ranForma());
			//parcela
			c.setParcela(1);
			//descricao
			c.setDescricao(null);
			//data
			c.setData(gc.generateDate());
			try {
				if(dao.inserir(c) == true){
				}
				else{
					System.out.println("falha");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		//fim for	
		}		
		System.out.println("inserido com sucesso : "+ i +": registros");	
	}

}
