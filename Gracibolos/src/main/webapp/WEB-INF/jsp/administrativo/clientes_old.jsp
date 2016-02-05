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
	<title>Graci Bolos | Clientes</title>

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
						<h2 class="">CLIENTES</h2>
						<h4 class="">Lista de clientes</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->

					<form action="administrativo-procurar-cliente" method="POST">

						<div class="row">

							<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
								<label class="control-label">Pesquisar cliente:</label>
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o nome, razão social, CNPJ, CPF, IE ou RG para realizar a pesquisa." name="pesquisa" id="pesquisa" required>

									<span class="input-group-btn">
								        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search disabled"></span></button>
								    </span>
								</div>
							</div>
							
						</div>
					</form>

					


					<table id="grid-basic" class="table table-hover">
						<thead>
							<tr>
								<th data-column-id="id" data-visible="false">#</th>
								<th data-column-id="nome">Nome</th>
								<th data-column-id="cpf_cnpj">CPF / CNPJ</th>
								<th data-column-id="rg_ie">RG / IE</th>
								<th data-column-id="comandos" data-formatter="commands" data-sortable="false">Ações</th>
							</tr>
						</thead>
						<tbody>

							

							<tr>
								<td>1</td>
								<td>Thomas Felix Y. Yamamoto</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>
							<tr>
								<td>2</td>
								<td>RogÃ©rio Yudi</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>3</td>
								<td>NatÃ¡lia InÃ¡cio</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>4</td>
								<td>Weslley Ruffino</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>5</td>
								<td>Breno Ruffino</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>
							<tr>
								<td>6</td>
								<td>Thomas Felix Y. Yamamoto</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>
							<tr>
								<td>7</td>
								<td>RogÃ©rio Yudi</td>
								<td>987.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>8</td>
								<td>NatÃ¡lia InÃ¡cio</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>9</td>
								<td>Weslley Ruffino</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>10</td>
								<td>Breno Ruffino</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

							<tr>
								<td>10</td>
								<td>Breno Ruffino</td>
								<td>123.123.123-12</td>
								<td>12.123.123-1</td>
								<td>Rua CanindÃ©</td>
							</tr>

						</tbody>
					</table>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
							<a class="btn btn-default fullwidth" href="administrativo-incluir-cliente"><span class="glyphicon glyphicon-plus disabled"></span>&nbsp;&nbsp;&nbsp;Incluir novo cliente</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<!-- Modal de confirmação de exclusão de cliente -->
	<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Excluir cliente</h4>
	      </div>
	      <div class="modal-body">
	        <div>
	        	<p>Deseja realmente excluir o cliente?</p>
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Não, quero excluir</button>
			<a href="" id="excluirCliente" class="btn btn-default">Sim, quero excluir</a>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- ########## FIM DO CONTEUDO ########## -->



	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/jquery.bootgrid.js"></script>

	<script type="text/javascript">
		$( document ).ready(function() {

			/* Comando javascript para configurar o plugin do bootgrid */
			var grid = $("#grid-basic").bootgrid({
				formatters: {
					"commands": function(column, row)
					{
						return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class='glyphicon glyphicon-pencil disabled'></span></button> " + 
						"<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class='glyphicon glyphicon-trash disabled'></span></button>";
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