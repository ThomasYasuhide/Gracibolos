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
						<div class="input-margin col-xs-12 col-sm-9 col-md-9 col-md-lg-9">
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
						
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">
							<label class="control-label hidden-xs">Listar caixa</label>
							<!-- Quando clicar no botão direciona a página para a url abaixo -->
							<a href="administrativo-listar-caixa" class="btn btn-default fullwidth">Listar caixa</a>
						</div>
						
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-caixa" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>#</th>
										<th>Encomenda ID</th>
										<th>Fornecedor ID</th>
										<th>Valor</th>										
										<th>Recebido / Gasto</th>
										<th>Forma</th>
										<th>Parcela</th>
										<th>Descrição</th>
										<th>Data</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="caixa" items="${caixas}">
										<tr>
											<td>${caixa.id}</td>
											<td>${caixa.encomendaId}</td>
											<td>${caixa.fornecedorId}</td>
											<td>${caixa.valor}</td>
											<td>${caixa.gastoRecebimento}</td>
											<td>${caixa.forma}</td>
											<td>${caixa.parcela}</td>
											<td>${caixa.descricao}</td>
											<td>${caixa.data}</td>
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
							<a href="" id="incluir-caixa-modal" data-toggle="modal" data-target="#modal-caixa" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir nova saída</a>
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

								<div class="hidden">
									<label class="control-label" for="id">Nº caixa:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="gastoRecebimento">Gasto/Recebimento*:</label>
									<select id="gastoRecebimento" name="gastoRecebimento" onchange="desabilitarCampos(this)" class="form-control" required>
										<option selected value="0">Gasto</option>
										<option value="1">Recebimento</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-4">
									<label class="control-label" for="nome_tipo" id="nome_tipo">Fornecedor*:</label>
									<input type="text" name="nome" id="nome_des" placeholder="Digite seu nome aqui." class="form-control" maxlength="100" required/>
								</div>																
															
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="valor">Valor*:</label>
									<div class="input-group">
										<span class="input-group-addon">R$</span>
										<input type="text" id="valor" name="valor" placeholder="0,00" class="form-control" maxlength="14" required/>
									</div>
								</div>								
																
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="formaPagamento">Forma de pagamento*:</label>
									<select class="form-control" id="formaPagamento" name="formaPagamento">										
										<option value="0" selected disabled>Selecione...</option>
										<option value="1">Dinheiro</option>
										<option value="2">Cartão de crédito</option>
										<option value="3">Cartão de débito</option>
										<option value="4">Cheque</option>
									</select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-4">
									<label class="control-label" for="parcela">Número de Parcelas:</label>
									<input id="parcela" type="number" min=1 class="form-control" pattern="[0-9]+" maxlength="1"  name="parcela" value="1">
								</div>
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="clientedesde">Data da transação:</label>
									<input type="date" id="clientedesde" name="clientedesde" class="form-control"  />
								</div>
								
								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="descricao">Descrição:</label>
									<textarea class="form-control" rows="3" name="descricao" id="descricao" placeholder="Digite aqui a descrição"></textarea>
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
	
	<script type="text/javascript">
		$(document).ready(function() {
			
// 			//Remove as mascaras quando apertar o submit
// 			$("#caixa-form").submit(function() {
// 				$("#cep").unmask();
// 				$("#recebidoGasto_inp").unmask();
// 				$("#tel").unmask();
// 				$("#cel").unmask();
// 			});


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
			* PESQUISA CLIENTES E POPULA O SELECT
			*
			*/
			
			$('#fornecedor').selectize({
			    valueField: 'id',
			    labelField: 'nomerazao',
			    searchField: ['nomerazao', 'cpfcnpj', 'rgie'],
			    options: [{id: '${encomenda.clienteid}', nomerazao: '${encomenda.clientenome}', cpfcnpj: '${encomenda.clientecpfcnpj}'}],
			    create: false,
			    render: {
			        option: function(item, escape) {
			        	
			            return	'<div>' +
									'<span class="title">' +
										'<span>' + escape(item.nomerazao) + '</span><br/>' +
										'<span>' + escape(item.cpfcnpj) + '</span><br/>' +
									'</span>' +
								'</div>';
			        }
			    },
			    load: function(query, callback) {
			        if (!query.length) return callback();
			        $.ajax({
			            
			            url: 'http://localhost:8080/Gracibolos/rest-clientes/' + encodeURIComponent(query),
			            type: 'GET',
			            error: function() {
			                callback();
			            },
			            success: function(res) {
			                callback(res);
			            }
			        });
			    }
			});
			
			var control = $('#fornecedor')[0].selectize;
			
			control.setValue(5);
			

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-caixa').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 1 ],
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
				$('#modal-subtitle').text("Incluir nova saída");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#caixa-form").attr("action","administrativo-incluir-caixa");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir cliente');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#caixa-form').each(function(){
					this.reset();
				});
				
				var now = moment().format('YYYY-MM-DD');
                $('#clientedesde').val(now);
				
				//Este método se encontra no arquivo scripts.js
				//Desabilita e habilita os campos NOME RAZÃO CPF CNPJ RG IE SEXO DATANASCIMENTO
                desabilitarCampos(document.getElementById("#gastoRecebimento"));
									
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
                    $('#encomendaId').val(data[1]);
                    $('#fornecedorId').val(data[2]);
    				
    				$('#recebidoGasto_inp').val(data[3]).trigger('input');
    				
                    $('#forma').val(data[4]);
                    $('#parcela').val(data[5]);
                    $('#descricao').val(data[6]);
					    				
                    desabilitarCampos(document.getElementById("gastoRecebimento").value);                

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