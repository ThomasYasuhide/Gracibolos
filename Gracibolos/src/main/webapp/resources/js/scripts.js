
//FUNÇÂO PARA ALTERAR O VALOR DOS CAMPOS
function desabilitarCampos (id){
	
	var sexo = document.getElementById("sexo");
	var datanascimento = document.getElementById("datanascimento");

	var nomerazao_lbl = document.getElementById("nomerazao_lbl");
	var nomerazao_inp = document.getElementById("nomerazao_inp");
	var cpfcnpj_lbl = document.getElementById("cpfcnpj_lbl");
	var cpfcnpj_inp = document.getElementById("cpfcnpj_inp");
	var rgie_lbl = document.getElementById("rgie_lbl");
	var rgie_inp = document.getElementById("rgie_inp");

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
		}

		if(cpfcnpj_lbl.innerHTML == 'CNPJ*:'){
			cpfcnpj_lbl.innerHTML = 'CPF*:';
		}

		if(cpfcnpj_inp.placeholder == '00.000.000/0000-00'){
			cpfcnpj_inp.placeholder = '000.000.000-00';
			cpfcnpj_inp.maxLength = '14';
		}
			
		if(rgie_lbl.innerHTML == 'IE:'){
			rgie_lbl.innerHTML = 'RG:';
		}

		if(rgie_inp.placeholder == '000.000.000.000'){
			rgie_inp.placeholder = '00.000.000-0';
			rgie_inp.maxLength = '9';
		}
		
	}else {
		
		if(sexo.disabled == false){
			sexo.disabled = true;
			sexo.value = 0;
		}

		if(datanascimento.disabled == false){
			datanascimento.disabled = true;
		}

		if(nomerazao_lbl.innerHTML == 'Nome*:'){
			nomerazao_lbl.innerHTML = 'Razão Social*:';
		}
		
		if(nomerazao_inp.placeholder == 'Digite seu nome aqui.'){
			nomerazao_inp.placeholder = 'Digite sua razão social aqui.';
		}

		if(cpfcnpj_lbl.innerHTML == 'CPF*:'){
			cpfcnpj_lbl.innerHTML = 'CNPJ*:';
		}

		if(cpfcnpj_inp.placeholder == '000.000.000-00'){
			cpfcnpj_inp.placeholder = '00.000.000/0000-00';
			cpfcnpj_inp.maxLength = '18';
		}
		
		if(rgie_lbl.innerHTML == 'RG:'){
			rgie_lbl.innerHTML = 'IE:';
		}
		
		if(rgie_inp.placeholder == '00.000.000-0'){
			rgie_inp.placeholder = '000.000.000.000';
			rgie_inp.maxLength = '12';
		}
		
	}	

}


