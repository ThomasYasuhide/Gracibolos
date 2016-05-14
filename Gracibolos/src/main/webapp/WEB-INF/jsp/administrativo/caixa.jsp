<!-- Define que este documento é uma pagina JSP -->
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Tag de importação JSTL, utilizado para fazer a repetição das tags HTML -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="PT-BR">
<head>

	<!-- Defenição dos arquivos meta -->
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Importação dos arquivos CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/reset.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/datatables.css" rel="stylesheet">

	<!-- Titulo da página -->
	<title>Graci Bolos | Caixa</title>

</head>

<body>

	<!-- Container com layout fluido, preenchendo maior parte da tela -->
	<div class="container-fluid fullheight">

		<!-- Cria uma linha para armazenar todo o conteudo -->
		<div class="row fullheight">
			
			<!-- Importação da barra de navegação Mobile e desktop -->
			<%@ include file="menu.jsp" %>
			
			<div class="content fullpage col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<div class="margin-top">

					<!-- ############################################################ CABEÇALHO ############################################################ -->
					<header>
						<h2 class="">CAIXA</h2>
						<h4 class="">Lista do caixa</h4>
					</header>

					<hr/>

					<!-- ############################################################ CONTEUDO ############################################################ -->


					<!-- ################################# ALERTAS ################################# -->
					<!-- Aqui as Expressions Languages recebem true caso a operação seja efetuado corretamente, caso de algum erro recebem false-->
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Transação armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir uma nova transação, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${alterar == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Alteração efetuada com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${alterar == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								 <strong>Erro!</strong> Houve algum erro ao tentar alterar a transação, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> transação foi excluida com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								 <strong>Erro!</strong> Houve algum erro ao tentar excluir a matéria-prima, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<!-- Essa div agrupa os campos de pesquisa e de listar as matérias-primas -->
					<div class="row">
					
<!-- ################################# PESQUISA ENTRE DATAS CAHMADA PARA A CONTROLLER administrativo-pesquisar-entre ################################# -->
					
						<form action="administrativo-pesquisar-entre" method="POST">
							<div class="input-margin col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<label class="control-label" for="datainicial">Data inicial*:</label>
								<input type="date" id="datainicial" class="form-control" placeholder="Informe a data inicial" name="datainicial" required>
							</div>
													
							<div class="input-margin col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<label class="control-label" for="datafinal">Data final*:</label>						
								<input type="date" id="datafinal" class="form-control" placeholder="Informe a data final" name="datafinal" required>
							</div>
							
							<div class="input-margin col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<label class="control-label" for="fabricacao">Pesquisar por data:</label>
								<button type="submit" class="btn btn-default fullwidth"><i class="material-icons">search</i>&nbsp;&nbsp;&nbsp;Pesquisar por período</button>
							</div>
						</form>
					</div>
					
<!-- ################################# FIM PESQUISA ENTRE DATAS CAHMADA PARA A CONTROLLER administrativo-pesquisar-entre ################################# -->
					
<!-- ############################################################ INICIO DA TABELA ############################################################ -->

					<!-- Essa div agrupa os títulos das tabelas, e os resultados das pesquisas -->
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-caixa" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>Data</th>
										<th>Recebido / Gasto</th>
										<th>Encomenda ID</th>
										<th>Fornecedor ID</th>
										<th>#</th>
										<th>Valor</th>									
										<th>Forma</th>
										<th>Parcela</th>										
										<th>Descrição</th>	
										<th>Nome Razão</th>									
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- 
										AQUI EU RECUPERO O OBJETO ENVIADO PELA CONTROLLER 
									-->
									<c:forEach var="caixa" items="${listCaixa}">
										<tr>
											<!-- 0 --><td>${caixa.data}</td>
											<!-- 1 --><td>${caixa.gastoRecebimento}</td>
											<!-- 2 --><td>${caixa.encomendaId}</td>
											<!-- 3 --><td>${caixa.fornecedorId}</td>
											<!-- 4 --><td>${caixa.id}</td>
											<!-- 5 --><td>${caixa.valor}</td>										
											<!-- 6 --><td>${caixa.forma}</td>
											<!-- 7 --><td>${caixa.parcela}</td>											
											<!-- 8 --><td>${caixa.descricao}</td>	
											<!-- 9 --><td>${caixa.nomeRazao}</td>	
																				
											
											<!-- Aqui nessa td, estão os botões de editar e excluir, que aparecem junto com a lista de matérias-primas na tabela -->
		                					<td>
		                						<button id="edit-caixa" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-caixa" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<!--Essa div tem o botão de abrir o modal "incluir nova matéria-prima" -->
					<div class="row">					
						
						<div class="input-margin pull-right col-xs-12 col-sm-4 col-md-4">
							<a href="" id="incluir-caixa-modal" data-toggle="modal" data-target="#modal-caixa" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir nova saída</a>
						</div>							
						
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
								<div class="row dashboard-box">
									<div class="col-xs-9">
										<h4>Saldo : ${saldo}</h4>
									</div>
									<div class="col-xs-3">
										<i class="material-icons pull-right dashboard-icon">done</i>
									</div>
								</div>
							</div>
						
				       
						
					</div>
					
<!-- 					 <div class="container"> -->
<!--   							<div class="panel panel-default col-sm-3 col-md-3"> -->
<%--     							<div class=""> Saldo : ${saldo} &nbsp;&nbsp; <i class="material-icons">done</i></div> --%>
<!--   							</div> -->
<!-- 						</div> -->
<!-- ############################################################ FIM DA TABELA ############################################################ -->
				</div>
			</div>
		</div>
	</div>
	
	<!--

############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DO CAIXA ####################################################

	-->
	<div class="modal fade" id="modal-caixa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    		
	    		<!-- formulário de preencher os dados da matéria-prima -->
	    		<form id="caixa-form" method="POST">
	    			
	    			<!--Essa div tem o título e subtítulo do modal, e o "X" de fechar o modal   -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">CAIXA</h3>
						<h4 id="modal-subtitle"></h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<!-- ################################# Corpo do modal CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control"  />
								</div>																	
								
								<!-- 
									gasto = 0
									recebimento = 1
								 -->
								<div class="hidden">
									<label class="control-label" for="gastoRecebimento">Gasto/Recebimento*:</label>
									<select id="gastoRecebimento" name="gastoRecebimento" class="form-control" >
										<option selected value="0">Gasto</option>
										<option value="1">Recebimento</option>
									</select> 
								</div>
																
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="nomeRazao" >Fornecedor*:</label>
									<input type="text" name="nomeRazao" id="nomeRazao"  class="form-control" maxlength="100" />
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
 									<label class="control-label" for="encomendaId" >Encomenda*:</label>
 								<input type="text" name="encomendaId" id="encomendaId"  class="form-control" maxlength="100" />
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="valor">Valor*:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input type="text" id="valor" name="valor" placeholder="0,00" class="form-control" maxlength="14" required/>
									</div>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="forma">Forma de pagamento*:</label>
									<select class="form-control" id="forma" name="forma">										
										<option value="0" selected disabled>Selecione...</option>
										<option value="dinheiro">Dinheiro</option>
										<option value="crédito">Cartão de crédito</option>
										<option value="débto">Cartão de débito</option>
										<option value="cheque">Cheque</option>
										<option value="boleto">Boleto</option>
									</select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="parcela">Número de Parcelas:</label>
									<input id="parcela" name="parcela" type="number" class="form-control" pattern="[0-9]+" maxlength="1" >
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="data">Data da transação:</label>
									<input type="date" id="data" name="data" class="form-control"  />
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="fornecedorId" id="lbl_fornecedorId">Fornecedor id:</label>
									<input type="text" name="fornecedorId" id="fornecedorId"  class="form-control" maxlength="100" placeholder=""/>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="descricao">Descrição:</label>
									<textarea class="form-control" rows="3" name="descricao" id="descricao" ></textarea>
								</div>
								
							</div>
						</div>
					</div>

					<!-- ################################# FIM DO CONTEUDO ################################# -->
					
					<!-- Esse div contem o 2 botões -->
					<div class="modal-footer">
						<!-- botão de fechar o modal  -->
						<button type="button" id="fecharModal" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
						<!-- botão de incluir ou alterar a matéria-prima, assim finalizando o formulário  -->
						<button type="submit" class="btn btn-default" id="modal-action"></button>
					</div>
					
				</form>
			</div>
		</div>
	</div>

	<!--

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DO CAIXA #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DO CAIXA      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de matéria-prima -->
	<div class="modal fade" id="excluir-caixa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- Envia o form para a url abaixo  -->
				<form id="caixa-delete-form" action="administrativo-excluir-caixa" method="POST">
					
					<!--Essa div tem o título do modal, e o "X" de fechar o modal   -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir caixa</h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<!-- Essa div contem o id do caixa q vai ser excluido, porem ele fica escondido na tela, por causa da class hidden-->
								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>
								<!-- mensagem no corpo do modal -->	
								<p>Deseja realmente excluir o caixa selecionada?</p>
							</div>
						</div>

						
					</div>
					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar a exclusão da matéria-prima-->
						<button type="button" class="btn btn-default" data-dismiss="modal">Não, quero manter</button>
						<!-- botão de confirmar a exclusão da matéria-prima -->
						<button type="submit" class="btn btn-default">Sim, quero excluir</button>
					</div>

				</form>
			</div>
		</div>
	</div>


	<!--

	############################################################ FIM DO  MODAL DE EXCLUSÃO DO CAIXA ############################################################

	-->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>	
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/bootstrap.js"></script>
    

	<script type="text/javascript">

		$(document).ready(function() {
			
			//Remove as mascaras quando apertar o submit
			$("#caixa-form").submit(function() {
				$("#valor").unmask();
				
			});

			/*
			*
			* INDICADOR DE PAGINA DO MENU
			*
			*/
			
			$('#menu-mob-caixa').addClass('active');
			$('#menu-caixa').addClass('active');
			
			/*
			*
			* Define os campos que receberam as mascaras.
			*
			*/
			
			//$("#valor").mask("000.000.000.000.000,00", {reverse: true});

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*	id da tabela lista-caixa
			*/
			
			//INVISIVEIS - Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-caixa').DataTable({
                "columnDefs": [
                    {                   	
                        
                     /* //0 - data
                     	//1 - gastoRecebimento
                        //2 - encomendaId
                        //3 - fornecedorId
                        //4 - id
                        //5 - valor
                        //6 - forma
                        //7 - parcela                        
                        //8 - descricao 
                        //9 - nomeRazao  */ 
                        "targets": [ 1, 2, 3, 4, 6, 7, 8, 9 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE NOVO GASTO
			*
			*/
			
			//quando o usuário clica no botão de incluir novo gasto, ele abre o modal e chama essa função
            $('#incluir-caixa-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo gasto");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#caixa-form").attr("action","administrativo-incluir-caixa");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir gasto');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#caixa-form').each(function(){
					this.reset();
				});
				
				var now = moment().format('YYYY-MM-DD');
                $('#data_transacao').val(now);               

				//Este método se encontra no arquivo scripts.js
                // DESABILITA O CAMPO
                desabilitarCampos(document.getElementById("#gastoRecebimento"));

              //Limpo os campos ao fechar - relacionado a visibilidade dos campos
				$("#caixa-form").click(function(){
					//objeto javascript
	            	mfornecedorId.value="";           		
	           		mnomeRazao.value="";
	             	mencomendaId.value="";    
				});
				
			});

            /*
			*
			* ALTERAÇÃO DO CAIXA
			*
			*/

 //Define uma ação na linha da tabela ao apertar o botão editar.----------------------------------------------------------------
            
            $('#lista-caixa tbody').on( 'click', '#edit-caixa', function () {            	
            	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar pagamento");
            	
            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#caixa-form").attr("action","administrativo-alterar-caixa");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

              	//Apresenta o modal de exclusão na tela.
              	$('#modal-caixa').modal('show');
					
				//Pega os valores que estão na tabela e passa para o modal.			
				$('#data').val(data[0]);
				$('#id').val(data[4]);
				$('#valor').val(data[5]);
				$('#forma').val(data[6]);
				$('#parcela').val(data[7]);				
				$('#descricao').val(data[8]);
          		$('#fornecedorId').val(data[3]);
          		$('#nomeRazao').val(data[9]);
          		$('#encomendaId').val(data[2]);
				
//---------------visibilidade-----------------------------------------------------------------
				//Atribuo os objetos para utilizar no bloqueio
				var mfornecedorId = document.getElementById("fornecedorId");
				var mencomendaId = document.getElementById("encomendaId");
				var mnomeRazao = document.getElementById("nomeRazao");
				
				//Se for recebimento
              	if(data[1] == 1){
                 	//console.log(data[1]);
                 	//Bloqueio o fornecedorId e o nomeRazao	e ativo encomenda	
                 	//mencomendaId.style.visibility="visible";			
             		mencomendaId.disabled = false;
             		//mfornecedorId.style.visibility="hidden";
  					mfornecedorId.disabled = true;
  					//mnomeRazao.style.visibility="hidden";
  		   			mnomeRazao.disabled = true;
              		//Coloca os valores na encomendaId
        			
        		}
        		//Se for gasto
        		if(data[1] == 0){
        			//console.log(data[1]);
        			//Boloqueio encomendaId e ativo fornecedor e nomeRzao  
        			//mfornecedorId.style.visibility="visible";     			              		
            		mfornecedorId.disabled = false;
            		//mnomeRazao.style.visibility="visible";	           		
               		mnomeRazao.disabled = false;
               		//mencomendaId.style.visibility="hidden";
                 	mencomendaId.disabled = true;
                                 
                	//console.log("fornecedor "+mfornecedorId.disabled);
           			//onsole.log("encomenda "+mencomendaId.disabled);
           			//console.log("nomeRazao "+mnomeRazao.disabled);
           	              		
                }
//---------------FIM - visibilidade-----------------------------------------------------------------             
              	
          		
            });
//FIM - Define uma ação na linha da tabela ao apertar o botão editar.----------------------------------------------------------------

			/*
			*
			* EXCLUSÃO DO CAIXA
			*
			*/
	
			//Define uma ação na linha da tabela ao apertar o botão delete.
			
            $('#lista-caixa tbody').on( 'click', '#delete-caixa', function () {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-caixa').modal('show');

            });

            
	
        });

	</script>
	
	
</body>
</html>