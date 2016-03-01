<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="PT-BR">
<head>

	<!-- DefeniÃ§Ã£o dos arquivos meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- ImportaÃ§Ã£o dos arquivos CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="../css/bootstrap.css" rel="stylesheet">
	<link href="../css/reset.css" rel="stylesheet">
	<link href="../css/style.css" rel="stylesheet">
	<link href="../css/jquery.bootgrid.css" rel="stylesheet">

	<!-- Titulo da pÃ¡gina -->
	<title>Graci Bolos | Clientes</title>

</head>

<body>

	<!-- Container com layout fluido, preenchendo maior parte da tela -->
	<div class="container-fluid fullheight">

		<!-- Cria uma linha para armazenar todo o conteudo -->
		<div class="row fullheight">

			<!-- Cria a barra de naveÃ§Ã£o mobile, ela nÃ£o aparece em telas medias e grandes -->
			<nav class="navbar navbar-transparent hidden-md hidden-lg">

				<div class="container-fluid">
					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
							<span class="glyphicon glyphicon-menu-hamburger disabled"></span>
						</button>
						<a class="navbar-brand" href="#"><img src="../img/logo.png" width="100px"></a>
					</div>

					<div class="collapse navbar-collapse" id="navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="#"><i class="material-icons">chrome_reader_mode</i>&nbsp;&nbsp;Encomendas</a></li>
							<li class="active"><a href="clientes.jsp"><i class="material-icons">people</i>&nbsp;&nbsp;Clientes</a></li>
							<li><a href="produtos.jsp"><i class="material-icons">local_grocery_store</i>&nbsp;&nbsp;Produtos</a></li>
							<!-- O href estÃ¡ vazio para o botÃ£o nÃ£o perder o tipo de ponteiro (Deixar assim) -->
							<li><a href="" data-toggle="modal" data-target="#logoffModal"><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Sair do sistema</a></li>
						</ul>
					</div>

				</div>
			</nav>
			<!-- Fim do menu de navegaÃ§Ã£o mobile -->

			<!-- Cria a barra de naveÃ§Ã£o lateral, aparecendo somente em telas grandes -->
			<div class="hidden-xs hidden-sm col-md-3 col-lg-3 ">
				<div class="margin-top text-center logo">
					<img src="../img/logo.png" width="150px">
				</div>

				<ul class="nav nav-pills nav-stacked">
					<li><a href="#"><i class="material-icons">chrome_reader_mode</i>&nbsp;&nbsp;Encomendas</a></li>
					<li class="active"><a href="clientes.jsp"><i class="material-icons">people</i>&nbsp;&nbsp;Clientes</a></li>
					<li><a href="produtos.jsp"><i class="material-icons">local_grocery_store</i>&nbsp;&nbsp;Produtos</a></li>
					<!-- O href estÃ¡ vazio para o botÃ£o nÃ£o perder o tipo de ponteiro (Deixar assim) -->
					<li><a href="" data-toggle="modal" data-target="#logoffModal"><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Sair do sistema</a></li>
				</ul>
			</div>
			<!-- Fim da barra de naveÃ§Ã£o lateral -->

			<div class="content fullpage col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<div class="margin-top">

					<!-- Titulo e subtitulo da pagina -->
					<header>
						<h2 class="">CLIENTES</h2>
						<h4 class="">Lista de clientes</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->

					<form action="" method="POST">

						<div class="row">

							<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
								<label class="control-label">Pesquisar cliente:</label>
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o nome, razÃ£o social, CNPJ, CPF, IE ou RG para realizar a pesquisa." name="pesquisa" id="pesquisa" required>

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
								<th data-column-id="comandos" data-formatter="commands" data-sortable="false">AÃ§Ãµes</th>
							</tr>
						</thead>
						<tbody>

							<!--

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

							-->
						</tbody>
					</table>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
				<button class="btn btn-default fullwidth" href="incluir_cliente.html"><span class="glyphicon glyphicon-plus disabled"></span>&nbsp;&nbsp;&nbsp;Incluir novo cliente</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- Modal de logoff -->
	<div class="modal fade" id="logoffModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Logoff</h4>
	      </div>
	      <div class="modal-body">
	        <div>
	        	<p>Deseja realmente sair do sistema?</p>
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">NÃ£o, quero continuar</button>
			<a href="../index.html" class="btn btn-default">Sim, quero sair</a>
	      </div>
	    </div>
	  </div>
	</div>


	<!-- Modal de confirmaÃ§Ã£o de exclusÃ£o de cliente -->
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
	        <button type="button" class="btn btn-default" data-dismiss="modal">NÃ£o, quero excluir</button>
			<a href="" id="excluirCliente" class="btn btn-default">Sim, quero excluir</a>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- ########## FIM DO CONTEUDO ########## -->



	<!-- ImportaÃ§Ã£o dos arquivos java script -->
	<script src="../js/jquery-2.1.4.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script src="../js/jquery.bootgrid.js"></script>

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