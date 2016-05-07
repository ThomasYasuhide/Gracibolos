package br.com.gracibolos.jdbc.teste;


import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.Fornecedor;

public class GeradorCaixa {

	private static Random ran;
	private static FornecedorDao daoForn;
	private static Fornecedor f;
	private static EncomendaDao daoEnc;
	private static Encomenda e;
	
	public GeradorCaixa() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		int[] idsForn = IdsForn();// Carregar os ids dos fornecedores
		Long[] idsEnc = IdsEnc();
		
		System.out.println("encomendaId : "+ ranIdLong(idsEnc));
		System.out.println("fornecedorId : "+ ranIdInt(idsForn));
		System.out.println("valor : "+ randBetween(1, 1000)+",00");
		System.out.println("gastoRecebimento : ");
		System.out.println("forma : "+ ranForma());
		System.out.println("parcela : ");
		System.out.println("descrição : ");
		System.out.println("data : "+ sdf.format(generateDate()));		
		
	}
	*/
	
	//Gerador de id
	public int ranIdInt(int[] ids){
		int id=0;
		id = ids[ran.nextInt(ids.length)];
		return id;
	}
	
	//ids do fornecedor
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//id = ids[8];
		
		return ids;
	}
	
	//Gerador de id
	public Long ranIdLong(Long[] ids){
		Long id=0L;
		id = ids[ran.nextInt(ids.length)];
		return id;
	}
	
	//ids do encomenda
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
				//System.out.println(ids[j]);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//id = ids[8];
		
		return ids;
	}
	
	//Gerador de forma de pagamento
	public String ranForma(){
		String[] forma = {"dinheiro", "cheque", "débto", "crédito", "boleto"};
		ran = new Random();
		String eForma = forma[ran.nextInt(forma.length)];	
		return eForma;
	}
	
	// Gerador de datas
	public LocalDate generateDate(){
		
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
	    long days = ChronoUnit.DAYS.between(start, LocalDate.now());
	    LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
	    //System.out.println(randomDate);
	    
        return randomDate;
	}
	
	//gerador de nureos incial e final 
	public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
}
