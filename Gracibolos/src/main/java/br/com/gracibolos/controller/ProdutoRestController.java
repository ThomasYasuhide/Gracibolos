package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

@RestController
public class ProdutoRestController {
	
	private Produto p;
	private ProdutoDao dao;
	private List<Produto> produtosList;
	
	
	@RequestMapping(value = "/rest-produtos", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Produto> listAllProdutos() {    
		try {
			dao = new ProdutoDao();
			produtosList = dao.listar();
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, lista de produtos.");
			e.printStackTrace();
		}
		return produtosList;
    }
	
	@RequestMapping(value = "/rest-produtos/{id}", method = RequestMethod.GET, headers="Accept=application/json")  
	 public Produto findById(@PathVariable int id) {  
		dao = new ProdutoDao();
		p = new Produto();
		try {
			p = dao.pesquisarPorId(id);
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, busca produtos por id.");
			e.printStackTrace();
		}    
	  return p;  
	 }  
	
}
