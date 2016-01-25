package br.com.gracibolos.jdbc.teste;


import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

public class ClienteInserir {
  
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		
		c1.setNomeRs("Raul Rufino");
		c1.setCpfCnpj("1231412");
		c1.setRgIe("1231232");
		c1.setCep(3678000);
		c1.setNumero("54");
		c1.setTel1("92323-3232");
		c1.setEmail("Raul@hotmail.com");
		c1.setStatus("ok");
		c1.setSexo('M');
		c1.setComplemento("10");
		c1.setSite("");
		c1.setObs("");
		
		ClienteDao dao = new ClienteDao();
		
		if(dao.inserir(c1) == true){
			System.out.println("inserido com sucesso");
		}else{
			System.out.println("falha");
		}	
		

	}

}
