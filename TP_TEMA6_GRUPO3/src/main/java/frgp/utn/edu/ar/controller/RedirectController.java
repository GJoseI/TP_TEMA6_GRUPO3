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
import frgp.utn.edu.ar.NegocioImp.TurnoNegocio;
import frgp.utn.edu.ar.NegocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
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
	PacienteNegocio pacNeg;
	@Autowired
	Paciente paciente;
	
	@Autowired
	@Qualifier("servicioTurno")
	TurnoNegocio turNeg;	
	@Autowired
	Turno turno;
	
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
	    MV.addObject("especialidades", epN.ReadAll());
	    
		String legajoStr = request.getParameter("btnModificar");
		if (legajoStr != null && !legajoStr.isEmpty()) {
            try {
            	int legajo = Integer.parseInt(legajoStr);
            	medico = this.medNeg.ReadOne(legajo);
                if (medico != null) {
                    MV.addObject("medicoSeleccionado", medico);
                } else {
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
                paciente = pacNeg.ReadOne(request.getParameter("btnModificar"));
                
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
	
	@RequestMapping("redireccionar_modificarTur_admin.html")
	public ModelAndView eventoRedireccionar_ModifTur(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("modificarTur_admin");
		MV.addObject("especialidades", epN.ReadAll());
		
		if (request.getParameter("btnModificar") != null && !request.getParameter("btnModificar").isEmpty()) {
            try {
                turno = turNeg.ReadOne(Integer.parseInt(request.getParameter("btnModificar")));
                
                if (turno != null) {
                    MV.addObject("turnoSeleccionado", turno);
                } else {
                    // Manejar médico no encontrado
                    request.setAttribute("mensajeError", "Error al buscar el turno");
                }
            } catch (NumberFormatException e) {
            	request.setAttribute("mensajeError", "Inválido");
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
		
		List<Paciente> ListaPaciente = pacNeg.ReadAll();
	    MV.addObject("ListaPaciente", ListaPaciente);
		
			MV.setViewName("admin_Paciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_adminTurnos.html")
	public ModelAndView eventoRedireccionar_adminTurnos() {
		ModelAndView MV = new ModelAndView();
		
		List<Paciente> paciente = pacNeg.ReadAll();
	    MV.addObject("paciente", paciente);
    
	    List<Medicos> medicos = medNeg.ReadAll();
	    MV.addObject("medicos", medicos);
	    
	    List<Turno> turnos = turNeg.ReadAll();
	    MV.addObject("ListaTurnos", turnos);
		
			MV.setViewName("admin_turnos");

		return MV;
	}
	
	@RequestMapping("redireccionar_adminMedico.html")
	public ModelAndView eventoRedireccionar_adminMedico() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_medico");
		
	    MV.addObject("especialidades", this.epN.ReadAll());

	    MV.addObject("medicos", this.medNeg.ReadAll());
		return MV;
	}

	@RequestMapping("redireccionar_adminInforme.html")
	public ModelAndView eventoRedireccionar_adminInforme() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_informe");
		
		MV.addObject("ausencias",turNeg.informeAusencias(0));
		MV.addObject("totalTurnos", turNeg.informeTotalTurnos(0));
		MV.addObject("pacientesAtendidos", turNeg.informePacienteAtendidos(0));
		MV.addObject("porcentajeAsistencias", turNeg.informePorcentAsistencias(0));
		
		return MV;
	}
}
