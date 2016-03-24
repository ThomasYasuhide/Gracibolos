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
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Novo pagamento realizado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar realizar o pagamento, favor tente novamente.
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
								 <strong>Erro!</strong> Houve algum erro ao tentar alterar o caixa, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Caixa foi excluido com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								 <strong>Erro!</strong> Houve algum erro ao tentar excluir o caixa, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar caixa:</label>
							<form action="administrativo-pesquisar-caixa" method="POST">
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o nome, CPF, CNPJ, RG ou IE para realizar a pesquisa." name="pesquisa" id="pesquisa" required />
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">
											<span class="glyphicon glyphicon-search disabled"></span>
										</button>
									</span>
								</div>
							</form>
						</div>
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-caixa" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Encomenda Id</th>
										<th>Valor</th>
										<th>Gasto</th>
										<th>Recebimento</th>
										<th>Forma</th>
										<th>Parcela</th>
										<th>Descrição</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="caixa" items="${caixas}">
										<tr>
											<td>${caixa.id}</td>
											<td>${caixa.encomendaId}</td>
											<td>${caixa.valor}</td>
											<td>${caixa.gasto}</td>
											<td>${caixa.recebimento}</td>
											<td>${caixa.forma}</td>
											<td>${caixa.parcela}</td>
											<td>${caixa.descricao}</td>
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

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-4">
							<a href="" id="incluir-caixa-modal" data-toggle="modal" data-target="#modal-caixa" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Realizar novo pagamento</a>
						</div>
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>
	




	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DO CAIXA ############################################################

	-->
	<div class="modal fade" id="modal-caixa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<form id="caixa-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">CAIXA</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden"> -->
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id" name="id" placeholder="Digite o número de ID" class="form-control" />
								</div>																	
										
								<div class="input-margin col-xs-12 col-sm-12 col-md-4">
									<label class="control-label" for="encomendaId">Encomenda ID*:</label>
									<input type="text" id="encomendaId" placeholder="00000" class="form-control" maxlength="30" placeholder="Digite o código da encomenda" name="encomendaId" required>
								</div> 
									
								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="valor">Valor:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input id="valor" type="text" class="form-control" name="valor" max="999999" placeholder="0,00">
									</div>
								</div>		
								
								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="custo">Gasto:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input id="gasto" type="text" class="form-control" name="gasto" max="999999" placeholder="0,00">
									</div>
								</div>								
								
								<div class="input-margin col-xs-12 col-sm-12 col-md-4">
									<label class="control-label" for="forma">Forma de pagamento*:</label>
									<input type="text" id="forma" class="form-control" maxlength="20" placeholder="Digite a forma de pagamento" name="forma" required>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="recebimento">Recebimento*:</label>
									<select class="form-control" id="recebimento" name="recebimento">
										<option value="" selected disabled>Selectione</option>
										<option value="true">Tudo pago</option>
										<option value="false">Pendente</option>
									</select>
								</div>
											
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="parcela">Parcela até 2 vezes:</label>
									<input id="parcela" type="number" min=1 max=2 class="form-control" pattern="[0-9]+" maxlength="1"  name="parcela" value="1">
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="descricao">Descrição:</label>
									<textarea class="form-control" name="descricao" id="descricao" placeholder="Digite aqui a descrição	"></textarea>
								</div>
								
							</div>
						</div>
					</div>

					<!-- ################################# FIM DO CONTEUDO ################################# -->

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
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



	<!-- Modal de confirmação de exclusão do caixa -->
	<div class="modal fade" id="excluir-caixa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="caixa-delete-form" action="administrativo-remover-caixa" method="POST">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir caixa</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>

								<p>Deseja realmente excluir o caixa selecionado?</p>
							</div>
						</div>

						
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Não, quero manter</button>
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
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-materiaprima').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 3, 5, 6, 7 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DO CAIXA
			*
			*/

            $('#incluir-caixa-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo caixa");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#caixa-form").attr("action","administrativo-incluir-caixa");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Concluir P');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#caixa-form').each(function(){
					this.reset();
				});
				
				
			});

            /*
			*
			* ALTERAÇÃO DO CAIXA
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-caixa tbody').on( 'click', '#edit-caixa', function () {            	
            	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar caixa");
            	
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
				$('#encomendaId').val(data[1]);
				$('#valor').val(data[2]);
				$('#gasto').val(data[3]);
				$('#recebimento').val(data[4]);
				$('#forma').val(data[5]);
				$('#parcela').val(data[6]);
				$('#descricao').val(data[7]);
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