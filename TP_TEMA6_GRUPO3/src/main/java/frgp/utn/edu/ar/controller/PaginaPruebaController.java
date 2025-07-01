package frgp.utn.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaPruebaController {

	@RequestMapping("redireccionar_pag2.html")
	public ModelAndView eventoRedireccionar() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Pagina2");
		return MV;
	}
}
