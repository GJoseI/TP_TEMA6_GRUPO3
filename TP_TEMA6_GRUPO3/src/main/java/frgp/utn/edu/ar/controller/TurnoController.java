package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import frgp.utn.edu.ar.NegocioImp.PacienteNegocio;
import frgp.utn.edu.ar.NegocioImp.TurnoNegocio;
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
	@Qualifier("servicioPaciente")
	PacienteNegocio pacNeg;
	@Autowired
	Paciente p;

}
