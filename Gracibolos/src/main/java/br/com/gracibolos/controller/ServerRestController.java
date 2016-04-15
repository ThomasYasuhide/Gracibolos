package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Cliente;
import br.com.gracibolos.jdbc.model.Produto;

@RestController
public class ServerRestController {
	
	private Produto p;
	private ProdutoDao produtoDao;
	private ClienteDao clienteDao;
	private List<Produto> produtosList;
	private List<Cliente> clientesList;
	
	@RequestMapping(value = "/rest-produtos", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Produto> listAllProdutos() {    
		try {
			produtoDao = new ProdutoDao();
			produtosList = produtoDao.listar();
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, lista de produtos.");
			e.printStackTrace();
		}
		return produtosList;
    }
	
	@RequestMapping(value = "/rest-produtos/{id}", method = RequestMethod.GET, headers="Accept=application/json")  
	 public Produto findById(@PathVariable int id) {  
		produtoDao = new ProdutoDao();
		p = new Produto();
		try {
			p = produtoDao.pesquisarPorId(id);
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, busca produtos por id.");
			e.printStackTrace();
		}    
	  return p;  
	 }  
	
	@RequestMapping(value = "/rest-clientes/{nome}", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Cliente> ListClientes(@PathVariable String nome){
		clienteDao = new ClienteDao();
		try {
			clientesList = clienteDao.pesquisar(nome);
		} catch (Exception e) {
			System.out.println("ERRO - rest clientes, lista de clientes.");
			e.printStackTrace();
		}
		return clientesList;
	}
	
}
