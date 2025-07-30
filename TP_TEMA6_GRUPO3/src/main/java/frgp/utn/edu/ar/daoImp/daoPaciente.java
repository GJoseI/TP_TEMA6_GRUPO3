package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IPaciente;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Paciente;

@Repository("daoPaciente")
public class daoPaciente implements IPaciente {
	@Autowired
	private  Conexion conexion;
	
	///Agrergar Paciente
	public boolean AgregarPaciente(Paciente paciente){
		conexion = new Conexion();
		boolean estado = true;
	    Session session = null;
		try 
		{
			session = conexion.abrirConexion();
		
			session.beginTransaction();
			session.save(paciente);
	    
			session.getTransaction().commit();    
			Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDNI());
			if (savedPaciente == null) {
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
	public boolean Exist(String dni){
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente=(Paciente)session.get(Paciente.class,dni);
        if(paciente!=null)
        	return true;
        conexion.cerrarSession();
        
        return false;
	}
	
	/// Devuelve por Nombre de usuario
	public Paciente ReadOne(String dni){
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente=(Paciente)session.get(Paciente.class,dni);
		conexion.cerrarSession();
		
        return paciente;
	}
	
	/// Modificar 
	public boolean Update(Paciente paciente){
		conexion = new Conexion();
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
	public boolean Delete(Paciente paciente) {	
		conexion = new Conexion();
		boolean estado = true;
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
	public List<Paciente> ReadAll() {
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Paciente> usuarios = session.createQuery("FROM Paciente").list();
        conexion.cerrarSession();
        
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
