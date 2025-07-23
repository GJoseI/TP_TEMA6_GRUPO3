package daoImp;

import java.util.List;
import org.hibernate.Session;

import dao.IPaciente;
import dao.ITurno;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Turno;

public class daoTurno implements ITurno{
	
	private static Conexion conexion;
	///Agrergar Usuario
		public boolean AgregarTurno(Turno turno)
		{
			boolean estado = true;
			conexion = new Conexion();
		    Session session = null;
			try 
			{
				session= conexion.abrirConexion();
			
				session.beginTransaction();
				session.save(turno);
		    
				session.getTransaction().commit();    
				Turno savedTurno = (Turno) session.get(Turno.class, turno.getId());
				if (savedTurno == null) {
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
		public boolean Exist(int id)
		{
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			Turno savedTurno = (Turno) session.get(Turno.class, id);
	        if(savedTurno!=null)
	        	return true;
	        conexion.cerrarSession();
	        
	        return false;
		}
		
		/// Devuelve por Nombre de usuario
		public Turno ReadOne(int id)
		{
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			Turno savedTurno = (Turno) session.get(Turno.class, id);
			conexion.cerrarSession();
			
	        return savedTurno;
		}
		
		/// Modificar 
		public boolean Update(Turno turno)
		{
			conexion = new Conexion();
			boolean estado = true;
		    Session session = null;

		    try {
		        session = conexion.abrirConexion();
		        session.beginTransaction();
		        
		        session.update(turno);

		        session.flush();

		        session.getTransaction().commit();
		        Turno savedTurno = (Turno) session.get(Turno.class, turno.getId());
				if (savedTurno == null) {
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
		public boolean Delete(Turno turno) 
		{	
			boolean estado = true;
			conexion = new Conexion();
		    Session session = null;

		    try {
		        session = conexion.abrirConexion();
		        session.beginTransaction();

		        session.delete(turno);
		        
		        session.flush();

		        session.getTransaction().commit();

		        Turno savedUser = (Turno) session.get(Turno.class, turno.getId());	        
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
		public List<Turno> ReadAll() {		
			conexion = new Conexion();
		    Session session = conexion.abrirConexion();
	        session.beginTransaction();
	        List<Turno> usuarios = session.createQuery("FROM Turno").list();
	        conexion.cerrarSession();
	        
	        return usuarios;
		}
		
		/// trae todo por fecha
		public List<Turno> FiltarxFecha(String facha) {		
			conexion = new Conexion();
		    Session session = conexion.abrirConexion();
	        session.beginTransaction();
	        List<Turno> usuarios = session.createQuery("SELECT * FROM turno  WHERE fecha = "+ facha +";").list();
	        session.flush();

	        session.getTransaction().commit();
	        conexion.cerrarSession();
	        
	        return usuarios;
		}
		/// trae por fecha y paciente
		public List<Turno> FiltarxFechaxPciente(String facha, String dni) {		
			conexion = new Conexion();
		    Session session = conexion.abrirConexion();
	        session.beginTransaction();
	        List<Turno> usuarios = session.createQuery("SELECT t.* FROM turno t inner join paciente p on p.DNI = t.DNI WHERE t.fecha = "+ facha +" and p.DNI = "+dni+";").list();
	        session.flush();

	        session.getTransaction().commit();
	        conexion.cerrarSession();
	        
	        return usuarios;
		}
		
		/// trae por paciente
		public List<Turno> FiltarPciente( String dni) {		
			conexion = new Conexion();
		    Session session = conexion.abrirConexion();
	        session.beginTransaction();
	        List<Turno> usuarios = session.createQuery("SELECT t.* FROM turno t inner join paciente p on   p.DNI = t.DNI where p.DNI = "+dni+";").list();
	        session.flush();

	        session.getTransaction().commit();
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
