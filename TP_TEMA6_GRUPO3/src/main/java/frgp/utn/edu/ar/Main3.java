package frgp.utn.edu.ar;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import NegocioImp.EspecialidadNegocio;
import NegocioImp.MedicosNegocio;
import NegocioImp.PacienteNegocio;
import NegocioImp.TurnoNegocio;
import NegocioImp.UsuarioNegocio;
import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;
import frgp.utn.edu.entidad.Paciente;
import frgp.utn.edu.entidad.Turno;
import frgp.utn.edu.entidad.Usuario;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext appContext;
		MedicosNegocio medNeg = new MedicosNegocio();
		EspecialidadNegocio espNeg = new EspecialidadNegocio();
		TurnoNegocio turNeg = new TurnoNegocio();
		UsuarioNegocio usNeg = new UsuarioNegocio();
		PacienteNegocio pacNeg = new PacienteNegocio();
		
		///Conseguir Beans
		appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/BeansEspecialidad.xml",
				"frgp/utn/edu/ar/resources/BeansMedico.xml", "frgp/utn/edu/ar/resources/BeansTurno.xml", "frgp/utn/edu/ar/resources/BeansUsuario.xml", 
				"frgp/utn/edu/ar/resources/BeansPaciente.xml");
		
		//Especialidad especialidad1 = (Especialidad)appContext.getBean("especialidad1");
		//Especialidad especialidad2 = (Especialidad)appContext.getBean("especialidad2");
		//Especialidad especialidad3 = (Especialidad)appContext.getBean("especialidad3");
		//System.out.println("Esp1 "+especialidad1.toString() + "Esp2 "+especialidad2 + "Esp3 "+especialidad3);
		
		//Usuario usuario1 = (Usuario)appContext.getBean("usuario1");
		//Usuario usuario2 = (Usuario)appContext.getBean("usuario2");
		//Usuario usuario3 = (Usuario)appContext.getBean("usuario3");
		//Usuario usuario4 = (Usuario)appContext.getBean("usuario4");
		//Usuario usuario5 = (Usuario)appContext.getBean("usuario5");
		//Usuario usuario6 = (Usuario)appContext.getBean("usuario6");
		//Usuario usuario7 = (Usuario)appContext.getBean("usuario7");
		//Usuario usuario8 = (Usuario)appContext.getBean("usuario8");
		//Usuario usuario9 = (Usuario)appContext.getBean("usuario9");
		//Usuario usuario10 = (Usuario)appContext.getBean("usuario10");
		//Usuario usuario11 = (Usuario)appContext.getBean("usuario11");
		//Usuario usuario12 = (Usuario)appContext.getBean("usuario12");
		//Usuario usuario13 = (Usuario)appContext.getBean("usuario13");
		//Usuario usuario14 = (Usuario)appContext.getBean("usuario14");
		//Usuario usuario15 = (Usuario)appContext.getBean("usuario15");
		
		//Medicos medico1 = (Medicos)appContext.getBean("medico1");
		//Medicos medico2 = (Medicos)appContext.getBean("medico2");
		//Medicos medico3 = (Medicos)appContext.getBean("medico3");
		//Medicos medico4 = (Medicos)appContext.getBean("medico4");
		//Medicos medico5 = (Medicos)appContext.getBean("medico5");
		//Medicos medico6 = (Medicos)appContext.getBean("medico6");
		//Medicos medico7 = (Medicos)appContext.getBean("medico7");
		//Medicos medico8 = (Medicos)appContext.getBean("medico8");
		//Medicos medico9 = (Medicos)appContext.getBean("medico9");
		//Medicos medico10 = (Medicos)appContext.getBean("medico10");
		//Medicos medico11 = (Medicos)appContext.getBean("medico11");
		//Medicos medico12 = (Medicos)appContext.getBean("medico12");
		//Medicos medico13 = (Medicos)appContext.getBean("medico13");
		//Medicos medico14 = (Medicos)appContext.getBean("medico14");
		//Medicos medico15 = (Medicos)appContext.getBean("medico15");
		//System.out.println("Med1 "+medico1.toString() + "Med2 "+medico2.toString());

		Paciente paciente1 = (Paciente)appContext.getBean("paciente1");
		Paciente paciente2 = (Paciente)appContext.getBean("paciente2");
		//System.out.println("Pac1 "+paciente1.toString() + "Pac2 "+paciente2.toString());
		
		//Turno turno1 = (Turno)appContext.getBean("turno1");
		//Turno turno2 = (Turno)appContext.getBean("turno2");
		//System.out.println("Tur1 "+turno1.toString() + "Tur2 "+turno1.toString());
		
		
		((ConfigurableApplicationContext)appContext).close();
		
		///Agregar todo
		pacNeg.AgregarPaciente(paciente1);
		pacNeg.AgregarPaciente(paciente2);
		
		//espNeg.AgregarEspecialidad(especialidad1);
		//espNeg.AgregarEspecialidad(especialidad2);
		//espNeg.AgregarEspecialidad(especialidad3);

		//usNeg.AgregarUsuario(usuario1);
		//usNeg.AgregarUsuario(usuario2);
		//usNeg.AgregarUsuario(usuario3);
		//usNeg.AgregarUsuario(usuario4);
		//usNeg.AgregarUsuario(usuario5);
		//usNeg.AgregarUsuario(usuario6);
		//usNeg.AgregarUsuario(usuario7);
		//usNeg.AgregarUsuario(usuario8);
		//usNeg.AgregarUsuario(usuario9);
		//usNeg.AgregarUsuario(usuario10);
		//usNeg.AgregarUsuario(usuario11);
		//usNeg.AgregarUsuario(usuario12);
		//usNeg.AgregarUsuario(usuario13);
		//usNeg.AgregarUsuario(usuario14);
		//usNeg.AgregarUsuario(usuario15);
		
		//medNeg.AgregarMedicos(medico1);
		//medNeg.AgregarMedicos(medico2);
		//	medNeg.AgregarMedicos(medico3);
		//	medNeg.AgregarMedicos(medico4);
		//	medNeg.AgregarMedicos(medico5);
		//	medNeg.AgregarMedicos(medico6);
		//	medNeg.AgregarMedicos(medico7);
		//	medNeg.AgregarMedicos(medico8);
		//	medNeg.AgregarMedicos(medico9);
		//	medNeg.AgregarMedicos(medico10);
		//	medNeg.AgregarMedicos(medico11);
		//	medNeg.AgregarMedicos(medico12);
		//medNeg.AgregarMedicos(medico13);
		//medNeg.AgregarMedicos(medico14);
		//medNeg.AgregarMedicos(medico15);
	
		//turNeg.AgregarTurno(turno1);
		//turNeg.AgregarTurno(turno2);
		
		///Mostrar
		/*List<Especialidad> listaEspecialidad= espNeg.ReadAll();
		System.out.println("Todas las Especialidades:");
    	for (Especialidad especialidad : listaEspecialidad) {
    		System.out.println(especialidad.toString());
    	}
    	
		List<Paciente> listaPacientes = pacNeg.ReadAll();
		System.out.println("Todos los Pacientes:");
    	for (Paciente paciente : listaPacientes) {
    		System.out.println(paciente.toString());
    	}
    	
		List<Usuario> listaUsuario = usNeg.ReadAll();
		System.out.println("Todos los usuarios:");
    	for (Usuario usuario : listaUsuario) {
    		System.out.println(usuario.toString());
    	}
    	
		List<Medicos> listaMedicos = medNeg.ReadAll();
		System.out.println("Todos los medicos:");
    	for (Medicos medico : listaMedicos) {
    		System.out.println(medico.toString());
    	}
    	
		List<Turno> listaTurno = turNeg.ReadAll();
		System.out.println("Todos los turnoss:");
    	for (Turno turno : listaTurno) {
    		System.out.println(turno.toString());
    	}*/
    	
		///Modificar
    	/*medico1.setDiasLab("Dom-Jue");
    	medNeg.Update(medico1);
    	
    	paciente1.setProvincia("Santa Fe");
    	pacNeg.Update(paciente1);
    	
    	turno1.setHora("11hs");
    	turno1.setId(1);
    	turNeg.Update(turno1);*/
		
		///Borrar
		//paciente2.setEstado(false);
		//pacNeg.Update(paciente2);
		
		//medico2.setEstado(false);
		//medNeg.Update(medico2);
		
		//turno2.setEstado(false);
		//turno2.setId(2);
		//turNeg.Update(turno2);
		
		//usuario2.setEstado(false);
		//usNeg.Update(usuario2);
	}

}
