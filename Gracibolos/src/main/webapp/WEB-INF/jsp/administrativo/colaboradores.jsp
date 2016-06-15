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
	<title>Graci Bolos | Colaboradores</title>

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
						<h2 class="">COLABORADORES</h2>
						<h4 class="">Lista de colaboradores</h4>
					</header>

					<hr/>

					<!-- ############################################################ CONTEUDO ############################################################ -->


					<!-- ################################# ALERTAS ################################# -->
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Colaborador armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir o novo colaborador, favor tente novamente.
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
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar o colaborador, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Colaborador foi excluido com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir o colaborador, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-9 col-md-9 col-lg-9">
							<label class="control-label">Pesquisar colaborador:</label>
							<form action="administrativo-procurar-colaborador" method="POST">
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o nome, CPF ou RG para realizar a pesquisa." name="pesquisa" id="pesquisa" required />
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">
											<span class="glyphicon glyphicon-search disabled"></span>
										</button>
									</span>
								</div>
							</form>
						</div>
						
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">
							<label class="control-label hidden-xs">Listar colaboradores</label>
							<a href="administrativo-listar-colaboradores" class="btn btn-default fullwidth">Listar colaboradores</a>
						</div>
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-colaboradores" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Status</th>
										<th>Nivel</th>
										<th>Usuário</th>
										<th>Senha</th>
										<th>Nome</th>
										<th>CPF</th>
										<th>RG</th>
										<th>Endereço</th>
										<th>Nº</th>
										<th>Complemento</th>
										<th>Bairro</th>
										<th>Estado</th>
										<th>Cidade</th>
										<th>CEP</th>
										<th>Telefone</th>
										<th>Celular</th>
										<th>E-mail</th>
										<th>Observaçoes</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="colaborador" items="${colaboradores}">
										<tr>
											<td>${colaborador.id}</td>
											<td>${colaborador.status}</td>
											<td>${colaborador.nivel}</td>
											<td>${colaborador.usuario}</td>
											<td>${colaborador.senha}</td>
											<td>${colaborador.nome}</td>
											<td>${colaborador.cpf}</td>
											<td>${colaborador.rg}</td>
											<td>${colaborador.endereco}</td>
											<td>${colaborador.numero}</td>
											<td>${colaborador.complemento}</td>
											<td>${colaborador.bairro}</td>
											<td>${colaborador.estado}</td>
											<td>${colaborador.cidade}</td>
											<td>${colaborador.cep}</td>
											<td>${colaborador.tel}</td>
											<td>${colaborador.cel}</td>
											<td>${colaborador.email}</td>
											<td>${colaborador.obs}</td>
		                					<td>
		                						<button id="edit-colaborador" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-colaborador" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-4">
							<a href="" id="incluir-colaborador-modal" data-toggle="modal" data-target="#modal-colaborador" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo colaborador</a>
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
	<div class="modal fade" id="modal-colaborador" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<form id="colaborador-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">COLABORADORES</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							
							<div id="alertas" class="col-xs-12"></div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº colaborador:</label>
			<!-- id="id" -->  		<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="status">Status:</label>
									<select id="status" name="status" class="form-control" required>
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="nivel">Acesso:</label>
									<select id="nivel" name="nivel" class="form-control" required>
										<option selected value="1">Atendente</option>
										<option value="2">Administrador</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="telefone">Usuario*:</label>
		<!-- id="usuario" --> 		<input type="text" id="usuario" name="usuario" placeholder="Digite o seu usuário" class="form-control" maxlength="20" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="celular">Senha*:</label>
		<!-- id="senha" -->		<input type="password" id="senha" name="senha" placeholder="Senha" class="form-control" maxlength="20" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="nome" id="nome_lbl">Nome*:</label>
		<!-- id="nome" -->			<input type="text" id="nome" name="nome" placeholder="Digite seu nome aqui" class="form-control" maxlength="100" required/>
								</div> 

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpf" id="cpf_lbl">CPF*:</label>
		<!-- id="cpf" -->			<input type="text" id="cpf" name="cpf" placeholder="000.000.000-00" class="form-control" maxlength="14" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rg" id="rg_lbl">RG:</label>
		<!-- id="rg" -->			<input type="text" id="rg" name="rg" placeholder="00.000.000-0" class="form-control" maxlength="9"/>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="cep">CEP*:</label>
		<!-- id="cep" -->			<input type="text" id="cep" name="cep" placeholder="00000-000" class="form-control" maxlength="9" required/>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="endereco">Endereço*:</label>
	<!-- id="endereco" -->			<input type="text" id="endereco" name="endereco" placeholder="Digite aqui o seu endereço" class="form-control" maxlength="120" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
		<!-- id="numero" -->		<input type="text" id="numero" name="numero" placeholder="0000" class="form-control" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="complemento">Complemento:</label>
	<!-- id="complemento" -->		<input type="text" id="complemento" name="complemento" placeholder="Digite o complemento se houver" class="form-control" maxlength="120" />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
		<!-- id="bairro" -->		<input type="text" id="bairro" name="bairro" placeholder="Digite seu bairro" class="form-control" maxlength="60" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-2 col-md-3">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" id="estado" name="estado" required >
										<option selected="selected" disabled="disabled" value="0">Selecione o estado</option>
			<!-- id="estado" -->			<c:forEach var="estado" items="${estados}">
											<option value="${estado.id}">${estado.sigla}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-4 col-md-6">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" id="cidade" name="cidade" required >
										<option selected="selected" disabled="disabled" value="0">Selecione a cidade</option>
			<!-- id="cidade" -->			<c:forEach var="cidade" items="${cidades}">
											<option value="${cidade.id}">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>
								

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tel">Tel:</label>
			<!-- id="tel" -->		<input type="text" id="tel" name="tel" placeholder="(00) 0000-0000" class="form-control" maxlength="14"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cel">Cel:</label>
			<!-- id="cel" -->		<input type="text" id="cel" name="cel" placeholder="(00) 00000-0000" class="form-control" maxlength="15" />
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="email">E-mail:</label>
		<!-- id="email" -->			<input type="email" id="email" name="email" class="form-control" placeholder="email@provedor.com.br" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">Observações:</label>
		<!-- id="obs" -->			<textarea id="obs" name="obs" class="form-control" placeholder="Insira uma observação sobre o colaborador"></textarea>
								</div>
							</div>
						</div>
					</div>

					<!-- ################################# FIM DO CONTEUDO ################################# -->

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
						<button type="submit" class="btn btn-default" id="modal-action"></button>
						<!-- JQuery
							$("#colaborador-form").attr("action","administrativo-incluir-colaborador"); 
						-->
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
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
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
<!--

