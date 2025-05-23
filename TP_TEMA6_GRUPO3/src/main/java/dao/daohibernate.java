package dao;
import java.util.ArrayList;

import org.hibernate.Session;

import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;
import frgp.utn.edu.entidad.Paciente;
import frgp.utn.edu.entidad.Turno;
import frgp.utn.edu.entidad.Usuario;

public class daohibernate {
	
	public static void AgregarMedico(Medicos med)
	{
		Confighiberneate ch = new Confighiberneate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(med);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static void AgregarUsuario(Usuario usuario)
	{
		Confighiberneate ch = new Confighiberneate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(usuario);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static void AgregarPaciente(Paciente paciente)
	{
		Confighiberneate ch = new Confighiberneate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(paciente);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static void AgregarEspecialidad(Especialidad especialidad)
	{
		Confighiberneate ch = new Confighiberneate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(especialidad);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static void AgregarTurno(Turno turno)
	{
		Confighiberneate ch = new Confighiberneate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(turno);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static Medicos ReadOne(int legajo)
	{
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Medicos med=(Medicos)session.get(Medicos.class,legajo);
        
        config.cerrarSession();
        
        return med;
	}
	
	public static ArrayList<Turno> ListarTodos(){
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		ArrayList<Turno> lista = (ArrayList<Turno>) session.createQuery("from Turno").list();
		
		session.getTransaction().commit();
		config.cerrarSession();
		
		return lista;
	}
	
	public static void Update(Turno med)
	{
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(med);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public static void Delete(Turno med) 
	{
		
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(med);
        session.getTransaction().commit();        
        
        config.cerrarSession();

	}
	
	public static void leerBidireccion() {
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		ArrayList<Usuario> lista = (ArrayList<Usuario>) session.createQuery("from Usuario").list();
		for (Usuario usuario : lista) {
			System.out.println(" Usuarios: "+ usuario.getNombre_Usuario()+" "+usuario.getContraseña()+" ");
		}
		config.cerrarSession();
	}
}
