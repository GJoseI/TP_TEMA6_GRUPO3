package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IEspecialidad;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Especialidad;

@Repository("daoEspecialidad")
public class daoEspecialidad implements IEspecialidad{
	
	@Autowired
	private Conexion conexion;
	
	public boolean AgregarEspecialidad(Especialidad especialidad)
	{
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;
		try 
		{
			session= conexion.abrirConexion();
		
			session.beginTransaction();
			session.save(especialidad);
	    
			session.getTransaction().commit();    
			Especialidad savedEspecialidad = (Especialidad) session.get(Especialidad.class, especialidad.getId());
			if (savedEspecialidad == null) {
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
	
	public boolean Exist(int id)
	{
		Session session= conexion.abrirConexion();
		conexion = new Conexion();
		session.beginTransaction();
		Especialidad medicos=(Especialidad)session.get(Especialidad.class,id);
        if(medicos!=null)
        	return true;
        conexion.cerrarSession();
        return false;
	}
	
	public Especialidad ReadOne(int id)
	{
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Especialidad especialidad=(Especialidad)session.get(Especialidad.class,id);
		conexion.cerrarSession();
        return especialidad;
	}
	
	public boolean Update(Especialidad especialidad)
	{
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;
	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        
	        session.update(especialidad);

	         session.flush();

	        session.getTransaction().commit();
	        Especialidad savedEspecialidad = (Especialidad) session.get(Especialidad.class, especialidad.getId());
			if (savedEspecialidad == null) {
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
	
	public boolean Delete(Especialidad especialidad) 
	{	
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();

	        session.delete(especialidad);
	        
	        session.flush();

	        session.getTransaction().commit();

	        Especialidad savedEspecialidad = (Especialidad) session.get(Especialidad.class, especialidad.getId());
	        if (savedEspecialidad != null) {
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
	
	public List<Especialidad> ReadAll() {		
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Especialidad> usuarios = session.createQuery("FROM Especialidad").list();
        conexion.cerrarSession();
        return usuarios;
	}
	
	public Especialidad nombre(String n) {	
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        Query usuarios = session.createQuery("SELECT * FROM especialidad  WHERE nombre = "+ n +" LIMIT 1;");
        conexion.cerrarSession();
        return (Especialidad) usuarios;
	}
	
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
