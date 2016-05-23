package br.com.gracibolos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;

@Controller
public class TesteController {
	
	@RequestMapping("/teste-jquery")
	public ModelAndView teste()	{
		
		EncomendaDao daoEnc = new EncomendaDao();
		ProdutoDao daoPro = new ProdutoDao();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teste/JQuery");
		try {
			//mv.addObject("encFinal",daoEnc.finalizadas());
			mv.addObject("produtos",daoPro.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/ajax")
	public ModelAndView testeajax()	{
		return new ModelAndView("teste/ajax");
	}

}
