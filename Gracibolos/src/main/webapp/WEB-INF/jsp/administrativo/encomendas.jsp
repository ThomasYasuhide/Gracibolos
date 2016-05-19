<!-- Define que este documento é uma pagina JSP -->
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Tag de importação JSTL, utilizado para fazer a repetição das tags HTML -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Tag de importação JSTL, utilizado para fazer formatação dos valores das tags HTML -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/datatables.css" rel="stylesheet">
    <link href="resources/css/selectize.css" rel="stylesheet">
    <link href="resources/css/wizard.css" rel="stylesheet">
	<link href="resources/css/reset.css" rel="stylesheet">

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
									<!-- 
										id="pesquisa" envio para a controller o número da encomenda
									 -->
									<input id="pesquisa" type="text" class="form-control" maxlength="100" placeholder="Informe o numero de encomenda para realizar a pesquisa." name="pesquisa"  required />
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">
											<span class="glyphicon glyphicon-search disabled"></span>
										</button>
									</span>
								</div>
							</form>
						</div>
						
						<div class="input-margin col-xs-12 col-sm-3 col-md-3 col-lg-3">
							<label class="control-label hidden-xs">Listar finalizadas</label>
							<!-- 
								Chamada para a controller @RequestMapping 
							-->
							<a href="administrativo-listar-encomendas-finalizadas" class="btn btn-default fullwidth">Listar finalizadas</a>
						</div>
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-encomendas" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<th>Encomenda</th>
										<th>Status</th>
										<th>Cliente ID</th>
										<th>Cliente</th>
										<th>Cliente CPF/CNPJ</th>
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
									<c:forEach var="encomendas" items="${encomendas}">
										<tr>
											<td>${encomendas.id}</td>
											<td>${encomendas.status}</td>
											<td>${encomendas.clienteid}</td>
											<td>${encomendas.nomerazao}</td>
											<td>${encomendas.cpfcnpj}</td>
											<td>${encomendas.responsavel}</td>
											<td>${encomendas.dataencomenda}</td>
											<td>${encomendas.dataentrega}</td>
											<td>${encomendas.datafaturamento}</td>
											<td>${encomendas.dataproducao}</td>
											<td>${encomendas.datafinalizado}</td>
											<td>${encomendas.datacancelamento}</td>
											<td>${encomendas.totalprodutos}</td>
											<td>${encomendas.obs}</td>
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
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-4">
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
				
	    
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 id="modal-title">ENCOMENDAS</h3>
						<h4 id="modal-subtitle"></h4>
					</div>

					<div class="modal-body">
						<!-- ################################# CONTEUDO ################################# -->
												
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
								<div class="wizard">
						            <div class="wizard-inner">
						                <div class="connecting-line"></div>
						                <ul class="nav nav-tabs" role="tablist">
						
						                    <li role="presentation" class="active">
						                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Informações da encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">chrome_reader_mode</i>
						                            </span>
						                        </a>
						                    </li>
						
						                    <li role="presentation" class="disabled">
						                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Informações do produto">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">shopping_cart</i>
						                            </span>
						                        </a>
						                    </li>
						                    <li role="presentation" class="disabled">
						                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Faturar encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">account_balance</i>
						                            </span>
						                        </a>
						                    </li>
						
						                    <li role="presentation" class="disabled">
						                        <a href="#step4" data-toggle="tab" aria-controls="step4" role="tab" title="Produzir encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">query_builder</i>
						                            </span>
						                        </a>
						                    </li>
						
						                    <li role="presentation" class="disabled">
						                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Finalizar encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">done</i>
						                            </span>
						                        </a>
						                    </li>
						
						                </ul>
						            </div>
						
						            <div class="tab-content">
						            				            	
						                <div class="tab-pane active" role="tabpanel" id="step1">
						                    
						                    <form id="dados-encomenda" method="POST">
						                    				                    
							                    <div class="row">
							                        <div class="input-margin col-xs-12 col-sm-6 col-md-3">
														<label class="control-label" for="id">Nº da encomenda:</label>
														<input type="text" id="id" name="id" value="${encomenda.id}" class="form-control" readonly />
													</div>
													
													<div class="input-margin col-xs-12 col-sm-6 col-md-3">
														<label class="control-label" for="dataencomenda">Data da encomenda:</label>
														<input type="date" id="dataencomenda" name="dataencomenda" class="form-control" value="${encomenda.dataencomenda}" readonly />
													</div>
													
													<div class="input-margin col-xs-12 col-sm-6 col-md-3">
														<label class="control-label" for="dataentrega">Data de entrega*:</label>
														<input type="date" id="dataentrega" name="dataentrega" class="form-control" value="${encomenda.dataentrega}" required />
													</div>
													
													<div class="input-margin col-xs-12 col-sm-6 col-md-3">
														<label class="control-label" for="datacancelado">Data do cancelamento:</label>
														<input type="date" id="datacancelado" name="datacancelado" class="form-control" value="${encomenda.datacancelamento}" readonly />
													</div>

													<div class="input-margin col-xs-12 col-sm-12 col-md-6">
														<label class="control-label" for="cliente">Cliente*:</label>
														<select id="cliente" name="cliente" class="form-control" placeholder="Insira o nome, RG, CPF, CNPJ ou IE." required></select>
													</div>
													
													<div class="input-margin col-xs-12 col-sm-12 col-md-6">
														<label class="control-label" for="responsavel">Responsável pela retirada:</label>
														<input type="text" id="responsavel" name="responsavel" placeholder="Digite o nome do responsável pela retirada." value="${encomenda.responsavel}" class="form-control" maxlength="100"/>
													</div>
													
													<div class="input-margin col-xs-12 col-sm-12 col-md-12">
														<label class="control-label" for="obs">Observações:</label>
														<textarea id="obs" name="obs" rows="5" class="form-control" placeholder="Insira uma observação sobre o cliente">${encomenda.obs}</textarea>
													</div>
							                    </div>

							                    <div class="modal-footer modal-margin-top">
													<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
								                    <button type="button" class="btn btn-default" id="cancelar-encomenda" disabled><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
								                    <button type="button" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
								                    <button type="submit" class="btn btn-default next-step"><i class="material-icons">shopping_cart</i>&nbsp;&nbsp;&nbsp;Produtos</button>
						                   		</div>
					                   		
					                   		</form>
					                   		
						                </div>
							                
						                
						                
										
						                <div class="tab-pane" role="tabpanel" id="step2">
						                    
						                    <form id="produtos-encomenda" method="POST">
						                    
							                    <div class="row">
							                    	<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-lg-12">
							                    		<button type="button" id="inserir-linha"  onclick="return false" class="btn btn-default fullwidth"><i class="material-icons">add_shopping_cart</i>&nbsp;&nbsp;&nbsp;Incluir novo produto</button>
													</div>
							                    
							                        <div class="input-margin col-xs-12 col-sm-12 col-md-12">
														<table id="produtos" class="input-margin table display table-settings">
															<thead>
																<!-- Titulos das tabelas  -->
																<tr>
																	<th width="35%">Produto</th>
																	<th width="10%">Quantidade</th>
																	<th width="25%">Valor unitário</th>
																	<th width="25%">Valor total</th>
																	<th width="5%">Ações</th>
																</tr>
															</thead>
															<tbody id="lista-produtos" >
						
																<c:forEach var="item" items="${itens}" varStatus="loop">
																	<tr id="item">
																		
																		<td class="hidden">
																			<input type="text" id="id_${loop.index}" name="item[${loop.index}].id" value="${item.id}" class="readonly">
																		</td>
																		
																		<td>
																			<select class="form-control produto" id="produto_${loop.index}" placeholder="Digite o código ou nome do produto." name="item[${loop.index}].produtoId">
																					<option value="teste" selected>Teste</option>
																			</select>
																		</td>
																		
																		<td>
																			<input type="number" name="item[${loop.index}].quantidade" value="${item.quantidade}" id="quantidade_${loop.index}" class="form-control quantidade"  min="0" max="9999999">
																		</td>
																		
																		<td>
																			<div class="input-group">
																				<span class="input-group-addon">R$</span>
																				<fmt:setLocale value="pt_BR"/>
																				<input type="text" name="item[${loop.index}].valor" value="<fmt:formatNumber value="${item.valor}" type="number" minFractionDigits="2"/>" id="valor_${loop.index}" class="form-control valor">
																			</div>
																		</td>
																		
																		<td>
																			<div class="input-group">
																				<span class="input-group-addon">R$</span>
																				<input type="text" name="item[${loop.index}].total" value="<fmt:formatNumber value="${item.total}" type="number" minFractionDigits="2"/>" id="total_${loop.index}" class="form-control total" readonly="readonly">
																			</div>
																		</td>
																		
																		<td>
																			<button type="button" id="delete-produto" class="btn btn-default"><i class="material-icons">remove_shopping_cart</i></button>
																		</td>
																		
																		
																	</tr>
																</c:forEach>
																
															</tbody>
														</table>
													</div>
																									
													<div class="input-margin pull-right col-xs-12 col-sm-12 col-md-6 col-md-6">
														<label class="control-label" for="totalprodutos">Valor total dos produtos:</label>
														<div class="input-group">
															<span class="input-group-addon">R$</span>
															<input id="totalprodutos" type="text" class="form-control totalprodutos" name="totalprodutos" max="999999999" value="<fmt:formatNumber value="${encomenda.totalprodutos}" type="number" minFractionDigits="2"/>" placeholder="0,00" readonly>
														</div>
													</div>
							                    </div>
							                    
							                    <div class="modal-footer modal-margin-top">
													<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
								                    <button type="button" class="btn btn-default" id="cancelar-encomenda" disabled><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
								                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">chrome_reader_mode</i>&nbsp;&nbsp;&nbsp;Voltar</button>
								                    <button type="button" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
								                    <button type="submit" class="btn btn-default next-step"><i class="material-icons">account_balance</i>&nbsp;&nbsp;&nbsp;Faturar</button>
						                   		</div>
						                    
						                    </form>
						                    
						                </div>
						
						                <div class="tab-pane" role="tabpanel" id="step3">
						                    
						                    <form id="faturar-encomenda" method="POST">
						                    
							                    <div class="row">
							                        <div class="input-margin col-xs-12 col-sm-6 col-md-4">
														<label class="control-label" for="datafaturamento">Data de faturamento:</label>
														<input type="date" id="datafaturamento" name="datafaturamento" class="form-control" readonly />
													</div>
													
													<div class="input-margin col-xs-12 col-sm-6 col-md-8">
														<label class="control-label" for="valortroco">Forma de pagamento:</label>
														<select class="form-control" name="formapagamento">
															<option value="0" selected disabled>Selecione...</option>
															<option value="1">Dinheiro</option>
															<option value="2">Cartão de crédito</option>
															<option value="3">Cheque</option>
														</select>
													</div>
													
													<div class="input-margin col-xs-12 col-sm-6 col-md-4">
														<label class="control-label" for="valorcompra">Valor total da encomenda:</label>
														<div class="input-group">
															<span class="input-group-addon">R$</span>
															<input type="text" id="totalencomenda" name="totalencomenda" class="form-control" readonly />
														</div>
													</div>
													
													<div class="input-margin col-xs-12 col-sm-6 col-md-4">
														<label class="control-label" for="valorpago">Valor pago:</label>
														<div class="input-group">
															<span class="input-group-addon">R$</span>
															<input type="text" id="valorpago" placeholder="0,00" name="valorpago" class="form-control" />
														</div>
													</div>
													
													<div class="input-margin col-xs-12 col-sm-12 col-md-4">
														<label class="control-label" for="valortroco">Troco:</label>
														<div class="input-group">
															<span class="input-group-addon">R$</span>
															<input type="text" id="valortroco" name="valortroco" placeholder="0,00" class="form-control" readonly />
														</div>
													</div>
													
													<div class="input-margin col-xs-12 col-sm-12 col-md-12">
														<label class="control-label" for="obs">Observações do pagamento:</label>
														<textarea id="obspagamento" name="obspagamento" rows="3" class="form-control" placeholder="Insira uma observação sobre o pagamento"></textarea>
													</div>
													
							                    </div>
							                    
							                    <div class="modal-footer modal-margin-top">
													<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
								                    <button type="button" class="btn btn-default" id="cancelar-encomenda"><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
								                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">shopping_cart</i>&nbsp;&nbsp;&nbsp;Voltar</button>
								                    <button type="button" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
								                    <button type="submit" class="btn btn-default next-step"><i class="material-icons">query_builder</i>&nbsp;&nbsp;&nbsp;Produzir</button>
						                   		</div>
						                   		
						                   	</form>
						                   	
						                </div>
						
						                <div class="tab-pane" role="tabpanel" id="step4">
						                    
						                    <form id="produzir-encomenda" method="POST">
						                    
							                    <div class="row">
							                        <div class="input-margin col-xs-12 col-sm-6 col-md-3">
														<label class="control-label" for="dataproducao">Data da produção:</label>
														<input type="date" id="dataproducao" name="dataproducao" class="form-control" readonly />
													</div>
							                    </div>
							                    
							                    <div class="modal-footer modal-margin-top">
													<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
								                    <button type="button" class="btn btn-default" id="cancelar-encomenda"><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
								                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">account_balance</i>&nbsp;&nbsp;&nbsp;Voltar</button>
								                    <button type="button" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
								                    <button type="submit" class="btn btn-default next-step"><i class="material-icons">done</i>&nbsp;&nbsp;&nbsp;Finalizar</button>
						                   		</div>
						                   		
						                   	</form>
						                   	
						                </div>
						
						                <div class="tab-pane" role="tabpanel" id="complete">
						                	
						                    <form id="finalizar-encomenda" method="POST">
						                
							                    <div class="row">
							                        <div class="input-margin col-xs-12 col-sm-6 col-md-3">
														<label class="control-label" for="datafinalizado">Data da finalização:</label>
														<input type="date" id="datafinalizado" name="datafinalizado" class="form-control" readonly />
													</div>
							                    </div>
							                    
							                    <div class="modal-footer modal-margin-top">
													<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
								                    <button type="button" class="btn btn-default" id="cancelar-encomenda"><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
								                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">query_builder</i>&nbsp;&nbsp;&nbsp;Voltar</button>
								                    <button type="button" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
								                    <button type="submit" class="btn btn-default" id="finalizar-encomenda"><i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Finalizar</button>
						                   		</div>
						                   		
						                   	</form>
						                </div>
						                
						            </div>
						        </div>
							</div>
						</div>
					</div>
					
					<!-- ################################# FIM DO CONTEUDO ################################# -->

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
	<script src="resources/js/wizard.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			/*
			*
			* INDICADOR DE PAGINA DO MENU
			*
			*/
			
			$('#menu-mob-encomendas').addClass('active');
			$('#menu-encomendas').addClass('active');
			
			/*
			*
			* Define os campos que receberam as mascaras.
			*
			*/
			
			$(".valor").mask("000.000.000.000.000,00", {reverse: true});
			$(".total").mask("000.000.000.000.000,00", {reverse: true});
			$(".totalprodutos").mask("000.000.000.000.000,00", {reverse: true});
			$("#totalencomenda").mask("000.000.000.000.000,00", {reverse: true});
			$("#valorpago").mask("000.000.000.000.000,00", {reverse: true});
			$("#valortroco").mask("000.000.000.000.000,00", {reverse: true});
			
			/*
			*
			* PESQUISA CLIENTES E POPULA O SELECT
			*
			*/
			
			$('#cliente').selectize({
			    valueField: 'id',
			    labelField: 'nomerazao',
			    searchField: ['nomerazao', 'cpfcnpj', 'rgie'],
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
			
			var control = $('#cliente')[0].selectize;
			
			control.setValue(5);
						
			/*
			*
			* PESQUISA PRODUTOS E POPULA O SELECT
			*
			*/
			
			$(".produto").each(function(){
				
				$(this).selectize({
				    valueField: 'id',
				    labelField: 'nome',
				    searchField: ['codigo', 'nome'],
					options: [{id: '${item.produtoId}', codigo: '${item.codigo}', nome: '${item.nome}'}],
				    create: false,
				    render: {
				        option: function(item, escape) {
				            return	'<div>' +
										'<span class="title">' +
											'<span>' + escape(item.nome) + '</span><br/>' +
											'<span>' + escape(item.codigo) + '</span><br/>' +
										'</span>' +
									'</div>';
				        }
				    },
				    load: function(query, callback) {
				        if (!query.length) return callback();
				        $.ajax({
				            
				            url: 'http://localhost:8080/Gracibolos/rest-pesquisar-produto-nome/' + encodeURIComponent(query),
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
			});
			
			$(".produto").on("change", function(){
				var linha = this.id.replace("produto_", "");
				
				var produto = $('#produto_' + linha);
				var valor = $('#valor_' + linha);
				

				if(produto.val() != undefined){
					$.ajax({
			            url : 'administrativo-pesquisar-valor',
			            method: "POST",
			            data: {id:produto.val()},
			            success : function(data) {
			            	
			            	valor.val(parseFloat(data.valor).toFixed(2)).trigger('input');
			            	
			            	calcularTotal(linha);
			            }
			        });
				}
				
			});
						
			/*
			*
			* Verifica a linha que está sendo alterada da tabela de produtos.
			*
			*/
			
			$("#produtos").on('change', '.valor, .quantidade', function() {
				//Recupera o numero da linha do produto.
			    var linha = this.id.replace("quantidade_", "").replace("valor_", "");

				//Chama o método para calcular o total dos produtos passando como parametro o numero da linha.
			    calcularTotal(linha);
			});
			
			/*
			*
			* Calcular o total do produto multiplicando valor pela quantidade recebendo o numero da linha.
			*
			*/
			
			function calcularTotal(linha) {
				//Busca os campos pelo numero do ID.
				var quantidade = $('#quantidade_' + linha);
				var valor = $('#valor_' + linha);
				var total = $('#total_' + linha);
				
				//Variavel temporaria para retirar a mascara e possibilitar o calculo.
				var valor_temp = valor.val();
				valor_temp = valor_temp.split(".").join("");
				valor_temp = valor_temp.split(",").join(".");
				
				//Insere o valor total da quantidade e valor dos produtos.
				//Fixed(2) informa que só haverá 2 casas decimais após a virgula.
				//Trigger aciona um evento para que o campo seja formatado com a mascara.
				total.val(parseFloat(parseInt(quantidade.val()) * valor_temp).toFixed(2)).trigger('input');
		    	
				//Calcula o total de todos os produtos.
		    	calculaTotalProdutos();
			}
			
			/*
			*
			* Método para realizar o calculo total dos produtos.
			*
			*/
			
			function calculaTotalProdutos() {
			
				//Reseta o valor total dos produtos para zero.
				var total = 0;
			
				//Verifica todos os campos que tiver total e realiza a seguinte função.
				$('.total').each(function() {

					//Variavel temporaria para retirar a mascara e possibilitar o calculo.
					var valor_temp = $(this).val();
				    valor_temp = valor_temp.split(".").join("");
				    valor_temp = valor_temp.split(",").join(".");
					
				    //Incrementa o valor total de cada campo.
					total += Number(valor_temp);
				});

				//Fixed(2) informa que só haverá 2 casas decimais após a virgula.
				total = parseFloat(total).toFixed(2);
	
				//Insere o valor total dos produtos.
				//Trigger aciona um evento para que o campo seja formatado com a mascara.
				$('#totalprodutos').val(total).trigger('input');
				
			}

			/*
			*
			* CRIA UMA NOVA LINHA DE PRODUTOS.
			*
			*/

			var produtos = $('#produtos');
			var i = $('#produtos tr').size() - 1;

			$('#inserir-linha').on('click', function() {
				
				if($('#produtos tr').size() <= 100){
			  	
				    var item = '<tr id="item">';
				    item +=			'<td class="hidden">';
				    item += 			'<input type="text" id="id_'+i+'" name="item['+i+'].id" value="${item.id}" class="readonly">';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<select class="form-control produto" placeholder="Digite o código ou nome do produto." name="item['+i+'].produtoId"></select>';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<input type="number" name="item['+i+'].quantidade" id="quantidade_'+i+'" placeholder="0" class="form-control quantidade"  min="0" max="9999999">';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<div class="input-group">';
				    item += 				'<span class="input-group-addon">R$</span>';
				    item += 				'<input type="text" name="item['+i+'].valor" placeholder="0,00" id="valor_'+i+'" class="form-control valor">';
				    item += 			'</div>';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<div class="input-group">';
				    item += 				'<span class="input-group-addon">R$</span>';
				    item += 				'<input type="text" name="item['+i+'].total" value="${item.total}" id="total_'+i+'" class="form-control total" readonly="readonly">';
				    item += 			'</div>';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<button type="button" id="delete-produto" class="btn btn-default"><i class="material-icons">remove_shopping_cart</i></button>';
				    item += 		'</td>';
				    item += 	'</tr>';
			    
				    produtos.append(item);
				    
				    i++;
				}else {
					alert('Você atingiu o limite máximo de produtos na encomenda');	
				}
				
			});
			
			/*
			*
			* EXCLUSÃO DA LINHA
			*
			*/
			
			$('#produtos').on('click', '#delete-produto', function() {
				
				//Busca a linha e remove o TR.
				$(this).parent().parent().remove();
	
				//Calcula o total de todos os produtos.
				calculaTotalProdutos();
			
			});
			
			//Remove as mascaras quando apertar o submit
			$("#dados-encomenda").submit(function(e) {
				e.preventDefault();
				alert('dados da encomenda');
				
				/*
				alert($('#id').val());
				alert($('#dataencomenda').val());
				alert($('#dataentrega').val());
				alert($('#datacancelado').val());
				alert($('#cliente').val());
				alert($('#responsavel').val());
				alert($('#obs').val());
				*/
				
				return false;
				
			});
			
			//Remove as mascaras quando apertar o submit
			$("#produtos-encomenda").submit(function(e) {
				e.preventDefault();
				
				alert('produtos da encomenda');
				
				var now = moment().format('YYYY-MM-DD');
				var totalencomenda = $('#totalprodutos').val();
               
				$('#datafaturamento').val(now);
				$('#totalencomenda').val(totalencomenda);
				
				
				return false;
			});
			
			//Remove as mascaras quando apertar o submit
			$("#faturar-encomenda").submit(function(e) {
				e.preventDefault();
				
				alert('faturar da encomenda');
				
				return false;
			});
			
			//Remove as mascaras quando apertar o submit
			$("#produzir-encomenda").submit(function(e) {
				e.preventDefault();
				
				alert('produzir da encomenda');
				
				return false;
			});
			
			//Remove as mascaras quando apertar o submit
			$("#finalizar-encomenda").submit(function(e) {
				e.preventDefault();
				
				alert('finalizar da encomenda');
				
				return false;
			});
			
			$('#valorpago').on('change', function(){
				
				//Variavel temporaria para retirar a mascara e possibilitar o calculo.
				var totalencomenda = $('#totalencomenda').val();
				totalencomenda = totalencomenda.split(".").join("");
				totalencomenda = totalencomenda.split(",").join(".");
				
				//Variavel temporaria para retirar a mascara e possibilitar o calculo.
				var valorpago = $('#valorpago').val();
				valorpago = valorpago.split(".").join("");
				valorpago = valorpago.split(",").join(".");
								
				if(parseFloat(valorpago) >= parseFloat(totalencomenda)){
					$("#valortroco").val((valorpago - totalencomenda).toFixed(2)).trigger('input');
				}else{
					alert('O valor pago é inferior ao valor total da encomenda.');
					
					$('#valorpago').val("");
					$("#valortroco").val("");
				}
				
				
			});
			
			/*
			*
			* CONFIGURAÇÃO DA TABELA
			*
			*/
			
			//Define que as colunas determinadas no "targes" não sejam visiveis para o usuário
            var table = $('#lista-encomendas').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 3, 4, 8, 9, 10, 11],
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

                //Settando no selectize os valores vindo da tabela
                var selectize = $('#cliente')[0].selectize;
                selectize.addOption({id:data[2], nomerazao:data[3], cpfcnpj:data[4]});
                selectize.setValue(data[2]);
                
                $('#responsavel').val(data[5]);
                $('#dataencomenda').val(data[6]);
   				$('#dataentrega').val(data[7]);
                //$('#datafaturamento').val(data[8]);
                //$('#dataproducao').val(data[9]);
                //$('#datafinalizado').val(data[10]);
   				//$('#datacancelado').val(data[11]);
   				$('#total').val(data[12]);
   				$('#obs').val(data[13]);

				//------------------------------------------------------------------------------
				var url = '/Gracibolos/rest-itensencomenda/'+data[0];
				$.getJSON(url).done(function(data){
					var itens = [];
					//recebe por parâmetro a lista de objetos. i = iteração e field = objeto
					$.each(data, function(i, field){
			            //$("div").append(field.nome + " ");
			            //console.log('itens : '+ data[i].nomeProduto, data[i].valor);
						//console.log('itens : '+ data[i].id);
			            console.log('itens : '+ data[i].nomeProduto);//Aqui seto so o nome - json muito grande
			            console.log('itens : '+ data[i].numero);
			            //console.log('itens : '+ data[i].produtoId);
			            //console.log('itens : '+ data[i].produtoIdProduto);
			            console.log('itens : '+ data[i].quantidade);
			            //console.log('itens : '+ data[i].total);
			            console.log('itens : '+ data[i].valor);
						
			        });
				});

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