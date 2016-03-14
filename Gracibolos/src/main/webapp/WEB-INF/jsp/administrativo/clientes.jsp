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
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Incluente armazenado com sucesso.
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
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar cliente:</label>
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
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
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
		                					<td>
		                						<button id="edit-cliente" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-cliente" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
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
	    	
	    		<form id="cliente-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">CLIENTES</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº cliente:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="status">Status:</label>
									<select id="status" name="status" class="form-control" required>
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tipopessoa">Pessoa:</label>
									<select id="tipopessoa" name="tipopessoa" onchange="desabilitarCampos(this)" class="form-control" required>
										<option selected value="0">Fisica</option>
										<option value="1">Jurídica</option>
									</select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									
									<label class="control-label" for="sexo">Sexo:</label>
									<select id="sexo" name="sexo" class="form-control" required>
										<option selected="selected" disabled="disabled" value="0">Selecione um sexo</option>
										<option value="1">Masculino</option>
										<option value="2">Feminino</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="datanascimento">Data Nascimento:</label>
									<input type="date" id="datanascimento" name="datanascimento" placeholder="Data de nascimento" class="form-control" />
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="nomerazao_lbl" id="nomerazao_lbl">Nome*:</label>
									<input type="text" id="nomerazao_inp" name="nomerazao" placeholder="Digite seu nome aqui." class="form-control" maxlength="100" required/>
								</div> 

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpfcnpj_inp" id="cpfcnpj_lbl">CPF*:</label>
									<input type="text" id="cpfcnpj_inp" name="cpfcnpj" placeholder="000.000.000-00" class="form-control" maxlength="11" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rgie_inp" id="rgie_lbl">RG:</label>
									<input type="text" id="rgie_inp" name="rgie" placeholder="00.000.000-0" class="form-control" maxlength="9"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="endereco">Endereço*:</label>
									<input type="text" id="endereco" name="endereco" placeholder="Digite aqui o seu endereço" class="form-control" maxlength="120" disabled required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-3 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
									<input type="text" id="numero" name="numero" placeholder="0" class="form-control" disabled required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="complemento">Complemento:</label>
									<input type="text" id="complemento" name="complemento" placeholder="Digite o complemento se houver" class="form-control" maxlength="120" disabled />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
									<input type="text" id="bairro" name="bairro" placeholder="Digite seu bairro" class="form-control" maxlength="60" disabled required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" id="estado" name="estado" disabled required >
										<option selected="selected" disabled="disabled" value="0">Selecione o estado</option>
										<c:forEach var="estado" items="${estados}">
											<option value="${estado.id}">${estado.sigla}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" id="cidade" name="cidade" disabled required >
										<option selected="selected" disabled="disabled" value="0">Selecione a cidade</option>
										<c:forEach var="cidade" items="${cidades}">
											<option value="${cidade.id}">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="cep">CEP*:</label>
									<input type="text" id="cep" name="cep" placeholder="00000-000" class="form-control" maxlength="8" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tel">Tel:</label>
									<input type="text" id="tel" name="tel" placeholder="(00) 0000-0000" class="form-control" maxlength="10"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cel">Cel:</label>
									<input type="text" id="cel" name="cel" placeholder="(00) 00000-0000" class="form-control" maxlength="11" />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="email">E-mail:</label>
									<input type="email" id="email" name="email" class="form-control" placeholder="email@provedor.com.br" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="site">Site:</label>
									<input type="text" id="site" name="site" class="form-control" placeholder="www.site.com.br" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="clientedesde">Cliente Desde:</label>
									<input type="date" id="clientedesde" name="clientedesde" class="form-control" />
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">Observações:</label>
									<textarea id="obs" name="obs" class="form-control" placeholder="Insira uma observação sobre o cliente"></textarea>
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

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE CLIENTE #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE CLIENTE      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de cliente -->
	<div class="modal fade" id="excluir-cliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="cliente-delete-form" action="administrativo-remover-cliente" method="POST">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir cliente</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº cliente:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>

								<p>Deseja realmente excluir o cliente selecionado?</p>
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

	############################################################ FIM DO  MODAL DE EXCLUSÃO DE CLIENTE ############################################################

	-->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/maskedinput.js"></script>
	<script src="resources/js/scripts.js"></script>
	
    

	<script type="text/javascript">
		$(document).ready(function() {
	
			$("#cep").mask("99999-999");
			$("#cpfcnpj_inp").mask("999.999.999-99");
			$("#tel").mask("(99) 9999-9999");
			$("#cel").mask("(99) 99999-9999");
			
			$('#tipopessoa').on('change', function(){
				if($('#tipopessoa').val() == 0){
					$("#cpfcnpj_inp").mask("999.999.999-99");
				} else {
					$("#cpfcnpj_inp").mask("99.999.999/9999-99");
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
            
            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {
				
            	$("#endereco").prop( "disabled", false );
            	$("#numero").prop( "disabled", false );
            	$("#complemento").prop( "disabled", false ); 
            	$("#bairro").prop( "disabled", false );
                $("#cidade").prop( "disabled", false );
                $("#estado").prop( "disabled", false );
            	
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
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
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
                ]
            });

            /*
			*
			* INCLUSÃO DE CLIENTE
			*
			*/

            $('#incluir-cliente-modal').click(function() {
            	
            	$("#endereco").prop( "disabled", true );
            	$("#numero").prop( "disabled", true );
            	$("#complemento").prop( "disabled", true); 
            	$("#bairro").prop( "disabled", true );
                $("#cidade").prop( "disabled", true );
                $("#estado").prop( "disabled", true );
            	
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
            	
            	$("#endereco").prop( "disabled", false );
            	$("#numero").prop( "disabled", false );
            	$("#complemento").prop( "disabled", false ); 
            	$("#bairro").prop( "disabled", false );
                $("#cidade").prop( "disabled", false );
                $("#estado").prop( "disabled", false );
            	
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

					//Preenche os determinados campos com os conteudos.
                    $('#id').val(data[0]);
                    $('#status').val(data[1]);
                    $('#tipopessoa').val(data[2]);
                    $('#sexo').val(data[3]);
                    $('#datanascimento').val(data[4]);
    				$('#nomerazao_inp').val(data[5]);
    				$('#cpfcnpj_inp').val(data[6]);
                    $('#rgie_inp').val(data[7]);
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
                    $('#site').val(data[18]);
                    $('#clientedesde').val(data[19]);
    				$('#obs').val(data[20]);
					
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