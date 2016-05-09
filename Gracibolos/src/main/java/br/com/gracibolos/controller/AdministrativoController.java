package br.com.gracibolos.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.dao.CidadeDao;
import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.ColaboradorDao;
import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.dao.EstadoDao;
import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Caixa;
import br.com.gracibolos.jdbc.model.Cidade;
import br.com.gracibolos.jdbc.model.Cliente;
import br.com.gracibolos.jdbc.model.Colaborador;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.Estado;
import br.com.gracibolos.jdbc.model.Fornecedor;
import br.com.gracibolos.jdbc.model.ItemEncomenda;
import br.com.gracibolos.jdbc.model.MateriaPrima;
import br.com.gracibolos.jdbc.model.Produto;

@Controller
public class AdministrativoController {
	//DASHBOARD
	@RequestMapping("/administrativo-dashboard")
	public ModelAndView dashboard(){
		System.out.println("Entrou na pagina dashboard");
		return new ModelAndView("administrativo/dashboard");
	}
	
	/*
	 * 
	 * ###################### PRODUTOS ######################
	 * 
	 * */
	
	//PRODUTOS
	//mapeamento da jsp admin produtos
	@RequestMapping("/administrativo-produtos")
	public ModelAndView produtos(){
		System.out.println("Entrou na pagina de listagem de produtos");
		//retorna a página produtos
		return new ModelAndView("administrativo/produtos");
	}
	
