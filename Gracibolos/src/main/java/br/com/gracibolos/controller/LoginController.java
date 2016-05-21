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
	
	//M�todo para redirecionar para p�gina de login para dentro do WEB-INF
	@RequestMapping("/loginview")
	public ModelAndView loginView(){
		
		//Direciona para a pagina index dentro da WEB-INF
		return new ModelAndView("index");
	}
	
	//M�todo de autentica��o de usu�rio
	@RequestMapping("/login")
	public ModelAndView login(Colaborador colaborador, HttpSession session, HttpServletResponse response, HttpServletRequest request){
		
		//Declara��o de valores padr�es para as variaveis.
		page = "index"; //P�gina padr�o para redirecionamento
		status = false; //Usuario ou senha inv�lidos.
		servidor = false; //Servidor offline.
		
		try {
			//Passa os dados da view por parametro, e pesquisa no banco de dados, caso o colaborador exista, popula o colaborador com as informa��es.
			colaborador = Login.login(colaborador);
			
			//Altera o status do servidor para online.
			servidor = true;
			
			//Verifica se o colaborador possu� algum numero de ID, sen�o apenas redireciona para pagina padr�o
	        if(colaborador.getId() != null){
	        	
	        	//Cria uma nova sess�o armazendo os dados do colaborador.
	            session.setMaxInactiveInterval(30*60);
	            session.setAttribute("id", colaborador.getId());
	            session.setAttribute("nome", colaborador.getNome());
	            session.setAttribute("nivel", colaborador.getNivel());
	            
	            //Verifica se a op��o de lembrar senha est� ativa.
	            if(colaborador.isLembrarsenha()){
	            	//Armazena os dados do usu�rio em cookies
	            	System.out.println("Usu�rio optou por lembrar sua senha.");
	            	Cookie usuario = new Cookie("usuario", colaborador.getUsuario());
	            	Cookie senha = new Cookie("senha", colaborador.getSenha());
	            	Cookie lembrarsenha = new Cookie("lembrarsenha", String.valueOf(colaborador.isLembrarsenha()));
	                response.addCookie(usuario);
	                response.addCookie(senha);
	                response.addCookie(lembrarsenha);
	            }else{
	            	//Limpa os dados dos cookies
	            	System.out.println("Usu�rio optou por n�o lembrar senha.");
	            	Cookie[] cookies = request.getCookies();
	                for(int i = 0; i< cookies.length ; ++i){
                        //Verifica se existe algum cookie
	                	if(cookies != null){
	                		//Verifica se o cookie armazena algum usu�rio, senha, ou lembrarsenha
                        	if(cookies[i].getName().equals("usuario") || cookies[i].getName().equals("senha") || cookies[i].getName().equals("lembrarsenha")){
			                	//Deleta os cookies
                        		cookies[i].setMaxAge(0);
		                        response.addCookie(cookies[i]);
                        	}
                        }
	                } 
	            }
	            
	            //Verifica o n�vel de acesso do colaborador e direciona para a p�gina de acesso.
	            switch(colaborador.getNivel()){
	                case 1:
	                    System.out.println("N�vel de acesso operador");
	                    status = true; //Altera o status de login v�lido
	                    page = "redirect:operacional-clientes"; //Direciona para a pagina do operador/clientes
	                    break;
	                
	                case 2:
	                    System.out.println("N�vel de acesso administrador");
	                    status = true; //Altera o status de login v�lido
	                    page = "redirect:administrativo-encomendas";  //Direciona para a pagina do administrador/dashboard
	                    break;
	            }
	            
	        }

		} catch (Exception e) {
			page = "index";
			status = true;
		}
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName(page);
        
        if(page == "index"){
        	//Adicionar os objetos
        	mv.addObject("status",status);
            mv.addObject("servidor",servidor);
        }
        
        //Adicionar os objetos
        mv.addObject("colaborador",colaborador);
        
		return mv;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		
		//Destroi a sess�o do usu�rio
		System.out.println("Usu�rio fez logout");
		session.invalidate();
		return new ModelAndView("index");
	}
	
	
}