<!-- Define que este documento é uma pagina JSP -->
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Tag de importação JSTL, utilizado para fazer a repetição das tags HTML -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<h4 class="">Tabelas estatistícas</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->
					
					<!-- Container com layout fluido, preenchendo maior parte da tela -->
					<div class="container-fluid fullheight">
						<div class="row">
							<div class=" col-xs-12 col-sm-12 col-md-6 col-lg-3">
								
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-3">
								
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-3">
								
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-3">
								
							</div>
						</div>
					</div>
					
					<div>
						<canvas id="graficos" height="100px"></canvas>
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

		var entradas = ["${recebimento.janeiro}","${recebimento.fevereiro}","${recebimento.marco}","${recebimento.abril}","${recebimento.maio}","${recebimento.junho}","${recebimento.julho}","${recebimento.agosto}","${recebimento.setembro}","${recebimento.outubro}","${recebimento.novembro}","${recebimento.dezembro}"];
		var saidas = ["${gasto.janeiro}","${gasto.fevereiro}","${gasto.marco}","${gasto.abril}","${gasto.maio}","${gasto.junho}","${gasto.julho}","${gasto.agosto}","${gasto.setembro}","${gasto.outubro}","${gasto.novembro}","${gasto.dezembro}"];
	
        var config = {
            type: 'line',
            data: {
                labels: ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                datasets: [{
                    label: "Total das vendas em R$",
                    backgroundColor : "rgba(107,83,68,0.18)",
                    borderColor : "rgba(107,83,68,1)",
					pointColor : "rgba(107,83,68,1)",
					data : entradas
                }, {
                    label: "Total das gastos em R$",
                    backgroundColor : "rgba(241,187,186,0.5)",
                    borderColor : "rgba(241,187,186,1)",
					pointColor : "rgba(241,187,186,1)",
					data : saidas
                }]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'Dashboard Gracibolos'
                },
                tooltips: {
                    mode: 'label'
                }
            }
        };
		
		window.onload = function() {
            var ctx = document.getElementById("graficos").getContext("2d");
            window.myLine = new Chart(ctx, config);
        };
		
	</script>


</body>
</html>