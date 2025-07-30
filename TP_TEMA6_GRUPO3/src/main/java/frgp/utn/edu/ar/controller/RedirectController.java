package frgp.utn.edu.ar.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.NegocioImp.MedicosNegocio;
import frgp.utn.edu.ar.NegocioImp.PacienteNegocio;
import frgp.utn.edu.ar.NegocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;

@Controller
public class RedirectController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("servicioUsuario")
	UsuarioNegocio uNeg;
	@Autowired
	private Usuario user;
	
	@Autowired
	@Qualifier("servicioEspecialidad")
	EspecialidadNegocio epN;
	
	@Autowired
	@Qualifier("servicioPaciente")
	PacienteNegocio negPaciente;
	
	@Autowired
	@Qualifier("servicioMedicos")
	private MedicosNegocio medNeg;
	@Autowired
	private Medicos medico;
	
	
	
	@RequestMapping("redireccionar_pag1.html")
	public ModelAndView eventoRedireccionar() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Pagina1");
		return MV;
	}
	
	@RequestMapping("redireccionar_usuario.html")
	public ModelAndView eventoRedireccionar_usuario(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena) {
		ModelAndView MV = new ModelAndView();
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
	
	@RequestMapping("redireccionar_modificarMed_admin.html")
	public ModelAndView eventoRedireccionar_listaAdminMed(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("modificarMed_admin");
		
		String legajoStr = request.getParameter("btnModificar");
		if (legajoStr != null && !legajoStr.isEmpty()) {
            try {
            	int legajo = Integer.parseInt(legajoStr);
                MedicosNegocio medNeg = new MedicosNegocio();
                Medicos medico = medNeg.ReadOne(legajo);
                
                if (medico != null) {
                    MV.addObject("medicoSeleccionado", medico);
                } else {
                    // Manejar médico no encontrado
                    request.setAttribute("mensajeError", "Error al buscar el médico");
                }
            } catch (NumberFormatException e) {
            	request.setAttribute("mensajeError", "Legajo inválido");
            } catch (Exception e) {
            	request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
		return MV;
	}
	
	@RequestMapping("redireccionar_modificarPac_admin.html")
	public ModelAndView eventoRedireccionar_ModifPac(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("modificarPac_admin");
		
		if (request.getParameter("btnModificar") != null && !request.getParameter("btnModificar").isEmpty()) {
            try {
                PacienteNegocio pacNeg = new PacienteNegocio();
                Paciente paciente = pacNeg.ReadOne(request.getParameter("btnModificar"));
                
                if (paciente != null) {
                    MV.addObject("pacienteSeleccionado", paciente);
                } else {
                    // Manejar médico no encontrado
                    request.setAttribute("mensajeError", "Error al buscar el paciente");
                }
            } catch (NumberFormatException e) {
            	request.setAttribute("mensajeError", "DNI inválido");
            } catch (Exception e) {
            	request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
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
		
		List<Paciente> ListaPasiente = negPaciente.ReadAll();;
	    MV.addObject("ListaPasiente", ListaPasiente);
		
			MV.setViewName("admin_Paciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_adminTurnos.html")
	public ModelAndView eventoRedireccionar_adminTurnos() {
		ModelAndView MV = new ModelAndView();

		List<Especialidad> especialidades = epN.ReadAll();
	    MV.addObject("especialidades", especialidades);
		
			MV.setViewName("admin_turnos");

		return MV;
	}
	
	@RequestMapping("redireccionar_adminMedico.html")
	public ModelAndView eventoRedireccionar_adminMedico() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_medico");
		
	    List<Especialidad> especialidades = epN.ReadAll();
	    MV.addObject("especialidades", especialidades);

	    List<Medicos> medicos = medNeg.ReadAll();
	    MV.addObject("medicos", medicos);
		return MV;
	}

	@RequestMapping("redireccionar_adminInforme.html")
	public ModelAndView eventoRedireccionar_adminInforme() {
		ModelAndView MV = new ModelAndView();

		MV.setViewName("admin_informe");
		return MV;
	}
}
