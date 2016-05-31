<!-- Define que este documento é uma pagina JSP -->
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Tag de importação JSTL, utilizado para fazer a repetição das tags HTML -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



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
	<link href="resources/css/selectize.css" rel="stylesheet">
	
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
								 <strong>Erro!</strong> Houve algum erro ao tentar excluir a transação, favor tente novamente.
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
								<input value="${datainicial }" type="date" id="datainicial" class="form-control" placeholder="Informe a data inicial" name="datainicial" required>
							</div>
													
							<div class="input-margin col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<label class="control-label" for="datafinal">Data final*:</label>						
								<input value="${datafinal }" type="date" id="datafinal" class="form-control" placeholder="Informe a data final" name="datafinal" required>
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
										<th width="30%">Data Transação</th>
										<th width="30%">Tipo</th>
										<th width="30%">Valor</th>
										
										<th>#</th>
										<th>Data Transação</th>
										<th>Recebido / Gasto</th>
										<th>Fornecedor ID</th>
										<th>N° Encomenda</th>
										<th>Valor</th>
										<th>Saldo</th>
										<th>Forma</th>
										<th>Parcela</th>
										<th>Data Operação</th>
										<th>Descrição</th>
										<th>Nome</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- 
										AQUI EU RECUPERO O OBJETO ENVIADO PELA CONTROLLER 
									-->
									<c:forEach var="caixa" items="${listCaixa}">
										<tr>
											<fmt:parseDate value="${caixa.dataTransacao}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
											
											<!-- 00 --><td><fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}" type="date"/></td>
											<!-- 01 --><td>
														<c:if test="${caixa.gastoRecebimento == 0}">Gasto</c:if>
														<c:if test="${caixa.gastoRecebimento == 1}">Recebimento</c:if>
													  </td>
											<!-- 02 --><td>R$ ${caixa.valor}</td>
											<!-- 03 --><td>${caixa.id}</td>
											<!-- 04 --><td>${caixa.dataTransacao}</td>
											<!-- 05 --><td>${caixa.gastoRecebimento}</td>
											<!-- 06 --><td>${caixa.fornecedorId}</td>
											<!-- 07 --><td>${caixa.encomendaId}</td>
											<!-- 08 --><td>${caixa.valor}</td>
											<!-- 09 --><td>${caixa.saldo}</td>											
											<!-- 10 --><td>${caixa.forma}</td>
											<!-- 11 --><td>${caixa.parcela}</td>	
											<!-- 12 --><td>${caixa.dataOperacao}</td>											
											<!-- 13 --><td>${caixa.descricao}</td>	
											<!-- 14 --><td>${caixa.nomerazao}</td>
											
											<!-- Aqui nessa td, estão os botões de editar e excluir, que aparecem junto com a lista de matérias-primas na tabela -->
		                					<td>
		                						<button id="edit-caixa" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						
		                						<!-- Verifica se for gasto, se for coloca o botão de exclusão -->
		                						<c:if test="${caixa.gastoRecebimento == 0}">
		                							<button id="delete-caixa" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                						</c:if>
		                						
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<!--
					Essa div tem o botão de abrir o modal "incluir novo gasto" 
					-->
					<div class="row">					
						
						<div class="input-margin pull-right col-xs-12 col-sm-4 col-md-4">
							<a href="" id="incluir-caixa-modal" data-toggle="modal" data-target="#modal-caixa" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo gasto</a>
						</div>
												
						<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<div class="row">
								<div class="col-xs-9">							
									<h4>Caixa: R$ <input id="saldomes" name="saldomes" value="${saldo}" type="text" size="10" style="border:0;" readonly/></h4>		
								</div>								
							</div>
						</div>											
					</div>
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
	    		
	    		<!-- 
	    		formulário de preencher os dados da matéria-prima 
	    		-->
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
									0 Para gasto.
									1 Para recebimento.
								 -->
								 
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="gastoRecebimento">Tipo:</label>
									<select id="gastoRecebimento" name="gastoRecebimento" class="form-control">
										<option value="0" selected>Gasto</option>
										<option value="1" disabled>Recebimento</option>
									</select> 
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="dataOperacao">Data da Operação:</label>
									<input type="date" id="dataOperacao" name="dataOperacao" class="form-control" readonly/>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="dataTransacao">Data da transação*:</label>
									<input type="date" id="dataTransacao" name="dataTransacao" class="form-control" required/>
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
									<input id="parcela" name="parcela" type="number" class="form-control" min=1 max=6 pattern="[0-9]+" maxlength="1" value="1">
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="valor">Valor*:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input type="text" id="valor" name="valor" placeholder="0,00" class="form-control" maxlength="14" required/>
									</div>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-12" id="fornecedorDiv">
									<label class="control-label" for="fornecedorId" id="lbl_fornecedorId">Fornecedor:</label>			 						
 									<select name="fornecedorId" id="fornecedorId" class="form-control" placeholder="Digite o nome do fornecedor."></select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-12" id="encomendaDiv">
 									<label class="control-label" for="encomendaId" >Numero da encomenda:</label>
 									<input type="text" name="encomendaId" id="encomendaId"  class="form-control" readonly/>
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
								<!-- Essa div contem o id do caixa q vai ser excluido, porem ele fica escondido na tela, por causa da class hidden-->
								<div class="hidden">
								<!-- A identificação do spring é pelo name -->	
									<label class="control-label" for="valor">Nº caixa:</label>
									<input type="text" id="valor_delete" name="valor" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>
								<!-- mensagem no corpo do modal -->	
								<p>Deseja realmente excluir o gasto selecionado?</p>
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
    <script src="resources/js/selectize.js"></script>
	<script src="resources/js/moment.js"></script>
	<script src="resources/js/wizard.js"></script>
	
	<script type="text/javascript">

		$(document).ready(function() {

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
			
			$("#valor").mask("000.000.000.000.000,00", {reverse: true});
			
			//Remove as mascaras quando apertar o submit
			$("#caixa-form").submit(function() {
				var valor = $("#valor").val();
				valor = valor.split(".").join("");
				valor = valor.split(",").join(".");
				$("#valor").val(valor);
			});
			
			//-----------Autocomplete----------------------------------------------------------------------
        	$('#fornecedorId').selectize({	
        	    valueField: 'id',//Valor do campo
        	    labelField: 'nomerazao',
        	    searchField: ['nomerazao', 'cpfcnpj', 'rgie'],
        	    options: [{id: '${fornecedor.fornid}', nomerazao: '${fornecedor.fornnome}', cpfcnpj: '${fornecedor.forncpfcnpj}'}],
        	    create: false,
        	    render: {
        	        option: function(item, escape) {
        	        	 return	'<div>' +
        					'<span class="title">' +
        						'<span>' + escape(item.nomerazao) + '</span><br/>' +
        						'<span>' + escape(item.cpfcnpj) + '</span><br/>' +
        					'</span>' +
        				'</div>';
        	        }
        	    },

        	    load: function(query, callback) {
        	        if (!query.length) return callback();
        	        $.ajax({
        	            url: 'rest-pesquisar-fornecedor/' + encodeURIComponent(query),
        	            type: 'GET',
        	            error: function() {
        	                callback();
        	            },
        	            success: function(res) {
        	                callback(res);
        	            }
        	        });
        	    }
   			});
			
			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*	id da tabela lista-caixa
			*/
			
			//INVISIVEIS - Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-caixa').DataTable({
                
            	"createdRow": function( row, data, dataIndex ) {
                    if ( data[5] == 0 ) {
                        //console.log(data[0], data[5]);               
                      	//$(row).css('color', 'Red');//linha toda
                    	$('td', row).eq(2).css('color', 'Red');//só a coluna    
                    }
                    
                    /* Código desnecessário
                    else if(data[2] == 1){
                    	//$(row).css('color', 'blue');
                    	$('td', row).eq(2).css('color', 'Blue');    
                    }
                    */
                    
                  },
                  
				/* 
				
					<!-- 00 -->View data transação
					<!-- 01 -->View Tipo
					<!-- 02 -->View valor
					
					<!-- 03 -->ID
					<!-- 04 -->Data transação
					<!-- 05 -->gastoRecebimento
					<!-- 06 -->fornecedorId
					<!-- 07 -->ID encomenda
					<!-- 08 -->Valor
					<!-- 09 -->Saldo
					<!-- 10 -->Forma pagamento
					<!-- 11 -->Caixa parcelas
					<!-- 12 -->Data operação											
					<!-- 13 -->Descrição
					<!-- 14 -->Nome razão
					
				*/ 
                             
                "columnDefs": [
								{
			                        "targets": [ 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ],
			                        "visible": false
								}
							  ]
            });// FIM - CONFIGURAÇÃO DA TABELA
            

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
                $('#dataOperacao').val(now);
                var now = moment().format('YYYY-MM-DD');
                $('#dataTransacao').val(now);                

                $('#valor').removeAttr('readonly');

				$("#gastoRecebimento option[value=0]").removeAttr('disabled');
				$("#gastoRecebimento option[value=1]").attr('disabled', 'disabled');
          		
				
				// DESABILITA O CAMPO
				var gastoRecebimento = $("#gastoRecebimento");
				var fornecedorDiv = $("#fornecedorDiv");
				var encomendaDiv = $("#encomendaDiv");
				
				if(gastoRecebimento.val() == 0){
					encomendaDiv.hide();
					fornecedorDiv.show();
				}else{
					encomendaDiv.show();
					fornecedorDiv.hide();
				}


				          
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

              	//Apresenta o modal de alteração na tela.-----------------------
              	$('#modal-caixa').modal('show');

				//Settando no selectize os valores vindo da tabela
				/* 
					<!-- 03 -->ID
					<!-- 04 -->Data transação
					<!-- 05 -->gastoRecebimento
					<!-- 06 -->fornecedorId
					<!-- 07 -->ID encomenda
					<!-- 08 -->Valor
					<!-- 09 -->Saldo
					<!-- 10 -->Forma pagamento
					<!-- 11 -->Caixa parcelas
					<!-- 12 -->Data operação											
					<!-- 13 -->Descrição
					<!-- 14 -->Nome razão
				*/ 
				
				//Pega os valores que estão na tabela e passa para o modal.			
				$('#id').val(data[3]);
				$('#dataTransacao').val(data[4]);
				$('#gastoRecebimento').val(data[5]);
				$('#valor').val(data[8]).trigger('input');
				$('#saldo').val(data[9]);
				$('#forma').val(data[10]);
				$('#parcela').val(data[11]);
				$('#dataOperacao').val(data[12]);
				$('#descricao').val(data[13]);
          		
				$("#gastoRecebimento option[value=0]").removeAttr('disabled');
				$("#gastoRecebimento option[value=1]").attr('disabled', 'disabled');
          		
				// DESABILITA O CAMPO
				var gastoRecebimento = $("#gastoRecebimento");
				var fornecedorDiv = $("#fornecedorDiv");
				var encomendaDiv = $("#encomendaDiv");
				
				if(gastoRecebimento.val() == 0){
					
					encomendaDiv.hide();
					fornecedorDiv.show();
					
					$('#valor').removeAttr('readonly');

	                var selectize = $('#fornecedorId')[0].selectize;
	                selectize.clearOptions();
	                
	                //Verifica se existe algum valor, se não existir não executa essa parte do código.
	                if(data[6] != 0){
	                	selectize.addOption({id:data[6], nomerazao:data[14], cpfcnpj:'123'});
		                selectize.setValue(data[6]);
	                }
	                
				}else{
					$("#gastoRecebimento option[value=1]").removeAttr('disabled');
					$("#gastoRecebimento option[value=0]").attr('disabled', 'disabled');
					
					$('#valor').attr('readonly', 'readonly');
					
					encomendaDiv.show();
					fornecedorDiv.hide();

					
					$('#encomendaId').val(data[7]);
				}
          		
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
                var data = table.row( $(this).parents('tr')).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[3]);
                $('#valor_delete').val(data[8]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-caixa').modal('show');//---------------------------------

            });
	
        });

	</script>
	
	
</body>
</html>