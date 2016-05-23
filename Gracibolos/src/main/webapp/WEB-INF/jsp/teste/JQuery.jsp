<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Tag de importação JSTL, utilizado para fazer a repetição das tags HTML -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html lang="PT-BR">
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
	<title>JQuey</title>
	
</head>
<body>
	<div id="dialog" title="Aviso do sistema">
		<p>Hello!</p>
	</div>
	
	<button id="btn_carregar">Carregar</button>
	
	<input type="text" id="topic_title" /><br>
	
	<!-- 
		indica q a div será invisível,e quando apertar o botão a tag ficara visivel
	 -->
	<div id="div1" style="display: none;">Escondido</div>
	
	<input type="text" id="estado" placeholder="Informe um estado"/><br>
	
	<input type="text" id="autocomplete-5" placeholder="autocomplete"/><br>
	
	<select id="select-repo"></select><br>
	
	
		<table id="tabela1" class="display" cellspacing="0" width="100%">
			<thead>		
				<tr>	
					<th>id</th>					
					<th>foto</th>			
					<th>codigo</th>
					<th>nome</th>			
					<th>valor</th>	
					<th>obs</th>	
					<th>rec</th>	
				</tr>
			</thead>
		</table>
	
	<!-- 
	<c:forEach var="produto" items="">
	${produtos }${produto.codigo }${produto.custo }${produto.estoque }${produto.foto }
	${produto.id }${produto.nome }${produto.obs }${produto.peso }${produto.rec }
	${produto.valor }
	</c:forEach>
	-->
	
	<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
               	<td>name</td>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
           		<td>name</td>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </tfoot>
    </table>
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

	$(document).ready(function() {
	    $('#example').DataTable( {
	        "ajax": '../Gracibolos/resources/arrays1.txt',
	        "columns": [
	                    { "data": "name" },
	                    { "data": "position" },
	                    { "data": "office" },
	                    { "data": "extn" },
	                    { "data": "start_date" },
	                    { "data": "salary" }
	                ]
	    } );
	} );
	
	//-----------------------------------------------------------------------------------------------
	var url = '/Gracibolos/rest-itensencomenda/55';
	
	$.getJSON(url).done(function(data){
		
		//recebe por parâmetro a lista de objetos. i = iteração e field = objeto
		$.each(data, function(i, field){
            //$("div").append(field.nome + " ");
            //console.log('nomeProduto : '+ data[i].nomeProduto, data[i].valor);
			//console.log('id : '+ data[i].id);
            //console.log('nomeProduto : '+ data[i].nomeProduto);//Aqui seto so o nome - json muito grande
            //console.log('numero : '+ data[i].numero);
            //console.log('produtoId : '+ data[i].produtoId);
            //console.log('produtoIdProduto : '+ data[i].produtoIdProduto);
            //console.log('quantidade : '+ data[i].quantidade);
            //console.log('total : '+ data[i].total);
            //console.log('valor : '+ data[i].valor);
			
        });
	});
	
	//--------JQuery---------------------------------------------------------------------------------------
	//Ativa o estilo do botão
	$('#btn_carregar').button({
		
	});

	$('#btn_carregar').click(function(){
		//alert('Botão ok');
		//$('#dialog').dialog();
		document.getElementById("div1").style.display = "block";
	});

	//Gera estilo da tabela
	$('#tabela1').DataTable({
// 			"ajax": "../Gracibolos/resources/produtos.txt",//funciona
			"ajax": {
				"url":'/Gracibolos/rest-produtos',
				"dataSrc": ""//Objeto simples, Isto diz DataTables que o JSON carregado 
					//é uma matriz simples, não um objeto com uma matriz dentro dela, 
					//como é o padrão.	
				},
			"processing": true,
	        "columns": [//nomes das propriedades
	 	            { "data": "id" },//0
		            { "data": "foto" },//1
	// 	            { "data": "status" },
		            { "data": "codigo" },//2
		            { "data": "nome" },//3
	// 	            { "data": "tipo" },//	         
	// 	            { "data": "unidade" },//
	// 	            { "data": "custo" },//
		            { "data": "valor" },//4
		            { "data": "obs" },//5
		            { "data": "rec" }//6
		          
	       		],
		     "order": [//Ordem alfabética
		   		     3, "asc" 
	   		     	],
		     "columnDefs": [//Visibilidade
					{
                        "targets": [ 5, 6],
                        "visible": false
					}
				  ]
		
	});
	
	//-----------------------------------------------------------------------------------------------	
	var urlProduto = 'rest-produtos';
	var url = "http://localhost:8080/Gracibolos/rest-pesquisar-produto-id/16";
	//-----------------------------------------------------------------------------------------------	
	
	//-----------------------autocompletar-nome-de-produtos-------------------------------------	
	function lista(data) 
	{
		//console.log(data[0].nome);
		var nomeProduto = [];
		//recebe por parâmetro a lista de objetos. i = iteração e field = objeto
		$.each(data, function(i, field){
            //$("div").append(field.nome + " ");
            //console.log('nome : '+ data[i].nome,' nome : '+ data[i].valor);
            //nomeProduto[i] = data[i].nome;//Aqui seto so o nome - json muito grande(aparece o objeto todo)
			//console.log('nome : '+nomeProduto[i]);
        });
        //-----Aqui preencho o autocomplete
		$("#topic_title" ).autocomplete({
			source: nomeProduto//nome
		});
	}
	
	$.getJSON(urlProduto)//--------url
	.done(lista);
	
	//-----------------------------------------------------------------------------------------------	
	
	$.getJSON(urlProduto, function(data) {
	  var items = [];
	 //recebe por parâmetro a lista de objetos. key = iteração e val = objeto
	  $.each(data, function(key, val) {
	    items.push('<li id="' + key + '">' + val.nome + '</li>');
	  });
	 
	  $('<ul/>', {
	    'class': 'my-new-list',
	    html: items.join('')
	  }).appendTo('body');
	});
	
	//-----------------------------------------------------------------------------------------------	
	
	var esportes = [
			"Natação",
			"Futebol",
			"Vôlei",
			"Basquete"
		];
	
	$(function() {
		
		$("#autocomplete-5" ).autocomplete({
			source: esportes
		});
	});
	
	//-----------------------------------------------------------------------------------------------
	
	var estados = [
   		{ value: "AL", label: "Alabama" },
   		{ value: "AK", label: "Alaska" },
   		{ value: "AZ", label: "Arizona" },
   		{ value: "AR", label: "Arkansas" },
   		{ value: "CA", label: "California" },
   		{ value: "CO", label: "Colorado" },
   		{ value: "CT", label: "Connecticut" },
   		{ value: "DE", label: "Delaware" },
   		{ value: "FL", label: "Florida" },
   		{ value: "GA", label: "Georgia" },
   		{ value: "HI", label: "Hawaii" },
   		{ value: "ID", label: "Idaho" },
   		{ value: "IL", label: "Illinois" },
   		{ value: "IN", label: "Indiana" },
   		{ value: "IA", label: "Iowa" },
   		{ value: "KS", label: "Kansas" },
   		{ value: "KY", label: "Kentucky" },
   		{ value: "LA", label: "Louisiana" },
   		{ value: "ME", label: "Maine" },
   		{ value: "MD", label: "Maryland" },
   		{ value: "MA", label: "Massachusetts" },
   		{ value: "MI", label: "Michigan" },
   		{ value: "MN", label: "Minnesota" },
   		{ value: "MS", label: "Mississippi" },
   		{ value: "MO", label: "Missouri" },
   		{ value: "MT", label: "Montana" },
   		{ value: "NE", label: "Nebraska" },
   		{ value: "NV", label: "Nevada" },
   		{ value: "NH", label: "New Hampshire" },
   		{ value: "NJ", label: "New Jersey" },
   		{ value: "NM", label: "New Mexico" },
   		{ value: "NY", label: "New York" },
   		{ value: "NC", label: "North Carolina" },
   		{ value: "ND", label: "North Dakota" },
   		{ value: "OH", label: "Ohio" },
   		{ value: "OK", label: "Oklahoma" },
   		{ value: "OR", label: "Oregon" },
   		{ value: "PA", label: "Pennsylvania" },
   		{ value: "RI", label: "Rhode Island" },
   		{ value: "SC", label: "South Carolina" },
   		{ value: "SD", label: "South Dakota" },
   		{ value: "TN", label: "Tennessee" },
   		{ value: "TX", label: "Texas" },
   		{ value: "UT", label: "Utah" },
   		{ value: "VT", label: "Vermont" },
   		{ value: "VA", label: "Virginia" },
   		{ value: "WA", label: "Washington" },
   		{ value: "WV", label: "West Virginia" },
   		{ value: "WI", label: "Wisconsin" },
   		{ value: "WY", label: "Wyoming" }
   	];
   	
	$(function() {
		$("#estado").autocomplete({
			source: estados
		});
	});

	//-----------------------------------------------------------------------------------------------
	
	$('#select-repo').selectize({
	    valueField: 'id',
	    labelField: 'nomerazao',
	    searchField: ['nomerazao', 'cpfcnpj', 'rgie'],
	    options: [{id: '${encomenda.clienteid}', nomerazao: '${encomenda.clientenome}', cpfcnpj: '${encomenda.clientecpfcnpj}'}],
	    create: false,
	    render: {
	        option: function(item, escape) {
	        	 return	'<div>' +
					'<span class="title">' +
						'<span>' + escape(item.nomerazao) + '</span><br/>' +
						'<span>' + escape(item.cpfcnpj) + '</span><br/>' +
					'</span>' +
				'</div>';
	        }
	    },

	    load: function(query, callback) {
	        if (!query.length) return callback();
	        $.ajax({
	            url: 'rest-pesquisar-fornecedor/' + encodeURIComponent(query),
	            type: 'GET',
	            error: function() {
	                callback();
	            },
	            success: function(res) {
	                callback(res);
	            }
	        });
	    }
	});
    
	//-----------------------------------------------------------------------------------------------
	
	
	
		
	</script>
</html>