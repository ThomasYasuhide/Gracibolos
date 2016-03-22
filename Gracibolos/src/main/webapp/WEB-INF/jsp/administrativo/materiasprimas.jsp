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
	<title>Graci Bolos | Matérias-primas</title>

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
						<h2 class="">MATÉRIAS-PRIMAS</h2>
						<h4 class="">Lista de matérias-primas</h4>
					</header>

					<hr/>

					<!-- ############################################################ CONTEUDO ############################################################ -->


					<!-- ################################# ALERTAS ################################# -->
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
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar matéria-prima:</label>
							<form action="administrativo-procurar-materiaprima" method="POST">
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o código ou o nome da matéria-prima para realizar a pesquisa." name="pesquisa" id="pesquisa" required />
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
							<table id="lista-materiaPrima" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Codigo</th>
										<th>Nome</th>
										<th>Estoque</th>
										<th>Unidade</th>
										<th>Fabricação</th>
										<th>Vencimento</th>
										<th>Descrição</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="materiaprima" items="${listaDeMateriaPrima}">
										<tr>
											<td>${materiaprima.id}</td>
											<td>${materiaprima.nome}</td>
											<td>${materiaprima.estoque}</td>
											<td>${materiaprima.unidade}</td>
											<td>${materiaprima.fabricacao}</td>
											<td>${materiaprima.vencimento}</td>
											<td>${materiaprima.descricao}</td>
		                					<td>
		                						<button id="edit-materiaPrima" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-materiaPrima" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-4">
							<a href="" id="incluir-materiaPrima-modal" data-toggle="modal" data-target="#modal-materiaPrima" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir nova matéria-prima</a>
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
	<div class="modal fade" id="modal-materiaPrima" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<form id="materiaPrima-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">MATÉRIA-PRIMA</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden"> -->
									<label class="control-label" for="id">Nº matéria-prima:</label>
									<input type="text" id="id" name="id" placeholder="Digite o número de ID" class="form-control" />
								</div>																	
										
								<div class="input-margin col-xs-12 col-sm-12 col-md-3">
									<label class="control-label" for="nome">Código*:</label>
									<input type="text" id="codigo" class="form-control" maxlength="30" placeholder="Digite o código da matéria-prima" name="codigo" required>
								</div> 
									
								<div class="input-margin col-xs-12 col-sm-12 col-md-9">
									<label class="control-label" for="nome">Nome*:</label>
									<input type="text" id="nome" class="form-control" maxlength="255" placeholder="Digite o nome da matéria-prima" name="nome" required>
								</div> 
								
								<div class="input-margin col-xs-12 col-sm-9 col-md-3">
									<label class="control-label" for="estoque">Estoque*:</label>
									<input id="estoque" type="text" class="form-control" name="estoque" maxlength="20" placeholder="0.000">
								</div>
								
								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
									<label class="control-label" for="unidade">Unidade*:</label>
									<select class="form-control" id="unidade" name="unidade">
										<option value="" selected disabled>Selectione</option>
										<option value="0">Gramas (g)</option>
										<option value="1">Mililitros (ml)</option>
									</select>
								</div>	
								
								<div class="input-margin col-xs-12 col-sm-12 col-md-3">
									<label class="control-label" for="fabricacao">Data de fabricação*:</label>
									<input type="date" id="fabricacao" class="form-control" placeholder="Escolha a data de fabricação" name="fabricacao" required>
								</div>
											
								<div class="input-margin col-xs-12 col-sm-12 col-md-3">
									<label class="control-label" for="vencimento">Data de vencimento*:</label>
									<input type="date" id="vencimento" class="form-control" placeholder="Escolha a data de vencimento" name="vencimento" required>
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

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE COLABORADOR #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE COLABORADOR      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de cliente -->
	<div class="modal fade" id="excluir-materiaPrima" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="materiaPrima-delete-form" action="administrativo-remover-materiaprima" method="POST">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir matéria-prima</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº matéria-prima:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>

								<p>Deseja realmente excluir a matéria-prima selecionada?</p>
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
			
			$('#menu-mob-materiasprimas').addClass('active');
			$('#menu-materiasprimas').addClass('active');

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-materiaPrima').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 5, 7 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE MATÉRIA-PRIMA
			*
			*/

            $('#incluir-materiaPrima-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir nova matéria-prima");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#materiaPrima-form").attr("action","administrativo-incluir-materiaprima");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir matéria-prima');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#materiaPrima-form').each(function(){
					this.reset();
				});
				
				
			});

            /*
			*
			* ALTERAÇÃO DE MATÉRIA-PRIMA
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-materiaPrima tbody').on( 'click', '#edit-materiaPrima', function () {            	
            	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar materia-prima");
            	
            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#materiaPrima-form").attr("action","administrativo-alterar-materiaprima");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

              	//Apresenta o modal de exclusão na tela.
              	$('#modal-materiaPrima').modal('show');
					
				//Preenche os determinados campos com os conteudos.
              	$('#id').val(data[0]);
				$('#marca').val(data[1]);
				$('#tipo').val(data[2]);
				$('#qtd').val(data[3]);
				$('#descricao').val(data[4]);
            });


			/*
			*
			* EXCLUSÃO DA MATÉRIA-PRIMA
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
            $('#lista-materiaPrima tbody').on( 'click', '#delete-materiaPrima', function () {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-materiaPrima').modal('show');

            });
	
        });

	</script>
	
	
</body>
</html>