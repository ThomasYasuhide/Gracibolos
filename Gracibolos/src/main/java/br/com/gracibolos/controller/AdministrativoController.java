package br.com.gracibolos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.CidadeDao;
import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.ColaboradorDao;
import br.com.gracibolos.jdbc.dao.EstadoDao;
import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Cidade;
import br.com.gracibolos.jdbc.model.Cliente;
import br.com.gracibolos.jdbc.model.Colaborador;
import br.com.gracibolos.jdbc.model.Estado;
import br.com.gracibolos.jdbc.model.Fornecedor;

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
	@RequestMapping("/administrativo-produtos")
	public ModelAndView produtos(){
		System.out.println("Entrou na pagina de listamgem de produtos");
		return new ModelAndView("administrativo/produtos");
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
	
	//AlTERAR CLIENTE
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/fornecedores");
		mv.addObject("alterar", status);
	    mv.addObject("estados", estados);
		
		return mv;
	}
	
	//EXCLUIR CLIENTE
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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

	/*
	 * 
	 * ###################### CIDADES ######################
	 * 
	 * */
	
	@RequestMapping(value="/administrativo-pesquisar-cidade", method=RequestMethod.POST)
	public @ResponseBody List<Cidade> pesquisar_cidade(int id){
				
		List<Cidade> cidades = new ArrayList<Cidade>();
		
		CidadeDao dao = new CidadeDao();
		cidades = dao.pesquisar_cidades(id);
		
	    return cidades;
		
	}
	
}