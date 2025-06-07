package daoImp;

import java.util.List;

import org.hibernate.Session;

import dao.IMedicos;
import daoImp.Conexion;
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
			conexion.cerrarSession();
			Medicos savedMedicos = (Medicos) session.get(Medicos.class, medicos.getLegajo());
			if (savedMedicos == null) {
	            estado = false;
	        }
	        
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
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
        if(medicos!=null)
        	return true;
        
        return false;
	}
	
	/// Devuelve por Nombre de usuario
	public Medicos ReadOne(int legajo)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
        return medicos;
	}
	
	/// Modificar 
	public boolean Update(Medicos medicos)
	{
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

	        session.delete(medicos);
	        
	        session.flush();

	        session.getTransaction().commit();

	        Medicos savedMedicos = (Medicos) session.get(Medicos.class, medicos.getLegajo());
	        
	        if (savedMedicos != null) {
	            estado = false;
	        }
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
        List<Medicos> usuarios = session.createQuery("FROM medico").list();
        return usuarios;
	}

	//Agrego los gettes y setters para Spring Core
	
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
