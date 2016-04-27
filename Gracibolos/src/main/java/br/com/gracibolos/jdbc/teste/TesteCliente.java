package br.com.gracibolos.jdbc.teste;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.model.Cliente;

public class TesteCliente {

	@Test
	public void test() {
Cliente c1 = new Cliente();
		
		c1.setStatus(1);
		c1.setTipopessoa(2);
		c1.setSexo(1);
		c1.setDatanascimento(LocalDate.now());
		c1.setNomerazao("");
		c1.setCpfcnpj("");
		c1.setRgie("");
		c1.setEndereco("");		
		c1.setNumero("54");
		c1.setComplemento("10");
		c1.setBairro("");
		c1.setEstado(3);
		c1.setCidade(3);		
		c1.setCep("3678000");
		c1.setTel("");
		c1.setCel("");		
		c1.setEmail("Raul@hotmail.com");
		c1.setSite("teste");
		c1.setClientedesde(LocalDate.now());		
		c1.setObs("teste");
		
		ClienteDao dao = new ClienteDao();
		Boolean b = true;
		try {
			assertEquals(b, dao.inserir(c1));
		} catch (Exception e) {
			// Todo Auto-generated catch block
			e.printStackTrace();
		}
		
	

	
	}
}