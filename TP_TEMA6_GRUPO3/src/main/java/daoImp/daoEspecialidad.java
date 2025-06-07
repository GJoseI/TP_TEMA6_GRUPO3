package daoImp;

import java.util.List;

import org.hibernate.Session;

import dao.IEspecialidad;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Especialidad;

public class daoEspecialidad implements IEspecialidad{
private static Conexion conexion;
	
	///Agrergar Usuario
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
			conexion.cerrarSession();
			Especialidad savedEspecialidad = (Especialidad) session.get(Especialidad.class, especialidad.getId());
			if (savedEspecialidad == null) {
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
	public boolean Exist(int id)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Especialidad medicos=(Especialidad)session.get(Especialidad.class,id);
        if(medicos!=null)
        	return true;
        
        return false;
	}
	
	/// Devuelve por Nombre de usuario
	public Especialidad ReadOne(int id)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Especialidad especialidad=(Especialidad)session.get(Especialidad.class,id);
        return especialidad;
	}
	
	/// Modificar 
	public boolean Update(Especialidad especialidad)
	{
		boolean estado = true;
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
	public List<Especialidad> ReadAll() {		
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Especialidad> usuarios = session.createQuery("FROM especialidad").list();
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
