package br.com.gracibolos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.CidadeDao;
import br.com.gracibolos.jdbc.dao.ColaboradorDao;
import br.com.gracibolos.jdbc.dao.EstadoDao;
import br.com.gracibolos.jdbc.model.Cidade;
import br.com.gracibolos.jdbc.model.Colaborador;
import br.com.gracibolos.jdbc.model.Estado;

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
	 * ###################### CLIENTES ######################
	 * 
	 * */
	
	//CLIENTES
	@RequestMapping("/administrativo-clientes")
	public ModelAndView clientes(){
		System.out.println("Entrou na pagina clientes");
		return new ModelAndView("administrativo/clientes");
	}
	
	//INCLUIR NOVO CLIENTE
	@RequestMapping("/administrativo-incluir-cliente")
	public ModelAndView incluir_cliente(){
		System.out.println("Entrou na pagina de inclusão de clientes");
		
		//######
		
		return new ModelAndView("administrativo/incluir_cliente");
	}
	
	//AlTERAR CLIENTE
	@RequestMapping("/administrativo-alterar-cliente")
	public ModelAndView alterar_cliente(){
		System.out.println("Entrou na pagina de alteração de clientes");
		return new ModelAndView("administrativo/alterar_cliente");
	}
	
	//EXCLUIR CLIENTE
	@RequestMapping("/administrativo-remover-cliente")
	public ModelAndView excluir_cliente(){
		System.out.println("Entrou na pagina de exclusão de clientes");
		return new ModelAndView("administrativo/excluir_cliente");
	}
	
	//PESQUISAR CLIENTE
	@RequestMapping("/administrativo-procurar-cliente")
	public ModelAndView pesquisar_cliente(String pesquisa){
		System.out.println("Realizou a pesquisa de clientes");
		
		return new ModelAndView("administrativo/clientes");
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