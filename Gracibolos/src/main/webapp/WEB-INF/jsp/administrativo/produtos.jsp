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
						<h2 class="">PRODUTOS</h2>
						<h4 class="">Lista de produtos</h4>
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
					
					<!-- Essa div agrupa os campos de pesquisa e de listar os produtos -->
					<div class="row">
						<!-- Campo de pesquisar os produtos -->
						<div class="input-margin col-xs-12 col-sm-9 col-md-9 col-lg-9">
							<label class="control-label">Pesquisar produto:</label>
							<!-- Quando clicar no botão envia o form para a url abaixo -->
							<form action="administrativo-pesquisar-produto" method="POST">
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
						
						<!-- Esse botão lista todos os produtos -->
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">
							<label class="control-label hidden-xs">Listar produtos</label>
							<a href="administrativo-listar-produtos" class="btn btn-default fullwidth">Listar produtos</a>
						</div>
					</div>
					
					<!-- Essa div agrupa os títulos das tabelas, e os resultados das pesquisas -->
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-produtos" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Foto</th>
										<th>Status</th>
										<th>Codigo</th>
										<th>Nome</th>
										<th>Tipo</th>
										<th>Peso</th>
										<th>Unid.</th>
										<th>Estoque</th>
										<th>Custo</th>
										<th>Valor</th>
										<th>Obs</th>
										<th>Receita</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="produto" items="${produtos}">
										<tr>
											<td>${produto.id}</td>
											<td>${produto.foto}</td>
											<td>${produto.status}</td>
											<td>${produto.codigo}</td>
											<td>${produto.nome}</td>
											<td>${produto.tipo}</td>
											<td>${produto.peso}</td>
											<td>${produto.unidade}</td>
											<td>${produto.estoque}</td>
											<td>${produto.custo}</td>
											<td>${produto.valor}</td>
											<td>${produto.obs}</td>
											<td>${produto.rec}</td>
											
											<!-- Aqui nessa td, estão os botões de editar e excluir, que aparecem junto com a lista de produtos na tabela -->
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

					<!--Essa div tem o botão de abrir o modal "incluir novo produto" -->
					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-4">
							<a href="" id="incluir-produto-modal" data-toggle="modal" data-target="#modal-produto" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo produto</a>
						</div>
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>
	
	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DE PRODUTO ############################################################

	-->
	<div class="modal fade" id="modal-produto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
			
	    		<!-- formulário de preencher os dados do produto -->
	    		<form id="produto-form" method="POST" enctype="multipart/form-data">
	    			
	    			<!--Essa div tem o título e subtítulo do modal, e o "X" de fechar o modal   -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">PRODUTOS</h3>
						<h4 id="modal-subtitle"></h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<!-- ################################# Corpo do modal ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<!-- ################################# TÍTULO DAS ABAS ################################# -->
								<ul class="nav nav-tabs">
									<li class="active"><a data-toggle="tab" href="#info">Informações do produto</a></li>
									<li><a data-toggle="tab" href="#receita">Receita do produto</a></li>
									<!-- <li><a data-toggle="tab" href="#materias-primas">Matérias primas</a></li> -->
								</ul>

									<div class="tab-content">
									
										<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
											INICIO DA ABA INFORMAÇÕES DO PRODUTO
										+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
										
										<div id="info" class="tab-pane fade in active">
											
											<div class="hidden">
												<label class="control-label" for="id">Nº produto:</label>
												<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" readonly/>
											</div>

											<!-- Campo foto produto-->
											<div class="col-xs-12 col-sm-6 col-md-3">
												<label class="control-label">Foto do produto:</label>
												<label for="file">
													<img id="foto-view" class="thumbnail" src="resources/img/produtos/model.png" width="100%" height="100%" alt="..." onclick="" >
													<input type="text" id="foto-inp" name="foto" class="hidden" maxlength="100">
												</label>
												<input type="file" id="file" name="file" class="hidden" accept="image/*">
											</div>
											
											<!-- Campo  status -->											
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="status">Status:</label>
												<select class="form-control" id="status" name="status" required>
													<option selected value="1">Ativado</option>
													<option value="0">Desativado</option>
												</select>
											</div>

											<!-- Campo código -->											
											<div class="input-margin col-xs-12 col-sm-6 col-md-6">
												<label class="control-label" for="codigo">Código*:</label>
												<input type="text" id="codigo" class="form-control" maxlength="20" placeholder="Digite o código do produto" name="codigo" required>
											</div> 

											<!-- Campo nome -->
											<div class="input-margin col-xs-12 col-sm-6 col-md-9">
												<label class="control-label" for="nome">Nome*:</label>
												<input type="text" id="nome" class="form-control" maxlength="100" placeholder="Digite o nome do produto" name="nome" required>
											</div>
											
											<!-- Campo tipo -->											
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="tipo">Tipo*:</label>
												<select class="form-control" id="tipo" name="tipo" required>
													<option value="" selected="selected" disabled="disabled">Selecione...</option>
													<option value="1">Bolo</option>
													<option value="2">Salgados</option>
													<option value="3">Doces</option>
												</select>
											</div>

											<!-- Campo peso-->
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="peso">Peso:</label>
												<input id="peso" type="text" class="form-control" name="peso" maxlength="10" placeholder="0.000">
											</div>

											<!-- Campo tipo de unidade litros ou kilos-->
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="unidade">Unidade:</label>
												<select class="form-control" id="unidade" name="unidade">
													<option value="0" selected disabled>Selecione...</option>
													<option value="1">Kilos (kg)</option>
													<option value="2">Litros (l)</option>
												</select>
											</div>
											
											<!-- Campo estoque -->
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="estoque">Estoque:</label>
												<input id="estoque" type="number" min=0 max=9999999 class="form-control" pattern="[0-9]+" maxlength="7"  name="estoque" value="0">
											</div>
											
											<!-- Campo custo-->
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="custo">Custo:</label>
												<div class="input-group">
													<span class="input-group-addon">R$</span>
													<input id="custo" type="text" class="form-control" name="custo" max="999999" placeholder="0,00">
												</div>
											</div>

											<!-- Campo valor-->
											<div class="input-margin col-xs-12 col-sm-6 col-md-3">
												<label class="control-label" for="valor">Valor*:</label>
												<div class="input-group">
													<span class="input-group-addon">R$</span>
													<input id="valor" type="text" class="form-control" name="valor" maxlength="20"  placeholder="0,00" required>
												</div>
											</div>
											
											<!-- Campo para escrever algum observação-->
											<div class="input-margin col-xs-12 col-sm-12 col-md-12">
												<label class="control-label" for="obs">Observação:</label>
												<textarea class="form-control" name="obs" name="obs" id="obs" rows="3" placeholder="Digite aqui as observações"></textarea>
											</div>
										</div>
										<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
											FIM DA ABBA INFORMAÇÕES DO PRODUTO 
										+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
										
										<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
											INICIO DA ABA RECEITA 
										+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
										
										<div id="receita" class="tab-pane fade">
										
											<!-- Campo receita	-->
											<div class="input-margin col-xs-12 col-sm-12 col-md-12">
												<label class="control-label" for="rec">Receita</label>
												<textarea class="form-control" name="rec" name="rec" id="rec" rows="20" placeholder="Descreva a receita e o modo de preparo."></textarea>
											</div>
										
										</div>
										
										<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
											FIM DA ABA MATERIAS PRIMAS
										+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
										
										<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
											INICIO DA ABA MATERIAS PRIMAS
										+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
										
										<div id="materias-primas" class="tab-pane fade">	
											<!-- TABELA PARA INSERÇÃO DE MATÉRIA PRIMA	-->
											<table class="input-margin table display table-settings">
												<thead>
													<!-- Titulos das tabelas  -->
													<tr>
														<th>Nome</th>
														<th>Medida</th>
														<th>Unidade</th>
														<th>Ações</th>
													</tr>
												</thead>
												<tbody id="lista-materiaprima" >

													
												</tbody>
											</table>
											
											<!-- BOTÃO INSERIR LINHA -->
											<div class="row">
												<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
													
													<!-- botão incluir novo ingrediente -->
													<button class="btn btn-default fullwidth" id="inserir-linha"  >
														<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;&nbsp;Incluir novo ingrediente
													</button>

												</div>
											</div>

										</div>
										<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
											FIM DA ABA MATERIAS PRIMAS
										+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
									</div>



							</div>
						</div>
					</div>

					<!-- ################################# FIM DO CONTEUDO ################################# -->
					
					<!-- Esse div contem o 2 botões -->
					<div class="modal-footer">
						<!-- Esse div contem o 2 botões -->
						<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
						<!-- botão de incluir ou alterar o produto, assim finalizando o formulário  -->
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

	############################################################        MODAL DE EXCLUSÃO DE PRODUTO      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de produto -->
	<div class="modal fade" id="excluir-produto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- Envia o form para a url abaixo  -->
				<form id="produto-delete-form" action="administrativo-remover-produto" method="POST">
					
					<!--Essa div tem o título do modal, e o "X" de fechar o modal   -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir produto</h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<!-- Essa div contem o id do produto q vai ser excluido, porem ele fica escondido na tela, por causa da class hidden-->
								<div class="hidden">
									<label class="control-label" for="id">Nº produto:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>
								
								<!-- mensagem no corpo do modal -->	
								<p>Deseja realmente excluir o produto selecionado?</p>
							</div>
						</div>

						
					</div>

					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar a exclusão do produto-->
						<button type="button" class="btn btn-default" data-dismiss="modal">Não, quero manter</button>
						<!-- botão de confirmar a exclusão do produto -->
						<button type="submit" class="btn btn-default">Sim, quero excluir</button>
					</div>

				</form>
			</div>
		</div>
	</div>


	<!--

	############################################################ FIM DO  MODAL DE EXCLUSÃO DE PRODUTO ############################################################

	-->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/mask.js"></script>
    

	<script type="text/javascript">
		$(document).ready(function() {
			
			
			//Remove as mascaras quando apertar o submit
			$("#produto-form").submit(function() {
				var peso = $("#peso").val();
				peso = peso.split(".").join("");
				peso = peso.split(",").join(".");
				$("#peso").val(peso);
				
				var custo = $("#custo").val();
				custo = custo.split(".").join("");
				custo = custo.split(",").join(".");
				$("#custo").val(custo);
				
				var valor = $("#valor").val();
				valor = valor.split(".").join("");
				valor = valor.split(",").join(".");
				$("#valor").val(valor);
			});
			
			//Aplica as mascaras nos campos
			$('#peso').mask("0.000.000.000,000", {reverse: true});
			$("#custo").mask("000.000.000.000.000,00", {reverse: true});
			$("#valor").mask("000.000.000.000.000,00", {reverse: true});
			
			$('#file').on('change', function(){
				readURL(this);
			});
			
			function readURL(input){
				
				if (input.files && input.files[0]) {
		            var reader = new FileReader();
		            
		            reader.onload = function (e) {
		                $('#foto-view').attr('src', e.target.result);
		            }
		            
		            reader.readAsDataURL(input.files[0]);
		        }
				
			}
			
			var lista_materiaprima = $('#lista-materiaprima');
			//
			// INSERIR UMA LINHA NA TABELA
			//
            $('#inserir-linha').click(function() {
            	var tabela;
            	var linha;
            	var coluna;
            	var medida;
            	var materiaprima;
            	var option;
            	var unidade;

            	tabela = document.getElementById("lista-materiaprima");

            	    linha = document.createElement("tr");
                	linha.setAttribute("id", "item");

                		id_column = document.createElement("td");
            			id_column.setAttribute("class","hidden");
                		materiaprima_column = document.createElement("td");
                		medida_column = document.createElement("td");
                		unidade_column = document.createElement("td");
                		acoes_column = document.createElement("td");

                			id = document.createElement("input")
            			    id.setAttribute("type","text");
            			    id.setAttribute("id","id");
            			    id.setAttribute("name","id");
            			    id.setAttribute("class", "form-control");
            			    id.setAttribute("class", "readonly");

            				materiaprima = document.createElement("select");
            				materiaprima.setAttribute("class", "form-control");
            			    
            					option = document.createElement("option");
            					option.text = "Selecione...";
            					option.value = "";
            					option.setAttribute("disabled","disabled");
            					option.setAttribute("selected","selected");
            					materiaprima.appendChild(option);
            					for(var i=0; i<5; i++){
            						option = document.createElement("option");
            						option.text = "Materia prima "+i;
            						materiaprima.appendChild(option);
            					}

            				medida = document.createElement("input");
            			    medida.setAttribute("type","text");
            			    medida.setAttribute("name","medida");
            			    medida.setAttribute("class","form-control");

            				unidade = document.createElement("select");
            				unidade.setAttribute("class", "form-control");
            					option = document.createElement("option");
            					option.text = "Selecione...";
            					option.value = "";
            					option.setAttribute("disabled","disabled");
            					option.setAttribute("selected","selected");
            					unidade.appendChild(option);
            					for(var i=0; i<5; i++){
            						option = document.createElement("option");
            						option.text = "Unidade "+i;
            						unidade.appendChild(option);
            					}
            	
            		//Botão de ação salvar
            		salvar_btn = document.createElement("button");
            		salvar_btn.type = "button";
            		salvar_btn.setAttribute("id","salvar-itemmateriaprima");
            		salvar_btn.setAttribute("class","btn btn-default margin-right");
            		salvar_btn.innerHTML = "<i class='material-icons'>save</i>";
            		salvar_btn.onclick = salvar;

            		//Botão de ação de exclusão
            		excluir_btn = document.createElement("button");
            		excluir_btn.type = "button";
            		excluir_btn.setAttribute("id","delete-itemmateriaprima");
            		excluir_btn.setAttribute("class","btn btn-default");
            		excluir_btn.innerHTML = "<i class='material-icons'>clear</i>";
            		excluir_btn.onclick = excluir;

				
               	id_column.appendChild(id);
            	materiaprima_column.appendChild(materiaprima);
                medida_column.appendChild(medida);
                unidade_column.appendChild(unidade);	
            	acoes_column.appendChild(salvar_btn);
            	acoes_column.appendChild(excluir_btn);

            	linha.appendChild(id_column);
                linha.appendChild(materiaprima_column);
                linha.appendChild(medida_column);
                linha.appendChild(unidade_column);
                linha.appendChild(acoes_column);
                
				// ADICIONA OS VALORES NA TABELA
            	tabela.appendChild(linha);

                function salvar(){
                	for(i=0; i<linha.childNodes.length-1;i++){
                		 alert(linha.childNodes[i].firstChild.value);
                	}
            	}

            	function excluir(){
            		
            	    linha.remove();
            	}
            });
	
            
			/*
			*
			* INDICADOR DE PAGINA DO MENU
			*
			*/
			
			$('#menu-mob-produtos').addClass('active');
			$('#menu-produtos').addClass('active');

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//INVISÍVEL - Define que as colunas determinadas no "targes" não sejam visiveis para o usuáriO
            var table = $('#lista-produtos').DataTable({
                "columnDefs": [
                    {
                        //0 - id
                        //1 - foto
                        //2 - status
                        //5 - tipo
                        //6 - peso
                        //7 - unidade
                        //8 - estoque
                        //9 - custo
                        //10 - valor
                        //11 - obs
                        //12 - receita
                        "targets": [ 0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12],
                        "visible": false
                    }
                ]
            });
			

            /*
			*
			* INCLUSÃO DE PRODUTO
			*
			*/
			
			//quando o usuário clica no botão de incluir novo produto, ele abre o modal e chama essa função
            $('#incluir-produto-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo produto");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#produto-form").attr("action","administrativo-incluir-produto");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir produto');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#produto-form').each(function(){
					this.reset();
				});
				
				$('#foto-view').attr("src", "resources/img/produtos/model.png");
				
			});

            /*
			*
			* ALTERAÇÃO DE PRODUTO
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-produtos tbody').on( 'click', '#edit-produto', function () {

            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar produto");

            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#produto-form").attr("action","administrativo-alterar-produto");

				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 

				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

           		//Apresenta o modal de exclusão na tela.
           		$('#modal-produto').modal('show');

				//Preenche os determinados campos com os conteudos.
				$('#id').val(data[0]);
				$('#foto-view').attr("src", "resources/img/produtos/"+data[1]);
				$('#foto-inp').val(data[1]);
				$('#status').val(data[2]);
				$('#codigo').val(data[3]);
				$('#nome').val(data[4]);
				$('#tipo').val(data[5]);
				$('#peso').val(data[6]).trigger('input');
				$('#unidade').val(data[7]);
				$('#estoque').val(data[8]);
				$('#custo').val(data[9]).trigger('input');
				$('#valor').val(data[10]).trigger('input');
				$('#obs').val(data[11]);
				$('#rec').val(data[12]);

			});

			/*
			*
			* EXCLUSÃO DE PRODUTO
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
            $('#lista-produtos tbody').on( 'click', '#delete-produto', function () {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-produto').modal('show');

            });

        });

	</script>
	
	
</body>
</html>