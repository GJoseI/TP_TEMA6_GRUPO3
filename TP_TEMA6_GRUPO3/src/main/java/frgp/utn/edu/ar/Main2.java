package frgp.utn.edu.ar;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import daoImp.Confighiberneate;
import daoImp.daohibernate;
import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;
import frgp.utn.edu.entidad.Usuario;
import frgp.utn.edu.entidad.Turno;
import frgp.utn.edu.entidad.Paciente;


public class Main2 
{
    public static void main( String[] args ){
    	Confighiberneate ch = new Confighiberneate();
    	Session session = ch.abrirConexion();

    	List<Medicos> lista =(List<Medicos>) session.createQuery("FROM Medicos m ORDER BY m.id DESC").list();
    	for (Medicos legajo : lista) {
    		System.out.println(legajo.toString());
    	}
    	//Mostrar todos los médicos ordenados según su legajo de menor a mayor.
    	List<Object[]> obj =(List<Object[]>) session.createQuery("SELECT m.legajo, m.nombre, m.apellido FROM medico m ORDER BY m.legajo ASC").list();
    	for (Object[] doc : obj) {
    		System.out.println(doc[0]+" " + doc[1]+" " + doc[2]);
    	}
    	
    	//Mostrar todos los turnos que posee el médico con legajo 1234 en el día 01/01/2025
    	
    	
    	//Mostrar todos los legajos de los médicos
    	List<Integer> listaLegajos =(List<Integer>) session.createQuery("SELECT m.legajo FROM Medico m").list();
    	for (int legajo : listaLegajos) {
    		System.out.println(legajo);
    	}
    	
    	//Mostrar el médico con mayor número de legajo
    	Medicos doctor = (Medicos) session.createQuery("SELECT MAX(m.legajo) FROM medico m").uniqueResult();
    	System.out.println(doctor.toString());

    	//A través de distintas consultas obtener la cantidad de turnos que existen en
    	//estado presente y ausente entre las fechas 01/01/2024 y 01/03/2024. Luego
    	//calcular porcentajes. No habrá turnos pendientes porque las fechas son
    	//antiguas.
    		
    	
    }
}
