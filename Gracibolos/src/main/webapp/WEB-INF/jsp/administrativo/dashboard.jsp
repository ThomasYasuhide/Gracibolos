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
	<title>Graci Bolos | Dashboard</title>

</head>

<body>

	<!-- Container com layout fluido, preenchendo maior parte da tela -->
	<div class="container-fluid fullheight">

		<!-- Cria uma linha para armazenar todo o conteudo -->
		<div class="row fullheight">

			<%@ include file="menu.jsp" %>
			
			<div class="content fullpage col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<div class="margin-top">

					<!-- Titulo e subtitulo da pagina -->
					<header>
						<h2 class="">DASHBOARD</h2>
						<h4 class="">Tabela de estatistícas</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->

					<div>
						<h3>Grafico de valores de venda por mês</h3>
						<canvas id="valores" height="100px"></canvas>
						<p>Valores espressos em R$</p>
					</div>

					<hr/>

					<div>
						<h3>Grafico de quantidade de vendas por mês</h3>
						<canvas id="vendas" height="100px"></canvas>
						<p>Valores espressos em quantidade</p>
					</div>

					<!-- ########## FIM DO CONTEUDO ########## -->
				</div>
			</div>
		</div>
	</div>

	


	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/chart.js"></script>

	<script>
		$('#menu-mob-dashboard').addClass('active');
		$('#menu-dashboard').addClass('active');
	
		var lineChartData = {
			labels : ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
			datasets : [
				{
					label: "Tabela de vendas",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [20,200,100,300,100,400,100,900,300,600,400]
				}
			]

		}

		var vendasData = {
			labels : ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
			datasets : [
				
				{
					label: "Tabela de vendas",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [10,30,20,30,20,40,10,100,30,50,30]
				}
			]

		}

		window.onload = function(){
			var ctx = document.getElementById("valores").getContext("2d");
			window.myLine = new Chart(ctx).Line(lineChartData, {
				responsive: true
			});

			var ctx = document.getElementById("vendas").getContext("2d");
			window.myBar = new Chart(ctx).Bar(vendasData, {
				responsive : true
			});
		}
	</script>


</body>
</html>