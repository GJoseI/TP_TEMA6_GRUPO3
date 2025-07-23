package frgp.utn.edu.ar.controller;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import NegocioImp.EspecialidadNegocio;
import NegocioImp.MedicosNegocio;
import NegocioImp.UsuarioNegocio;
import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;
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
	
	@RequestMapping("alta_medico.html")
	public ModelAndView eventoAltaMedico(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MedicosNegocio medNeg = new MedicosNegocio();
		EspecialidadNegocio epn = new EspecialidadNegocio();
        Usuario user = null;
        
        MV.setViewName("admin_medico");
        if (request.getParameter("btnguardar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(!medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    UsuarioNegocio negUser = new UsuarioNegocio();
                    negUser.AgregarUsuario(user);
                    
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
                    
                    if(medNeg.AgregarMedicos(m)) {
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
