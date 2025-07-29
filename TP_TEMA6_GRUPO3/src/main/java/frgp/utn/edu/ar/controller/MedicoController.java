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
import frgp.utn.edu.ar.NegocioImp.UsuarioNegocio;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Usuario;

@Controller
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("servicioMedicos")
	private MedicosNegocio medNeg;
	//No se que tan bien esta esto, investigar mas como se hace
	@Autowired
	private Medicos medico;
	
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
		//MedicosNegocio medNeg = new MedicosNegocio();
		//EspecialidadNegocio epn = new EspecialidadNegocio();
        //Usuario user = null;
        
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(!medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    UsuarioNegocio negUser = new UsuarioNegocio();
                    negUser.AgregarUsuario(user);
                    
                    //Medicos m = new Medicos();
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
		MedicosNegocio medNeg = new MedicosNegocio();
		EspecialidadNegocio epn = new EspecialidadNegocio();
        Usuario user = null;
        
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar_Modificar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    UsuarioNegocio negUser = new UsuarioNegocio();
                    negUser.Update(user);
                    
                    Medicos m = new Medicos();
                    m.setUsuario(user);
                    m.setEspecialidad(epn.ReadOne(Integer.parseInt(request.getParameter("especialidad"))));
                    
                    m.setLegajo(legajo);
                    m.setNombre(request.getParameter("nombre")); 
                    m.setApellido(request.getParameter("apellido"));
                    m.setDireccion(request.getParameter("direccion"));
                    m.setSexo(request.getParameter("Sexo"));
                    m.setLocalidad(request.getParameter("localidad"));
                    try {
                        String fechaNacStr = request.getParameter("fechaNac");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaNac = sdf.parse(fechaNacStr);
                        m.setFechaNac(fechaNac);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //m.setFechaNac(request.getParameter("fechaNac"));
                    m.setEmail(request.getParameter("email"));
                    m.setDiasLab(request.getParameter("Dias"));
                    m.setHorarioLab(request.getParameter("horarios"));
                    m.setTelefono(request.getParameter("telefono"));
                    m.setEstado("activo".equals(request.getParameter("estado")));
                    
                    if(medNeg.Update(m)) {
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
