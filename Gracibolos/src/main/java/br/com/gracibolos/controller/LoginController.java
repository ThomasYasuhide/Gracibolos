package br.com.gracibolos.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	private boolean servidor;
	
	//Método para redirecionar para página de login para dentro do WEB-INF
	@RequestMapping("/loginview")
	public ModelAndView loginView(HttpSession session){
		
		return new ModelAndView("index");
	}
	
	//Método de autenticação de usuário
	@RequestMapping("/login")
	public ModelAndView login(Colaborador colaborador, HttpSession session, HttpServletResponse response, HttpServletRequest request){
		
		page = "index";
		status = false;
		servidor = false;
		
		try {
			colaborador = Login.login(colaborador);
			
			servidor = true;
			
	        if(colaborador.getId() != null){
	        	
	            session.setMaxInactiveInterval(30*60);
	            session.setAttribute("id", colaborador.getId());
	            session.setAttribute("nome", colaborador.getNome());
	            session.setAttribute("nivel", colaborador.getNivel());
	            
	            if(colaborador.isLembrarsenha()){
	            	System.out.println("######################## CRIANDO COOKIES #########################");
	            	Cookie usuario = new Cookie("usuario", colaborador.getUsuario());
	            	Cookie senha = new Cookie("senha", colaborador.getSenha());
	                response.addCookie(usuario);
	                response.addCookie(senha);
	            }else{
	            	System.out.println("######################## EXCLUIR COOKIES #########################");
	            	Cookie[] cookies = request.getCookies();
	                for(int i = 0; i< cookies.length ; ++i){
                        cookies[i].setMaxAge(0);
                        response.addCookie(cookies[i]);
	                } 
	            }
	            
	            switch(colaborador.getNivel()){
	                case 1:
	                    System.out.println("Nível de privilégio 1");
	                    status = true;
	                    page = "redirect:operacional/clientes";
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

		} catch (Exception e) {
			page = "index";
			status = true;
		}
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName(page);
        
        if(page == "index"){
        	mv.addObject("status",status);
            mv.addObject("servidor",servidor);
        }
        mv.addObject("colaborador",colaborador);
        
		return mv;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		
		System.out.println("Usuário fez logout");
		session.invalidate();
		return new ModelAndView("index");
	}
	
	
}