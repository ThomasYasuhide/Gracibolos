package br.com.gracibolos.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptador extends HandlerInterceptorAdapter {
	
	private int nivel;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		
//		nivel = 0;
//		
//		String uri = request.getRequestURI();
//		HttpSession session = request.getSession(false);
//		
//		if(uri.contains("/administrativo-") || uri.contains("/operacional-")){
//			
//            if(session != null){
//            	
//            	if(session.getAttribute("nivel") != null){
//            		nivel = (Integer) session.getAttribute("nivel");
//                    
//                    if((nivel == 1 && uri.contains("/operacional-")) || (nivel == 2 && uri.contains("/administrativo-"))){
//                        return true;
//                    }else{
//                		response.sendRedirect("loginview");
//                    	return false;
//                    }
//            	}else {
//            		response.sendRedirect("loginview");
//            		return false;
//            	}
//            	
//            }else{
//            	return true;
//            }
//            
//        } else {
//        	return true;
//        }
		return true;	
	}
}