<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							
							<!-- Chamada para a controller @RequestMapping -->
							
							<a href="administrativo-listar-encomendas-finalizadas" class="btn btn-default fullwidth">Listar finalizadas</a>
						</div>
					</div>
					
					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="lista-encomendas" class="table table-hover display table-settings">
								<thead>
									<!-- Titulos das tabelas  -->
									<tr>
										<!-- 00 --><th>Encomenda</th>
										<!-- 01 --><th>Status</th>
										<!-- 02 --><th>Status</th>
										<!-- 03 --><th>Cliente</th>
										<!-- 04 --><th>Cliente ID</th>
										<!-- 05 --><th>Cliente CPF/CNPJ</th>											
										<!-- 06 --><th>Responsável</th>
										<!-- 07 --><th>Data da encomenda</th>
										<!-- 08 --><th>Data de entrega</th><!-- VIEW -->
										<!-- 09 --><th>Data de entrega</th><!-- DADOS -->
										<!-- 10 --><th>Data do faturamento</th>
										<!-- 11 --><th>Data da finalização</th>
										<!-- 12 --><th>Data do cancelamento</th>
										<!-- 13 --><th>Total</th>
										<!-- 14 --><th>Obs</th>
										<!-- 15 --><th width="10px">Ações</th>
									</tr>
								</thead>
								<tbody>

									<!-- Comando JSTL para repetição da tag TR, com leitura do objeto passado pelo JSP  -->
									<c:forEach var="encomendas" items="${encomendas}">
										<tr>
											
											<fmt:parseDate value="${encomendas.dataentrega}" pattern="yyyy-MM-dd" var="parsedDataentrega" type="date" />
											
											<!-- 00 --><td>${encomendas.id}</td>
											<!-- 01 --><td>
															<c:if test="${encomendas.status == 1}">Iniciado</c:if>
															<c:if test="${encomendas.status == 2}">Cancelado</c:if>
															<c:if test="${encomendas.status == 3}">Faturada</c:if>
															<c:if test="${encomendas.status == 4}">Produzindo</c:if>
															<c:if test="${encomendas.status == 5}">Finalizado</c:if>
														</td>
											<!-- 02 --><td>${encomendas.status}</td>
											<!-- 03 --><td>${encomendas.nomerazao}</td>
											<!-- 04 --><td>${encomendas.clienteid}</td>
											<!-- 05 --><td>${encomendas.cpfcnpj}</td>
											<!-- 06 --><td>${encomendas.responsavel}</td>
											<!-- 07 --><td>${encomendas.dataencomenda}</td>
											<!-- 08 --><td><fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDataentrega}" type="date"/></td>
											<!-- 09 --><td>${encomendas.dataentrega}</td>
											<!-- 10 --><td>${encomendas.datafaturamento}</td>
											<!-- 12 --><td>${encomendas.datafinalizado}</td>
											<!-- 13 --><td>${encomendas.datacancelamento}</td>
											<!-- 14 --><td>${encomendas.totalprodutos}</td>
											<!-- 15 --><td>${encomendas.obs}</td>
		                					<td>
		                						<button id="edit-encomenda" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
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
						
						                    <li id="tab-info" role="presentation" class="tab active">
						                        <a href="#step1" id="link-info" data-toggle="tab" aria-controls="step1" role="tab" title="Informações da encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">chrome_reader_mode</i>
						                            </span>
						                        </a>
						                    </li>
						
						                    <li id="tab-produtos" role="presentation" class="tab">
						                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Informações do produto">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">shopping_cart</i>
						                            </span>
						                        </a>
						                    </li>
						                    <li id="tab-faturar" role="presentation" class="tab disabled">
						                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Faturar encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">account_balance</i>
						                            </span>
						                        </a>
						                    </li>
						
						                    <li id="tab-produzir" role="presentation" class="tab disabled">
						                        <a href="#step4" data-toggle="tab" aria-controls="step4" role="tab" title="Produzir encomenda">
						                            <span class="round-tab">
						                                <i class="material-icons timeline">query_builder</i>
						                            </span>
						                        </a>
						                    </li>
						
						                    <li id="tab-finalizar" role="presentation" class="tab disabled">
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
							                    <button type="button" class="btn btn-default cancelar-encomenda" disabled><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>               
							                   	<button type="submit" id="btn_submit_produtos" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
							                    <button type="button" class="btn btn-default next-step" id="btn_produtos"><i class="material-icons">shopping_cart</i>&nbsp;&nbsp;&nbsp;Produtos</button>
					                   		</div>
					                   		
						                </div>
							                
						                <div class="tab-pane" role="tabpanel" id="step2">

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
													  
								                    <button type="button" class="btn btn-default cancelar-encomenda" id="cancelar-itens-encomenda" disabled><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
								                   
								                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">chrome_reader_mode</i>&nbsp;&nbsp;&nbsp;Voltar</button>
								                    <button type="submit" id="btn_submit_produtos" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
								                    <button type="button" id="btn_faturar" class="btn btn-default" data-toggle="modal"  data-target="#faturar-encomenda"><i class="material-icons">account_balance</i>&nbsp;&nbsp;&nbsp;Faturar</button>
								                    <button type="button" id="btn_faturar_bypass" class="btn btn-default next-step"><i class="material-icons">account_balance</i>&nbsp;&nbsp;&nbsp;Faturar</button>
						                   		</div>

						                </div>
						
						                <div class="tab-pane" role="tabpanel" id="step3">
											
						                    <div class="row">
						                    	
												
												<div id="errosFatura" class="col-xs-12">
													
												</div>
						                    
						                        <div class="input-margin col-xs-12 col-sm-6 col-md-4">
													<label class="control-label" for="datafaturamento">Data de faturamento:</label>
													<input type="date" id="datafaturamento" name="datafaturamento" class="form-control" readonly />
												</div>
												
												<div class="input-margin col-xs-12 col-sm-6 col-md-8">
													<label class="control-label" for="valortroco">Forma de pagamento:</label>
													<select class="form-control" id="formapagamento" name="formapagamento">
														<option value="0" selected disabled>Selecione...</option>
														<option value="1">Dinheiro</option>
														<option value="2">Cartão de crédito</option>
														<option value="3">Cartão de débito</option>
														<option value="4">Boleto</option>
														<option value="5">Cheque</option>
													</select>
												</div>
												
												<div class="input-margin col-xs-12 col-sm-6 col-md-4">
													<label class="control-label" for="totalencomenda">Valor total da encomenda:</label>
													<div class="input-group">
														<span class="input-group-addon">R$</span>
														<!-- readonly -->
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
							                    <button type="button" class="btn btn-default cancelar-encomenda"><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
							                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">shopping_cart</i>&nbsp;&nbsp;&nbsp;Voltar</button>
							                    <button type="submit" id="btn_submit_faturar" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
							                    <button type="button" id="btn_produzir" class="btn btn-default" data-toggle="modal" data-target="#produzir-encomenda"><i class="material-icons">query_builder</i>&nbsp;&nbsp;&nbsp;Produzir</button>
							                    <button type="button" id="btn_produzir_bypass" class="btn btn-default next-step"><i class="material-icons">query_builder</i>&nbsp;&nbsp;&nbsp;Produzir</button>
					                   		</div>
						                </div>
						
						                <div class="tab-pane" role="tabpanel" id="step4">
						                    <div class="row">
						                        <div class="input-margin col-xs-12 col-sm-6 col-md-3">
													<label class="control-label" for="dataproducao">Data da produção:</label>
													<input type="date" id="dataproducao" name="dataproducao" class="form-control" readonly />
												</div>
						                    </div>
						                    
						                    <div class="row">
						                    	<div class="col-xs-12">
						                    	
						                    		<div id="lista-producao" class="panel-group" role="tablist">
														
													</div>
						                    		
															                    	
						                    	</div>
						                    </div>
						                    
						                    
						                    <div class="modal-footer modal-margin-top">
												<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
							                    <button type="button" class="btn btn-default cancelar-encomenda"><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
							                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">account_balance</i>&nbsp;&nbsp;&nbsp;Voltar</button>
							                    <button type="submit" id="btn_submit_produzir" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
							                    <button type="button" id="finalizar_btn" class="btn btn-default disabled next-step" disabled><i class="material-icons">done</i>&nbsp;&nbsp;&nbsp;Finalizar</button>
					                   		</div>
						                </div>
						
						                <div class="tab-pane" role="tabpanel" id="complete">
						                    <div class="row">
						                        <div class="input-margin col-xs-12 col-sm-6 col-md-3">
													<label class="control-label" for="datafinalizado">Data da finalização:</label>
													<input type="date" id="datafinalizado" name="datafinalizado" class="form-control" readonly />
												</div>
						                    </div>
						                    
						                    <div class="modal-footer modal-margin-top">
												<button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
							                    <button type="button" class="btn btn-default cancelar-encomenda"><i class="material-icons">cancel</i>&nbsp;&nbsp;&nbsp;Cancelar</button>
							                    <button type="button" class="btn btn-default prev-step"><i class="material-icons">query_builder</i>&nbsp;&nbsp;&nbsp;Voltar</button>
							                    <button type="submit" id="btn_submit_finalizar" class="btn btn-default"><i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar</button>
							                    <button type="submit" class="btn btn-default" id="finalizar-encomenda" disabled><i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Finalizar</button>
					                   		</div>
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
	
	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE ENCOMENDA ####################
	
	-->
	
	<div class="modal fade" id="faturar-encomenda" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">Faturar encomenda</h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<p>Deseja realmente faturar a encomenda?</p>
								<p>Após o fechamento não será possível algumas informações da encomenda.</p>
							</div>
						</div>
					</div>
					
					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar-->
						<button type="button" class="btn btn-default faturar_btn" data-dismiss="modal">Fechar</button>
						<button type="button" class="btn btn-default faturar_btn next-step" data-dismiss="modal">Faturar encomenda</button>
					</div>

				
			</div>
		</div>
	</div>
	
	<!--
	
	######################################################### FIM DO MODAL DE INCLUSÃO OU ALTERAÇÂO DE ENCOMENDA ####################
	
	-->
	
	<div class="modal fade" id="produzir-encomenda" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">Produzir encomenda</h4>
					</div>
					
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<p>Deseja realmente produzir a encomenda?</p>
								<p>Após a confirmação não será possível algumas informações da encomenda e do faturamento.</p>
							</div>
						</div>
					</div>
					
					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar-->
						<button type="button" class="btn btn-default produzir_btn" data-dismiss="modal">Fechar</button>
						<button type="button" class="btn btn-default produzir_btn next-step" data-dismiss="modal">Produzir encomenda</button>
					</div>

				
			</div>
		</div>
	</div>
	
	<!--
	
	######################################################### MODAL DE ERRO #########################################################
	
	-->
	
	<div class="modal fade" id="modal_erro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<!-- Faturar encomenda -->
						<h4 class="modal-title" id="title_modal_erro"></h4>
					</div>
						
					<!--  Corpo do modal -->
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<!-- Deseja realmente faturar a encomenda? -->
								<p id="msg1_modal_erro"></p>
								<!-- Após o fechamento, não será possível alterar algumas informações da encomenda. -->
								<p id="msg2_modal_erro"></p>
							</div>
						</div>
					</div>
					
						<!-- ################################# ALERTAS ################################# -->				
						<div class="row" id="msg1" >
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda iniciada com sucesso.
								</div>
							</div>
						</div>
					
						<div class="row" id="msg2">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar incluir a nova encomenda, favor tente novamente.
								</div>
							</div>
						</div>
					
						<div class="row" id="msg3">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Alteração efetuada com sucesso.
								</div>
							</div>
						</div>
					
						<div class="row" id="msg4">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar alterar a encomenda, favor tente novamente.
								</div>
							</div>
						</div>
					
						<div class="row" id="msg5">
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda foi excluida com sucesso!
								</div>
							</div>
						</div>
					
						<div class="row" id="msg6">
							<div class="col-xs-12">
								<div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Erro!</strong> Houve algum erro ao tentar excluir a encomenda, favor tente novamente.
								</div>
							</div>
						</div>
						
						<div class="row" id="msg7" >
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda faturada com sucesso.
								</div>
							</div>
						</div>
						
						<div class="row" id="msg8" >
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda produzindo com sucesso.
								</div>
							</div>
						</div>
						
						<div class="row" id="msg9" >
							<div class="col-xs-12">
								<div class="alert alert-success alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <strong>Sucesso!</strong> Encomenda finalizada com sucesso.
								</div>
							</div>
						</div>
					
					<!-- ################################# FIM DOS ALERTAS ################################# -->
					<!-- Essa div contem 2 botões -->
					<div class="modal-footer">
						<!-- botão de cancelar-->
						<button type="button" id="btn_ok_modal_erro" class="btn btn-default" data-dismiss="modal" >ok</button>
						
					</div>

				
			</div>
		</div>
	</div>
	
	<!--
	############################################################ FIM DO MODAL DE ERRO ############################################################
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
			
			$('.panel-group').collapse()
			
			/*
			*
			* CONFIGURA MASCARAS
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
			            
			            url: '../Gracibolos/rest-clientes/' + encodeURIComponent(query),
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

			/*
			*
			* PESQUISA PRODUTOS E POPULA O VALOR
			*
			*/
			
			//Quandor alterar o produto, captura o valor e preenche.
			$("#produtos").on("change", ".produto", function(){
				var linha = this.id.replace("produto_", "");
				
				pesquisarValor(linha);
			});
			
			
			$(document).on("change", ".produtopronto", function(){
				
				//Verifica se todos os checkbox estão preenchidos
				if($('.produtopronto:checked').length == $('.produtopronto').length) {
					$('#finalizar_btn').removeAttr('disabled').removeClass('disabled');
				} else {
					$('#finalizar_btn').attr('disabled','disabled').addClass('disabled');
				}
				
			});
			
			/*
			*
			* Verifica se a quantidade ou o valor é alterado, se for, realiza o calculo do produto.
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
			};
			
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
				$('#totalencomenda').val(total).trigger('input');
				
			};		

			function pesquisarValor(linha){
				
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
			}
			
			
			function verificaStatus(status) {
				
				//Volta para a primeira telas
				$('#link-info').click();
				
				switch(status){
					
					case '1':
						$('#tab-faturar').addClass('disabled');
						$('#tab-produzir').addClass('disabled');
						$('#tab-finalizar').addClass('disabled');
						
						$('.cancelar-encomenda').removeAttr('disabled');
						
						$('#btn_faturar').removeClass('hidden').removeAttr('disabled');
						$('#btn_faturar_bypass').addClass('hidden').attr('disabled','disabled');
						
						var selectize = $('#cliente')[0].selectize;
						selectize.enable();
						
						$('#inserir-linha').removeClass('disabled').removeAttr('disabled');
						
						break;
						
					case '2':
						
						$('.cancelar-encomenda').attr('disabled','disabled');
						
						break;
					
					case '3':
						$('#tab-faturar').removeClass('disabled');
						$('#tab-produzir').addClass('disabled');
						$('#tab-finalizar').addClass('disabled');
						
						$('.cancelar-encomenda').removeAttr('disabled');
						
						$('#btn_faturar').addClass('hidden').attr('disabled','disabled');
						$('#btn_faturar_bypass').removeClass('hidden').removeAttr('disabled');
						
						$('#btn_produzir').removeClass('hidden').removeAttr('disabled');
						$('#btn_produzir_bypass').addClass('hidden').attr('disabled','disabled');
						
						var selectize = $('#cliente')[0].selectize;
						selectize.disable();
						
						$('#inserir-linha').addClass('disabled').attr('disabled','disabled');

						setTimeout(function(){
							$('#lista-produtos tr').each(function () {					
								//Captura os numeros de linhas
								var linha = this.id.replace('item_', '');

								var selectize = $('#produto_'+linha)[0].selectize;
								selectize.disable();

								$('#valor_'+linha).attr('readonly','readonly');
								$('#quantidade_'+linha).attr('readonly','readonly');
								$('#delete-produto_'+linha).addClass('disabled').attr('disabled','disabled');
								
								calculaTotalProdutos();
							});
						}, 500);
						
						$('#formapagamento option').each(function () {					
							if($(this).val() != 0){
								$(this).removeAttr('disabled');
							}
						});
						
						$('#valorpago').removeAttr('readonly');
						
						break;
					
					case '4':
						
						$('#tab-faturar').removeClass('disabled');
						$('#tab-produzir').removeClass('disabled');
						$('#tab-finalizar').addClass('disabled');
						
						$('.cancelar-encomenda').removeAttr('disabled');
						
						$('#btn_faturar').addClass('hidden').attr('disabled','disabled');
						$('#btn_faturar_bypass').removeClass('hidden').removeAttr('disabled');
						
						$('#btn_produzir').addClass('hidden').attr('disabled','disabled');
						$('#btn_produzir_bypass').removeClass('hidden').removeAttr('disabled');
						
						var selectize = $('#cliente')[0].selectize;
						selectize.disable();
						
						$('#inserir-linha').addClass('disabled').attr('disabled','disabled');

						setTimeout(function(){
							$('#lista-produtos tr').each(function () {					
								//Captura os numeros de linhas
								var linha = this.id.replace('item_', '');

								var selectize = $('#produto_'+linha)[0].selectize;
								selectize.disable();

								$('#valor_'+linha).attr('readonly','readonly');
								$('#quantidade_'+linha).attr('readonly','readonly');
								$('#delete-produto_'+linha).addClass('disabled').attr('disabled','disabled');
								
								calculaTotalProdutos();
							});
						}, 500);
												
						$('#formapagamento option').each(function () {					
							if($(this).val() != 4){
								$(this).attr('disabled','disabled');
							}
						});
						
						$('#valorpago').attr('readonly','readonly');
						
						break;
						
					case '5':
						
						$('#tab-faturar').removeClass('disabled');
						$('#tab-produzir').removeClass('disabled');
						$('#tab-finalizar').removeClass('disabled');
						
						break;
				}
			}
			
			
			/*
			*
			* CRIA UMA NOVA LINHA DE PRODUTOS.
			*
			*/


			$('#inserir-linha').on('click', function() {
				
				//Chama o método para inserção
				inserir_item();
				
			});//Fim inserir linha
			
			/*
			*
			* EXCLUSÃO DA LINHA
			*
			*/
			
			$('#produtos').on('click', '.delete_produto', function() {
				
				//Busca a linha e remove o TR.
				$(this).parent().parent().remove();
	
				calculaTotalProdutos();
			});
			
			function inserir_item_producao(produto, quantidade){
				
				var lista = $('#lista-producao');
				var i = $('#lista-producao div.panel').size() + 1;
				
				var item_prod = '<div class="panel panel-default">';
				item_prod +=		'<div class="panel-heading" role="tab" id="collapseListGroupHeading1">';
				item_prod +=			'<h4 class="panel-title">';
				item_prod +=				'<a class="" role="button" data-toggle="collapse" href="#item'+i+'" aria-expanded="true" aria-controls="collapseListGroup1">#'+i+' - '+produto+' - '+quantidade+' unidade(s).</a>';
				item_prod +=			'</h4>';
				item_prod +=		'</div>';
				item_prod +=		'<div id="item'+i+'" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1" aria-expanded="true">';
				item_prod +=			'<ul class="list-group">';
				
				for(j=1; j<=quantidade; j++) {
					
					item_prod +=				'<li class="list-group-item">';
					item_prod +=					'<label class="google-checkbox input-brown">';
					item_prod +=						'<input type="checkbox" class="produtopronto" name="produtopronto" value="true">';
					item_prod +=						'<i class="material-icons checked">check_box</i>';
					item_prod +=						'<i class="material-icons unchecked">check_box_outline_blank</i>';
					item_prod +=						produto+' '+j+'/'+quantidade;
					item_prod +=					'</label>';
					item_prod +=				'</li>';
					
				}
				
				item_prod +=			'</ul>';
				item_prod +=		'</div>';
				item_prod +=	'</div>';
				
				lista.append(item_prod);
				
			    i++;
				
			}

			function inserir_item(callback){
				
				var produtos = $('#produtos');
				var i = $('#produtos tr').size() - 1;
				
				if($('#produtos tr').size() <= 100){
				  	
				    var item = '<tr id="item_'+i+'">';
				    item +=			'<td class="hidden">';
				    item += 			'<input type="text" name="item['+i+'].id" id="id_'+i+'" class="readonly" />';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<select name="item['+i+'].produtoId" id="produto_'+i+'" class="form-control produto" placeholder="Digite o código ou nome do produto."></select>';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<input type="number" name="item['+i+'].quantidade" id="quantidade_'+i+'" placeholder="0" class="form-control quantidade"  min="0" max="9999999" />';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<div class="input-group">';
				    item += 				'<span class="input-group-addon">R$</span>';
				    item += 				'<input type="text" name="item['+i+'].valor" id="valor_'+i+'" placeholder="0,00" class="form-control valor" />';
				    item += 			'</div>';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<div class="input-group">';
				    item += 				'<span class="input-group-addon">R$</span>';
				    item += 				'<input type="text" name="item['+i+'].total" id="total_'+i+'" class="form-control total" readonly="readonly" />';
				    item += 			'</div>';
				    item += 		'</td>';
				    item +=			'<td>';
				    item += 			'<button type="button" id="delete-produto_'+i+'" class="btn btn-default delete_produto"><i class="material-icons">remove_shopping_cart</i></button>';
				    item += 		'</td>';
				    item += 	'</tr>';
			    
				    produtos.append(item);
				    
				    addSelectize(i, function(){
				    	callback(i);
				    });
				    
				    i++;
				    
				}else {
					alert('Você atingiu o limite máximo de produtos na encomenda');
				}
			};
			
			function addSelectize(i, callback){

				$("#produto_"+i).selectize({
				    valueField: 'id',
				    labelField: 'nome',
				    searchField: ['codigo', 'nome'],
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
				            
				            url: '../Gracibolos/rest-pesquisar-produto-nome/' + encodeURIComponent(query),
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
				
				callback();
			};
			
// 			//Remove as mascaras quando apertar o submit
// 			$("#dados-encomenda").submit(function(e) {
// 				e.preventDefault();				
// 				return true;				
// 			});

			
// 			//apertar o submit --------------------------------------------------  	
// 			$("#produtos-encomenda").submit(function(e) {
// 				e.preventDefault();//Aqui desativa o submit do form
// 				return false;
// 			});

			//Verifica se existe algum item de produto
			function verificaProdutos(){
				
				if($('#lista-produtos tr').length){
					//alert('produtos existe');
					return true;
				}else{
					document.getElementById("step2").focus();
					//alert('produtos não existe');
					return false;
				}
			};
			
			function verificaTotalP(){
				if($('#totalprodutos').val() == ''){
					document.getElementById("totalprodutos").focus();
					//alert('total não existe');
					return false;
				}else{
					//alert('nome existe');
					return true;
				}
			};

			function verificaCliente(){
				if($('#cliente').val() == ''){
					document.getElementById("cliente").focus();
					//alert('nome não existe');
					return false;
				}else{
					//alert('nome existe');
					return true;
				}
			};

			function verificaItemProdutoNome(){
				var status;
				$('#lista-produtos tr').each(function () {					
					//Captura os numeros de linhas
					var linha = this.id.replace('item_', '');
					var produto = $('#produto_' + linha);
					if(produto.val() == ''){
						console.log('item nome do produto '+linha+' não existe');
						return  status = false;
						alert('item nome do produto '+linha+' não existe');
					}else{
						return status = true;
					}							
					//var quantidade = $('#quantidade_' + linha);
					//var valor = $('#valor_' + linha);
					//var total = $('#total_' + linha);				
				});
				
			};

			function verificaFormaPag(){
				if(($('#formapagamento').val() == '')){
					document.getElementById("formapagamento").focus();
					//alert('forma pagamento não existe');
					return false;
				}else{
					//alert('nome existe');
					return true;
				}
			};

			function verificaDataEntr(){
				if($('#dataentrega').val() == ''){
					document.getElementById("dataentrega").focus();
					//alert('data entrega não existe');
					return false;
				}else{
					//alert('nome existe');
					return true;
				}
			};

			function verificaValorPago(){
				if($('#valorpago').val() == ''){
					document.getElementById("valorpago").focus();
					//alert('valor pago não existe');
					return false;
				}else{
					//alert('nome existe');
					return true;
				}
			};

			function recarregar(){
				window.location.href = "../Gracibolos/administrativo-encomendas";
			};
			
			function verificaFormaPag(){//Não funciona
				if(($('#formapagamento').val() == '')){
					document.getElementById("formapagamento").focus();
					//alert('forma pagamento não existe');
					return false;
				}else{
					//alert('nome existe');
					return true;
				}
			};

			$('#btn_faturar').click(function(){
            	var totalprodutos = $('#totalprodutos').val();     
				$('#totalencomenda').val(totalprodutos);
            });

			function recarregar(){
				window.location.href = "../Gracibolos/administrativo-encomendas";
			};
			
			function recarregar(){
				window.location.href = "../Gracibolos/administrativo-encomendas";
			};
			
			/*
			*
			* INCLUIR ENCOMENDA---------------------------------------
			*
			*/

			function inserirEncomenda(status, callback){
				//recupera os valores da encomenda
				var enc = new Object();
				if(status==3){
					enc.status = 3;//status - faturada
				}else{
					enc.status = 1;//status - inicializada
				}
				enc.dataencomenda = $('#dataencomenda').val();
				enc.dataentrega = $('#dataentrega').val();
				enc.datacancelado = $('#datacancelado').val();
				enc.clienteid = $('#cliente').val();
				enc.responsavel = $('#responsalvel').val();
				enc.obs = $('#obs').val();

	
				enc.listItemEncomenda = [];

				
				$('#lista-produtos tr').each(function () {
					
					//Captura os numeros de linhas
					var linha = this.id.replace("item_", "");
					
					var produto = $('#produto_' + linha);
					var quantidade = $('#quantidade_' + linha);
					var valor = $('#valor_' + linha);
					var total = $('#total_' + linha);
				
	                 // Criar objeto para armazenar os dados
	                 var itemencomenda = new Object();
	                 
	                 itemencomenda.produtoId = produto.val(); // valor da coluna id do Produto
	                 itemencomenda.quantidade = quantidade.val(); // Valor da coluna Quantidade
	                 				
	                 var valor_temp = valor.val(); // Valor da coluna Quantidade
	 				 valor_temp = valor_temp.split(".").join("");//Retirar a máscara
	 				 itemencomenda.valor = valor_temp.split(",").join(".");//Retirar a máscara

 					 valor_temp = '';
	 				 valor_temp = total.val();//total
	 				 valor_temp = valor_temp.split(".").join("");//Retirar a máscara	
	                 itemencomenda.total = valor_temp.split(",").join(".");//Retirar a máscara

	                 //Insere todos os itens no list
	                 enc.listItemEncomenda[linha] = itemencomenda;

				});		
	
				//Parse para json		
				var js = JSON.stringify(enc);
				//alert(enc);
				
				$.ajax({
		            url: "../Gracibolos/rest-encomenda/",
		            type: 'POST',    
		            data: js,
		            contentType: "application/json; charset=utf-8",
		            success: function(result) {   
		                $('#id').val(result);//Com o retorno do numero da encomenda, preencho o campo id
		                callback(result);                
		            }
		        });
				
			};// FIM INSERIR ENCOMENDA --------------------------------------------------------------
			
			
			$("#btn_submit_produtos").click(function() {
				
				if(verificaCliente() && verificaDataEntr()){
					
					inserirEncomenda(1, resposta);//insiro a encomenda e espero a resposta (callback)
					function resposta(result){//essa resposta é uma função

						$('#msg1').show();//Encomenda inicializada
						console.log('resposta '+result);
						$('#title_modal_erro').text('Número da encomenda : ');
		                $('#msg1_modal_erro').text(result);
						$('#modal_erro').modal('show');
						$('#btn_ok_modal_erro').click(function(){
							setTimeout(function(){recarregar();}, 500	);	
						});
					}
										
				}else{

				}
					
			});//INCLUIR ENCOMENDA SUBMIT---------------------------------------


			/*
			*
			* FATURAR ENCOMENDA---------------------------------------
			*
			*/

			function faturar(callback){
				//alert('faturar');
				var caixa = new Object();

				caixa.parcela = 1;
				caixa.gastoRecebimento = 1;//gastoRecebimento
				caixa.encomendaId = $('#id').val();//encomendaId
				caixa.dataTransacao = $('#datafaturamento').val();//dataTransacao(inserindo no dao)
				
				var valor_temp = $('#totalencomenda').val(); //Total encomenda
				valor_temp = valor_temp.split(".").join("");//Retirar a máscara
				caixa.valor = valor_temp.split(",").join(".");//Retirar a máscara
				 
				caixa.forma = $('#formapagamento').val();//forma
				
				var js = JSON.stringify(caixa);
				//alert(js);
			
				$.ajax({//Enviando o caixa
		            url: "../Gracibolos/rest-caixa/",
		            type: 'POST',    
		            data: js,
		            contentType: "application/json; charset=utf-8",
		            success: function(msg) {
		                //alert(msg);   
		                console.log('ajax faturada'+msg)               
		                callback(msg);            
		            }
		        });
			};
			
			$("#btn_submit_faturar").click(function() {
				if(verificaCliente() && verificaProdutos() && verificaTotalP() && verificaValorPago()){
					
					inserirEncomenda(3, resposta);//insiro a encomenda e espero a resposta (callback)
					function resposta(result){//essa resposta é uma função

						//$('#msg1').show();//Encomenda inicializada
						$('#msg7').show(); //Faturada
						console.log('resposta iniciada'+result);
						$('#title_modal_erro').text('Número da encomenda : ');
		                $('#msg1_modal_erro').text(result);
						$('#modal_erro').modal('show');
						$('#btn_ok_modal_erro').click(function(){
							
							faturar(resposta);//função faturar com callback 
							function resposta(result){
								console.log('callback faturada'+result)							
								setTimeout(function(){recarregar();}, 500 );	
							}						
							
						});
					}							
					
				}else{

				}			
				
			});
			//FIM - FATURAR ENCOMENDA---------------------------------------

			/*
			*
			* PRODUZIR ENCOMENDA---------------------------------------
			*
			*/
			$("#btn_submit_produzir").click(function() {

				var id = $('#id').val();//encomendaId
				var js = JSON.stringify(id);
				
				$.ajax({
		            url: "../Gracibolos/rest-encomenda/prod/",
		            type: 'PUT',    
		            data: JSON.stringify(id),
		            contentType: "application/json; charset=utf-8",
		            success: function(result) {
		                //alert(result);
		            	$('#msg8').show(); 
		            	$('#msg1_modal_erro').text(result);
		            	$('#modal_erro').modal('show'); 
						$('#btn_ok_modal_erro').click(function(){		
							setTimeout(function(){recarregar();}, 500 );
						});          
		            }
		        });
				     
				
				//setTimeout(function(){resetCampos();}, 1500	);		
			});
			//FIM - PRODUZIR ENCOMENDA---------------------------------------


			/*
			*
			* FINALIZAR ENCOMENDA---------------------------------------
			*
			*/
			$("#btn_submit_finalizar").click(function() {

				var id = $('#id').val();//encomendaId
				
				$.ajax({
		            url: "../Gracibolos/rest-encomenda/fin/",
		            type: 'PUT',    
		            data: JSON.stringify(id),
		            contentType: "application/json; charset=utf-8",
		            success: function(result) {
		                //alert(result);
		            	$('#msg9').show();   
		            	$('#msg1_modal_erro').text(result);
		            	$('#modal_erro').modal('show');   
		            	$('#btn_ok_modal_erro').click(function(){		
		            		setTimeout(function(){recarregar();}, 500 );
						});                 
		            }
		        });
				
				
				//setTimeout(function(){resetCampos();}, 1500	);		
			});
			//FIM - FINALIZAR ENCOMENDA---------------------------------------
			
// 			//Remove as mascaras quando apertar o submit
// 			$("#faturar-encomenda").submit(function(e) {
// 				e.preventDefault();
				
// 				return false;
// 			});
			
// 			//Remove as mascaras quando apertar o submit
// 			$("#produzir-encomenda").submit(function(e) {
// 				e.preventDefault();
				
// 				return false;
// 			});
			
// 			//Remove as mascaras quando apertar o submit
// 			$("#finalizar-encomenda").submit(function(e) {
// 				e.preventDefault();
				
// 				return false;
// 			});
			
			//CALCULO DO TROCO
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
					var erro = '<div id="erroValorPago" class="alert alert-danger alert-dismissible fade in" role="alert">';
							erro +='<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
							erro +='<strong>Atenção!</strong> O valor pago informado é menor do que o valor total da encomenda.';
						erro +='</div>';
					
					$('#errosFatura').append(erro);
					
					setTimeout(function(){
						$('#erroValorPago').alert('close');
					}, 5000)
					
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

            	/*          	
            		<!-- 00 --><th>Encomenda</th>
					<!-- 01 --><th>Status</th> VIEW
					<!-- 02 --><th>Status</th> DADOS
					<!-- 03 --><th>Cliente</th>
					<!-- 04 --><th>Cliente ID</th>
					<!-- 05 --><th>Cliente CPF/CNPJ</th>											
					<!-- 06 --><th>Responsável</th>
					<!-- 07 --><th>Data da encomenda</th>
					<!-- 08 --><th>Data de entrega</th> VIEW
					<!-- 09 --><th>Data de entrega</th> DATA
					<!-- 10 --><th>Data do faturamento</th>
					<!-- 11 --><th>Data da finalização</th>
					<!-- 12 --><th>Data do cancelamento</th>
					<!-- 13 --><th>Total</th>
					<!-- 14 --><th>Obs</th>
					<!-- 15 --><th>Ações</th>            	
            	*/
                
                "columnDefs": [
                    {
                        "targets": [ 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14 ],
                        "visible": false
                    }
                ]
            });
            
          //Reset autmaticamente todos os campos do formulário.
           function resetCampos(){
				
				$('#tab-faturar').addClass('disabled');
				$('#tab-produzir').addClass('disabled');
				$('#tab-finalizar').addClass('disabled');
				
				$('.cancelar-encomenda').attr('disabled','disabled');
				
				$('#id').val('');
				$('#dataentrega').val('');
				$('#datacancelado').val('');
				
				var selectize = $('#cliente')[0].selectize;//Autocomplete
                selectize.enable();
                selectize.clearOptions();
               
				$('#responsavel').val('');
				$('#obs').val('');
				

				$('#inserir-linha').removeClass('disabled').removeAttr('disabled');
				
				$("#lista-produtos tr").each(function(){//itens produtos
					$(this).remove();
				});
				
				$('#totalprodutos').val('');
				$('#total').val('');
				
				$('#btn_faturar').removeClass('hidden').removeAttr('disabled');
				$('#btn_faturar_bypass').addClass('hidden').attr('disabled','disabled');
				
				$('#btn_produzir').removeClass('hidden').removeAttr('disabled');
				$('#btn_produzir_bypass').addClass('hidden').attr('disabled','disabled');
				
				$('#formapagamento option').each(function () {					
					if($(this).val() != 0){
						$(this).removeAttr('disabled');
					}
				});
				
				$('#valorpago').removeAttr('readonly');
				
            }

          	//------settando a data de hoje---------------------------------
			var now = moment().format('YYYY-MM-DD');        
			$('#datafaturamento').val(now);//Colocar a data de hoje
            $('#dataencomenda').val(now);
            $('#dataproducao').val(now);
            $('#datafinalizado').val(now);
            
            /*
			*
			* INCLUSÃO DE ENCOMENDA
			*	btn-incluir nova encomenda
			*/
            $('#incluir-encomenda-modal').click(function() {
            	
            	resetCampos();

				inserir_item();	

            	//Altera dinamicamente o titulo do modal.
				$('#modal-subtitle').text("Incluir nova encomenda");
				
				//Nome do botão incluir encomenda
				$("#btn_submit_produtos").html('<i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar');
				//Nome do botão do faturar.
				$("#btn_submit_faturar").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Faturar');
				//Nome do botão do produzir.
				$("#btn_submit_produzir").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Produzir');
				//Nome do botão do finalizar.
				$("#btn_submit_finalizar").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Finalizar');   
				               
				$("#btn_submit_finalizar").html('<i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Finalizar');

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
				$("#btn_submit_produtos").html('<i class="material-icons">save</i>&nbsp;&nbsp;&nbsp;Salvar'); 
				
				//Pega os dados de determinada linha da tabela.
                var data = table.row( $(this).parents('tr') ).data();

           		//Apresenta o modal de exclusão na tela.
           		$('#modal-encomenda').modal('show');

           		/*
            	
        		<!-- 00 --><th>Encomenda</th>
				<!-- 01 --><th>Status</th> VIEW
				<!-- 02 --><th>Status</th> DADOS
				<!-- 03 --><th>Cliente</th>
				<!-- 04 --><th>Cliente ID</th>
				<!-- 05 --><th>Cliente CPF/CNPJ</th>											
				<!-- 06 --><th>Responsável</th>
				<!-- 07 --><th>Data da encomenda</th>
				<!-- 08 --><th>Data de entrega</th> VIEW
				<!-- 09 --><th>Data de entrega</th> DATA
				<!-- 10 --><th>Data do faturamento</th>
				<!-- 11 --><th>Data da finalização</th>
				<!-- 12 --><th>Data do cancelamento</th>
				<!-- 13 --><th>Total</th>
				<!-- 14 --><th>Obs</th>
				<!-- 15 --><th>Ações</th>
        	
        		*/
           		
				//Preenche os determinados campos com os conteudos.
                $('#id').val(data[0]);
                $('#status').val(data[2]);
                
                //Settando no selectize os valores vindo da tabela
                var selectize = $('#cliente')[0].selectize;
                selectize.clearOptions();
                selectize.addOption({id:data[4], nomerazao:data[3], cpfcnpj:data[5]});
                selectize.setValue(data[4]);
                
                $('#responsavel').val(data[6]);
                $('#dataencomenda').val(data[7]);
   				$('#dataentrega').val(data[9]);
                $('#datafaturamento').val(data[10]);
                //$('#dataproducao').val(data[9]);
                //$('#datafinalizado').val(data[11]);
   				$('#datacancelado').val(data[12]);
   				$('#total').val(data[13]);
   				$('#obs').val(data[14]);

				//carrega os itens à partir do número da encomenda
				var url = '/Gracibolos/rest-itensencomenda/'+data[0];
				$.getJSON(url).done(function(data){
					
					//recebe por parâmetro a lista de objetos. i = iteração e field = objeto
					$("#lista-produtos tr").each(function(){
						$(this).remove();
					});
					
					$("#lista-producao div").each(function(){
						$(this).remove();
					});
					
					$.each(data, function(i, field){
						$('#produtos').off('change', '.produto');
						
						inserir_item(function(linha){
							
							selectize = $('#produto_'+linha)[0].selectize;
			                selectize.clearOptions();
			                selectize.addOption({id:data[i].produtoId, codigo:'código', nome:data[i].nomeProduto});
			                selectize.setValue(data[i].produtoId);
			                
							$('#quantidade_' + linha).val(data[i].quantidade).trigger('input');
							$('#valor_' + linha).val(parseFloat(data[i].valor).toFixed(2).replace(".", ",")).trigger('input');
							$('#total_' + linha).val(parseFloat(data[i].total).toFixed(2).replace(".", ",")).trigger('input');
							
							calculaTotalProdutos();
						});
						
						$("#produtos").on("change", ".produto", function(){
							var linha = this.id.replace("produto_", "");
							
							pesquisarValor(linha);
						});
						

						inserir_item_producao(data[i].nomeProduto, data[i].quantidade);
						
			        });
					
				});
				
				verificaStatus(data[2]);
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
			
			
			
			
			
			
            /*
			*
			* REALIZA A SUBSTITUIÇÃO DO MODAL QUANDO OUTRO É INVOCADO
			*
			*/

			//Remove o modal de encomenda
			$('#btn_faturar').on('click', function(){
				$('#modal-encomenda').addClass('hidden');
			});
			
			//Remove o modal de encomenda
			$('#btn_produzir').on('click', function(){
				$('#modal-encomenda').addClass('hidden');
			});
			
			//Adiciona o modal de encomenda
			$('.faturar_btn').on('click', function(){
				$('#modal-encomenda').removeClass('hidden');
			});

			//Adiciona o modal de encomenda
			$('.produzir_btn').on('click', function(){
				$('#modal-encomenda').removeClass('hidden');
			});
			
			
			
			
			
            /*
			 MENSAGENS DE ERRO
			*/
			$('#msg1').hide();
			$('#msg2').hide();
			$('#msg3').hide();
			$('#msg4').hide();
			$('#msg5').hide();
			$('#msg6').hide();
			$('#msg7').hide();
			$('#msg8').hide();
			$('#msg9').hide();
			

            
            
		});
	</script>
	
	
</body>
</html>