alert('carregado');


//FUNÇÂO PARA ALTERAR O VALOR DOS CAMPOS
function desabilitarCampos (id){
	
	alert('teste');
	
//	var nome_tipo = document.getElementById("nome_tipo");
//	var nome_des = document.getElementById("nome_des");
	
	var sexo = document.getElementById("sexo");
	var datanascimento = document.getElementById("datanascimento");

	var nomerazao_lbl = document.getElementById("nomerazao_lbl");
	var nomerazao_inp = document.getElementById("nomerazao_inp");
	var cpfcnpj_lbl = document.getElementById("cpfcnpj_lbl");
	var cpfcnpj_inp = document.getElementById("cpfcnpj_inp");
	var rgie_lbl = document.getElementById("rgie_lbl");
	var rgie_inp = document.getElementById("rgie_inp");

	if(id.value == 0){
		
//		if(nome_tipo.innerHTML == 'Encomenda*:'){
//		    nome_tipo.innerHTML = 'Fornecedor*:';
//		}
		
//		if(nome_des.placeholder == 'Número da encomenda.'){
//			nome_des.placeholder = 'Digite o nome do fornecedor.';
//		}
		
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
		
//		if(nome_tipo.innerHTML == 'Fornecedor*:'){
//		    nome_tipo.innerHTML = 'Encomenda*:';
//		}
//		
//		if(nome_des.placeholder == 'Digite o nome do fornecedor.'){
//			nome_des.placeholder = 'Número da encomenda.';
//		}
		
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


