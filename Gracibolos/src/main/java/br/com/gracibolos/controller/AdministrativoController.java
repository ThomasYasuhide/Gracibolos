package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.ColaboradorDao;
import br.com.gracibolos.jdbc.model.Colaborador;

@Controller
public class AdministrativoController {
	
	//DASHBOARD
	@RequestMapping("/administrativo-dashboard")
	public ModelAndView dashboard(){
		System.out.println("Entrou na pagina dashboard");
		return new ModelAndView("administrativo/dashboard");
	}
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	//COLABORADOR
	@RequestMapping("/administrativo-colaboradores")
	public ModelAndView colaboradores(){
		System.out.println("Entrou na pagina de colaboradores");
		return new ModelAndView("administrativo/colaboradores");
	}
	
	//INCLUIR NOVO COLABORADOR
	@RequestMapping("/administrativo-incluir-colaborador")
	public ModelAndView incluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de inclusão de um novo colaborador");
		
		ColaboradorDao dao = new ColaboradorDao();
		dao.incluir_colaborador(colaborador);
		
		return new ModelAndView("administrativo/incluir_colaborador");
	}
	
	//AlTERAR COLABORADOR
	@RequestMapping("/administrativo-alterar-colaborador")
	public ModelAndView alterar_colaborador(){
		System.out.println("Entrou na pagina de alteração de colaborador");
		return new ModelAndView("administrativo/alterar_colaborador");
	}
	
	//EXCLUIR COLABORADOR
	@RequestMapping("/administrativo-remover-colaborador")
	public ModelAndView excluir_colaborador(){
		System.out.println("Entrou na pagina de exclusão de colaborador");
		return new ModelAndView("administrativo/colaboradores");
	}
	
	//PESQUISAR COLABORADOR
	@RequestMapping("/administrativo-procurar-colaborador")
	public ModelAndView pesquisar_colaborador(String pesquisa){
		System.out.println("Realizou a pesquisa de colaboradores");
		
		ColaboradorDao dao = new ColaboradorDao();
		List<Colaborador> colaboradores = dao.pesquisa_colaborador(pesquisa);
		
		return new ModelAndView("administrativo/colaboradores", "colaboradores", colaboradores);
	}
	
	
	
	
}