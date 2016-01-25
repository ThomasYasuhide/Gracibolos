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
							<li><a href="" data-toggle="modal" data-target="#myModal"><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Sair do sistema</a></li>
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
					<li><a href="" data-toggle="modal" data-target="#myModal"><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Sair do sistema</a></li>
				</ul>
			</div>
			<!-- Fim da barra de naveÃ§Ã£o lateral -->

			<div class="content fullpage col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<div class="margin-top">

					<!-- Titulo e subtitulo da pagina -->
					<header>
						<h2 class="">CLIENTES</h2>
						<h4 class="">Incluir novo cliente</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->

					<div class="row">

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

							<form action="#" method="POST">
								
								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
									<label class="control-label" for="status">Status:</label>
									<select class="form-control" id="status" name="status" required>
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>

								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
									<label class="control-label" for="pessoa">Pessoa:</label>
									<select onchange="desabilitarCamposCliente(this);" class="form-control" id="pessoa" name="pessoa" required>
										<option selected value="0">Fisica</option>
										<option value="1" >Juridica</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3" id="sexo">
									<label class="control-label" for="sexo">Sexo:</label>
									<select class="form-control" id="sexo" name="sexo">
										<option selected disabled="true">Selecione</option>
										<option value="M">Masculino</option>
										<option value="F">Feminino</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3" id="aniversario">
									<label class="control-label" for="aniversario">AniversÃ¡rio:</label>
									<input type="date" name="aniversario" class="form-control" name="aniversario" id="aniversario">
								</div>

								<div class="clearfix"></div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="nome" id="nome_lbl">Nome*:</label>
									<input type="text" id="nome_inp" class="form-control" maxlength="100" placeholder="Digite seu nome aqui" name="nome" id="nome" required>
								</div> 

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpfcnpj" id="cpfcnpj_lbl">CPF*:</label>
									<input type="text" id="cpfcnpj_inp" class="form-control" placeholder="000.000.000-00" maxlength="14" name="cpfcnpj" id="cpfcnpj" required>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rgie" id="rgie_lbl">RG:</label>
									<input type="text" id="rgie_inp" class="form-control" placeholder="00.000.000-0" maxlength="12" name="rgie" id="rgie">
								</div>

								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="endereco">EndereÃ§o*:</label>
									<input type="text" class="form-control" name="endereco" maxlength="120" id="endereco" placeholder="Digite aqui o seu endereÃ§o" required>
								</div>

								<div class="input-margin col-xs-12 col-sm-3 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
									<input type="number" class="form-control" name="numero" id="numero" placeholder="Digite seu numero" required>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="complemento">Complemento:</label>
									<input type="text" class="form-control" name="complemento" maxlength="120" id="complemento" placeholder="Digite o complemento se houver">
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
									<input type="text" class="form-control" name="bairro" id="bairro" maxlength="60" placeholder="Digite seu bairro" required>
								</div>

								<div class="clearfix"></div>

								<div class="input-margin col-xs-12 col-sm-2 col-md-2">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" name="estado" id="estado" required>
										<option selected value="0">SP</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" name="cidade" id="cidade" required>
										<option selected value="0">SÃ£o Paulo</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cep">CEP*:</label>
									<input type="text" class="form-control" maxlength="8" name="cep" id="cep" placeholder="Digite seu CEP" required>
								</div>

								<div class="clearfix"></div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="telefone">Tel:</label>
									<input type="text" class="form-control" name="telefone" id="telefone" maxlength="10" placeholder="(00) 0000-0000">
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="celular">Cel:</label>
									<input type="text" class="form-control" name="celular" id="celular" maxlength="11" placeholder="(00) 00000-0000">
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="email">E-mail:</label>
									<input type="text" class="form-control" name="email" maxlength="120" id="email" placeholder="email@provedor.com.br">
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="site">Site:</label>
									<input type="text" class="form-control" name="site" maxlength="120" id="site" placeholder="www.site.com.br">
								</div>

								<div class="clearfix"></div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="desde">Cliente desde:</label>
									<input type="date" class="form-control input-brown disabled" disabled="true" name="desde" name="desde" id="desde">
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="qtdcompras">Qtd. de compras:</label>
									<input type="number" class="form-control input-brown disabled" disabled="true" name="qtdcompras" name="qtdcompras" id="qtdcompras" value="0">
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">ObservaÃ§Ã£o:</label>
									<textarea class="form-control" name="obs" name="obs" id="obs" placeholder="Digite aqui as observaÃ§Ãµes"></textarea>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12 text-right">
									<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-disk disabled"></span>&nbsp;&nbsp;&nbsp;Incluir cliente</button>
								</div>
							</form>
						</div>
					</div>


					<!-- Modal de logoff -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
					
					<!-- ########## FIM DO CONTEUDO ########## -->



					<!-- ImportaÃ§Ã£o dos arquivos java script -->
					<script src="../js/jquery-2.1.4.js"></script>
					<script src="../js/bootstrap.js"></script>
					<script src="../js/scripts.js"></script>
</body>
</html>