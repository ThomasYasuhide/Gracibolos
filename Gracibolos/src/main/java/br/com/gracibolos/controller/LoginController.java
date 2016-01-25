package br.com.gracibolos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.model.Colaborador;
import br.com.gracibolos.login.Login;

@Controller
public class LoginController {
	
	private String page;
	private boolean status;
	
	//Método para redirecionar para página de login para dentro do WEB-INF
	@RequestMapping("/loginview")
	public ModelAndView loginView(){
		return new ModelAndView("index");
	}
	
	//Método de autenticação de usuário
	@RequestMapping("/login")
	public ModelAndView login(Colaborador colaborador, HttpSession session){
		
		page = "index";
		status = false;
		
		colaborador = Login.login(colaborador);
        
        if(colaborador.getId() != 0){
            
            session.setMaxInactiveInterval(30*60);
            session.setAttribute("id", colaborador.getId());
            session.setAttribute("nome", colaborador.getNome());
            session.setAttribute("nivel", colaborador.getNivel());
            
            switch(colaborador.getNivel()){
                case 1:
                    System.out.println("Nível de privilégio 1");
                    status = true;
                    page = "operacional/clientes";
                    break;
                
                case 2:
                    System.out.println("Nível de privilégio 2");
                    status = true;
                    page = "redirect:administrativo-dashboard";
                    break;
            }
        }else{
            page = "index";
        }
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName(page);
        
        if(page == "index"){
        	mv.addObject("status",status);
        }
        
        mv.addObject("colaborador",colaborador);
        
		return mv;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		
		//System.out.println("Usuário fez logout");
		session.invalidate();
		return new ModelAndView("index");
	}
	
	
}