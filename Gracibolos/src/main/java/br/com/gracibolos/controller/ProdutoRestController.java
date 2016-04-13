package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

@RestController
@RequestMapping(value = "/rest-produtos")
public class ProdutoRestController {
	
	private ProdutoDao dao;
	private List<Produto> produtosList;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> listAllProdutos() {    
		try {
			dao = new ProdutoDao();
			produtosList = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosList;
    }
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)  
//	 public @ResponseBody String sayHello(@PathVariable String nome) {  
//		dao = new ProdutoDao();
//		Produto p = dao.pesquisar(nome);
//	  String result="Hello "+dao.name+" to dineshonjava.com!!!";    
//	  return result;  
//	 }  
	
}
