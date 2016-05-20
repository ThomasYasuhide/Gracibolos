package br.com.gracibolos.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.dao.ItemEncomendaDao;
import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Cliente;
import br.com.gracibolos.jdbc.model.Fornecedor;
import br.com.gracibolos.jdbc.model.ItemEncomenda;
import br.com.gracibolos.jdbc.model.MateriaPrima;
import br.com.gracibolos.jdbc.model.Produto;

@RestController
public class ServerRestController {
	
	private Produto p;
	private ProdutoDao produtoDao;
	private ClienteDao clienteDao;
	private List<Produto> produtosList;
	private List<Cliente> clientesList;
	private MateriaPrimaDao mpDao;
	private List<MateriaPrima> mpList;
	private FornecedorDao fornDao;
	private List<Fornecedor> fornList;
	private ItemEncomendaDao ItemEncDao;
	private List<ItemEncomenda> listItemEnc;
	
	// OK
	@RequestMapping(value = "/rest-pesquisar-fornecedor/{pesquisa}")  
	public List<Fornecedor> pesquisar_fornecedor(@PathVariable String pesquisa
			, HttpServletResponse response) {
		fornList = null;
		fornDao = new FornecedorDao();
		try {
			fornList = fornDao.pesquisar(pesquisa);
		} catch (Exception e) {
			System.out.println("ERRO - rest fornecedor, pesquisa fornecedor.");
			e.printStackTrace();
		}    
		colocarAcesso(response);
		return fornList;  
	}
	
	// OK
	@RequestMapping(value = "/rest-pesquisa-materiaprima/{pesquisa}")
	public List<MateriaPrima> pesquisar_materiprima(@PathVariable String pesquisa
			, HttpServletResponse response) 
	{
		mpList = null;
		mpDao = new MateriaPrimaDao();
		try {
			mpList = mpDao.pesquisar(pesquisa);
		} catch (Exception e) {
			System.out.println("ERRO - rest materiaprima, pesquisa materiaprima.");
			e.printStackTrace();
		} 
		// AJAX
		colocarAcesso(response);
	   
		return mpList;  
	}
	// AJAX
	private void colocarAcesso(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	}
	
	// OK
	@RequestMapping(value = "/rest-produtos")
	public List<Produto> listAllProdutos(HttpServletResponse response) {
		try {
			produtoDao = new ProdutoDao();
			produtosList = produtoDao.listar();
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, lista de produtos.");
			e.printStackTrace();
		}
		colocarAcesso(response);
		
		return produtosList;
    }
	
	// OK
	@RequestMapping(value = "/rest-pesquisar-produto-id/{id}")
	 public Produto findById(@PathVariable int id, HttpServletResponse response) {  
		produtoDao = new ProdutoDao();
		p = new Produto();
		try {
			p = produtoDao.pesquisarPorId(id);
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, busca produtos por id.");
			e.printStackTrace();
		}    
		colocarAcesso(response);
        
        return p;  
	 }
	
	// OK
	@RequestMapping(value = "/rest-pesquisar-produto-nome/{pesquisa}") 
	public List<Produto> pesquisar_produto(@PathVariable String pesquisa, HttpServletResponse response) {
		produtoDao = null;
		produtoDao = new ProdutoDao();
		try {
			produtosList = produtoDao.pesquisar(pesquisa);
		} catch (Exception e) {
			System.out.println("ERRO - rest produtos, pesquisa produtos.");
			e.printStackTrace();
		}   
		colocarAcesso(response);
		
		return produtosList;  
	}

	// OK
	@RequestMapping(value = "/rest-clientes/{nome}") 
	public List<Cliente> ListClientes(@PathVariable String nome, HttpServletResponse response){
		clienteDao = new ClienteDao();
		try {
			clientesList = clienteDao.pesquisar(nome);
		} catch (Exception e) {
			System.out.println("ERRO - rest clientes, lista de clientes.");
			e.printStackTrace();
		}
		colocarAcesso(response);
		
		return clientesList;
	}
	
	@RequestMapping(value = "/rest-itensencomenda/{encomenda}") 
	public List<ItemEncomenda> ListItensEncomenda(@PathVariable String encomenda
			, HttpServletResponse response){
		ItemEncDao = new ItemEncomendaDao();
		try {
			listItemEnc = ItemEncDao.pesquisar(encomenda);
		} catch (Exception e) {
			System.out.println("ERRO - rest itensencomenda, lista de itensencomenda.");
			e.printStackTrace();
		}
		colocarAcesso(response);
		
		return listItemEnc;
	}
	
}
