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
import frgp.utn.edu.ar.entidad.Usuario;

@Controller
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	@Qualifier("servicioMedicos")
	private MedicosNegocio medNeg;
	@Autowired
	Medicos medico;
	
	@Autowired
	@Qualifier("servicioUsuario")
	UsuarioNegocio uNeg;
	@Autowired
	private Usuario user;
	
	@Autowired
	@Qualifier("servicioEspecialidad")
	EspecialidadNegocio epn;
	
	@RequestMapping("alta_medico.html")
	public ModelAndView eventoAltaMedico(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
        
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(!medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    uNeg.AgregarUsuario(user);
                    
                    //Medicos medico = context.getBean(Medicos.class);
                    medico = new Medicos();
                    medico.setUsuario(user);
                    int espe = Integer.parseInt(request.getParameter("especialidad"));
                    Especialidad espes = epn.ReadOne(espe);
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
                    
                    if(medNeg.AgregarMedicos(medico)) {
                        request.setAttribute("mensajeExito", "Médico registrado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al registrar el médico");
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

		return MV;
	}
	
	@RequestMapping("modif_medico.html")
	public ModelAndView eventoModif_medico(HttpServletRequest request){
		ModelAndView MV = new ModelAndView();
        
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar_Modificar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    uNeg.Update(user);
                    //Medicos medico = context.getBean(Medicos.class);
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
                    //m.setFechaNac(request.getParameter("fechaNac"));
                    medico.setEmail(request.getParameter("email"));
                    medico.setDiasLab(request.getParameter("Dias"));
                    medico.setHorarioLab(request.getParameter("horarios"));
                    medico.setTelefono(request.getParameter("telefono"));
                    medico.setEstado("activo".equals(request.getParameter("estado")));
                    
                    if(medNeg.Update(medico)) {
                        request.setAttribute("mensajeExito", "Médico actualizad correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al actualizar el médico");
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "Legajo No encontrado");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
		return MV;
	}
	
	@RequestMapping("filtrar_medicos.html")
	public ModelAndView eventoFiltrar_medicos() {
		ModelAndView MV = new ModelAndView();

		//Codigo para filtrar en la lista de medicos
		
	return MV;
	}

}
