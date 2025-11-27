package frgp.utn.edu.ar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.NegocioImp.MedicosNegocio;
import frgp.utn.edu.ar.NegocioImp.PacienteNegocio;
import frgp.utn.edu.ar.NegocioImp.TurnoNegocio;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;

@Controller
public class TurnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("servicioTurno")
	TurnoNegocio turNeg;	
	@Autowired
	Turno turno;
	
	@Autowired
	@Qualifier("servicioMedicos")
	private MedicosNegocio medNeg;
	@Autowired
	Medicos m;
	
	@Autowired
	@Qualifier("servicioEspecialidad")
	EspecialidadNegocio epn;
	@Autowired
	Especialidad especialidad;
	
	@Autowired
	@Qualifier("servicioPaciente")
	PacienteNegocio pacNeg;
	@Autowired
	Paciente p;
	
	@RequestMapping("alta_turno.html")
	public ModelAndView eventoAltaTurno (HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_Turno");
		
		if(request.getParameter("btnguardar") != null) {
			try {
				//Despues veo de hacer un if de validaciones de turnos
				String dniPaciente = request.getParameter("dni");
				p = this.pacNeg.ReadOne(dniPaciente);
				int legajoMed = Integer.parseInt(request.getParameter("Legajo"));
				m = this.medNeg.ReadOne(legajoMed);
				int idEspecialidad = Integer.parseInt(request.getParameter("especialidad"));
				especialidad = this.epn.ReadOne(idEspecialidad);
				
				turno = new Turno();
				turno.setHora(request.getParameter("hora"));
				turno.setMedico(m);
				turno.setPaciente(p);
				turno.setEspecialidad(especialidad);
				turno.setEstadoTurno("Pendiente");
				turno.setEstado("activo".equals(request.getParameter("estado")));
				try {
	                String fechaStr = request.getParameter("fecha");
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                Date fecha = sdf.parse(fechaStr);
	                turno.setFecha(fecha);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
				
				if(turNeg.AgregarTurno(turno)) {
					request.setAttribute("mensajeExito", "Turno asignado correctamente");
                } else {
                    request.setAttribute("mensajeError", "Error al asignar el turno");
                }
			
			} catch(Exception e){
				request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
			}
		}
		
		return MV;
	}
	
	@RequestMapping("modif_turno.html")
	public ModelAndView eventoModificarTurno (HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_Turno");
		
		if(request.getParameter("btnmodificar") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("idTurno"));
				if(turNeg.Exist(id)) {
					String dniPaciente = request.getParameter("dni");
					p = this.pacNeg.ReadOne(dniPaciente);
					int legajoMed = Integer.parseInt(request.getParameter("Legajo"));
					m = this.medNeg.ReadOne(legajoMed);
					int idEspecialidad = Integer.parseInt(request.getParameter("especialidad"));
					especialidad = this.epn.ReadOne(idEspecialidad);
					
					turno = new Turno();
					turno.setHora(request.getParameter("hora"));
					turno.setMedico(m);
					turno.setPaciente(p);
					turno.setEspecialidad(especialidad);
					try {
		                String fechaStr = request.getParameter("fecha");
		                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		                Date fecha = sdf.parse(fechaStr);
		                turno.setFecha(fecha);
		            } catch (ParseException e) {
		                e.printStackTrace();
		            }
					
					if(turNeg.AgregarTurno(turno)) {
						request.setAttribute("mensajeExito", "Turno actualizado correctamente");
	                } else {
	                    request.setAttribute("mensajeError", "Error al actualizar el turno");
	                }
				}
				
			} catch(Exception e){
				request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
			}
			
		}
		
		return MV;
	}

}
