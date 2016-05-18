package br.com.gracibolos.jdbc.teste;


import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Cliente;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.Fornecedor;
import br.com.gracibolos.jdbc.model.Produto;

public class Gerador {
	
	private static Random ran = null;
	private static FornecedorDao daoForn = null;
	private static Fornecedor f = null;
	private static EncomendaDao daoEnc = null;
	private static Encomenda e = null;
	private static ClienteDao daoCli = null;
	private static Cliente c = null;
	private static ProdutoDao daoPro = null;
	private static Produto p = null;
	
	//EXEMPLO PARA GERAR UM ID DA LSTA DE PRODUTOS
	//System.out.println(ranIdLong(idsProduto()));
	
	
	//Gerador de id int---------------------------------------------------------
	public int ranIdInt(int[] ids){
		int id=0;
		id = ids[ran.nextInt(ids.length)];
		return id;
	}
	
	//ids do clientes-----------------------------------------------------------
	public int[] IdsCli(){	
		ran = new Random();
		int i=0;
		int[] ids = null;
		try {
			daoCli = new ClienteDao();
			i = daoCli.listar().size();
			ids = new int[i];
				
			for(int j=0;j<i;j++){
				c = new Cliente();
				c = daoCli.listar().get(j);
				ids[j] = c.getId();
				//System.out.println(ids[j]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return ids;
	}
	
	//ids do fornecedor----------------------------------------------------------
	public int[] IdsForn(){	
		ran = new Random();
		int i=0;
		int[] ids = null;
		try {
			daoForn = new FornecedorDao();
			i = daoForn.listar().size();
			ids = new int[i];
				
			for(int j=0;j<i;j++){
				f = new Fornecedor();
				f = daoForn.listar().get(j);
				ids[j] = f.getId();
				//System.out.println(ids[j]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	//Gerador de id Long-------------------------------------------------------------
	public Long ranIdLong(Long[] ids){
		Long id=0L;
		id = ids[ran.nextInt(ids.length)];
		return id;
	}
	
	//produto-------------------------------------------------------------------------
	public Long[] idsProduto(){
		ran = new Random();
		int i=0;
		Long[] ids = null;
		try {
			daoPro = new ProdutoDao();
			i = daoPro.listar().size();
			ids = new Long[i];
				
			for(int j=0;j<i;j++){
				p = new Produto();
				p = daoPro.listar().get(j);
				ids[j] = p.getId();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	//ids da encomenda---------------------------------------------------------------------
	public Long[] IdsEnc(){	
		ran = new Random();
		int i=0;
		Long[] ids = null;
		try {
			daoEnc = new EncomendaDao();
			i = daoEnc.listar().size();
			ids = new Long[i];
				
			for(int j=0;j<i;j++){
				e = new Encomenda();
				e = daoEnc.listar().get(j);
				ids[j] = e.getId();
				//System.out.println("N° Encom. : "+ids[j]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	//Gerador de nomes aleátorios a partir do cliente----------------------------------------
	public String responsavel()
	{
		daoCli = new ClienteDao();
		String[] nomes = null;
		String nomeAle ="";
		int i = 0;
		ran = new Random();
		int j=0;
		try {			
			i = daoCli.listar().size();	
			nomes = new String[i];
			for(Cliente c : daoCli.listar()){
				nomes[j] = c.getNomerazao();
				j++;
			}
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		nomeAle = nomes[ran.nextInt(nomes.length)];
		return nomeAle;
	}
	
	//Gerador de forma de pagamento--------------------------------------------------------
	public String ranForma(){
		String[] forma = {"dinheiro", "cheque", "débto", "crédito", "boleto"};
		ran = new Random();
		String eForma = forma[ran.nextInt(forma.length)];	
		return eForma;
	}
	
	// Gerador de datas---------------------------------------------------------------------
	public LocalDate generateDate(){
		//Data inicial e final
		LocalDate start = LocalDate.of(2014, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2016, Month.JUNE, 21);
		
	    long days = ChronoUnit.DAYS.between(start, end);
	    LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
	    //System.out.println(randomDate);
	    
        return randomDate;
	}
	
	//gerador de nureos incial e final ------------------------------------------------------
	public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
}
