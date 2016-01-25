<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="PT-BR">
<head>

	<!-- Defenição dos arquivos meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Importação dos arquivos CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/reset.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/jquery.bootgrid.css" rel="stylesheet">

	<!-- Titulo da página -->
	<title>Graci Bolos | Incluir novo produto</title>

</head>

<body>

	<!-- Container com layout fluido, preenchendo maior parte da tela -->
	<div class="container-fluid fullheight">

		<!-- Cria uma linha para armazenar todo o conteudo -->
		<div class="row fullheight">
			
			<!-- Barra de navegação Mobile e desktop -->
			<%@ include file="menu.jsp" %>
			
			<div class="content fullpage col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<div class="margin-top">

					<!-- Titulo e subtitulo da pagina -->
					<header>
						<h2>PRODUTOS</h2>
						<h4>Incluir novo produto</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->

					<div class="row">

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

							<div class="row">
								<div class="col-xs-12">
									<ul class="nav nav-tabs">
										<li class="active"><a data-toggle="tab" href="#info">InformaÃ§Ãµes do produto</a></li>
										<li><a data-toggle="tab" href="#receita">Receita do produto</a></li>
									</ul>

									<div class="tab-content">

										<div id="info" class="tab-pane fade in active">
											<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
												<label class="control-label">Foto do produto:</label>
												<a href="#"></a>
													<img class="thumbnail img-responsive" src="resources/img/modelo.png" alt="...">
												</a>
											</div>

											<div class="col-xs-12 col-sm-6 col-md-6 col-lg-9">
												<div class="row">
													<div class="input-margin col-xs-6 col-sm-6 col-md-6 col-lg-4">
														<label class="control-label" for="status">Status:</label>
														<select class="form-control" id="status" name="status" required>
															<option selected value="1">Ativado</option>
															<option value="0">Desativado</option>
														</select>
													</div>

													<div class="input-margin col-xs-6 col-sm-6 col-md-6 col-lg-8">
														<label class="control-label" for="status">Tipo*:</label>
														<select class="form-control" id="status" name="status" required>
															<option value="" selected="true" disabled="">Selecione</option>
															<option value="1">Bolo</option>
															<option value="0">Salgados</option>
														</select>
													</div>

													<div class="clearfix"></div>

													<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-lg-4">
														<label class="control-label" for="nome" id="nome_lbl">CÃ³digo*:</label>
														<input type="text" id="nome_inp" class="form-control" maxlength="20" placeholder="Digite o cÃ³digo do produto" name="codigo" required>
													</div> 

													<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-lg-8">
														<label class="control-label" for="nome" id="nome_lbl">Nome*:</label>
														<input type="text" id="nome_inp" class="form-control" maxlength="100" placeholder="Digite o nome do produto" name="nome" required>
													</div>

													<div class="clearfix"></div>

													<div class="input-margin col-xs-6 col-sm-6 col-md-6 col-lg-4">
														<label class="control-label" for="status">Unidade*:</label>
														<select class="form-control" id="status" name="status" required>
															<option value="" selected disabled="true">Selecione:</option>
															<option value="kg">kg</option>
															<option value="gr">gr</option>
														</select>
													</div>

													<div class="input-margin col-xs-6 col-sm-6 col-md-6 col-lg-8">
														<label class="control-label" for="endereco">Peso:</label>
														<input type="text" class="form-control" name="peso" maxlength="20" placeholder="Digite aqui o peso do produto">
													</div>

													<div class="clearfix"></div>

													<div class="input-margin col-xs-6 col-sm-6 col-md-6 col-lg-4">
														<label class="control-label" for="endereco">Custo do produto:</label>
														<input type="text" class="form-control" name="custo" maxlength="20" placeholder="Digite aqui o custo do produto">
													</div>

													<div class="input-margin col-xs-6 col-sm-6 col-md-6 col-lg-4">
														<label class="control-label" for="endereco">Valor do produto*:</label>
														<input type="text" class="form-control" name="valor" maxlength="20" placeholder="Digite aqui o valor do produto" required>
													</div>

													<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-lg-4">
														<label class="control-label" for="qtdcompras">Quantidade no estoque:</label>
														<input type="number" class="form-control input-brown" nname="estoque" value="0">
													</div>
												</div>
											</div>

											<div class="input-margin col-xs-12 col-sm-12 col-md-12">
												<label class="control-label" for="obs">Observação:</label>
												<textarea class="form-control" name="obs" name="obs" id="obs" placeholder="Digite aqui as observaÃ§Ãµes"></textarea>
											</div>

											<div class="input-margin col-xs-12 col-sm-12 col-md-12 text-right">
												<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-disk disabled"></span>&nbsp;&nbsp;&nbsp;Incluir produtos</button>
											</div>
										</div>

										<div id="receita" class="tab-pane fade">
											<table id="grid-basic" class="table table-hover">
												<thead>
													<tr>
														<th data-column-id="id" data-visible="false">#</th>
														<th data-column-id="nome">Nome</th>
														<th data-column-id="medida">Medida</th>
														<th data-column-id="unidade">Unidade</th>
														<th data-column-id="comandos" data-formatter="commands" data-sortable="false">AÃ§Ãµes</th>
													</tr>
												</thead>
												<tbody>

													<tr>
														<td>1</td>
														<td>Farinha de trigo</td>
														<td>200</td>
														<td>gr</td>
													</tr>

													<tr>
														<td>1</td>
														<td>Ovos de galinha</td>
														<td>2</td>
														<td>un</td>
													</tr>

												</tbody>
											</table>

											<div class="row">
												<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
													<a class="btn btn-default fullwidth" href="incluir_cliente.jsp"><span class="glyphicon glyphicon-plus disabled"></span>&nbsp;&nbsp;&nbsp;Incluir novo ingrediente</a>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>

						</div>
					</div>

					
					<!-- ########## FIM DO CONTEUDO ########## -->



					<!-- Importação dos arquivos java script -->
					<script src="resources/js/jquery-2.1.4.js"></script>
					<script src="resources/js/bootstrap.js"></script>
					<script src="resources/js/jquery.bootgrid.js"></script>
					<script src="resources/js/scripts.js"></script>

					<script type="text/javascript">
						$( document ).ready(function() {

							/* Comando javascript para configurar o plugin do bootgrid */
							var grid = $("#grid-basic").bootgrid({
								formatters: {
									"commands": function(column, row)
									{
										return "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class='glyphicon glyphicon-trash disabled'></span></button>";
									}
								}
							}).on("loaded.rs.jquery.bootgrid", function()
							{
								/* Executes after data is loaded and rendered */
								grid.find(".command-edit").on("click", function(e)
								{
									window.location="alterar_cliente.html?id="+$(this).data("row-id");
								}).end().find(".command-delete").on("click", function(e)
								{
									$('#excluirModal').modal('show');

									$('#excluirCliente').attr("href","excluir_cliente.html?id=" + $(this).data("row-id"));
								});
							});
							/* Fim do comando javascript para configurar o plugin do bootgrid */

						});

					</script>

</body>
</html>