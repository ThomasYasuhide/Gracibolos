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
	<title>Graci Bolos | Fornecedores</title>

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
						<h2 class="">Fornecedores</h2>
						<h4 class="">Lista de fornecedores</h4>
					</header>

					<hr/>

					<!-- ############################################################ CONTEUDO ############################################################ -->


					<!-- ################################# ALERTAS ################################# -->
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Fornecedor armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir o novo fornecedor, favor tente novamente.
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
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar o fornecedor, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Fornecedor foi excluido com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir o fornecedor, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar fornecedores:</label>
							<form action="administrativo-pesquisar-fornecedor" method="POST">
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
							<table id="lista-fornecedores" class="table table-hover display" cellspacing="0" width="100%">
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
										<th>Observaçoes</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="fornecedor" items="${fornecedores}">
										<tr>
											<td>${fornecedor.id}</td>
											<td>${fornecedor.status}</td>
											<td>${fornecedor.tipopessoa}</td>
											<td>${fornecedor.sexo}</td>
											<td>${fornecedor.datanascimento}</td>
											<td>${fornecedor.nomerazao}</td>
											<td>${fornecedor.cpfcnpj}</td>
											<td>${fornecedor.rgie}</td>
											<td>${fornecedor.endereco}</td>
											<td>${fornecedor.numero}</td>
											<td>${fornecedor.complemento}</td>
											<td>${fornecedor.bairro}</td>
											<td>${fornecedor.estado}</td>
											<td>${fornecedor.cidade}</td>
											<td>${fornecedor.cep}</td>
											<td>${fornecedor.tel}</td>
											<td>${fornecedor.cel}</td>
											<td>${fornecedor.email}</td>
											<td>${fornecedor.site}</td>
											<td>${fornecedor.obs}</td>
		                					<td>
		                						<button id="edit-fornecedor" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-fornecedor" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
							<a href="" id="incluir-fornecedor-modal" data-toggle="modal" data-target="#modal-fornecedor" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo fornecedor</a>
						</div>
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>

	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DE FORNECEDOR ############################################################

	-->
	<div class="modal fade" id="modal-fornecedor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<form id="fornecedor-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">FORNECEDORES</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº fornecedor:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>
								
								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
									<label class="control-label" for="tipopessoa">Status:</label>
									<select id="status" name="status" class="form-control">
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>

								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
									<label class="control-label" for="tipopessoa">Pessoa:</label>
									<select id="tipopessoa" name="tipopessoa" onchange="desabilitarCampos(this)" class="form-control" required>
										<option selected value="0">Fisica</option>
										<option value="1">Jurídica</option>
									</select>
								</div>
								
								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
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
									<label class="control-label" for="nomerazao_inp" id="nomerazao_lbl">Nome*:</label>
									<input type="text" id="nomerazao_inp" name="nomerazao" placeholder="Digite seu nome aqui." class="form-control" maxlength="100" required/>
								</div> 

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpfcnpj_inp" id="cpfcnpj_lbl">CPF*:</label>
									<input type="text" id="cpfcnpj_inp" name="cpfcnpj" placeholder="000.000.000-00" class="form-control" maxlength="14" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rgie_inp" id="rgie_lbl">RG:</label>
									<input type="text" id="rgie_inp" name="rgie" placeholder="00.000.000-0" class="form-control" maxlength="12"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="endereco">Endereço*:</label>
									<input type="text" id="endereco" name="endereco" placeholder="Digite aqui o seu endereço" class="form-control" maxlength="120" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-3 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
									<input type="text" id="numero" name="numero" placeholder="0000" class="form-control" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="complemento">Complemento:</label>
									<input type="text" id="complemento" name="complemento" placeholder="Digite o complemento se houver" class="form-control" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
									<input type="text" id="bairro" name="bairro" placeholder="Digite seu bairro" class="form-control" maxlength="60" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-2 col-md-3">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" id="estado" name="estado" required >
										<option selected="selected" disabled="disabled" value="0">Selecione o estado</option>
										<c:forEach var="estado" items="${estados}">
											<option value="${estado.id}">${estado.sigla}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" id="cidade" name="cidade" required >
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
									<input type="text" id="email" name="email" class="form-control" placeholder="email@provedor.com.br" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="site">Site:</label>
									<input type="text" id="site" name="site" class="form-control" placeholder="www.site.com.br" maxlength="120"/>
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

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE FORNECEDOR #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE FORNECEDOR      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de fornecedor -->
	<div class="modal fade" id="excluir-fornecedor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="fornecedor-delete-form" action="administrativo-remover-fornecedor" method="POST">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir fornecedor</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº fornecedor:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" />
								</div>

								<p>Deseja realmente excluir o fornecedor selecionado?</p>
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

	############################################################ FIM DO  MODAL DE EXCLUSÃO DE FORNECEDOR ############################################################

	-->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/scripts.js"></script>
    

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
			
			$('#menu-mob-fornecedores').addClass('active');
			$('#menu-fornecedores').addClass('active');

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-fornecedores').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 1, 2, 3, 4, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE FORNECEDOR
			*
			*/

            $('#incluir-fornecedor-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo fornecedor");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#fornecedor-form").attr("action","administrativo-incluir-fornecedor");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir fornecedor');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#fornecedor-form').each(function(){
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
			* ALTERAÇÃO DE FORNECEDOR
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-fornecedores tbody').on( 'click', '#edit-fornecedor', function () {
            	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar fornecedor");
            	
            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#fornecedor-form").attr("action","administrativo-alterar-fornecedor");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();
                
                //Passa o ID da cidade e caso existe executa a função callback para abrir o modal e preencher os campos com os dados.
              	listar_cidades(data[9], function(){

              		//Apresenta o modal de exclusão na tela.
              		$('#modal-fornecedor').modal('show');
					
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
    				$('#obs').val(data[19]);
					
                    desabilitarCampos(document.getElementById("tipopessoa"));
                });

			});

			/*
			*
			* EXCLUSÃO DE FORNECEDOR
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
            $('#lista-fornecedores tbody').on( 'click', '#delete-fornecedor', function() {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-fornecedor').modal('show');

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