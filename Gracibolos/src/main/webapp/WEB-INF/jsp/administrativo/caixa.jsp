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
								  <strong>Sucesso!</strong> pagamento armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir o novo pagamento, favor tente novamente.
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
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar o pagamento, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Pagamento foi excluido com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir o pagamento, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar pagamento:</label>
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
										<th>Tipo ID</th>
										<th>Numero ID</th>
										<th>Recebido / Gasto</th>
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
											<td>${caixa.tipoId}</td>
											<td>${caixa.numeroId}</td>
											<td>${caixa.recebidoGasto}</td>
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
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
							<a href="" id="incluir-caixa-modal" data-toggle="modal" data-target="#modal-caixa" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo pagamento</a>
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

								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="tipoId">Tipo ID:</label>
									<select id="tipoId" name="tipoId" onchange="desabilitarCampos(this)" class="form-control" required>
										<option selected value="0">Encomenda</option>
										<option value="1">Matéria Prima</option>
									</select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="numeroId">Número ID*:</label>
									<input id="numeroId" type="text" class="form-control" name="numeroId" maxlength="20" placeholder="0000" required>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="recebidoGasto_inp" id="recebidoGasto_lbl">Valor recebido*:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input type="text" id="recebidoGasto_inp" name="recebidoGasto" placeholder="0.00" class="form-control" maxlength="14" required/>
									</div>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-12 col-md-8">
									<label class="control-label" for="forma">Forma de pagamento*:</label>
									<input type="text" id="forma" class="form-control" maxlength="20" placeholder="Digite a forma de pagamento" name="forma" required>
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

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE CLIENTE #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE CLIENTE      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de cliente -->
	<div class="modal fade" id="excluir-caixa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="caixa-delete-form" action="administrativo-excluir-caixa" method="POST">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Excluir pagamento</h4>
					</div>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
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

	############################################################ FIM DO  MODAL DE EXCLUSÃO DE CLIENTE ############################################################

	-->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/moment.js"></script>
	<script src="resources/js/scripts2.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
// 			//Remove as mascaras quando apertar o submit
// 			$("#caixa-form").submit(function() {
// 				$("#cep").unmask();
// 				$("#recebidoGasto_inp").unmask();
// 				$("#tel").unmask();
// 				$("#cel").unmask();
// 			});
			
// 			//Aplica as mascaras nos campos
// 			$("#cep").mask("00000-000");
// 			$("#recebidoGasto_inp").mask("0.00");
// 			$("#tel").mask("(00) 0000-0000");
// 			$("#cel").mask("(00) 00000-0000");
			
// 			//Altera o tipo da mascara quando o usuário muda o tipo de pessoa
// 			$('#tipoId').on('change', function(){
// 				if($('#tipoId').val() == 0){
// 					$("#recebidoGasto_inp").mask("0.00");
// 				} else {
// 					$("#recebidoGasto_inp").mask("0.000");
// 				}
// 			});
			
			
// 			function limpa_formulário_cep() {
//                 // Limpa valores do formulário de cep.
//                 $("#endereco").val("");
//                 $("#bairro").val("");
//                 $("#estado").val(0);
//               	//Remove todas as opções do combo cidade.
// 				combo_cidade.find('option').remove();
				
// 				//Adiciona opção onde solicita que o usuário selecione uma cidade.
// 				combo_cidade.append($('<option></option>').val(0).html("Selecione a cidade").attr('disabled','disabled').attr('selected','selected'));
//             }
            
            //Quando o campo cep perde o foco.
//             $("#cep").blur(function() {
				
//             	$("#endereco").prop( "disabled", false );
//             	$("#numero").prop( "disabled", false );
//             	$("#complemento").prop( "disabled", false ); 
//             	$("#bairro").prop( "disabled", false );
//                 $("#cidade").prop( "disabled", false );
//                 $("#estado").prop( "disabled", false );
            	
//                 //Nova variável "cep" somente com dígitos.
//                 var cep = $(this).val().replace(/\D/g, '');

//                 //Verifica se campo cep possui valor informado.
//                 if (cep != "") {

//                     //Expressão regular para validar o CEP.
//                     var validacep = /^[0-9]{8}$/;

//                     //Valida o formato do CEP.
//                     if(validacep.test(cep)) {

//                         //Preenche os campos com "Pesquisando..." enquanto consulta webservice.
//                         $("#endereco").val("Pesquisando...")
//                         $("#bairro").val("Pesquisando...")
//                         $("#estado").val("Pesquisando...")
//                         $("#cidade").val("Pesquisando...")

//                         //Consulta o webservice viacep.com.br/
//                         $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

//                             if (!("erro" in dados)) {
//                                 //Atualiza os campos com os valores da consulta.
//                                 $("#endereco").val(dados.logradouro);
//                                 $("#bairro").val(dados.bairro);
                                
//                                 $("#estado option").filter(function() {
//                                     return $(this).text() == dados.uf;
//                                 }).prop("selected", true);
                                
//                                 listar_cidades(combo_estado.val(), function(){
//                                 	$("#cidade option").filter(function() {
//                                         return $(this).text() == dados.localidade;
//                                     }).prop("selected", true);
//                                 });
                                
//                             } //end if.
//                             else {
//                                 //CEP pesquisado não foi encontrado.
//                                 limpa_formulário_cep();
//                                 alert("CEP não encontrado.");
//                             }
//                         });
//                     } //end if.
//                     else {
//                         //cep é inválido.
//                         limpa_formulário_cep();
//                         alert("Formato de CEP inválido.");
//                     }
//                 } //end if.
//                 else {
//                     //cep sem valor, limpa formulário.
//                     limpa_formulário_cep();
//                 }
//             });
			
			
			
			

			/*
			*
			* DEFINIÇÃO DAS VARIAVEIS
			*
			*/

// 			var combo_estado = $('#estado');
// 			var combo_cidade = $('#cidade');

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
            var table = $('#lista-caixa').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 4, 5, 6],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE CLIENTE
			*
			*/

            $('#incluir-caixa-modal').click(function() {
            	
//             	$("#endereco").prop( "disabled", true );
//             	$("#numero").prop( "disabled", true );
//             	$("#complemento").prop( "disabled", true); 
//             	$("#bairro").prop( "disabled", true );
//                 $("#cidade").prop( "disabled", true );
//                 $("#estado").prop( "disabled", true );
            	                
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir novo pagamento");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#caixa-form").attr("action","administrativo-incluir-caixa");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir pagamento');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#caixa-form').each(function(){
					this.reset();
				});
				
				var now = moment().format('YYYY-MM-DD');
                $('#clientedesde').val(now);
				
				//Este método se encontra no arquivo scripts.js
				//Desabilita e habilita os campos NOME RAZÃO CPF CNPJ RG IE SEXO DATANASCIMENTO
                desabilitarCampos(document.getElementById("tipoId"));
				
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
                    $('#tipoId').val(data[1]);
                    $('#numeroId').val(data[2]);
    				
    				$('#recebidoGasto_inp').val(data[3]).trigger('input');
    				
                    $('#forma').val(data[4]);
                    $('#parcela').val(data[5]);
                    $('#descricao').val(data[6]);
					    				
                    desabilitarCampos(document.getElementById("tipoId"));                

			});

			/*
			*
			* EXCLUSÃO DE CLIENTE
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