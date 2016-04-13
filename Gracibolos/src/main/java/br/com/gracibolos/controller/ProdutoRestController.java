package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

@RestController
public class ProdutoRestController {
	
	private ProdutoDao dao;
	private List<Produto> produtosList;
	
	
	@RequestMapping(value = "/rest-produtos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> listAllProdutos() {    
		try {
			dao = new ProdutoDao();
			produtosList = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosList;
    }
	
	@RequestMapping(value = "/rest-produtos/{id}", method = RequestMethod.GET)  
	 public Produto findById(@PathVariable int id) {  
		dao = new ProdutoDao();
		Produto p = new Produto();
		try {
			p = dao.pesquisarPorId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	  return p;  
	 }  
	
}
