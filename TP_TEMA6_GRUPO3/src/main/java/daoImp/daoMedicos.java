package daoImp;

import java.util.List;

import org.hibernate.Session;

import dao.IMedicos;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;

public class daoMedicos implements IMedicos{
private static Conexion conexion;
	
	///Agrergar Usuario
	public boolean AgregarMedicos(Medicos medicos)
	{
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;
		try 
		{
			session= conexion.abrirConexion();
		
			session.beginTransaction();
			session.save(medicos);
	    
			session.getTransaction().commit();    
			Medicos savedMedicos = (Medicos) session.get(Medicos.class, medicos.getLegajo());
			if (savedMedicos == null) {
				estado = false;
			}
			conexion.cerrarSession();
	        
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    }
	    
	    return estado;
	}
	
	/// Si existe
	public boolean Exist(int legajo)
	{
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
        conexion.cerrarSession();
        
        return (medicos!=null);
	}
	
	/// Devuelve por Nombre de id
	public Medicos ReadOne(int legajo)
	{
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
		conexion.cerrarSession();
		
        return medicos;
	}
	
	
	/// Devuelve por Nombre de usuario y especialidad
	public List<Medicos> FiltarXEspecilidad(int  especialidad)
	{
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Medicos> medicos = session.createQuery("SELECT m.* FROM medico m WHERE Especialidad_id = " + especialidad +" ; ").list();
        session.flush();

        session.getTransaction().commit();
        conexion.cerrarSession();
        
        return medicos;
	}
			
	/// Devuelve por Nombre de usuario y especialidad
	public List<Medicos> FiltarXEspecilidadYLegajo(int legajo, int  especialidad)
	{
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Medicos> medicos = session.createQuery("SELECT m.* FROM medico m WHERE Especialidad_id = "+ especialidad + " and m.legajo = "+ legajo + " ;").list();
        session.flush();

        session.getTransaction().commit();
        conexion.cerrarSession();
        
        return medicos;
	}
				
	
	/// Modificar 
	public boolean Update(Medicos medicos)
	{
		conexion = new Conexion();
		boolean estado = true;
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        
	        session.update(medicos);

	         session.flush();

	        session.getTransaction().commit();
	        Medicos savedMedicos = (Medicos) session.get(Medicos.class, medicos.getLegajo());
			if (savedMedicos == null) {
	            estado = false;
	        }
			conexion.cerrarSession();
			
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    }
	    
	    return estado;
	}
	
	/// Borrar
	public boolean Delete(Medicos medicos) 
	{	
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();

	        session.update(medicos);
	        
	        session.flush();

	        session.getTransaction().commit();

	        Medicos savedMedicos = (Medicos) session.get(Medicos.class, medicos.getLegajo());  
	        if (savedMedicos != null) {
	            estado = false;
	        }
	        conexion.cerrarSession();
	        
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    }
	    
		return estado;
	}
	
	/// trae todo
	public List<Medicos> ReadAll() {		
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Medicos> medicos = session.createQuery("from Medicos").list();
        session.flush();

        session.getTransaction().commit();
        conexion.cerrarSession();
        
        return medicos;
	}
	
	
	//Agrego los gettes y setters para Spring Core
	
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	
	
}
