package br.com.gracibolos.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import br.com.gracibolos.jdbc.model.MateriaPrima;
import br.com.gracibolos.jdbc.model.Produto;

@Controller
public class AdministrativoController {
	//teste
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
	@RequestMapping("/administrativo-produtos")
	public ModelAndView produtos(){
		System.out.println("Entrou na pagina de listagem de produtos");
		return new ModelAndView("administrativo/produtos");
	}
	
	//INCLUIR NOVO PRODUTO
	@RequestMapping("/administrativo-incluir-produto")
	public ModelAndView incluir_produto(Produto produto, @RequestParam("file") MultipartFile file, HttpServletRequest request){
		System.out.println("Entrou na servlet de inclusão de um novo produto");
		
		boolean status = false;
		
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
		    
	    }
	    
		try {
			if(produtoDao.inserir(produto)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/produtos");
		mv.addObject("incluir", status);

		return mv;
	}
	
	//AlTERAR PRODUTO
	@RequestMapping("/administrativo-alterar-produto")
	public ModelAndView alterar_produto(Produto produto, @RequestParam("file") MultipartFile file, HttpServletRequest request){
				
		System.out.println("Entrou na pagina de alteração de produto");

		boolean status = false;
		
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
			if(produtoDao.alterar(produto)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/produtos");
		mv.addObject("alterar", status);
		
		return mv;
	}
	
	//EXCLUIR PRODUTO
	@RequestMapping("/administrativo-remover-produto")
	public ModelAndView excluir_produto(Produto produto){
		System.out.println("Entrou na pagina de exclusão de produto");
		
		boolean status = false;
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		try {
			if(produtoDao.excluir(produto)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/produtos");
		mv.addObject("excluir", status);
		
		return mv;
	}
	
	//PESQUISAR PRODUTOS
	@RequestMapping("/administrativo-pesquisar-produto")
	public ModelAndView pesquisar_produto(String pesquisa){
		System.out.println("Realizou a pesquisa de produto");
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/produtos");
	    mv.addObject("produtos", produtos);
	    
	    return mv;
	}
	
	//LISTAR PRODUTOS
		@RequestMapping("/administrativo-listar-produtos")
		public ModelAndView listar_produtos(){
			System.out.println("Realizou a listagem de produtos");
			
			ProdutoDao produtoDao = new ProdutoDao();
			
			List<Produto> produtos = null;
			
			try {
				produtos = produtoDao.listar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    ModelAndView mv = new ModelAndView();
		    mv.setViewName("administrativo/produtos");
		    mv.addObject("produtos", produtos);
		    
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
		
		EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
		
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/fornecedores");
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//INCLUIR NOVO FORNECEDOR
	@RequestMapping("/administrativo-incluir-fornecedor")
	public ModelAndView incluir_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na servlet de inclusão de um novo fornecedor");
		
		boolean status = false;

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			if(fornecedorDao.inserir(fornecedor)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/fornecedores");
		mv.addObject("incluir", status);
		mv.addObject("estados", estados);

		return mv;
	}
	
	//AlTERAR FORNECEDOR
	@RequestMapping("/administrativo-alterar-fornecedor")
	public ModelAndView alterar_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na pagina de alteração de fornecedor");

		boolean status = false;

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();

		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			if(fornecedorDao.alterar(fornecedor)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/fornecedores");
		mv.addObject("alterar", status);
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//EXCLUIR FORNECEDOR
	@RequestMapping("/administrativo-remover-fornecedor")
	public ModelAndView excluir_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na pagina de exclusão de fornecedor");
		
		boolean status = false;
		
	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();

		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			if(fornecedorDao.excluir(fornecedor)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/fornecedores");
		mv.addObject("excluir", status);
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//PESQUISAR FORNECEDORES
	@RequestMapping("/administrativo-pesquisar-fornecedor")
	public ModelAndView pesquisar_fornecedor(String pesquisa){
		System.out.println("Realizou a pesquisa de fornecedor");

		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = null;
		
		try {
			fornecedores = fornecedorDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/fornecedores");
	    mv.addObject("fornecedores", fornecedores);
	    mv.addObject("estados", estados);
	    
	    return mv;
	}
	
	//LISTAR FORNECEDORES
		@RequestMapping("/administrativo-listar-fornecedores")
		public ModelAndView listar_fornecedores(){
			System.out.println("Realizou a listagem de fornecedores");

			FornecedorDao fornecedorDao = new FornecedorDao();
			List<Fornecedor> fornecedores = null;
			
			try {
				fornecedores = fornecedorDao.listar();
			} catch (Exception e) {
				e.printStackTrace();
			}

		    EstadoDao estadoDao = new EstadoDao();
		    List<Estado> estados = estadoDao.listar_estados();
		    
		    ModelAndView mv = new ModelAndView();
		    mv.setViewName("administrativo/fornecedores");
		    mv.addObject("fornecedores", fornecedores);
		    mv.addObject("estados", estados);
		    
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
		
		EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
		
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/clientes");
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//INCLUIR NOVO CLIENTE
	@RequestMapping("/administrativo-incluir-cliente")
	public ModelAndView incluir_cliente(Cliente cliente){
		System.out.println("Entrou na servlet de inclusão de um novo cliente");
		
		boolean status = false;

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
		ClienteDao dao = new ClienteDao();
		
		try {
			if(dao.inserir(cliente)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/clientes");
		mv.addObject("incluir", status);
		mv.addObject("estados", estados);

		return mv;
	}
	
	//AlTERAR CLIENTE
	@RequestMapping("/administrativo-alterar-cliente")
	public ModelAndView alterar_cliente(Cliente cliente){
		System.out.println("Entrou na pagina de alteração de cliente");

		boolean status = false;

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();

		ClienteDao clienteDao = new ClienteDao();
		
		try {
			if(clienteDao.alterar(cliente)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/clientes");
		mv.addObject("alterar", status);
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//EXCLUIR CLIENTE
	@RequestMapping("/administrativo-remover-cliente")
	public ModelAndView excluir_cliente(Cliente cliente){
		System.out.println("Entrou na pagina de exclusão de cliente");
		
		boolean status = false;
		
	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();

		ClienteDao clienteDao = new ClienteDao();
		
		try {
			if(clienteDao.excluir(cliente)){
				status = true;
			}else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/clientes");
		mv.addObject("excluir", status);
	    mv.addObject("estados", estados);
		
		
		return mv;
	}
	
	//PESQUISAR CLIENTE
	@RequestMapping("/administrativo-pesquisar-cliente")
	public ModelAndView pesquisar_cliente(String pesquisa){
		System.out.println("Realizou a pesquisa de cliente");

		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			clientes = clienteDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/clientes");
	    mv.addObject("clientes", clientes);
	    mv.addObject("estados", estados);
	    
	    return mv;
	}
	
	//LISTAR CLIENTES
		@RequestMapping("/administrativo-listar-clientes")
		public ModelAndView listar_cliente(){
			System.out.println("Realizou a listagem de clientes");

			ClienteDao clienteDao = new ClienteDao();
			List<Cliente> clientes = null;
			try {
				clientes = clienteDao.listar();
			} catch (Exception e) {
				e.printStackTrace();
			}

		    EstadoDao estadoDao = new EstadoDao();
		    List<Estado> estados = estadoDao.listar_estados();
		    
		    ModelAndView mv = new ModelAndView();
		    mv.setViewName("administrativo/clientes");
		    mv.addObject("clientes", clientes);
		    mv.addObject("estados", estados);
		    
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
		
		EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
		
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/colaboradores");
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//INCLUIR NOVO COLABORADOR
	@RequestMapping("/administrativo-incluir-colaborador")
	public ModelAndView incluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na servlet de inclusão de um novo colaborador");
		
		boolean status = false;

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
		ColaboradorDao dao = new ColaboradorDao();
		
		if(dao.inserir(colaborador)){
			status = true;
		}else{
			status = false;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/colaboradores");
		mv.addObject("incluir", status);
		mv.addObject("estados", estados);

		return mv;
	}
	
	//AlTERAR COLABORADOR
	@RequestMapping("/administrativo-alterar-colaborador")
	public ModelAndView alterar_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de alteração de colaborador");

		boolean status = false;

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		if(colaboradorDao.alterar(colaborador)){
			status = true;
		}else{
			status = false;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/colaboradores");
		mv.addObject("alterar", status);
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//EXCLUIR COLABORADOR
	@RequestMapping("/administrativo-remover-colaborador")
	public ModelAndView excluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de exclusão de colaborador");
		
		boolean status = false;
		
	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
		
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		if(colaboradorDao.excluir(colaborador)){
			status = true;
		}else{
			status = false;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/colaboradores");
		mv.addObject("excluir", status);
	    mv.addObject("estados", estados);
		
		
		return mv;
	}
	
	//PESQUISAR COLABORADOR
	@RequestMapping("/administrativo-procurar-colaborador")
	public ModelAndView pesquisar_colaborador(String pesquisa){
		System.out.println("Realizou a pesquisa de colaboradores");
		
		ColaboradorDao dao = new ColaboradorDao();
		List<Colaborador> colaboradores = dao.pesquisar(pesquisa);

	    EstadoDao estadoDao = new EstadoDao();
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("administrativo/colaboradores");
	    mv.addObject("colaboradores", colaboradores);
	    mv.addObject("estados", estados);
	    
	    return mv;
	}
	
	//LISTAR COLABORADOR
		@RequestMapping("/administrativo-listar-colaboradores")
		public ModelAndView listar_colaborador(){
			System.out.println("Realizou a listagem de colaboradores");
			
			ColaboradorDao colaboradorDao = new ColaboradorDao();
			List<Colaborador> colaboradores = colaboradorDao.listar();

		    EstadoDao estadoDao = new EstadoDao();
		    List<Estado> estados = estadoDao.listar_estados();
		    
		    ModelAndView mv = new ModelAndView();
		    mv.setViewName("administrativo/colaboradores");
		    mv.addObject("colaboradores", colaboradores);
		    mv.addObject("estados", estados);
		    
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
	 * ###################### MATÉRIA PRIMA ######################
	 * 
	 * */
	
	//MATÉRIA PRIMA
	@RequestMapping("/administrativo-materiasprimas")
	public ModelAndView materiaPrima(){
		System.out.println("Entrou na servlet de listagem de matéria prima");
						
		return new ModelAndView("administrativo/materiasprimas");
	}
		
	//INCLUIR NOVA MATÉRIA PRIMA
	@RequestMapping("/administrativo-incluir-materiaprima")
	public ModelAndView incluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na servlet de inclusão de uma nova materiaPrima");
			
		boolean status = false;
		    
		MateriaPrimaDao dao = new MateriaPrimaDao();			
			
		try {
			if(dao.inserir(materiaprima)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/materiasprimas");
		mv.addObject("incluir", status);

		return mv;
	}
		
	//AlTERAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-alterar-materiaprima")
	public ModelAndView alterar_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de alteração de materiaPrima");

		boolean status = false;

		MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();			
			
		try
		{
			if(materiaPrimaDao.alterar(materiaprima)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/materiasprimas");
		mv.addObject("alterar", status);
			
		return mv;
	}
		
	//EXCLUIR MATÉRIA PRIMA
	@RequestMapping("/administrativo-remover-materiaprima")
	public ModelAndView excluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de exclusão de materiaprima");
			
		boolean status = false;	
			
	    MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
			
		try {
			if(materiaPrimaDao.excluir(materiaprima)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/materiasprimas");
		mv.addObject("excluir", status);			
			
		return mv;
	}
		
	//PESQUISAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-procurar-materiaprima")
	public ModelAndView pesquisar_materiaPrima(String pesquisa){
		System.out.println("Realizou a pesquisa de matéria prima");
			
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		try {
			materiasprimas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
				    
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/materiasprimas");
		mv.addObject("materiasprimas", materiasprimas);
		    
	    return mv;
	}
	
	//LISTAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-listar-materiasprimas")
	public ModelAndView listar_materiasprimas(){
		System.out.println("Realizou a listagem de matérias primas");
			
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		
		try {
			materiasprimas = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
				    
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/materiasprimas");
		mv.addObject("materiasprimas", materiasprimas);
		    
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
				
		boolean status = false;
		    
		CaixaDao dao = new CaixaDao();			
			
		try {
			if(dao.inserir(caixa)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/caixa");
		mv.addObject("incluir", status);

		return mv;
	}
	
	//AlTERAR CAIXA
	@RequestMapping("/administrativo-alterar-caixa")
	public ModelAndView alterar_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de alteração do caixa");

		boolean status = false;

		CaixaDao dao = new CaixaDao();			
			
		try
		{
			if(dao.alterar(caixa)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/caixa");
		mv.addObject("alterar", status);
				
		return mv;
	}
			
	//EXCLUIR CAIXA
	@RequestMapping("/administrativo-excluir-caixa")
	public ModelAndView excluir_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de exclusão do caixa");
				
		boolean status = false;	
				
		CaixaDao dao = new CaixaDao();			
				
		try {
			if(dao.excluir(caixa)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/caixa");
		mv.addObject("excluir", status);			
				
		return mv;
	}
			
	//PESQUISAR CAIXA
	@RequestMapping("/administrativo-pesquisar-caixa")
	public ModelAndView pesquisar_caixa (String pesquisa){
		System.out.println("Realizou a pesquisa do caixa");
				
		CaixaDao dao = new CaixaDao();		
		List<Caixa> caixas = null;
		try {
			caixas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
					    
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/caixa");
		mv.addObject("caixas", caixas);
			    
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
						
		return new ModelAndView("administrativo/encomendas");
	}
		
	//INCLUIR NOVA ENCOMENDA
	@RequestMapping("/administrativo-incluir-encomenda")
	public ModelAndView incluir_encomenda(Encomenda encomenda){
		System.out.println("Entrou na servlet de inclusão de uma nova materiaPrima");
			
		boolean status = false;
		    
		EncomendaDao dao = new EncomendaDao();			
			
		try {
			if(dao.inserir(encomenda)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/encomendas");
		mv.addObject("incluir", status);

		return mv;
	}
		
	//AlTERAR ENCOMENDA
	@RequestMapping("/administrativo-alterar-encomenda")
	public ModelAndView alterar_encomenda(Encomenda encomenda){
		System.out.println("Entrou na pagina de alteração de materiaPrima");

		boolean status = false;

		EncomendaDao dao = new EncomendaDao();			
			
		try
		{
			if(dao.alterar(encomenda)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/encomendas");
		mv.addObject("alterar", status);
			
		return mv;
	}
		
	//EXCLUIR ENCOMENDA
	@RequestMapping("/administrativo-excluir-encomenda")
	public ModelAndView excluir_encomenda(Encomenda encomenda){
		System.out.println("Entrou na pagina de exclusão de materiaprima");
			
		boolean status = false;	
			
		EncomendaDao dao = new EncomendaDao();
			
		try {
			if(dao.excluir(encomenda)) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/encomendas");
		mv.addObject("excluir", status);			
			
		return mv;
	}
		
	//PESQUISAR ENCOMENDA
	@RequestMapping("/administrativo-pesquisar-encomenda")
	public ModelAndView pesquisar_encomenda(String pesquisa){
		System.out.println("Realizou a pesquisa de matéria prima");
			
		EncomendaDao dao = new EncomendaDao();
		
		List<Encomenda> encomendas = null;
		try {
			encomendas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
				    
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/encomendas");
		mv.addObject("encomendas", encomendas);
		    
	    return mv;
	}
	
}