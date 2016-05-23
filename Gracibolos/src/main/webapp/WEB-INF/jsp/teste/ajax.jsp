<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!-- Defenição dos arquivos meta -->
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Importação dos arquivos CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/reset.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/datatables.css" rel="stylesheet">
    
    <link href="resources/css/selectize.css" rel="stylesheet">

	<!-- Titulo da página -->
	<title>ajax</title>
	
</head>
<body>
	<button id="btn_carregar">Carregar</button>
</body>

<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/mask.js"></script>
	
	<script src="resources/js/selectize.js"></script>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.js" type="text/javascript"></script>
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
		
	<script type="text/javascript">

	$('#btn_carregar').click(function(){
		
		var data = {"status": 3,"nomerazao": "Rogerio"};
		var enc = new Object();

		enc.nomerazao = "rogerio";
		enc.status = 3;
		js  = JSON.stringify(enc);
		alert(js);
		
		$.ajax({
            url: "../Gracibolos/rest-encomenda/",
            type: 'POST',    
            data: js,
            contentType: "application/json; charset=utf-8",
            success: function(result) {
                alert("success?");
            }
        });

	});
		
	
		
</script>
</html>