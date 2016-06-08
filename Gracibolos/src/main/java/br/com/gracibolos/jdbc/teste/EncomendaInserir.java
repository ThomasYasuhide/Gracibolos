package br.com.gracibolos.jdbc.teste;


import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;
//import br.com.gracibolos.jdbc.model.Status;

//funcionando
public class EncomendaInserir {

	public static void main(String[] args) {
		
		Encomenda encomenda = null;
		Gerador g = new Gerador();
		EncomendaDao dao = null;
		
		//List<ItemEncomenda> listIe = null;
		//ItemEncomenda itemEncomenda = null;
		//Status status = new Status();
		
		for(int i=0;i<1;i++){
					encomenda = new Encomenda();
			//------cliente---------------------------------------							
					encomenda.setClienteid(g.ranIdInt(g.IdsCli()));
					encomenda.setClienteid(356);
			//------status----------------------------------------
					//encomenda.setStatus(g.randBetween(1, 5));//vai de 1 - 5
					//encomenda.setStatus(g.randBetween(3, 4));//Em aberto
					//encomenda.setStatus(2);//cancelado
					encomenda.setStatus(1);//finalizado
			//------data encomenda--------------------------------	
					encomenda.setDataencomenda(g.generateDate());
			//------data entrega----------------------------------
					encomenda.setDataentrega(g.generateDate());
					//encomenda.setDataentrega(null);
			//------responsável-----------------------------------
					encomenda.setResponsavel(g.responsavel());
			//------data faturamento------------------------------
					//encomenda.setDatafaturamento(g.generateDate());
					encomenda.setDatafaturamento(null);
			//------data produção---------------------------------
					//encomenda.setDataproducao(g.generateDate());
					encomenda.setDataproducao(null);
			//------data produção---------------------------------
					//encomenda.setDatafinalizado(g.generateDate());
					encomenda.setDatafinalizado(null);
			//------data finalizado-------------------------------
					//encomenda.setDatacancelamento(g.generateDate());
					//encomenda.setDatacancelamento(null);
			//------data cancelado--------------------------------
					//total = new BigDecimal(g.randBetween(8, 250));
					//encomenda.setTotalprodutos(null);
					encomenda.setObs("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");
					
//					listIe = new ArrayList<ItemEncomenda>();
//					//DE 1 À 4 ITENS 
//					for(int j=0;j<g.randBetween(1, 4);j++)
//					{
//						itemEncomenda = new ItemEncomenda();
//						itemEncomenda.setProdutoId(g.ranIdLong(g.idsProduto()));
//						//Sem o id da encomenda - no ResultSet eu pego o retorno da chave  gerada
//						//itemEncomenda.setEncomendaId(g.ranIdLong(g.IdsEnc()));
//						itemEncomenda.setQuantidade(g.randBetween(1, 10));		
//						listIe.add(itemEncomenda);
//					}
//					encomenda.setListItemEncomenda(listIe);
					
					dao = new EncomendaDao();
					try {
						if(dao.inserir(encomenda)){
							System.out.println("inserido com sucesso");
						}else{
							System.out.println("falha");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		}//Fim do for qtd de encomenda
		

	}

}
