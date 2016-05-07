package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

public class CaixaInserirGasto {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CaixaDao dao = new CaixaDao();
		Gerador gc = new Gerador();
		Caixa c = null;
		//Long[] idsEnc = gc.IdsEnc();
		int[] idsForn = gc.IdsForn();
		int i;
		int qtd = 250;
		//
		for(i=0; i<qtd;i++)
		{	
			c = new Caixa();
			//encomendaId
			//Long idEnc = gc.ranIdLong(idsEnc);
			c.setEncomendaId(null);
			//fornecedorId
			int idForn = gc.ranIdInt(idsForn);
			c.setFornecedorId(idForn);
			//valor
			BigDecimal valor = new BigDecimal(gc.randBetween(1, 1000));
			c.setValor(valor);
			//gastoRecebimento
			//gasto = 0, recebimento = 1
			c.setGastoRecebimento(0);
			//forma
			c.setForma(gc.ranForma());
			//parcela
			c.setParcela(null);
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


