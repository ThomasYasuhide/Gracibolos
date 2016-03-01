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
	<title>Graci Bolos | Desenvolvedores</title>

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
						<h2 class="">DESENVOLVEDORES</h2>
						<h4 class="">Tecnologias utilizadas</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->


					<div class="row">
						
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Front-end</th>
									</tr>
								</thead>

								<tbody>
									<tr><td>HTML 5</td></tr>
									<tr><td>CSS 3</td></tr>
									<tr><td>Bootstrap</td></tr>
									<tr><td>JavaScript</td></tr>
									<tr><td>Bootstrap grid</td></tr>
									<tr><td>Chart JS</td></tr>
								</tbody>
							</table>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Back-end</th>
									</tr>
								</thead>

								<tbody>
									<tr><td>Java</td></tr>
									<tr><td>Maven</td></tr>
									<tr><td>Spring</td></tr>
								</tbody>
							</table>
						</div>

						<div class="clearfix"></div>

						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Banco de dados</th>
									</tr>
								</thead>

								<tbody>
									<tr><td>MySQL</td></tr>
								</tbody>
							</table>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Ferramentas de desenvolvimento</th>
									</tr>
								</thead>

								<tbody>
									<tr><td>Github</td></tr>
								</tbody>
							</table>
						</div>

					</div>

					

					

					

					

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nome:</th>
								<th>RA:</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>Breno de Oliveira Rufino</td>
								<td>1410452</td>
							</tr>
							<tr>
								<td>Natália Inácio Scarmeloto</td>
								<td>1410332</td>
							</tr>
							<tr>
								<td>RogÃ©rio Yudi Horauti</td>
								<td>1410188</td>
							</tr>
							<tr>
								<td>Thomas Felix Yasuhide Yamamoto</td>
								<td>1410127</td>
							</tr>
							<tr>
								<td>Weslley Rufino de Lima</td>
								<td>1410565</td>
							</tr>
						</tbody>
					</table>

					<!-- ########## FIM DO CONTEUDO ########## -->
				</div>
			</div>
		</div>
	</div>


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/bootstrap.js"></script>

</body>
</html>