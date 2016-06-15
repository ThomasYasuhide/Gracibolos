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
	<title>Graci Bolos | Clientes</title>

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
						<h2 class="">CLIENTES</h2>
						<h4 class="">Lista de clientes</h4>
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
								  <strong>Sucesso!</strong> Cliente armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir o novo cliente, favor tente novamente.
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
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar o cliente, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Cliente foi excluido com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir o cliente, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<!-- Essa div agrupa os campos de pesquisa e de listar os clientes -->
					<div class="row">
						<!-- Campo de pesquisar os clientes -->
						<div class="input-margin col-xs-12 col-sm-9 col-md-9 col-lg-9">
							<label class="control-label">Pesquisar cliente:</label>
							<!-- Quando clicar no botão envia o form para a url abaixo -->
							<form action="administrativo-pesquisar-cliente" method="POST">
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
						<!-- Esse botão lista todos os clientes -->
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">
							<label class="control-label hidden-xs">Listar clientes</label>
							<!-- Quando clicar no botão direciona a página para a url abaixo -->
							<a href="administrativo-listar-clientes" class="btn btn-default fullwidth">Listar clientes</a>
						</div>						
					</div>
					
					<!-- Essa div agrupa os títulos das tabelas, e os resultados das pesquisas -->
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<!-- tabela da lista de clientes  -->
							<table id="lista-clientes" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Status</th>
										<th>Pessoa</th>
										<th>Sexo</th>
										<th>Data Nascimento</th>
										<th>Nome / Razão Social</th>
										<th>CPF / CNPJ</th>
										<th>RG / IE</th>
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
										<th>Site</th>
										<th>Cliente desde</th>
										<th>Observaçoes</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="cliente" items="${clientes}">
										<tr>
											<td>${cliente.id}</td>
											<td>${cliente.status}</td>
											<td>${cliente.tipopessoa}</td>
											<td>${cliente.sexo}</td>
											<td>${cliente.datanascimento}</td>
											<td>${cliente.nomerazao}</td>
											<td>${cliente.cpfcnpj}</td>
											<td>${cliente.rgie}</td>
											<td>${cliente.endereco}</td>
											<td>${cliente.numero}</td>
											<td>${cliente.complemento}</td>
											<td>${cliente.bairro}</td>
											<td>${cliente.estado}</td>
											<td>${cliente.cidade}</td>
											<td>${cliente.cep}</td>
											<td>${cliente.tel}</td>
											<td>${cliente.cel}</td>
											<td>${cliente.email}</td>
											<td>${cliente.site}</td>
											<td>${cliente.clientedesde}</td>
											<td>${cliente.obs}</td>
											
											<!-- Aqui nessa td, estão os botões de editar e excluir, que aparecem junto com a lista de clientes na tabela -->
		                					<td>
		                						<button id="edit-cliente" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-cliente" class="btn btn-xs btn-default "><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<!--Essa div tem o botão de abrir o modal "incluir novo cliente" -->
					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-4">
							<a href="" id="incluir-cliente-modal" data-toggle="modal" data-target="#modal-cliente" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo cliente</a>
						</div>
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>

	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DE CLIENTE ############################################################

	-->
	<div class="modal fade" id="modal-cliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<!-- formulário de preencher os dados do cliente -->
	    		<form id="cliente-form" method="POST">
	    			
	    			<!--Essa div tem o título e subtítulo do modal, e o "X" de fechar o modal   -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">CLIENTES</h3>
						<h4 id="modal-subtitle"></h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
						
							<div id="alertas" class="col-xs-12"></div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								
								<div class="hidden">
									<label class="control-label" for="id">Nº cliente:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>
								
								<!-- campo status-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="status">Status:</label>
									<select id="status" name="status" class="form-control" required>
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>
								
								<!-- Tipo de pessoa -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tipopessoa">Pessoa:</label>
									<select id="tipopessoa" name="tipopessoa" onchange="desabilitarCampos(this)" class="form-control" required>
										<option selected value="0">Fisica</option>
										<option value="1">Jurídica</option>
									</select>
								</div>
								
								<!-- Qual o sexo -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">									
									<label class="control-label" for="sexo">Sexo:</label>
									<select id="sexo" name="sexo" class="form-control" required>
										<option selected="selected" disabled="disabled" value="0">Selecione um sexo</option>
										<option value="1">Masculino</option>
										<option value="2">Feminino</option>
									</select>
								</div>
								
								<!-- Define a data de nascimento -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="datanascimento">Data Nascimento:</label>
									<input type="date" id="datanascimento" name="datanascimento" placeholder="Data de nascimento" class="form-control" />
								</div>
								
								<!-- Campo nome/nomerazao -->
								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="nomerazao_lbl" id="nomerazao_lbl">Nome*:</label>
									<input type="text" id="nomerazao_inp" name="nomerazao" placeholder="Digite seu nome aqui." class="form-control" maxlength="100" required/>
								</div> 
								
								<!-- Campo cpf/cnpj -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpfcnpj_inp" id="cpfcnpj_lbl">CPF*:</label>
									<input type="text" id="cpfcnpj_inp" name="cpfcnpj" placeholder="000.000.000-00" class="form-control cpfcnpj_inp" maxlength="14" required/>
								</div>
								
								<!-- Campo rg/ie -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rgie_inp" id="rgie_lbl">RG:</label>
									<input type="text" id="rgie_inp" name="rgie" placeholder="00.000.000-0" class="form-control" maxlength="9"/>
								</div>
								
								<!-- Campo  cep-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="cep">CEP*:</label>
									<input type="text" id="cep" name="cep" placeholder="00000-000" class="form-control" maxlength="9" required/>
								</div>
								
								<!-- Campo  endereço -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="endereco">Endereço*:</label>
									<input type="text" id="endereco" name="endereco" placeholder="Digite aqui o seu endereço" class="form-control" maxlength="120" required/>
								</div>
								
								<!-- Campo número da casa -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
									<input type="text" id="numero" name="numero" placeholder="0" class="form-control" required/>
								</div>
								
								<!-- Campo complemento da casa -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="complemento">Complemento:</label>
									<input type="text" id="complemento" name="complemento" placeholder="Digite o complemento se houver" class="form-control" maxlength="120"  />
								</div>
								
								<!-- Campo bairro -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
									<input type="text" id="bairro" name="bairro" placeholder="Digite seu bairro" class="form-control" maxlength="60" required/>
								</div>

								<!-- Campo estado-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" id="estado" name="estado" required >
										<option selected="selected" disabled="disabled" value="0">Selecione o estado</option>
										<c:forEach var="estado" items="${estados}">
											<option value="${estado.id}">${estado.sigla}</option>
										</c:forEach>
									</select>
								</div>
								
								<!-- Campo  cidade-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" id="cidade" name="cidade" required >
										<option selected="selected" disabled="disabled" value="0">Selecione a cidade</option>
										<c:forEach var="cidade" items="${cidades}">
											<option value="${cidade.id}">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>
								
								<!-- Campo telefone fixo-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tel">Tel:</label>
									<input type="text" id="tel" name="tel" placeholder="(00) 0000-0000" class="form-control" maxlength="14"/>
								</div>

								<!-- Campo celular-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cel">Cel:</label>
									<input type="text" id="cel" name="cel" placeholder="(00) 00000-0000" class="form-control" maxlength="15" />
								</div>

								<!-- Campo email-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="email">E-mail:</label>
									<input type="email" id="email" name="email" class="form-control" placeholder="email@provedor.com.br" maxlength="120"/>
								</div>

								<!-- Campo site-->
								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="site">Site:</label>
									<input type="text" id="site" name="site" class="form-control" placeholder="www.site.com.br" maxlength="120"/>
								</div>
								
								<!-- define desde quando "data" a pessoa é cliente -->
								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="clientedesde">Cliente Desde:</label>
									<input type="date" id="clientedesde" name="clientedesde" class="form-control" readonly />
								</div>
								
								<!-- Campo para escrever algum observação-->
								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">Observações:</label>
									<textarea id="obs" name="obs" class="form-control" placeholder="Insira uma observação sobre o cliente"></textarea>
								</div>
							</div>
						</div>
					</div>

					<!-- ################################# FIM DO CONTEUDO ################################# -->
					
					<!-- Esse div contem o 2 botões -->
					<div class="modal-footer">
						<!-- botão de fechar o modal  -->
						<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
						<!-- botão de incluir ou alterar o cliente, assim finalizando o formulário  -->
						<button type="submit" class="btn btn-default" id="modal-action"></button>
					</div>
					
				</form>
			</div>
		</div>
	</div>

	<!--

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE CLIENTE #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE CLIENTE      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de cliente -->
	<div class="modal fade" id="excluir-cliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- Envia o form para a url abaixo  -->
				<form id="cliente-delete-form" action="administrativo-remover-cliente" method="POST">
					
					<!--Essa div tem o título do modal, e o "X" de fechar o modal   -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir cliente</h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<!-- Essa div contem o id do cliente q vai ser excluido, porem ele fica escondido na tela, por causa da class hidden-->	
								<div class="hidden">
									<label class="control-label" for="id">Nº cliente:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>
								
								<!-- mensagem no corpo do modal -->	
								<p>Deseja realmente excluir o cliente selecionado?</p>
							</div>
						</div>

						
					</div>
					
					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar a exclusão do cliente-->
						<button type="button" class="btn btn-default" data-dismiss="modal">Não, quero manter</button>
						<!-- botão de confirmar a exclusão do cliente -->
						<button type="submit" class="btn btn-default">Sim, quero excluir</button>
					</div>

				</form>
			</div>
		</div>
	</div>


	<!--

	############################################################ FIM DO  MODAL DE EXCLUSÃO DE CLIENTE ############################################################

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
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/moment.js"></script>
    <script src="resources/js/cpfcnpj.js"></script>
	<script src="resources/js/scripts.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			//Valida o cpf ou cnpj
			$('#cpfcnpj_inp').cpfcnpj({
                mask: true,
                validate: 'cpfcnpj',
                event: 'blur',
                handler: '#cpfcnpj_inp',
                ifValid: function () { },//-----------------------------------------------------------------------------------------
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
                    $('#cpfcnpj_inp').val(""); 
                }
            });
			
			//Remove as mascaras quando apertar o submit
			$("#cliente-form").submit(function() {
				$("#cep").unmask();
				$("#cpfcnpj_inp").unmask();
				$("#tel").unmask();
				$("#cel").unmask();
			});
			
			//Aplica as mascaras nos campos
			$("#cep").mask("00000-000");
			$("#cpfcnpj_inp").mask("000.000.000-00");
			$("#tel").mask("(00) 0000-0000");
			$("#cel").mask("(00) 00000-0000");
			
			//Altera o tipo da mascara quando o usuário muda o tipo de pessoa
			$('#tipopessoa').on('change', function(){
				if($('#tipopessoa').val() == 0){
					$("#cpfcnpj_inp").mask("000.000.000-00");
				} else {
					$("#cpfcnpj_inp").mask("00.000.000/0000-00");
				}
			});
			
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

