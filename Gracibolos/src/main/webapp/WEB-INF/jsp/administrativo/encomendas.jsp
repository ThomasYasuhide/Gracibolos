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
    <link href="resources/css/selectize.css" rel="stylesheet">

	<!-- Titulo da página -->
	<title>Graci Bolos | Encomendas</title>

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
						<h2 class="">ENCOMENDAS</h2>
						<h4 class="">Lista de encomendas</h4>
					</header>

					<hr/>

					<!-- ############################################################ CONTEUDO ############################################################ -->


					<!-- ################################# ALERTAS ################################# -->
					<c:if test="${incluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda armazenado com sucesso.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${incluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir a nova encomenda, favor tente novamente.
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
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar a encomenda, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'true'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda foi excluida com sucesso!
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${excluir == 'false'}">
						<div class="row">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir a encomenda, favor tente novamente.
								</div>
							</div>
						</div>
					</c:if>
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-9 col-md-9 col-lg-9">
							<label class="control-label">Pesquisar encomenda:</label>
							<form action="administrativo-pesquisar-encomenda" method="POST">
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o numero de encomenda para realizar a pesquisa." name="pesquisa" id="pesquisa" required />
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">
											<span class="glyphicon glyphicon-search disabled"></span>
										</button>
									</span>
								</div>
							</form>
						</div>
						
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">
							<label class="control-label hidden-xs">Listar encomendas</label>
							<a href="administrativo-listar-encomendas" class="btn btn-default fullwidth">Listar encomendas</a>
						</div>
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-encomendas" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>Pedido</th>
										<th>Status</th>
										<th>Cliente</th>
										<th>Responsável</th>
										<th>Data da encomenda</th>
										<th>Data da entrega</th>
										<th>Data do faturamento</th>
										<th>Data da produção</th>
										<th>Data da finalização</th>
										<th>Data do cancelamento</th>
										<th>Total</th>
										<th>Obs</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="cliente" items="${clientes}">
										<tr>
											<td>${cliente.id}</td>
											<td>${cliente.status}</td>
											<td>${cliente.cliente}</td>
											<td>${cliente.responsavel}</td>
											<td>${cliente.dataencomenda}</td>
											<td>${cliente.dataentrega}</td>
											<td>${cliente.datafaturamento}</td>
											<td>${cliente.dataproducao}</td>
											<td>${cliente.datafinalizado}</td>
											<td>${cliente.datacancelamento}</td>
											<td>${cliente.total}</td>
											<td>${cliente.obs}</td>
		                					<td>
		                						<button id="edit-encomenda" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete-encomenda" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>


					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
							<a href="" id="incluir-encomenda-modal" data-toggle="modal" data-target="#modal-encomenda" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir nova encomenda</a>
						</div>
					</div>

					<!-- ############################################################ FIM DO CONTEUDO ############################################################ -->
				</div>
			</div>
		</div>
	</div>

	<!--

	############################################################ MODAL DE INCLUSÃO OU ALTERAÇÂO DE ENCOMENDA ############################################################

	-->
	<div class="modal fade" id="modal-encomenda" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
	    	
	    		<form id="encomenda-form" method="POST">
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">ENCOMENDAS</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
												
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<!-- ABAS -->
								<ul class="nav nav-tabs">
									<li class="active"><a data-toggle="tab" href="#info">Informações do produto</a></li>
									<li><a data-toggle="tab" href="#receita">Receita do produto</a></li>
								</ul>

								<div class="tab-content">

									<div id="info" class="tab-pane fade in active">
							
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="id">Nº da encomenda:</label>
											<input type="text" id="id" name="id" placeholder="Gerado automaticamente" class="form-control" readonly />
										</div>
		
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="status">Status:</label>
											<select id="status" name="status" class="form-control">
												<option value="0" selected>Nova Encomenda</option>
												<option value="1" disabled>Faturado</option>
												<option value="2" disabled>Produzido</option>
												<option value="3" disabled>Finalizado</option>
											</select>
										</div>
										
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="dataencomenda">Data da encomenda:</label>
											<input type="date" id="dataencomenda" name="dataencomenda" class="form-control" readonly />
										</div>
										
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="dataentrega">Data de entrega:</label>
											<input type="date" id="dataentrega" name="dataentrega" class="form-control" />
										</div>
										
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="datafaturamento">Data de faturamento:</label>
											<input type="date" id="datafaturamento" name="datafaturamento" class="form-control" readonly />
										</div>
										
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="dataproducao">Data da produção:</label>
											<input type="date" id="dataproducao" name="dataproducao" class="form-control" readonly />
										</div>
										
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="datafinalizado">Data da finalização:</label>
											<input type="date" id="datafinalizado" name="datafinalizado" class="form-control" readonly />
										</div>
										
										<div class="input-margin col-xs-12 col-sm-6 col-md-3">
											<label class="control-label" for="datacancelado">Data de cancelamento:</label>
											<input type="date" id="datacancelado" name="datacancelado" class="form-control" readonly />
										</div>
		
										<div class="input-margin col-xs-12 col-sm-12 col-md-6">
											<label class="control-label" for="cliente">Cliente:</label>
											<select id="cliente" name="cliente" class="form-control" required>
												<option selected value="0">Thomas F. Yasuhide Yamamoto</option>
												<option value="1">Rogério Yudi</option>
												<option value="2">Weslley Ruffino</option>
												<option value="3">Breno Ruffin</option>
												<option value="4">Natália Inácio Lula da silva</option>
											</select>
										</div>
										
										<div class="input-margin col-xs-12 col-sm-12 col-md-6">
											<label class="control-label" for="responsavel" id="responsavel">Responsável pela retirada:</label>
											<input type="text" id="responsavel" name="responsavel" placeholder="Digite o nome do responsável pela retirada aqui." class="form-control" maxlength="100"/>
										</div>
										
										<div class="input-margin col-xs-12 col-sm-12 col-md-12">
											<label class="control-label" for="obs">Observações:</label>
											<textarea id="obs" name="obs" class="form-control" placeholder="Insira uma observação sobre o cliente"></textarea>
										</div>
									</div>

									<div id="receita" class="tab-pane fade">
										<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
											<button class="btn btn-default fullwidth" onclick="return false" id="inserir-linha">
												<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;&nbsp;Incluir novo produto
											</button>
										</div>
									
										<div class="input-margin pull-right col-xs-12 col-sm-12 col-md-12">
											<table class="input-margin table display table-settings">
												<thead>
													<!-- Titulos das tabelas  -->
													<tr>
														<th>Produto</th>
														<th>Quantidade</th>
														<th>Valor unitário</th>
														<th>Valor total</th>
														<th>Ações</th>
													</tr>
												</thead>
												<tbody id="lista-produtos" >
			
													<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
												
													<!-- 	FALTA IMPLEMENTAR 
			
													<c:forEach var="produto" items="${produtos}">
														<tr>
															<td>${produto.id}</td>
															<td>${produto.nome}</td>
															<td>${produto.quantidade}</td>
															<td>${produto.valor}</td>
						                					<td>
						                						<button id="edit-fornecedor" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
						                						<button id="delete-fornecedor" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
						                					</td>
														</tr>
													</c:forEach>
			
													-->
												</tbody>
											</table>
										</div>
										
										<div class="input-margin col-xs-12 col-sm-12 col-md-12">
											<label class="control-label" for="total">Valor total da encomenda:</label>
											<div class="input-group">
												<span class="input-group-addon">R$</span>
												<input id="total" type="text" class="form-control" name="total" max="999999999" placeholder="0,00">
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

	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE ENCOMENDA #########################################################

	-->






	<!--

	############################################################        MODAL DE EXCLUSÃO DE ENCOMENDA      ############################################################

	-->



	<!-- Modal de confirmação de exclusão de cliente
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
										<input type="text" id="id_delete" name="id" placeholder="Digite o numero de ID" class="form-control" readonly />
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
	 -->


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/moment.js"></script>
	<script src="resources/js/selectize.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			$('#cliente').selectize();
			
			//Remove as mascaras quando apertar o submit
			$("#encomenda-form").submit(function() {				
				var total = $("#total").val();
				valor = total.replace(".","");
				valor = total.replace(",",".");
				$("#total").val(total);
			});
			
			
			/*
			*
			* ADICIONA LINHA PARA PRODUTOS
			*
			*/
			
			$('#inserir-linha').click(function() {
            	line_product();
            });
	
            function line_product() {

            	var tabela;
            	var linha;
            	var coluna;
            	var medida;
            	var materiaprima;
            	var option;
            	var unidade;

            	tabela = document.getElementById("lista-produtos");

            	    linha = document.createElement("tr");
                	linha.setAttribute("id", "item");
						
	                	id_column = document.createElement("td");
	        			id_column.setAttribute("class","hidden");
                		nome_column = document.createElement("td");
                		quantidade_column = document.createElement("td");
                		valor_column = document.createElement("td");
                		total_column = document.createElement("td");
                		acoes_column = document.createElement("td");
							
	                		id = document.createElement("input");
	        			    id.setAttribute("type","text");
	        			    id.setAttribute("id","id");
	        			    id.setAttribute("name","id");
	        			    id.setAttribute("class", "form-control");
	        			    id.setAttribute("class", "readonly");
	        					
            				produto = document.createElement("select");
            				produto.setAttribute("class", "form-control");
            			    
            					option = document.createElement("option");
            					option.text = "Selecione...";
            					option.value = "";
            					option.setAttribute("disabled","disabled");
            					option.setAttribute("selected","selected");
            					produto.appendChild(option);
            					
            					for(var i=0; i<5; i++){
            						option = document.createElement("option");
            						option.text = "Produto "+i;
            						produto.appendChild(option);
            					}
							
           					quantidade = document.createElement("input");
               			    quantidade.setAttribute("type","number");
           					quantidade.setAttribute("name","quantidade");
           					quantidade.setAttribute("class", "form-control");
           					quantidade.setAttribute("min", "0");
           					quantidade.setAttribute("max", "9999999");
           					
           					valor = document.createElement("input");
               			    valor.setAttribute("type","text");
           					valor.setAttribute("name","valor");
           					valor.setAttribute("class", "form-control");
           					
           					total = document.createElement("input");
               			    total.setAttribute("type","text");
           					total.setAttribute("name","total");
           					total.setAttribute("class", "form-control");
           					total.setAttribute("readonly", "readonly");
            	
            		//Botão de ação salvar
            		salvar_btn = document.createElement("button");
            		salvar_btn.type = "button";
            		salvar_btn.setAttribute("id","salvar-produto");
            		salvar_btn.setAttribute("class","btn btn-default margin-right");
            		salvar_btn.innerHTML = "<i class='material-icons'>save</i>";
            		salvar_btn.onclick = salvar;

            		//Botão de ação de exclusão
            		excluir_btn = document.createElement("button");
            		excluir_btn.type = "button";
            		excluir_btn.setAttribute("id","delete-produto");
            		excluir_btn.setAttribute("class","btn btn-default");
            		excluir_btn.innerHTML = "<i class='material-icons'>clear</i>";
            		excluir_btn.onclick = excluir;

           		id_column.appendChild(id);
            	nome_column.appendChild(produto);
                quantidade_column.appendChild(quantidade);
                valor_column.appendChild(valor);
                total_column.appendChild(total);
            	acoes_column.appendChild(salvar_btn);
            	acoes_column.appendChild(excluir_btn);

            	linha.appendChild(id_column);
                linha.appendChild(nome_column);
                linha.appendChild(quantidade_column);
                linha.appendChild(valor_column);
                linha.appendChild(total_column);
                linha.appendChild(acoes_column);

            	tabela.appendChild(linha);

                function salvar(){
                	for(i=0; i<linha.childNodes.length-1;i++){
                		 alert(linha.childNodes[i].firstChild.value);
                	}
            	}

            	function excluir(){
            	    linha.remove();
            	}
            }
            
			
			
			
			
			/*
			*
			* INDICADOR DE PAGINA DO MENU
			*
			*/
			
			$('#menu-mob-encomendas').addClass('active');
			$('#menu-encomendas').addClass('active');

			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-encomendas').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 3, 4, 8, 9, 10, 11, 12 ],
                        "visible": false
                    }
                ]
            });

            /*
			*
			* INCLUSÃO DE ENCOMENDA
			*
			*/

            $('#incluir-encomenda-modal').click(function() {
            	
            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir nova encomenda");
				
				//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#encomenda-form").attr("action","administrativo-incluir-encomenda");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir encomenda');
				
				//Reset autmaticamente todos os campos do formulário.
				$('#encomenda-form').each(function(){
					this.reset();
				});
				
				var now = moment().format('YYYY-MM-DD');
                $('#dataencomenda').val(now);
				
                line_product();
                
            });

            /*
			*
			* ALTERAÇÃO DE ENCOMENDA
			*
			*/

            //Define uma ação ao apertar o botão editar de algum item da tabela.
            $('#lista-encomendas tbody').on( 'click', '#edit-encomenda', function () {
            	            	
            	 //Altera dinamicamente o titulo do modal.
            	$('#modal-subtitle').text("Alterar encomenda");
            	
            	//Altera o método de ação do form do modal (Altera para caso clicar no botão submit seja enviado a instrução de alteração).
				$("#encomenda-form").attr("action","administrativo-alterar-encomenda");
				
				//Altera o nome do botão do modal.
				$("#modal-action").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

           		//Apresenta o modal de exclusão na tela.
           		$('#modal-encomenda').modal('show');

				//Preenche os determinados campos com os conteudos.
                $('#id').val(data[0]);
                $('#status').val(data[1]);
                $('#cliente').val(data[2]);
                $('#responsavel').val(data[3]);
                $('#dataencomenda').val(data[4]);
   				$('#dataentrega').val(data[5]);
                //$('#datafaturamento').val(data[6]);
                //$('#dataproducao').val(data[7]);
                //$('#datafinalizado').val(data[8]);
   				//$('#datacancelado').val(data[9]);
   				$('#total').val(data[10]);
   				$('#obs').val(data[11]);
				

			});

			/*
			*
			* EXCLUSÃO DE ENCOMENDA
			*
			*/
	
			//Define uma ação ao apertar o botão excluir de algum item da tabela.
            $('#lista-encomendas tbody').on( 'click', '#delete-encomenda', function () {
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

                //Preenche o modal com o numero do ID a ser deletado.
                $('#id_delete').val(data[0]);

                //Apresenta o modal de exclusão na tela.
				$('#excluir-encomenda').modal('show');

            });
		});
	</script>
	
	
</body>
</html>