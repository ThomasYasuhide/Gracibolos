<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="PT-BR">
<head>

	<!-- Defeniçãoo dos arquivos meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Importação dos arquivos CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/reset.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">

	<!-- Titulo da página -->
	<title>Graci Bolos | Login</title>

</head>
<body>

	<!-- Container com layout fluido, preenchendo maior parte da tela -->
	<div class="container-fluid">


		<!-- Cria uma linha para armazenar todo o conteudo -->
		<div class="row">


			<div class="col-xs-12 col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">
				<div class="text-center margin-top">
					<img src="resources/img/logo.png" width="200px;">
				</div>

				<div class="margin-top">
					
					<form action="login" method="POST">
						
						<div class="input-group input-margin">
							<span class="input-group-addon"><i class="material-icons">perm_identity</i></span>
							<input type="text" name="usuario" maxlength="20" class="form-control" value="${cookie.usuario.value}" placeholder="Usuário" tabindex="1" required>
						</div>

						<div class="input-group input-margin">
							<span class="input-group-addon"><i class="material-icons">lock_outline</i></span>
							<input type="password" name="senha" maxlength="20" class="form-control" value="${cookie.senha.value}" placeholder="Senha" tabindex="2" required>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="checkbox pull-left">
									<label class="google-checkbox input-brown">
										
										<input type="checkbox" tabindex="3" name="lembrarsenha" <c:if test="${cookie.lembrarsenha.value == 'true'}">checked="checked"</c:if> value="true">
										<i class="material-icons checked">check_box</i>
										<i class="material-icons unchecked">check_box_outline_blank</i>
										Lembrar senha?
									</label>
								</div>
							</div>

							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="input-group pull-right">
									<button type="submit" class="btn btn-default btn-login" tabindex="4"><i class="material-icons">fingerprint</i>&nbsp;&nbsp;&nbsp;Autenticar</button>
								</div>
							</div>
						</div>

					</form>
					
					<c:if test="${servidor == false}">
						<div class="alert alert-danger alert-dismissible" role="alert" >
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>Erro: </strong>Não foi possível conectar-se ao banco de dados, tente novamente mais tarde!
						</div>
					</c:if>
					
					<c:if test="${status == false}">
						<div class="alert alert-danger alert-dismissible" role="alert" >
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>Erro: </strong>Usuário ou senha incorreto, favor tente novamente!
						</div>
					</c:if>
					
					
				</div>
				
			</div>
		</div>
	</div>

		<!-- ImportaÃ§Ã£o dos arquivos java script -->
		<script src="resources/js/jquery-2.1.4.js"></script>
		<script src="resources/js/bootstrap.js"></script>
	</body>
	</html>