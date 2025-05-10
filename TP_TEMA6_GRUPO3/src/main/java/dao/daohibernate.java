package dao;
import org.hibernate.Session;
import frgp.utn.edu.entidad.Medicos;

public class daohibernate {
	public static void Add(Medicos user)
	{
		Confighiberneate ch = new Confighiberneate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(user);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public static Medicos ReadOne(int id)
	{
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Medicos usuario=(Medicos)session.get(Medicos.class,id);
        
        config.cerrarSession();
        
        return usuario;
	}
	
	public static void Update(Medicos usuario)
	{
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public static void Delete(Medicos usuario) 
	{
		
		Confighiberneate config = new Confighiberneate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();        
        
        config.cerrarSession();

	}
}
