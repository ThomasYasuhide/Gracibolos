//FUNÇÂO PARA ALTERAR O VALOR DOS CAMPOS
function desabilitarCampos (id){


	var recebidoGasto_lbl = document.getElementById("recebidoGasto_lbl");
	var recebidoGasto_inp = document.getElementById("recebidoGasto_inp");

	if(id.value == 0){
		
		if(recebidoGasto_lbl.innerHTML == 'Valor gasto*:'){
			recebidoGasto_lbl.innerHTML = 'Valor recebido*:';
		}

		if(recebidoGasto_inp.placeholder == '0.00'){
			recebidoGasto_inp.placeholder = '0.000';
			recebidoGasto_inp.maxLength = '14';
		}		
		
	}else {
		

		if(recebidoGasto_lbl.innerHTML == 'Valor gasto*:'){
			recebidoGasto_lbl.innerHTML = 'Valor recebido*:';
		}

		if(recebidoGasto_inp.placeholder == '0.00'){
			recebidoGasto_inp.placeholder = '0.000';
			recebidoGasto_inp.maxLength = '18';
		}
		
	}	

}