######################################################### modal de errro ########################################################################

-->

<!-- Modal de erro -->
	<div class="modal fade" id="modal_erro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">Atenção! ocorreu algum erro!</h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<!-- mensagem no corpo do modal -->	
								<p id="erro_msg"></p>
							</div>
						</div>
					</div>
					
					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar-->
						<button id="btn_erro" type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					</div>

				
			</div>
		</div>
	</div>


	<!--

	############################################################ fim do modal de erro ############################################################
	-->

	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/cpfcnpj.js"></script>
    
	<script type="text/javascript">
		$(document).ready(function() {
			
			//Valida o cpf
			$('#cpf').cpfcnpj({
                mask: true,
                validate: 'cpf',
                event: 'blur',
                handler: '#cpf',
                ifValid: function () { },
                ifInvalid: function () { 

                	var erro = '<div class="alert alert-warning  alert-dismissible fade in" role="alert">';
					erro +='<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
					erro +='<strong>Atenção!</strong> CPF ou CNPJ inválido, favor tente novamente.';
						erro +='</div>';
					
					$('#alertas').append(erro);
					
					setTimeout(function(){
						$('.alert').alert('close');
					}, 5000);
                    
                	//$('#modal_erro').modal('show');
                    //$('#erro_msg').text('CPF ou CNPJ inválido, favor tente novamente.');
                    $('#cpf').val("");
                }
            });
			
			//Remove as mascaras quando apertar o submit
			$("#colaborador-form").submit(function() {
				$("#cep").unmask();
				$("#cpf").unmask();
				$("#tel").unmask();
				$("#cel").unmask();
			});
			
			//Aplica as mascaras nos campos
			$("#cep").mask("00000-000");
			$("#cpf").mask("000.000.000-00");
			$("#tel").mask("(00) 0000-0000");
			$("#cel").mask("(00) 00000-0000");
						
			function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#endereco").val("");
                $("#bairro").val("");
                $("#estado").val(0);
              	//Remove todas as opções do combo cidade.
				combo_cidade.find('option').remove();
				
				//Adiciona opção onde solicita que o usuário selecione uma cidade.
				combo_cidade.append($('<option></option>').val(0).html("Selecione a cidade").attr('disabled','disabled').attr('selected','selected'));
            }
            
            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {
				
                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "Pesquisando..." enquanto consulta webservice.
                        $("#endereco").val("Pesquisando...")
                        $("#bairro").val("Pesquisando...")

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#endereco").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                
                                $("#estado option").filter(function() {
                                    return $(this).text() == dados.uf;
                                }).prop("selected", true);
                                
                                listar_cidades(combo_estado.val(), function(){
                                	$("#cidade option").filter(function() {
                                        return $(this).text() == dados.localidade;
                                    }).prop("selected", true);
                                });
                                
                            } //end if.
                            else {

                            	var erro = '<div class="alert alert-warning  alert-dismissible fade in" role="alert">';
    							erro +='<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
    							erro +='<strong>Atenção!</strong> O CEP digitado não foi encontrado, favor tente novamente.';
		    						erro +='</div>';
		    					
		    					$('#alertas').append(erro);
		    					
		    					setTimeout(function(){
		    						$('.alert').alert('close');
		    					}, 5000);
		    					
                            	//CEP pesquisado não foi encontrado.                            
                                //$('#modal_erro').modal('show');
                              	//Altera dinamicamente o titulo do modal.
                				//$('#erro_msg').text("O CEP digitado não foi encontrado, favor tente novamente.");
                				$('#cep').val('');
                				$('#endereco').val('');
                				$('#bairro').val('');
                				$('#cidade').val(0);
                				$('#estado').val(0);
                            }
                        });
                    } //end if.
                    else {

                    	var erro = '<div class="alert alert-warning  alert-dismissible fade in" role="alert">';
						erro +='<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
						erro +='<strong>Atenção!</strong> Formato de CEP inválido.';
    						erro +='</div>';
    					
    					$('#alertas').append(erro);
    					
    					setTimeout(function(){
    						$('.alert').alert('close');
    					}, 5000);
    					
                    	//cep é inválido.                       
       					//modal de erro
                        //$('#modal_erro').modal('show');
                        //$('#erro_msg').text("ERRO! Formato de CEP inválido.");
                        $('#cep').val('');
                    }
                } //end if.
                else {
                	//cep sem valor, limpa formulário.
                    $('#cep').val('');
                }
            });
			
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
				//CHAMADA PARA A CONTROLLER INCLUIR COLABORADOR
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
            	
            	//CHAMADA PARA A CONTROLLER.
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
    				$('#cpf').val(data[6]).trigger('input');
                    $('#rg').val(data[7]);
                    $('#endereco').val(data[8]);
                    $('#numero').val(data[9]);
    				$('#complemento').val(data[10]);
    				$('#bairro').val(data[11]);
    				$('#estado').val(data[12]);
                    $('#cidade').val(data[13]);
                    $('#cep').val(data[14]).trigger('input');
                    $('#tel').val(data[15]).trigger('input');
    				$('#cel').val(data[16]).trigger('input');
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