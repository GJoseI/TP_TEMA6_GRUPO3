package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IMedicos;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Usuario;

@Repository("daoMedicos")
public class daoMedicos implements IMedicos{
	
	@Autowired	
	private Conexion conexion;
	
	///Agrergar Usuario
	@Override
	public boolean AgregarMedicos(Medicos medicos)
	{
		conexion = new Conexion();
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
	public boolean Exist(int legajo){
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
        conexion.cerrarSession();
        
        return (medicos!=null);
	}
	
	/// Devuelve por Nombre de id
	@Override
	public Medicos ReadOne(int legajo){
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		Medicos medicos=(Medicos)session.get(Medicos.class,legajo);
		conexion.cerrarSession();
		
        return medicos;
	}
				
	
	/// Modificar 
	@Override
	public boolean Update(Medicos medicos){
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
	@Override
	public boolean Delete(Medicos medicos) {
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
	
	public Medicos getMedicoFromUser(Usuario usuario) {
		String hql = "SELECT m FROM Medicos m WHERE m.usuario.Nombre_Usuario= :usuario";
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		
		
		Medicos medico = (Medicos) session.createQuery(hql)
		.setParameter("usuario", usuario.getNombre_Usuario()).uniqueResult();
		
		session.getTransaction().commit();
        conexion.cerrarSession();
        return medico;
	}
	
}
