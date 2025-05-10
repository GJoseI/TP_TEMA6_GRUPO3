package dao;
import java.util.ArrayList;

import org.hibernate.Session;
import frgp.utn.edu.entidad.Medicos;

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
	
	public static Medicos ReadOne(int legajo)
	{
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Medicos med=(Medicos)session.get(Medicos.class,legajo);
        
        config.cerrarSession();
        
        return med;
	}
	
	public static ArrayList<Medicos> ListarTodos(){
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		ArrayList<Medicos> lista = (ArrayList<Medicos>) session.createQuery("from Medicos").list();
		
		session.getTransaction().commit();
		config.cerrarSession();
		
		return lista;
	}
	
	public static void Update(Medicos med)
	{
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(med);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public static void Delete(Medicos med) 
	{
		
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(med);
        session.getTransaction().commit();        
        
        config.cerrarSession();

	}
}
