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
	MedicosNegocio medNeg;
	@Autowired
	Medicos medico;
	
	
	
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
				
				if(user.isAdmin()) {
					MV.addObject("usuarioLogueado", user.getNombre_Usuario());
					MV.setViewName("admin");
				}
				else {
					MV.addObject("medicoLogueado", this.medNeg.getMedicoFromUser(user));
					MV.addObject("listTurnos",this.turNeg.getTurnosMedico(this.medNeg.getMedicoFromUser(user)));
					MV.setViewName("medico");
				}
				return MV;
			}
		}
		MV.setViewName("Pagina1");
	    MV.addObject("mensajeError", "Usuario o contraseña incorrectos.");
		return MV;
	}
	
	@RequestMapping("redireccionar_modificarMed_admin.html")
	public ModelAndView eventoRedireccionar_listaAdminMed(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("modificarMed_admin");
	    MV.addObject("especialidades", epN.ReadAll());
	    
	    String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
	    
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
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
		if (request.getParameter("btnModificar") != null && !request.getParameter("btnModificar").isEmpty()) {
            try {
                paciente = pacNeg.ReadOne(request.getParameter("btnModificar"));
                
                if (paciente != null) {
                    MV.addObject("paciente_p", paciente);
                } else {
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
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
		if (request.getParameter("btnModificar") != null && !request.getParameter("btnModificar").isEmpty()) {
            try {
                turno = turNeg.ReadOne(Integer.parseInt(request.getParameter("btnModificar")));
                
                if (turno != null) {
                    MV.addObject("turnoSeleccionado", turno);
                } else {
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
	public ModelAndView eventoRedireccionar_Admin(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin");
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
		return MV;
	}
	
	
	@RequestMapping("redireccionar_adminPaciente.html")
	public ModelAndView eventoRedireccionar_adminPaciente(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
		List<Paciente> ListaPaciente = pacNeg.ReadAll();
	    MV.addObject("ListaPaciente", ListaPaciente);
	    
		
			MV.setViewName("admin_Paciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_adminTurnos.html")
	public ModelAndView eventoRedireccionar_adminTurnos(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
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
	public ModelAndView eventoRedireccionar_adminMedico(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_medico");
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
	    MV.addObject("especialidades", this.epN.ReadAll());

	    MV.addObject("medicos", this.medNeg.ReadAll());
		return MV;
	}

	@RequestMapping("redireccionar_adminInforme.html")
	public ModelAndView eventoRedireccionar_adminInforme(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_informe");
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
		MV.addObject("ausencias",turNeg.informeAusencias(0));
		MV.addObject("totalTurnos", turNeg.informeTotalTurnos(0));
		MV.addObject("pacientesAtendidos", turNeg.informePacienteAtendidos(0));
		MV.addObject("porcentajeAsistencias", turNeg.informePorcentAsistencias(0));
		
		MV.addObject("especialidad1",turNeg.informeEspecialidad(1));
		MV.addObject("especialidad2",turNeg.informeEspecialidad(2));
		MV.addObject("especialidad3",turNeg.informeEspecialidad(3));
		MV.addObject("especialidad4",turNeg.informeEspecialidad(4));
		MV.addObject("especialidad5",turNeg.informeEspecialidad(5));
		MV.addObject("especialidad6",turNeg.informeEspecialidad(6));
		MV.addObject("especialidad7",turNeg.informeEspecialidad(7));
		MV.addObject("especialidad8",turNeg.informeEspecialidad(8));
		MV.addObject("especialidad9",turNeg.informeEspecialidad(9));
		MV.addObject("especialidad10",turNeg.informeEspecialidad(10));
		
		return MV;
	}
}
