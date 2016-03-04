
//FUNÇÂO PARA ALTERAR O VALOR DOS CAMPOS
function desabilitarCamposCliente (id){
	
	var sexo = document.getElementById("sexo");
	var datanascimento = document.getElementById("datanascimento");

	var nomerazao_lbl = document.getElementById("nomerazao_lbl");
	var nomerazao_inp = document.getElementById("nomerazao_inp");
	var cpfcnpj_lbl = document.getElementById("cpfcnpj_lbl");
	var cpfcnpj_inp = document.getElementById("cpfcnpj_inp");
	var rgie_lbl = document.getElementById("rgie_lbl");
	//var rgie_inp = document.getElementById("rgie_inp");

	if(id.value == 0){
		
		if(sexo.disabled == true){
			sexo.disabled = false;
		}
		
		if(datanascimento.disabled == true){
			datanascimento.disabled = false;
		}
		
		if(nomerazao_lbl.innerHTML == 'Razão Social*:'){
			nomerazao_lbl.innerHTML = 'Nome*:';
		}
		

		if(nomerazao_inp.placeholder == 'Digite sua razão social aqui.'){
			nomerazao_inp.placeholder = 'Digite seu nome aqui.';
			nomerazao_inp.value = "";
		}

		if(cpfcnpj_lbl.innerHTML == 'CNPJ*:'){
			cpfcnpj_lbl.innerHTML = 'CPF*:';
		}

		if(cpfcnpj_inp.placeholder == '00.000.000/0000-00'){
			cpfcnpj_inp.placeholder = '000.000.000-00';
			cpfcnpj_inp.maxLength = '11';
			cpfcnpj_inp.value = "";
		}
			
		if(rgie_lbl.innerHTML == 'IE:'){
			rgie_lbl.innerHTML = 'RG:';
		}

		if(rgie_inp.placeholder == '000.000.000.000'){
			rgie_inp.placeholder = '00.000.000-0';
			rgie_inp.maxLength = '9';
			rgie_inp.value = "";
		}
		
	}else {
		
		if(sexo.disabled == false){
			sexo.disabled = true;
			sexo.value = 0;
		}

		if(datanascimento.disabled == false){
			datanascimento.disabled = true;
			datanascimento.value = "";
		}

		if(nomerazao_lbl.innerHTML == 'Nome*:'){
			nomerazao_lbl.innerHTML = 'Razão Social*:';
		}
		
		if(nomerazao_inp.placeholder == 'Digite seu nome aqui.'){
			nomerazao_inp.placeholder = 'Digite sua razão social aqui.';
			nomerazao_inp.value = "";
		}

		if(cpfcnpj_lbl.innerHTML == 'CPF*:'){
			cpfcnpj_lbl.innerHTML = 'CNPJ*:';
		}

		if(cpfcnpj_inp.placeholder == '000.000.000-00'){
			cpfcnpj_inp.placeholder = '00.000.000/0000-00';
			cpfcnpj_inp.maxLength = '14';
			cpfcnpj_inp.value = "";
		}
		
		if(rgie_lbl.innerHTML == 'RG:'){
			rgie_lbl.innerHTML = 'IE:';
		}
		
		if(rgie_inp.placeholder == '00.000.000-0'){
			rgie_inp.placeholder = '000.000.000.000';
			rgie_inp.maxLength = '12';
			rgie_inp.value = "";
		}
		
	}	

}



//FUNÇÂO PARA ALTERAR O VALOR DOS CAMPOS
function desabilitarCamposTransportador (id){
	var nome_lbl = document.getElementById("nome_lbl");
	var nome_inp = document.getElementById("nome_inp");
	var documentofederal_lbl = document.getElementById("cpfcnpj_lbl");
	var documentofederal_inp = document.getElementById("cpfcnpj_inp");
	var documentoestadual_lbl = document.getElementById("rgie_lbl");
	var documentoestadual_inp = document.getElementById("rgie_inp");

	if(id.value == 0){

		if(nome_lbl.innerHTML == 'Razão Social*:'){
			nome_lbl.innerHTML = 'Nome*:';
		}

		if(nome_inp.placeholder == 'Digite sua razão social aqui'){
			nome_inp.placeholder = 'Digite seu nome aqui';
			nome_inp.value = '';
		}

		if(documentofederal_lbl.innerHTML == 'CNPJ*:'){
			documentofederal_lbl.innerHTML = 'CPF*:';
		}

		if(documentofederal_inp.placeholder == '00.000.000/0000-00'){
			documentofederal_inp.placeholder = '000.000.000-00';
			documentofederal_inp.maxLength = '11';
			documentofederal_inp.value = '';
		}

		if(documentoestadual_lbl.innerHTML == 'IE:'){
			documentoestadual_lbl.innerHTML = 'RG:';
		}

		if(documentoestadual_inp.placeholder == '000.000.000.000'){
			documentoestadual_inp.placeholder = '00.000.000-0';
			documentoestadual_inp.maxLength = '9';
			documentoestadual_inp.value = '';
		}

		
	}else {

		if(nome_lbl.innerHTML == 'Nome*:'){
			nome_lbl.innerHTML = 'Razão Social*:';
		}

		if(nome_inp.placeholder == 'Digite seu nome aqui'){
			nome_inp.placeholder = 'Digite sua razão social aqui';
			nome_inp.value = '';
		}

		if(documentofederal_lbl.innerHTML == 'CPF*:'){
			documentofederal_lbl.innerHTML = 'CNPJ*:';
		}

		if(documentofederal_inp.placeholder == '000.000.000-00'){
			documentofederal_inp.placeholder = '00.000.000/0000-00';
			documentofederal_inp.maxLength = '14';
			documentofederal_inp.value = '';
		}

		if(documentoestadual_lbl.innerHTML == 'RG:'){
			documentoestadual_lbl.innerHTML = 'IE:';
		}

		if(documentoestadual_inp.placeholder == '00.000.000-0'){
			documentoestadual_inp.placeholder = '000.000.000.000';
			documentoestadual_inp.maxLength = '12';
			documentoestadual_inp.value = '';
		}
	}

	

}