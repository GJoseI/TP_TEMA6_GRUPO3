package frgp.utn.edu.ar.daoImp;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IUsuario;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Usuario;

@Repository("daoUsuario")
public class daoUsuario implements IUsuario {

	@Autowired
	private Conexion conexion;
	
	public boolean AgregarUsuario(Usuario usuario)
	{
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;
		try 
		{
			session= conexion.abrirConexion();
		
			session.beginTransaction();
			session.save(usuario);
	    
			session.getTransaction().commit();    
			Usuario savedUser = (Usuario) session.get(Usuario.class, usuario.getNombre_Usuario());
			if (savedUser == null) {
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
	
	public boolean Exist(String nombreUsuario)
	{
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,nombreUsuario);
        if(usuario!=null)
        	return true;
        conexion.cerrarSession();
        
        return false;
	}
	
	public Usuario ReadOne(String nombreUsuario)
	{
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,nombreUsuario);
        conexion.cerrarSession();
        
        return usuario;
	}

	public boolean Update(Usuario usuario)
	{
		conexion = new Conexion();
		boolean estado = true;
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        
	        session.update(usuario);

	         session.flush();

	        session.getTransaction().commit();
			Usuario savedUser = (Usuario) session.get(Usuario.class, usuario.getNombre_Usuario());
			if (savedUser == null) {
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
	
	public boolean Delete(Usuario usuario) 
	{	
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();

	        session.delete(usuario);
	        
	        session.flush();

	        session.getTransaction().commit();

	        Usuario savedUser = (Usuario) session.get(Usuario.class, usuario.getNombre_Usuario());
	        if (savedUser != null) {
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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> ReadAll() {		
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("FROM Usuario u WHERE u.estado = true").list();
        conexion.cerrarSession();
        
        return usuarios;
	}
	
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

}