	//INCLUIR NOVO PRODUTO
	@RequestMapping("/administrativo-incluir-produto")
	public ModelAndView incluir_produto(Produto produto, @RequestParam("file") MultipartFile file, HttpServletRequest request){
		System.out.println("Entrou na servlet de inclusão de um novo produto");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do produto
	    ProdutoDao produtoDao = new ProdutoDao();

	    if(!file.isEmpty()) {
		    produto.setFoto(file.getOriginalFilename().toString());
		    
		    try {
		    	
		    	//Pasta de destino
		        String Path = request.getServletContext().getRealPath("\\resources\\img\\produtos");
		        System.out.println("uploadRootPath=" + Path);
		 
		        File diretorio = new File(Path);
		        
		        //Verifica se o diretório já existe, senão cria o diretorio
		        if (!diretorio.exists()) {
		        	diretorio.mkdirs();
		        }
		        
		        File serverFile = new File(diretorio.getAbsolutePath() + File.separator + file.getOriginalFilename());
		    	
		    	BufferedOutputStream stream = null;
		    	stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				FileCopyUtils.copy(file.getInputStream(), stream);
				
				stream.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
	    } else {
	    	
	    	if(produto.getFoto() == null || produto.getFoto().equals("")){
		    	produto.setFoto("model.png");
	    	}
	    	
	    }
	    
		try {
			//se o método inserir passando um produto, for executado corretamente, status recebe verdadeiro
			if(produtoDao.inserir(produto)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/produtos");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//retorna o mv
		return mv;
	}
	
	//AlTERAR PRODUTO
	@RequestMapping("/administrativo-alterar-produto")
	public ModelAndView alterar_produto(Produto produto, @RequestParam("file") MultipartFile file, HttpServletRequest request){
				
		System.out.println("Entrou na pagina de alteração de produto");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do produto
		ProdutoDao produtoDao = new ProdutoDao();
	    
		if(!file.isEmpty()) {
		    produto.setFoto(file.getOriginalFilename().toString());
		    
		    try {
		    	
		    	//Pasta de destino
		        String Path = request.getServletContext().getRealPath("\\resources\\img\\produtos");
		        System.out.println("uploadRootPath=" + Path);
		 
		        File diretorio = new File(Path);
		        
		        //Verifica se o diretório já existe, senão cria o diretorio
		        if (!diretorio.exists()) {
		        	diretorio.mkdirs();
		        }
		        
		        File serverFile = new File(diretorio.getAbsolutePath() + File.separator + file.getOriginalFilename());
		    	
		    	BufferedOutputStream stream = null;
		    	stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				FileCopyUtils.copy(file.getInputStream(), stream);

				stream.close();
			} catch (IOException e) {
				System.out.println("Não foi possível fazer o upload da imagem.");
				e.printStackTrace();
			}
		    
	    } else {
	    	
	    	if(produto.getFoto() == null){
		    	produto.setFoto("model.png");
	    	}
	    	
	    }
				
		try {
			//se o método alterar passando um produto, for executado corretamente, status recebe verdadeiro
			if(produtoDao.alterar(produto)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView		
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/produtos");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//retorna o mv
		return mv;
	}
	
	//EXCLUIR PRODUTO
	@RequestMapping("/administrativo-remover-produto")
	public ModelAndView excluir_produto(Produto produto){
		System.out.println("Entrou na pagina de exclusão de produto");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do produto
		ProdutoDao produtoDao = new ProdutoDao();
		
		try {
			//se o método excluir passando um produto, for executado corretamente, status recebe verdadeiro
			if(produtoDao.excluir(produto)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/produtos");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		//retorna o mv
		return mv;
	}	
	
	//PESQUISAR PRODUTOS
	@RequestMapping("/administrativo-pesquisar-produto")
	public ModelAndView pesquisar_produto(String pesquisa){
		System.out.println("Realizou a pesquisa de produto");
		
		//cria uma nova instância DAO do produto
		ProdutoDao produtoDao = new ProdutoDao();
				
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/produtos");
		//passa a lista de produtos para a Expression Language chamada produtos
		mv.addObject("produtos", produtos);
		//retorna o mv	    
	    return mv;
	}
	
	//LISTAR PRODUTOS
		@RequestMapping("/administrativo-listar-produtos")
		public ModelAndView listar_produtos(){
			System.out.println("Realizou a listagem de produtos");
			
			//cria uma nova instância DAO do produto
			ProdutoDao produtoDao = new ProdutoDao();
			
			List<Produto> produtos = null;
			
			try {
				//Guarda a lista de produtos num List
				produtos = produtoDao.listar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
			//instância uma nova modelView
			ModelAndView mv = new ModelAndView();
			//seta o caminho e o nome da jsp
			mv.setViewName("administrativo/produtos");
			//passa a lista de produtos para a Expression Language chamada produtos
			mv.addObject("produtos", produtos);
			//retorna o mv	    
		    return mv;
		}
				
	/*
	 * 
	 * ###################### FORNECEDORES ######################
	 * 
	 * */
	
	//FORNECEDORES
	@RequestMapping("/administrativo-fornecedores")
	public ModelAndView fornecedores(){
		System.out.println("Entrou na servlet de listagem de fornecedores");
		
		//cria uma nova instância DAO do estado
		EstadoDao estadoDao = new EstadoDao();
		//Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
		
	    //instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/fornecedores");
	    //passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);
	    //retorna o mv
		return mv;
	}
	
	//INCLUIR NOVO FORNECEDOR
	@RequestMapping("/administrativo-incluir-fornecedor")
	public ModelAndView incluir_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na servlet de inclusão de um novo fornecedor");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			//se o método inserir passando um fornecedor, for executado corretamente, status recebe verdadeiro
			if(fornecedorDao.inserir(fornecedor)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
     	//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/fornecedores");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//passa a lista de estados para a Expression Language chamada estados
		mv.addObject("estados", estados);
		//retorna o mv
		return mv;
	}
	
	//AlTERAR FORNECEDOR
	@RequestMapping("/administrativo-alterar-fornecedor")
	public ModelAndView alterar_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na pagina de alteração de fornecedor");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			//se o método alterar passando um fornecedor, for executado corretamente, status recebe verdadeiro
			if(fornecedorDao.alterar(fornecedor)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/fornecedores");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);		
	    //retorna o mv
		return mv;
	}
	
	//EXCLUIR FORNECEDOR
	@RequestMapping("/administrativo-remover-fornecedor")
	public ModelAndView excluir_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na pagina de exclusão de fornecedor");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			//se o método excluir passando um fornecedor, for executado corretamente, status recebe verdadeiro
			if(fornecedorDao.excluir(fornecedor)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/fornecedores");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		//passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);		
	    //retorna o mv
		return mv;
	}
	
	//PESQUISAR FORNECEDORES
	@RequestMapping("/administrativo-pesquisar-fornecedor")
	public ModelAndView pesquisar_fornecedor(String pesquisa){
		System.out.println("Realizou a pesquisa de fornecedor");
		
		//cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = null;
		
		try {
			fornecedores = fornecedorDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/fornecedores");
	    //passa a lista de fornecedores para a Expression Language chamada fornecedores
	    mv.addObject("fornecedores", fornecedores);
		//passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);	    
	    //retorna o mv
	    return mv;
	}
	
	//LISTAR FORNECEDORES
		@RequestMapping("/administrativo-listar-fornecedores")
	public ModelAndView listar_fornecedores(){
		System.out.println("Realizou a listagem de fornecedores");
		
		//cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = null;
		
		try {
			//Guarda a lista de fornecedores num List
			fornecedores = fornecedorDao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/fornecedores");
		//passa a lista de fornecedores para a Expression Language chamada fornecedores
	    mv.addObject("fornecedores", fornecedores);
		//passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
		//retorna o mv		    
	    return mv;
	}
	
	/*
	 * 
	 * ###################### CLIENTES ######################
	 * 
	 * */
	
	//CLIENTES
	@RequestMapping("/administrativo-clientes")
	public ModelAndView clientes(){
		System.out.println("Entrou na servlet de listagem de clientes");
		
		//cria uma nova instância DAO do estado
		EstadoDao estadoDao = new EstadoDao();
		//Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
		
	    //instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/clientes");
	    //passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
	    //retorna o mv	
		return mv;
	}
	
	//INCLUIR NOVO CLIENTE
	@RequestMapping("/administrativo-incluir-cliente")
	public ModelAndView incluir_cliente(Cliente cliente){
		System.out.println("Entrou na servlet de inclusão de um novo cliente");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do cliente
		ClienteDao dao = new ClienteDao();
		
		try {
			//se o método inserir passando um cliente, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(cliente)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/clientes");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
	    //retorna o mv
		return mv;
	}
	
	//AlTERAR CLIENTE
	@RequestMapping("/administrativo-alterar-cliente")
	public ModelAndView alterar_cliente(Cliente cliente){
		System.out.println("Entrou na pagina de alteração de cliente");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	  //cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		
		try {
			//se o método alterar passando um cliente, for executado corretamente, status recebe verdadeiro
			if(clienteDao.alterar(cliente)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/clientes");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
	    //retorna o mv		
		return mv;
	}
	
	//EXCLUIR CLIENTE
	@RequestMapping("/administrativo-remover-cliente")
	public ModelAndView excluir_cliente(Cliente cliente){
		System.out.println("Entrou na pagina de exclusão de cliente");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		
		try {
			//se o método excluir passando um cliente, for executado corretamente, status recebe verdadeiro
			if(clienteDao.excluir(cliente)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/clientes");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
		//retorna o mv		
		return mv;
	}
	
	//PESQUISAR CLIENTE
	@RequestMapping("/administrativo-pesquisar-cliente")
	public ModelAndView pesquisar_cliente(String pesquisa){
		System.out.println("Realizou a pesquisa de cliente");
		
		//cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			clientes = clienteDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de clientes num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/clientes");
	    //passa a lista de clientes para a Expression Language chamada clientes	
	    mv.addObject("clientes", clientes);
	    //passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
	    //retorna mv
	    return mv;
	}

	//LISTAR CLIENTES
	@RequestMapping("/administrativo-listar-clientes")
	public ModelAndView listar_cliente(){
		System.out.println("Realizou a listagem de clientes");
		
		//cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			//Guarda a lista de clientes num List
			clientes = clienteDao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/clientes");
	    //passa a lista de clientes para a Expression Language chamada clientes	
	    mv.addObject("clientes", clientes);
	    //passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
	    //retorna mv
	    return mv;
	}

	/*
	 * 
	 * ###################### COLABORADOR ######################
	 * 
	 * */
	
	//COLABORADOR
	@RequestMapping("/administrativo-colaboradores")
	public ModelAndView colaboradores(){
		System.out.println("Entrou na servlet de listagem de colaboradores");
		
		//cria uma nova instância DAO do estado
		EstadoDao estadoDao = new EstadoDao();
		//Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
		
	    //instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/colaboradores");
	    //passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);
	    //retorna mv		
		return mv;
	}
	
	//INCLUIR NOVO COLABORADOR
	@RequestMapping("/administrativo-incluir-colaborador")
	public ModelAndView incluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na servlet de inclusão de um novo colaborador");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do colaborador
		ColaboradorDao dao = new ColaboradorDao();
		
		//se o método inserir passando um colaborador, for executado corretamente, status recebe verdadeiro
		if(dao.inserir(colaborador)){
			status = true;
		}
		//caso contrário, status recebe falso
		else{
			status = false;
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/colaboradores");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//passa a lista de estados para a Expression Language chamada estados
		mv.addObject("estados", estados);
		//retorna mv
		return mv;
	}	
	
	//AlTERAR COLABORADOR
	@RequestMapping("/administrativo-alterar-colaborador")
	public ModelAndView alterar_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de alteração de colaborador");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do colaborador
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		//se o método alterar passando um colaborador, for executado corretamente, status recebe verdadeiro
		if(colaboradorDao.alterar(colaborador)){
			status = true;
		}
		//caso contrário, status recebe falso
		else{
			status = false;
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/colaboradores");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//passa a lista de clientes para a Expression Language chamada clientes
	    mv.addObject("estados", estados);
	    //retorna mv		
		return mv;
	}
	
	//EXCLUIR COLABORADOR
	@RequestMapping("/administrativo-remover-colaborador")
	public ModelAndView excluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de exclusão de colaborador");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	  //cria uma nova instância DAO do colaborador
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		//se o método excluir passando um colaborador, for executado corretamente, status recebe verdadeiro
		if(colaboradorDao.excluir(colaborador)){
			status = true;
		}
		//caso contrário, status recebe falso
		else{
			status = false;
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/colaboradores");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
	    //passa a lista de clientes para a Expression Language chamada clientes
		mv.addObject("estados", estados);
	    //retorna mv		
		return mv;
	}
	
	//PESQUISAR COLABORADOR
	@RequestMapping("/administrativo-procurar-colaborador")
	public ModelAndView pesquisar_colaborador(String pesquisa){
		System.out.println("Realizou a pesquisa de colaboradores");
		
		//cria uma nova instância DAO do colaborador
		ColaboradorDao dao = new ColaboradorDao();
		List<Colaborador> colaboradores = dao.pesquisar(pesquisa);
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/colaboradores");
		//passa a lista de colaborador para a Expression Language chamada colaboradores
	    mv.addObject("colaboradores", colaboradores);
	    //passa a lista de clientes para a Expression Language chamada clientes
	    mv.addObject("estados", estados);
	    //retorna mv    
	    return mv;
	}
	
	//LISTAR COLABORADOR
		@RequestMapping("/administrativo-listar-colaboradores")
	public ModelAndView listar_colaborador(){
			System.out.println("Realizou a listagem de colaboradores");
			
			//cria uma nova instância DAO do colaborador
			ColaboradorDao colaboradorDao = new ColaboradorDao();
			//Guarda a lista de colaborador num List
			List<Colaborador> colaboradores = colaboradorDao.listar();
			
			//cria uma nova instância DAO do estado
		    EstadoDao estadoDao = new EstadoDao();
		    //Guarda a lista de estados num List
		    List<Estado> estados = estadoDao.listar_estados();
		    
		    //instância uma nova modelView
		    ModelAndView mv = new ModelAndView();
		    //seta o caminho e o nome da jsp
		    mv.setViewName("administrativo/colaboradores");
			//passa a lista de colaborador para a Expression Language chamada colaboradores
		    mv.addObject("colaboradores", colaboradores);
		    //passa a lista de clientes para a Expression Language chamada clientes
		    mv.addObject("estados", estados);
		    //retorna mv    
		    return mv;
		}

	/*
	 * 
	 * ###################### CIDADES ######################
	 * 
	 * */
	
	@RequestMapping(value="/administrativo-pesquisar-cidade", method=RequestMethod.POST)
	public @ResponseBody List<Cidade> pesquisar_cidade(int id){
				
		List<Cidade> cidades = new ArrayList<Cidade>();

		//cria uma nova instância DAO do estado
		CidadeDao dao = new CidadeDao();
		try {
			cidades = dao.pesquisar_cidades(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    return cidades;
		
	}
	
	/*
	 * 
	 * ###################### PESQUISA VALORES ######################
	 * 
	 * */
	
	@RequestMapping(value="/administrativo-pesquisar-valor", method=RequestMethod.POST)
	public @ResponseBody Produto pesquisar_valor(int id){
				
		Produto produto = new Produto();

		//cria uma nova instância DAO
		ProdutoDao dao = new ProdutoDao();
		try {
			produto = dao.pesquisarPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	    return produto;
		
	}
	
	/*
	 * 
	 * ###################### MATÉRIA PRIMA ######################
	 * 
	 * */
	
	//MATÉRIA PRIMA
	//mapeamento da jsp admin materias-primas
	@RequestMapping("/administrativo-materiasprimas")
	public ModelAndView materiaPrima(){
		System.out.println("Entrou na servlet de listagem de matéria prima");
		
		//retorna a página materias-primas
		return new ModelAndView("administrativo/materiasprimas");
	}
		
	//INCLUIR NOVA MATÉRIA PRIMA
	@RequestMapping("/administrativo-incluir-materiaprima")
	public ModelAndView incluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na servlet de inclusão de uma nova materiaPrima");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();			
		
		try {
			//se o método inserir passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(materiaprima)) {
				status = true;			
			}
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//retorna o mv
		return mv;
	}
		
	//AlTERAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-alterar-materiaprima")
	public ModelAndView alterar_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de alteração de materiaPrima");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO da materia-prima
		MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();			
			
		try
		{
			//se o método alterar passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(materiaPrimaDao.alterar(materiaprima)) {
				status = true;
			} else {
			//caso contrário, status recebe falso
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
	    //retorna mv
		return mv;
			
	}
		
	//EXCLUIR MATÉRIA PRIMA
	@RequestMapping("/administrativo-remover-materiaprima")
	public ModelAndView excluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de exclusão de materiaprima");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;	
		
		//cria uma nova instância dao da materia-prima
	    MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
			
		try {
			//se o método excluir passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(materiaPrimaDao.excluir(materiaprima)) {
				status = true;
			} 
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);			
	    //retorna mv
		return mv;
	}
		
	//PESQUISAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-procurar-materiaprima")
	public ModelAndView pesquisar_materiaPrima(String pesquisa){
		System.out.println("Realizou a pesquisa de matéria prima");
		
		//cria uma nova instância dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		try {
			materiasprimas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa a lita de materia-prima para a Expression Language chamada materiasprimas
		mv.addObject("materiasprimas", materiasprimas);
	    //retorna mv		    
	    return mv;
	}
	
	//LISTAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-listar-materiasprimas")
	public ModelAndView listar_materiasprimas(){
		System.out.println("Realizou a listagem de matérias primas");
		
		//cria uma nova instância dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		
		try {
			//Guarda a lista de materia-prima num List
			materiasprimas = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa a lita de materia-prima para a Expression Language chamada materiasprimas
		mv.addObject("materiasprimas", materiasprimas);
	    //retorna mv		    
	    return mv;
	}
	
	/*
	 * 
	 * ###################### CAIXA ######################
	 * 
	 * */
	
	//CAIXA
	@RequestMapping("/administrativo-caixa")
	public ModelAndView caixa(){
		System.out.println("Entrou na servlet de listagem de matéria prima");
						
		return new ModelAndView("administrativo/caixa");
	}
	
	//INCLUIR NOVO CAIXA
	@RequestMapping("/administrativo-incluir-caixa")
	public ModelAndView incluir_caixa(Caixa caixa){
		System.out.println("Entrou na servlet de inclusão de um novo caixa");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		 
		//cria uma nova instância DAO do caixa
		CaixaDao dao = new CaixaDao();			
			
		try {
			//se o método inserir passando um caixa, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(caixa)) {
				status = true;
			} 
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
	    //retorna mv
		return mv;
	}
	
	//AlTERAR CAIXA
	@RequestMapping("/administrativo-alterar-caixa")
	public ModelAndView alterar_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de alteração do caixa");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do caixa
		CaixaDao dao = new CaixaDao();			
			
		try
		{
			//se o método alterar passando um caixa, for executado corretamente, status recebe verdadeiro
			if(dao.alterar(caixa)) {
				status = true;
			}
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
	    //retorna mv
		return mv;
	}
			
	//EXCLUIR CAIXA
	@RequestMapping("/administrativo-excluir-caixa")
	public ModelAndView excluir_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de exclusão do caixa");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;	
		//cria uma nova instância DAO do caixa		
		CaixaDao dao = new CaixaDao();			
				
		try {
			//se o método excluir passando um caixa, for executado corretamente, status recebe verdadeiro
			if(dao.excluir(caixa)) {
				status = true;
			}
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);			
	    //retorna mv
		return mv;
	}
			
	//PESQUISAR ENTRE CAIXA
	@RequestMapping("/administrativo-pesquisar-entre")
	public ModelAndView pesquisar_entre (String inicio, String fim){
		System.out.println("Realizou a pesquisa entre datas do caixa");
		
		//cria uma nova instância DAO do caixa
		CaixaDao dao = new CaixaDao();		
		List<Caixa> caixas = null;
		try {
			caixas = dao.pesquisarEntre(inicio, fim);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/caixa");
	    //passa a lista do caixa para a Expression Language chamada caixas
		mv.addObject("listCaixa", caixas);
	    //retorna mv
	    return mv;
	}
	
	//LISTAR CAIXA
		@RequestMapping("/administrativo-listar-caixa")
		public ModelAndView listar_caixa(){
			System.out.println("Realizou a listagem do caixa");
			
			//cria uma nova instância dao da materia-prima
			CaixaDao dao = new CaixaDao();
			List<Caixa> caixas = null;
			
			try {
				//Guarda a lista de materia-prima num List
				caixas = dao.listar();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//instância uma nova modelView
			ModelAndView mv = new ModelAndView();
		    //seta o caminho e o nome da jsp
			mv.setViewName("administrativo/caixa");
			//passa a lita de materia-prima para a Expression Language chamada materiasprimas
			mv.addObject("caixas", caixas);
		    //retorna mv		    
		    return mv;
		}
	
	/*
	 * 
	 * ###################### ENCOMENDA ######################
	 * 
	 * */
	
	//ENCOMENDA
	@RequestMapping("/administrativo-encomendas")
	public ModelAndView encomenda(){
		System.out.println("Entrou na servlet de listagem de matéria prima");
			
			//TESTES
				Encomenda encomenda = new Encomenda();
				encomenda.setId((long) 667);
				encomenda.setClienteid(5);
				encomenda.setClientenome("Breno Rufino");
				encomenda.setClientecpfcnpj("212.542.288-21");
				encomenda.setTotalprodutos(new BigDecimal("300.00"));
				encomenda.setResponsavel("Rogério Yudi");
				encomenda.setDataencomenda(LocalDate.now());
				encomenda.setDataentrega(LocalDate.now().plusDays(2));
				encomenda.setObs("Nenhuma observação");
		
				List<ItemEncomenda> itens = new ArrayList<ItemEncomenda>();
		
				ItemEncomenda item = new ItemEncomenda();
				item.setId((long) 1);
				item.setNumero(1);
				item.setProdutoId(3);
				item.setQuantidade(20);
				item.setValor(new BigDecimal("10.00"));
				item.setTotal(new BigDecimal("200.00"));
				
				ItemEncomenda item2 = new ItemEncomenda();
				item2.setId((long) 2);
				item2.setNumero(2);
				item2.setProdutoId(2);
				item2.setQuantidade(20);
				item2.setValor(new BigDecimal("5.00"));
				item2.setTotal(new BigDecimal("100.00"));
				
				itens.add(item);
				itens.add(item2);
			//FIM DOS TESTES

		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
		//passa os dados da encomenda para a Expression Language chamada encomenda
		mv.addObject("encomenda", encomenda);
		//passa a lista de item para a Expression Language chamada itens
		mv.addObject("itens", itens);
		//retorna mv
		return mv;
	}
		
	//INCLUIR NOVA ENCOMENDA
	@RequestMapping("/administrativo-incluir-encomenda")
	public ModelAndView incluir_encomenda(Encomenda encomenda){
		System.out.println("Entrou na servlet de inclusão de uma nova encomenda");
		
		
		/*
		 
		 
		 
		 Código para ler os produtos de um input array html
		 
		 
		 
		 System.out.println(encomendas.getProdutos().size());
		
		for(int i=0; i<encomendas.getProdutos().size();i++){
			if(encomendas.getProdutos().get(i).getNome() != ""){
				
				Produto produto = new Produto();
				produto.setId(encomendas.getProdutos().get(i).getId());
				produto.setNome(encomendas.getProdutos().get(i).getNome());

				System.out.println(produto.getId());
				System.out.println(produto.getNome());
			}
		}
		 
		 
		 */
		
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO da encomenda
		EncomendaDao dao = new EncomendaDao();			
			
		try {
			//se o método inserir passando uma encomenda, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(encomenda)) {
				status = true;
			} 
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
	    //retorna mv
		return mv;
	}
		
	//AlTERAR ENCOMENDA
	@RequestMapping("/administrativo-alterar-encomenda")
	public ModelAndView alterar_encomenda(Encomenda encomenda){
		System.out.println("Entrou na pagina de alteração de encomenda");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO da encomenda
		EncomendaDao dao = new EncomendaDao();			
			
		try
		{
			//se o método alterar passando uma encomenda, for executado corretamente, status recebe verdadeiro
			if(dao.alterar(encomenda)) {
				status = true;
			}
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
	    //retorna mv			
		return mv;
	}
		
	//EXCLUIR ENCOMENDA
	@RequestMapping("/administrativo-excluir-encomenda")
	public ModelAndView excluir_encomenda(Encomenda encomenda){
		System.out.println("Entrou na pagina de exclusão de encomenda");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;	
		//cria uma nova instância DAO da encomenda	
		EncomendaDao dao = new EncomendaDao();
			
		try {
			//se o método excluir passando uma encomenda, for executado corretamente, status recebe verdadeiro
			if(dao.excluir(encomenda)) {
				status = true;
			} 
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);			
	    //retorna mv			
		return mv;
	}
		
	//PESQUISAR ENCOMENDA
	@RequestMapping("/administrativo-pesquisar-encomenda")
	public ModelAndView pesquisar_encomenda(String pesquisa){
		System.out.println("Realizou a pesquisa de matéria prima");
		
		//cria uma nova instância DAO da encomenda
		EncomendaDao dao = new EncomendaDao();
		
		List<Encomenda> encomendas = null;
		try {
			encomendas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
	    //passa a lista de encomenda para a Expression Language chamada encomendas
		mv.addObject("encomendas", encomendas);
	    //retorna mv		    
	    return mv;
	}
	
}