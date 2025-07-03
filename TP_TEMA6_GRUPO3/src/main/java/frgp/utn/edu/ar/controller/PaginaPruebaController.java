package frgp.utn.edu.ar.controller;

import java.io.Console;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaPruebaController {

	@RequestMapping("redireccionar_pag1.html")
	public ModelAndView eventoRedireccionar() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Pagina1");
		return MV;
	}
	
	
	@RequestMapping("redireccionar_usuario.html")
	public ModelAndView eventoRedireccionar_usuario() {
		ModelAndView MV = new ModelAndView();

			//MV.setViewName("admin");

			MV.setViewName("medico");

		return MV;
	}
	
	
	@RequestMapping("redireccionar_adminPaciente.html")
	public ModelAndView eventoRedireccionar_adminPaciente() {
		ModelAndView MV = new ModelAndView();
			MV.setViewName("admin_Paciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_adminTurnos.html")
	public ModelAndView eventoRedireccionar_adminTurnos() {
		ModelAndView MV = new ModelAndView();

			MV.setViewName("admin_turnos");

		return MV;
	}
	
@RequestMapping("redireccionar_adminMedico.html")
public ModelAndView eventoRedireccionar_adminMedico() {
	ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_medico");
	return MV;
}

@RequestMapping("redireccionar_adminInforme.html")
public ModelAndView eventoRedireccionar_adminInforme() {
	ModelAndView MV = new ModelAndView();

		MV.setViewName("admin_informe");
	return MV;
}

}
