package frgp.utn.edu.ar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.NegocioImp.MedicosNegocio;
import frgp.utn.edu.ar.NegocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;

@Controller
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("servicioMedicos")
	private MedicosNegocio medNeg;
	@Autowired
	Medicos medico;
	
	
	@Autowired
	@Qualifier("servicioUsuario")
	UsuarioNegocio uNeg;
	@Autowired
	Usuario user;
	
	@Autowired
	@Qualifier("servicioEspecialidad")
	EspecialidadNegocio epn;
	
	@RequestMapping("alta_medico.html")
	public ModelAndView eventoAltaMedico(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
        
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(!medNeg.Exist(legajo)) {
                	int espe = Integer.parseInt(request.getParameter("especialidad"));
                	Especialidad espes = epn.ReadOne(espe);
                	user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                	
                	medico = new Medicos();
                	medico.setUsuario(user);
                	medico.setEspecialidad(espes);            
                	medico.setLegajo(legajo);
                	medico.setNombre(request.getParameter("nombre")); 
                	medico.setApellido(request.getParameter("apellido"));
                	medico.setDireccion(request.getParameter("direccion"));
                	medico.setSexo(request.getParameter("Sexo"));
                	medico.setLocalidad(request.getParameter("localidad"));
                	try {
                		String fechaNacStr = request.getParameter("fechaNac");
                		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                		Date fechaNac = sdf.parse(fechaNacStr);
                		medico.setFechaNac(fechaNac);
                	} catch (ParseException e) {
                		e.printStackTrace();
                	}
                	medico.setEmail(request.getParameter("email"));
                	medico.setDiasLab(request.getParameter("Dias"));
                	medico.setHorarioLab(request.getParameter("horarios"));
                	medico.setTelefono(request.getParameter("telefono"));
                	medico.setEstado("activo".equals(request.getParameter("estado")));
                	
                    if(uNeg.Exist(user.getNombre_Usuario())) {
                    	request.setAttribute("mensajeError", "Usuario existente");
                    	MV.addObject("medicoInput", medico);
                    	MV.addObject("especialidades", this.epn.ReadAll());
                   	    MV.addObject("medicos", this.medNeg.ReadAll());
                    	return MV;
                    }
                    uNeg.AgregarUsuario(user);
                    
                    
                    if(medNeg.AgregarMedicos(medico)) {
                        request.setAttribute("mensajeExito", "Médico registrado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al registrar el médico");
                        MV.addObject("medicoInput", medico);
                    }
                } else {
                    request.setAttribute("mensajeError", "El legajo ya existe");        
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "Legajo inválido");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
	    MV.addObject("especialidades", this.epn.ReadAll());

	    MV.addObject("medicos", this.medNeg.ReadAll());
		return MV;
	}
	
	@RequestMapping("modif_medico.html")
	public ModelAndView eventoModif_medico(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
        
		int legajo = Integer.parseInt(request.getParameter("legajo"));
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar_Modificar") != null) {
            try {        
                if(medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    uNeg.Update(user);
                    medico.setUsuario(user);
                    medico.setEspecialidad(epn.ReadOne(Integer.parseInt(request.getParameter("especialidad"))));
                    
                    medico.setLegajo(legajo);
                    medico.setNombre(request.getParameter("nombre")); 
                    medico.setApellido(request.getParameter("apellido"));
                    medico.setDireccion(request.getParameter("direccion"));
                    medico.setSexo(request.getParameter("Sexo"));
                    medico.setLocalidad(request.getParameter("localidad"));
                    try {
                        String fechaNacStr = request.getParameter("fechaNac");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaNac = sdf.parse(fechaNacStr);
                        medico.setFechaNac(fechaNac);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    medico.setEmail(request.getParameter("email"));
                    medico.setDiasLab(request.getParameter("Dias"));
                    medico.setHorarioLab(request.getParameter("horarios"));
                    medico.setTelefono(request.getParameter("telefono"));
                    medico.setEstado(true);
                    
                    if(medNeg.Update(medico)) {
                        request.setAttribute("mensajeExito", "Medico actualizado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al actualizar el medico");
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "Legajo No encontrado");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        } else if (request.getParameter("btneliminar") != null) {
        	try {
                if(medNeg.Exist(legajo)) {     
                	medico = new Medicos ();
                	medico = medNeg.ReadOne(legajo);
                	medico.setEstado(false);
                	
                	user = new Usuario();
                	user = uNeg.ReadOne(medico.getUsuario().getNombre_Usuario());
                	user.setEstado(false);
                    if(medNeg.Update(medico) && uNeg.Update(user)) {
                        request.setAttribute("mensajeExito", "Medico y usuario asociado eliminado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al eliminar el medico");
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "Legajo No encontrado");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
	    MV.addObject("especialidades", this.epn.ReadAll());

	    MV.addObject("medicos", this.medNeg.ReadAll());
		return MV;
	}
}
