package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IMedicos;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medicos;

@Repository("daoMedicos")
public class daoMedicos implements IMedicos{
	
	@Autowired	
	private Conexion conexion;
	
	///Agrergar Usuario
	@Override
	public boolean AgregarMedicos(Medicos medicos)
	{
		boolean estado = true;
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
	@Override
	public boolean Exist(int legajo)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
        conexion.cerrarSession();
        
        return (medicos!=null);
	}
	
	/// Devuelve por Nombre de id
	@Override
	public Medicos ReadOne(int legajo)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
		conexion.cerrarSession();
		
        return medicos;
	}
	
	
	/// Devuelve por Nombre de usuario y especialidad
	@Override
	public List<Medicos> FiltarXEspecilidad(int  especialidad)
	{
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Medicos> medicos = session.createQuery("SELECT m.* FROM medico m WHERE Especialidad_id = " + especialidad +" ; ").list();
        session.flush();

        session.getTransaction().commit();
        conexion.cerrarSession();
        
        return medicos;
	}
			
	/// Devuelve por Nombre de usuario y especialidad
	@Override
	public List<Medicos> FiltarXEspecilidadYLegajo(int legajo, int  especialidad)
	{
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Medicos> medicos = session.createQuery("SELECT m.* FROM medico m WHERE Especialidad_id = "+ especialidad + " and m.legajo = "+ legajo + " ;").list();
        session.flush();

        session.getTransaction().commit();
        conexion.cerrarSession();
        
        return medicos;
	}
				
	
	/// Modificar 
	@Override
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
	@Override
	public boolean Delete(Medicos medicos) 
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
	@Override
	public List<Medicos> ReadAll() {		
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
