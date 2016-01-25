
//FUNÇÂO PARA ALTERAR O VALOR DOS CAMPOS
function desabilitarCamposCliente (id){
	var sexo = document.getElementById("sexo");
	var aniversario = document.getElementById("aniversario");
	var nome_lbl = document.getElementById("nome_lbl");
	var nome_inp = document.getElementById("nome_inp");
	var documentofederal_lbl = document.getElementById("cpfcnpj_lbl");
	var documentofederal_inp = document.getElementById("cpfcnpj_inp");
	var documentoestadual_lbl = document.getElementById("rgie_lbl");
	var documentoestadual_inp = document.getElementById("rgie_inp");

	if(id.value == 0){
		if(aniversario.style.display == 'none' || aniversario.style.display == ''){
			aniversario.style.display = 'block';
		}

		if(sexo.style.display == 'none' || sexo.style.display == ''){
			sexo.style.display = 'block';
		}

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
		if(sexo.style.display == 'block' || sexo.style.display == ''){
			sexo.style.display = 'none';
		}

		if(aniversario.style.display == 'block' || aniversario.style.display == ''){
			aniversario.style.display = 'none';
		}

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