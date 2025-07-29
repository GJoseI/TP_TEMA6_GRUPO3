package frgp.utn.edu.ar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.NegocioImp.PacienteNegocio;
import frgp.utn.edu.ar.entidad.Paciente;

@Controller
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping("alta_paciente.html")
	public ModelAndView eventoAltaPaciente(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		PacienteNegocio pacNeg = new PacienteNegocio();
        
        MV.setViewName("admin_Paciente");
        if (request.getParameter("btnguardar") != null) {
            try {
                
                if(!pacNeg.Exist(request.getParameter("dni"))) {
                    
                    Paciente p = new Paciente();
                    
                    p.setDNI(request.getParameter("dni"));
                    p.setNombre(request.getParameter("nombre"));
                    p.setApellido(request.getParameter("apellido"));
                    p.setCorreo_electronico(request.getParameter("email"));
                    p.setDireccion(request.getParameter("direccion"));
                    p.setLocalidad(request.getParameter("localidad"));
                    p.setProvincia(request.getParameter("provincia"));
                    p.setTelefono(request.getParameter("telefono"));
                    p.setEstado("activo".equals(request.getParameter("estado")));
                    try {
                        String fechaNacStr = request.getParameter("fecha_nacimiento");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaNac = sdf.parse(fechaNacStr);
                        p.setFecha_nacimiento(fechaNac);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if(pacNeg.AgregarPaciente(p)) {
                        request.setAttribute("mensajeExito", "Paciente registrado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al registrar el paciente");
                    }
                } else {
                    request.setAttribute("mensajeError", "El DNI ya existe");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "DNI inválido");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }

		return MV;
	}
	
	@RequestMapping("modif_paciente.html")
	public ModelAndView eventoModifPaciente(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		PacienteNegocio pacNeg = new PacienteNegocio();
        
        MV.setViewName("admin_Paciente");
        if (request.getParameter("btnguardar_Modificar") != null) {
            try {
                
                if(pacNeg.Exist(request.getParameter("dni"))) {
                    
                    Paciente p = new Paciente();
                    
                    p.setDNI(request.getParameter("dni"));
                    p.setNombre(request.getParameter("nombre"));
                    p.setApellido(request.getParameter("apellido"));
                    p.setCorreo_electronico(request.getParameter("email"));
                    p.setDireccion(request.getParameter("direccion"));
                    p.setLocalidad(request.getParameter("localidad"));
                    p.setProvincia(request.getParameter("provincia"));
                    p.setTelefono(request.getParameter("telefono"));
                    p.setEstado("activo".equals(request.getParameter("estado")));
                    try {
                        String fechaNacStr = request.getParameter("fecha_nacimiento");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaNac = sdf.parse(fechaNacStr);
                        p.setFecha_nacimiento(fechaNac);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if(pacNeg.Update(p)) {
                        request.setAttribute("mensajeExito", "Paciente Actualizad correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al actualizar el paciente");
                    }
                } 
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "DNI inválido");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }

		return MV;
	}
	
}
