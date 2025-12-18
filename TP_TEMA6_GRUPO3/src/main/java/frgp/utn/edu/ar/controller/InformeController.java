package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.NegocioImp.TurnoNegocio;

@Controller
public class InformeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("servicioTurno")
	TurnoNegocio turNeg;	
	
	
	@RequestMapping("filtroMes_Informe.html")
	public ModelAndView eventoFiltrarMes(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("admin_informe");
		
		String usuarioLogueado = request.getParameter("usuarioLogueado");
		MV.addObject("usuarioLogueado", usuarioLogueado);
		
		MV.addObject("ausencias",turNeg.informeAusencias(Integer.parseInt(request.getParameter("mes"))));
		MV.addObject("totalTurnos", turNeg.informeTotalTurnos(Integer.parseInt(request.getParameter("mes"))));
		MV.addObject("pacientesAtendidos", turNeg.informePacienteAtendidos(Integer.parseInt(request.getParameter("mes"))));
		MV.addObject("porcentajeAsistencias", turNeg.informePorcentAsistencias(Integer.parseInt(request.getParameter("mes"))));
		
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
