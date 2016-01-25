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

	<!-- Titulo da página -->
	<title>Graci Bolos | Alterar dados fornecedor</title>

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
						<h2 class="">FORNECEDORES</h2>
						<h4 class="">Alterar dados do fornecedor</h4>
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
									<select onchange="desabilitarCamposTransportador(this);" class="form-control" id="pessoa" name="pessoa" required>
										<option selected value="0">Fisica</option>
										<option value="1" >Juridica</option>
									</select>
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

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">Observação:</label>
									<textarea class="form-control" name="obs" name="obs" id="obs" placeholder="Digite aqui as observaÃ§Ãµes"></textarea>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12 text-right">
									<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-disk disabled"></span>&nbsp;&nbsp;&nbsp;Salvar alteraÃ§Ãµes</button>
								</div>
							</form>
						</div>
					</div>
					
					<!-- ########## FIM DO CONTEUDO ########## -->



					<!-- Importação dos arquivos java script -->
					<script src="resources/js/jquery-2.1.4.js"></script>
					<script src="resources/js/bootstrap.js"></script>
					<script src="resources/js/scripts.js"></script>
</body>
</html>