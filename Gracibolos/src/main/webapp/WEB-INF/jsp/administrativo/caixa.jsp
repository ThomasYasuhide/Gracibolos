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
								  <strong>Sucesso!</strong> Matéria-prima armazenada com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir uma nova matéria-prima, favor tente novamente.
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
								 <strong>Erro!</strong> Houve algum erro ao tentar alterar a matéria-prima, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Matéria-prima foi excluida com sucesso!
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
					
						<div class="input-margin col-xs-12 col-sm-1 col-md-1 col-lg-1">
							<label class="control-label" for="fabricacao">De*:</label>
						</div>
						
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">							
							<input type="date" id="fabricacao" class="form-control" placeholder="Escolha a data de fabricação" name="fabricacao" required>
						</div>
						
						<div class="input-margin col-xs-12 col-sm-1 col-md-1 col-lg-1">
							<label class="control-label" for="fabricacao">até*:</label>
						</div>						
						
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">							
							<input type="date" id="fabricacao" class="form-control" placeholder="Escolha a data de fabricação" name="fabricacao" required>
						</div>
						
						<div class="input-margin col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<a href="administrativo-pesquisar-caixa" class="col-xs-12 col-sm-4 col-md-4 col-lg-4 btn btn-default fullwidth">
								<span class="glyphicon glyphicon-search disabled"></span>
							</a>
						</div>					
					</div>
					
					<!-- Essa div agrupa os títulos das tabelas, e os resultados das pesquisas -->
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-caixa" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Recebido / Gasto</th>
										<th>Encomenda ID</th>
										<th>Fornecedor ID</th>
										<th>Valor</th>									
										<th>Forma</th>
										<th>Parcela</th>
										<th>Data</th>
										<th>Descrição</th>										
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="caixa" items="${caixas}">
										<tr>
											<td>${caixa.id}</td>
											<td>${caixa.gastoRecebimento}</td>
											<td>${caixa.encomendaId}</td>
											<td>${caixa.fornecedorId}</td>
											<td>${caixa.valor}</td>											
											<td>${caixa.forma}</td>
											<td>${caixa.parcela}</td>
											<td>${caixa.data}</td>
											<td>${caixa.descricao}</td>											
											
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
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>
	
	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DE COLABORADOR ############################################################

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
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>																	
								
	
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="gastoRecebimento">Gasto/Recebimento*:</label>
									<select id="gastoRecebimento" name="gastoRecebimento" onchange="desabilitarCampos(this)" class="form-control" required>
										<option selected value="0">Gasto</option>
										<option value="1">Recebimento</option>
									</select>
								</div>
																
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="nome_tipo" id="nome_tipo">Fornecedor*:</label>
									<input type="text" name="nome" id="nome_des" placeholder="Digite seu nome aqui." class="form-control" maxlength="100" required/>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="valor">Valor*:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input type="text" id="valor" name="valor" placeholder="0,00" class="form-control" maxlength="14" required/>
									</div>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="formaPagamento">Forma de pagamento*:</label>
									<select class="form-control" id="formaPagamento" name="formaPagamento">										
										<option value="0" selected disabled>Selecione...</option>
										<option value="1">Dinheiro</option>
										<option value="2">Cartão de crédito</option>
										<option value="3">Cartão de débito</option>
										<option value="4">Cheque</option>
									</select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="parcela">Número de Parcelas:</label>
									<input id="parcela" type="number" min=1 class="form-control" pattern="[0-9]+" maxlength="1"  name="parcela" value="1">
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="data_transacao">Data da transação:</label>
									<input type="date" id="data_transacao" name="data_transacao" class="form-control" required />
								</div>
								
								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="descricao">Descrição:</label>
									<textarea class="form-control" rows="3" name="descricao" id="descricao" placeholder="Digite aqui a descrição"></textarea>
								</div>
								
							</div>
						</div>
					</div>

					<!-- ################################# FIM DO CONTEUDO ################################# -->
					
					<!-- Esse div contem o 2 botões -->
					<div class="modal-footer">
						<!-- botão de fechar o modal  -->
						<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
						<!-- botão de incluir ou alterar a matéria-prima, assim finalizando o formulário  -->
						<button type="submit" class="btn btn-default" id="modal-action"></button>
					</div>
					
				</form>
			</div>
		</div>
	</div>

	<!--

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE COLABORADOR #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE COLABORADOR      ############################################################

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

	############################################################ FIM DO  MODAL DE EXCLUSÃO DE COLABORADOR ############################################################

	-->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>	
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/bootstrap.js"></script>
    

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

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-caixa').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 2, 3, 5, 6, 8 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE MATÉRIA-PRIMA
			*
			*/
			
			//quando o usuário clica no botão de incluir nova matéria-prima, ele abre o modal e chama essa função
            $('#incluir-caixa-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir nova saída");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#caixa-form").attr("action","administrativo-incluir-caixa");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir saída');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#caixa-form').each(function(){
					this.reset();
				});
				
				var now = moment().format('YYYY-MM-DD');
                $('#data_transacao').val(now);               

				//Este método se encontra no arquivo scripts.js
				//Desabilita e habilita os campos NOME RAZÃO CPF CNPJ RG IE SEXO DATANASCIMENTO
                desabilitarCampos(document.getElementById("#gastoRecebimento"));
				
			});

            /*
			*
			* ALTERAÇÃO DE MATÉRIA-PRIMA
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
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
					
				//Preenche os determinados campos com os conteudos.
              	$('#id').val(data[0]);
              	$('#gastoRecebimento').val(data[1]);
              	$('#encomendaId').val(data[2]);
              	$('#fornecedorId').val(data[3]);
				$('#valor').val(data[4]);
				$('#forma').val(data[5]);
				$('#parcela').val(data[6]);
				$('#data_transacao').val(data[7]);
				$('#descricao').val(data[8]);
            });


			/*
			*
			* EXCLUSÃO DA MATÉRIA-PRIMA
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
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