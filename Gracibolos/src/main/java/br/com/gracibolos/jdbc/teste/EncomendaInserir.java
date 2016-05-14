package br.com.gracibolos.jdbc.teste;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;

//funcionando
public class EncomendaInserir {

	public static void main(String[] args) {
		
		Encomenda encomenda;
		Gerador g = new Gerador();
		EncomendaDao dao = new EncomendaDao();
		
		for(int i=0;i<50;i++){
					encomenda = new Encomenda();
			//------cliente---------------------------------------		
					int[] ids = g.IdsCli();
					int idCli;
					idCli = g.ranIdInt(ids);
					encomenda.setClienteid(idCli);
			//------status----------------------------------------
					encomenda.setStatus(g.randBetween(1, 5));//vai de 1 - 5
			//------data encomenda--------------------------------	
					encomenda.setDataencomenda(g.generateDate());
			//------data entrega----------------------------------
					encomenda.setDataentrega(g.generateDate());
			//------responsável-----------------------------------
					encomenda.setResponsavel(g.responsavel());
			//------data faturamento------------------------------
					encomenda.setDatafaturamento(g.generateDate());
			//------data produção---------------------------------
					encomenda.setDataproducao(g.generateDate());
			//------data produção---------------------------------
					encomenda.setDatafinalizado(g.generateDate());
			//------data finalizado-------------------------------
					encomenda.setDatacancelamento(g.generateDate());
			//------data cancelado--------------------------------
					//total = new BigDecimal(g.randBetween(8, 250));
					encomenda.setTotalprodutos(null);
					encomenda.setObs("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
						
					try {
						if(dao.inserir(encomenda) == true){
							System.out.println("inserido com sucesso");
						}else{
							System.out.println("falha");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		}//Fim do for
		

	}

}
