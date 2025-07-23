package daoImp;
import java.util.List;

import org.hibernate.Session;

import dao.IUsuario;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Usuario;

public class daoUsuario implements IUsuario {

	private static Conexion conexion;
	
	///Agrergar Usuario
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
	
	/// Si existe
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
	
	/// Devuelve por Nombre de usuario
	public Usuario ReadOne(String nombreUsuario)
	{
		conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,nombreUsuario);
        conexion.cerrarSession();
        
        return usuario;
	}
	
	/// Modificar 
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
	
	/// Borrar
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
	
	/// trae todo
	public List<Usuario> ReadAll() {		
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("FROM Usuario").list();
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
