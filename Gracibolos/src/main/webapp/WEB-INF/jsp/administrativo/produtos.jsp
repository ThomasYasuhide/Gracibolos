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
	<title>Graci Bolos | Produtos</title>

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
						<h2 class="">Produtos</h2>
						<h4 class="">Lista de produtos</h4>
					</header>

					<hr/>

					<!-- ############################################################ CONTEUDO ############################################################ -->


					<!-- ################################# ALERTAS ################################# -->
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Produto armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir o novo produto, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${alterar == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Alteração efetuarda com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${alterar == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar o produto, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Produto foi excluido com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir o produto, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar produto:</label>
							<form action="administrativo-procurar-produto" method="POST">
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o código ou o nome do produto para realizar a pesquisa." name="pesquisa" id="pesquisa" required />
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
							<table id="lista-produtos" class="table table-hover display" cellspacing="0" width="100%">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Status</th>
										<th>Tipo</th>
										<th>Codigo</th>
										<th>Nome</th>
										<th>Custo</th>
										<th>Valor</th>
										<th>Unid.</th>
										<th>Peso</th>
										<th>Receita</th>
										<th>Foto</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="produto" items="${produtos}">
										<tr>
											<td>${produto.id}</td>
											<td>${produto.status}</td>
											<td>${produto.tipo}</td>
											<td>${produto.codigo}</td>
											<td>${produto.nome}</td>
											<td>${produto.custo}</td>
											<td>${produto.valor}</td>
											<td>${produto.unid}</td>
											<td>${produto.peso}</td>
											<td>${produto.receita}</td>
											<td>${produto.foto}</td>
		                					<td>
		                						<button id="edit-produto" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-produto" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
							<a href="" id="incluir-produto-modal" data-toggle="modal" data-target="#modal-produto" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo produto</a>
						</div>
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>
	


<!-- 








CONTINUAR DAQUI 









-->


	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DE PRODUTO ############################################################

	-->
	<div class="modal fade" id="modal-produto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<form id="produto-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">PRODUTOS</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<!-- ABAS -->
								<ul class="nav nav-tabs">
									<li class="active"><a data-toggle="tab" href="#info">Informações do produto</a></li>
									<li ><a data-toggle="tab" href="#receita">Receita do produto</a></li>
								</ul>

									<div class="tab-content">

										<div id="info" class="tab-pane fade in active">
											
											<div class="hidden">
												<label class="control-label" for="id">Nº produto:</label>
												<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" />
											</div>

											<div class="col-xs-6 col-md-3">
												<label class="control-label">Foto do produto:</label>
												<a href="">
													<img class="thumbnail" src="resources/img/model.png" width="100%" height="100%" alt="...">
												</a>
											</div>

											<div class="input-margin col-xs-6 col-sm-6 col-md-3">
												<label class="control-label" for="status">Status:</label>
												<select class="form-control" id="status" name="status" required>
													<option selected value="1">Ativado</option>
													<option value="0">Desativado</option>
												</select>
											</div>

											<div class="input-margin col-xs-6 col-sm-6 col-md-3">
												<label class="control-label" for="status">Tipo*:</label>
												<select class="form-control" id="status" name="status" required>
													<option value="" selected="true" disabled="">Selecione</option>
													<option value="1">Bolo</option>
													<option value="0">Salgados</option>
												</select>
											</div>
											
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="estoque">Estoque:</label>
												<input type="number" class="form-control" name="estoque" value="0">
											</div>
											
											<div class="input-margin col-xs-12 col-sm-12 col-md-3">
												<label class="control-label" for="codigo">Código*:</label>
												<input type="text" id="codigo" class="form-control" maxlength="20" placeholder="Digite o código do produto" name="codigo" required>
											</div> 

											<div class="input-margin col-xs-12 col-sm-12 col-md-6">
												<label class="control-label" for="nome">Nome*:</label>
												<input type="text" id="nome" class="form-control" maxlength="100" placeholder="Digite o nome do produto" name="nome" required>
											</div> 

											<div class="input-margin col-xs-6 col-sm-6 col-md-3">
												<label class="control-label" for="unid">Unidade*:</label>
												<select class="form-control" id="unid" name="unid" required>
													<option value="" selected disabled="true">Selectione</option>
													<option value="kg">Kilo(s)</option>
													<option value="gr">Grama(s)</option>
												</select>
											</div>

											<div class="input-margin col-xs-12 col-sm-9 col-md-3">
												<label class="control-label" for="peso">Peso:</label>
												<input type="text" class="form-control" name="peso" maxlength="20" placeholder="0.000">
											</div>

											<div class="input-margin col-xs-12 col-sm-9 col-md-3">
												<label class="control-label" for="custo">Custo:</label>
												<input type="text" class="form-control" name="custo" maxlength="20" placeholder="Digite aqui o custo do produto">
											</div>

											<div class="input-margin col-xs-12 col-sm-9 col-md-3">
												<label class="control-label" for="valor">Valor*:</label>
												<input type="text" class="form-control" name="valor" maxlength="20" placeholder="Digite aqui o valor do produto" required>
											</div>

											

											<div class="input-margin col-xs-12 col-sm-12 col-md-12">
												<label class="control-label" for="obs">Observação:</label>
												<textarea class="form-control" name="obs" name="obs" id="obs" placeholder="Digite aqui as observações"></textarea>
											</div>
										</div>

										<div id="receita" class="tab-pane fade">
											<table id="grid-basic" class="table table-hover">
												<thead>
													<tr>
														<th data-column-id="id" data-visible="false">#</th>
														<th data-column-id="nome">Nome</th>
														<th data-column-id="medida">Medida</th>
														<th data-column-id="unidade">Unidade</th>
														<th data-column-id="comandos" data-formatter="commands" data-sortable="false">Ações</th>
													</tr>
												</thead>
												<tbody>

													<tr>
														<td>1</td>
														<td>Farinha de trigo</td>
														<td>200</td>
														<td>gr</td>
													</tr>

													<tr>
														<td>1</td>
														<td>Ovos de galinha</td>
														<td>2</td>
														<td>un</td>
													</tr>

												</tbody>
											</table>

											<div class="row">
												<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
													<a class="btn btn-default fullwidth" href="incluir_cliente.html"><span class="glyphicon glyphicon-plus disabled"></span>&nbsp;&nbsp;&nbsp;Incluir novo ingrediente</a>
												</div>
											</div>

										</div>

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
	<div class="modal fade" id="excluir-colaborador" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="colaborador-delete-form" action="administrativo-remover-colaborador" method="POST">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir colaborador</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº colaborador:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>

								<p>Deseja realmente excluir o colaborador?</p>
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
	<script src="resources/js/bootstrap.js"></script>
    

	<script type="text/javascript">
		$(document).ready(function() {

			/*
			*
			* DEFINIÇÃO DAS VARIAVEIS
			*
			*/

			var combo_estado = $('#estado');
			var combo_cidade = $('#cidade');

			/*
			*
			* INDICADOR DE PAGINA DO MENU
			*
			*/
			
			$('#menu-mob-colaboradores').addClass('active');
			$('#menu-colaboradores').addClass('active');

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-colaboradores').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 1, 2, 3, 4, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE COLABORADOR
			*
			*/

            $('#incluir-colaborador-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo colaborador");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#colaborador-form").attr("action","administrativo-incluir-colaborador");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir colaborador');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#colaborador-form').each(function(){
					this.reset();
				});
				
				//Remove todas as opções do combo cidade.
				combo_cidade.find('option').remove();
				
				//Adiciona opção onde solicita que o usuário selecione uma cidade.
				combo_cidade.append($('<option></option>').val(0).html("Selecione a cidade").attr('disabled','disabled').attr('selected','selected'));
			});

            /*
			*
			* ALTERAÇÃO DE COLABORADOR
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-colaboradores tbody').on( 'click', '#edit-colaborador', function () {
            	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar colaborador");
            	
            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#colaborador-form").attr("action","administrativo-alterar-colaborador");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();
                
                //Passa o ID da cidade e caso existe executa a função callback para abrir o modal e preencher os campos com os dados.
              	listar_cidades(data[12], function(){

              		//Apresenta o modal de exclusão na tela.
              		$('#modal-colaborador').modal('show');
					
					//Preenche os determinados campos com os conteudos.
                    $('#id').val(data[0]);
                    $('#status').val(data[1]);
                    $('#nivel').val(data[2]);
                    $('#usuario').val(data[3]);
                    $('#senha').val(data[4]);
    				$('#nome').val(data[5]);
    				$('#cpf').val(data[6]);
                    $('#rg').val(data[7]);
                    $('#endereco').val(data[8]);
                    $('#numero').val(data[9]);
    				$('#complemento').val(data[10]);
    				$('#bairro').val(data[11]);
    				$('#estado').val(data[12]);
                    $('#cidade').val(data[13]);
                    $('#cep').val(data[14]);
                    $('#tel').val(data[15]);
    				$('#cel').val(data[16]);
                    $('#email').val(data[17]);
    				$('#obs').val(data[18]);

                });

			});

			/*
			*
			* EXCLUSÃO DE COLABORADOR
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
            $('#lista-colaboradores tbody').on( 'click', '#delete-colaborador', function () {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-colaborador').modal('show');

            });

            /*
			*
			* CIDADES
			*
			*/

			//Verifica o evento do mudança do campo estado e chama função listar_cidades passando o ID do estado
            combo_estado.change(function(){
				listar_cidades(combo_estado.val());
			});

			//
			function listar_cidades(id, callback){
				
				$.ajax({
		            url : 'administrativo-pesquisar-cidade',
		            method: "POST",
		            data: {id:id},
		            success : function(data) {

		            	combo_cidade.find('option').remove();

		            	combo_cidade.append($('<option></option>').val(0).html("Selecione a cidade").attr('disabled','disabled').attr('selected','selected'));
						
		            	$.each(data, function(val, cidade){
							combo_cidade.append($('<option></option>').val(cidade.id).html(cidade.nome));
						});

						callback();
						
		            }
		        });

			}
        });

	</script>
	
	
</body>
</html>