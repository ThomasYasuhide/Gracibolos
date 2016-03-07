package br.com.gracibolos.jdbc.teste;

import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

//funcionando
public class ClienteAlterar {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente();
		
		c1.setId(1);		 	
		c1.setStatus(1);
		c1.setTipopessoa(2);
		c1.setSexo(1);
		c1.setDatanascimento(LocalDate.now());
		c1.setNomerazao("Teste");
		c1.setCpfcnpj("");
		c1.setRgie("");
		c1.setEndereco("");		
		c1.setNumero("54");
		c1.setComplemento("10");
		c1.setBairro("");
		c1.setEstado(3);
		c1.setCidade(3);		
		c1.setCep(367832);
		c1.setTel("");
		c1.setCel("");		
		c1.setEmail("Raul@hotmail.com");
		c1.setSite("teste");
		c1.setClientedesde(LocalDate.now());		
		c1.setObs("teste");		
		
		ClienteDao dao = new ClienteDao();
		
		try {
			if(dao.alterar(c1) == true){
				System.out.println("alterado com sucesso!");
			}else{
				System.out.println("Não foi possivel alterar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
