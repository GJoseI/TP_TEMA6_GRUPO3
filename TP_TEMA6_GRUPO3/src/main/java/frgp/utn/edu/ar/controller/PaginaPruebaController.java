package frgp.utn.edu.ar.controller;

import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import NegocioImp.UsuarioNegocio;
import frgp.utn.edu.entidad.Usuario;

@Controller
public class PaginaPruebaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@RequestMapping("redireccionar_pag1.html")
	public ModelAndView eventoRedireccionar() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Pagina1");
		return MV;
	}
	
	
	@RequestMapping("redireccionar_usuario.html")
	public ModelAndView eventoRedireccionar_usuario(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena) {
		ModelAndView MV = new ModelAndView();
		UsuarioNegocio uNeg = new UsuarioNegocio();
		List<Usuario> usuarios = uNeg.ReadAll();
		for(Usuario user : usuarios) {
			if(usuario.equals(user.getNombre_Usuario()) && contrasena.equals(user.getContraseña())) {
				MV.addObject("usuarioLogueado", user);
				if(user.isAdmin()) {
					MV.setViewName("admin");
				}
				else {
					MV.setViewName("medico");
				}
				return MV;
			}
		}
		MV.setViewName("Pagina1");
	    MV.addObject("error", "Usuario o contraseña incorrectos.");
		return MV;
	}
	
	@RequestMapping("redireccionar_Admin.html")
	public ModelAndView eventoRedireccionar_Admin() {
		ModelAndView MV = new ModelAndView();
			MV.setViewName("admin");
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
