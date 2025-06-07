package daoImp;

import java.util.List;

import org.hibernate.Session;

import dao.IPaciente;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Paciente;

public class daoPaciente implements IPaciente {
private static Conexion conexion;
	
	///Agrergar Paciente
	public boolean AgregarPaciente(Paciente paciente)
	{
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;
		try 
		{
			session= conexion.abrirConexion();
		
			session.beginTransaction();
			session.save(paciente);
	    
			session.getTransaction().commit();    
			conexion.cerrarSession();
			Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDNI());
			if (savedPaciente == null) {
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
	public boolean Exist(String dni)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente=(Paciente)session.get(Paciente.class,dni);
        if(paciente!=null)
        	return true;
        
        return false;
	}
	
	/// Devuelve por Nombre de usuario
	public Paciente ReadOne(String dni)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente=(Paciente)session.get(Paciente.class,dni);
        return paciente;
	}
	
	/// Modificar 
	public boolean Update(Paciente paciente)
	{
		boolean estado = true;
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        
	        session.update(paciente);

	         session.flush();

	        session.getTransaction().commit();
	        Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDNI());
			if (savedPaciente == null) {
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
	public boolean Delete(Paciente paciente) 
	{	
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();

	        session.delete(paciente);
	        
	        session.flush();

	        session.getTransaction().commit();

	        Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDNI());
	        
	        if (savedPaciente != null) {
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
	public List<Paciente> ReadAll() {		
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Paciente> usuarios = session.createQuery("FROM paciente").list();
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