//-------Busca de cep---------------------------------------------------------------------------------------------------------------------------------------
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
                        $("#estado").val("Pesquisando...")
                        $("#cidade").val("Pesquisando...")

                        //Consulta o webservice viacep.com.br/
                        //Ex: http://www.viacep.com.br/ws/04673070/json/?callback=?
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
                        });// FIM getJason
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
//----------fim da busca de cep------------------------------------------------------------------------------------------------------------------------------------			
			
			
			

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
			
			$('#menu-mob-clientes').addClass('active');
			$('#menu-clientes').addClass('active');

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-clientes').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 1, 2, 3, 4, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
                        "visible": false
                    }
                ],
                //Em ordem alfabética
                "order": [[ 5, "asc" ]]
            });

            /*
			*
			* INCLUSÃO DE CLIENTE
			*
			*/
			
			//quando o usuário clica no botão de incluir novo cliente, ele abre o modal e chama essa função
            $('#incluir-cliente-modal').click(function() {
            	
    			$("#cpfcnpj_inp").mask("000.000.000-00");
            	          
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo cliente");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#cliente-form").attr("action","administrativo-incluir-cliente");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir cliente');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#cliente-form').each(function(){
					this.reset();
				});
				
				var now = moment().format('YYYY-MM-DD');
                $('#clientedesde').val(now);
				
				//Este método se encontra no arquivo scripts.js
				//Desabilita e habilita os campos NOME RAZÃO CPF CNPJ RG IE SEXO DATANASCIMENTO
                desabilitarCampos(document.getElementById("tipopessoa"));
				
				//Remove todas as opções do combo cidade.
				combo_cidade.find('option').remove();
				
				//Adiciona opção onde solicita que o usuário selecione uma cidade.
				combo_cidade.append($('<option></option>').val(0).html("Selecione a cidade").attr('disabled','disabled').attr('selected','selected'));
			});

            /*
			*
			* ALTERAÇÃO DE CLIENTE
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-clientes tbody').on( 'click', '#edit-cliente', function () {
            	           	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar cliente");
            	
            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#cliente-form").attr("action","administrativo-alterar-cliente");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Passa o ID da cidade e caso existe executa a função callback para abrir o modal e preencher os campos com os dados.
              	listar_cidades(data[12], function(){
             	
              		//Apresenta o modal de exclusão na tela.
              		$('#modal-cliente').modal('show');

//------------------Coloca os valores nos campos ao abrir a modal----------------------------------------------------------------------------------------------------------------------------
                    $('#id').val(data[0]);
                    $('#status').val(data[1]);
                    $('#tipopessoa').val(data[2]);
                    $('#sexo').val(data[3]);
                    $('#datanascimento').val(data[4]);
    				$('#nomerazao_inp').val(data[5]);
    				
    				/* aqui define qual vai ser o tipo de máscara,
    				   se for cpf é um tipo, se for cnpj é outro tipo*/   				
    				if(data[2] == 0){
    					$("#cpfcnpj_inp").mask("000.000.000-00");
    				} else {
    					$("#cpfcnpj_inp").mask("00.000.000/0000-00");
    				}

    				
    				$('#cpfcnpj_inp').val(data[6]).trigger('input');   				
                    $('#rgie_inp').val(data[7]);
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
                    $('#site').val(data[18]);
                    $('#clientedesde').val(data[19]);
    				$('#obs').val(data[20]);
//----------------------------------------------------------------------------------------------------------------------------------------------					    				
                    desabilitarCampos(document.getElementById("tipopessoa"));

                });

			});

			/*
			*
			* EXCLUSÃO DE CLIENTE
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
            $('#lista-clientes tbody').on( 'click', '#delete-cliente', function () {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-cliente').modal('show');

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