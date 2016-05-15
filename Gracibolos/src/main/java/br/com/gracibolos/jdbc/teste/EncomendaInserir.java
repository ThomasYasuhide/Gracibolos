package br.com.gracibolos.jdbc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.ItemEncomenda;

//funcionando
public class EncomendaInserir {

	public static void main(String[] args) {
		
		Encomenda encomenda;
		Gerador g = new Gerador();
		EncomendaDao dao = new EncomendaDao();
		List<ItemEncomenda> listIe = new ArrayList<ItemEncomenda>();
		ItemEncomenda itemEncomenda = null;
		
		for(int i=0;i<1;i++){
					encomenda = new Encomenda();
			//------cliente---------------------------------------							
					encomenda.setClienteid(g.ranIdInt(g.IdsCli()));
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
					
					
					for(int j=0;j<4;j++){
						itemEncomenda = new ItemEncomenda();
						itemEncomenda.setProdutoId(g.ranIdLong(g.idsProduto()));
						//Sem o id da encomenda - no ResultSet eu pego o retorno da chave  gerada
						//itemEncomenda.setEncomendaId(g.ranIdLong(g.IdsEnc()));
						itemEncomenda.setQuantidade(g.randBetween(1, 10));		
						listIe.add(itemEncomenda);
					}
					encomenda.setListItemEncomenda(listIe);
					
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
