package frgp.utn.edu.ar.daoImp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IPaciente;
import frgp.utn.edu.ar.dao.ITurno;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Turno;

@Repository("daoTurno")
public class daoTurno implements ITurno{
	
	@Autowired
	private Conexion conexion;
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
		public boolean validarTurno(int legajoM, Date fecha, String hora)
		{
			String hql = "SELECT COUNT(t) FROM Turno t WHERE t.medico.legajo = :legajo AND t.fecha = :fecha AND t.hora = :hora";
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			
			
			Long count = (Long) session.createQuery(hql)
			.setParameter("legajo", legajoM)
			.setParameter("fecha", fecha)
			.setParameter("hora", hora).uniqueResult();		
			
			session.getTransaction().commit();
	        conexion.cerrarSession();
	        return count > 0;
		}
		
		public boolean Exist(int id) {
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			Turno savedTurno = (Turno) session.get(Turno.class, id);
	        if(savedTurno!=null) return true;
	        conexion.cerrarSession();
	        return savedTurno != null;
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
		

		//Agrego los gettes y setters para Spring Core
		
		public Conexion getConexion() {
			return conexion;
		}

		public void setConexion(Conexion conexion) {
			this.conexion = conexion;
		}

		@Override
		public long informeAusencias(int mes) {
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			if(mes > 0) {
				String hql = "SELECT COUNT(t) FROM Turno t WHERE t.estadoTurno = 'Ausente' AND t.fecha BETWEEN :inicio AND :fin";
				Calendar calInicio = Calendar.getInstance();
				calInicio.set(2025, mes -1, 1);
				
				Calendar calFin = Calendar.getInstance();
				calFin.set(2025, mes -1, calInicio.getActualMaximum(Calendar.DAY_OF_MONTH));
				
				Date inicio = calInicio.getTime();
				Date fin = calFin.getTime();
				
				Long count = (Long) session.createQuery(hql)
				.setParameter("inicio", inicio)
				.setParameter("fin", fin).uniqueResult();
				
				session.getTransaction().commit();
				conexion.cerrarSession();
				return count;
			}
			String hql = "SELECT COUNT(t) FROM Turno t WHERE t.estadoTurno = 'Ausente'";
			Long count = (Long) session.createQuery(hql).uniqueResult();
			session.getTransaction().commit();
			conexion.cerrarSession();
			return count;
		}

		@Override
		public long informeTotalTurnos(int mes) {
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			if(mes > 0) {
				String hql = "SELECT COUNT(t) FROM Turno t WHERE t.fecha BETWEEN :inicio AND :fin";
				Calendar calInicio = Calendar.getInstance();
				calInicio.set(2025, mes -1, 1);
				
				Calendar calFin = Calendar.getInstance();
				calFin.set(2025, mes -1, calInicio.getActualMaximum(Calendar.DAY_OF_MONTH));
				
				Date inicio = calInicio.getTime();
				Date fin = calFin.getTime();
				
				Long count = (Long) session.createQuery(hql)
				.setParameter("inicio", inicio)
				.setParameter("fin", fin).uniqueResult();
				
				session.getTransaction().commit();
				conexion.cerrarSession();
				return count;
			}
			String hql = "SELECT COUNT(t) FROM Turno t";
			Long count = (Long) session.createQuery(hql).uniqueResult();
			session.getTransaction().commit();
			conexion.cerrarSession();
			return count;
		}

		@Override
		public long informePacienteAtendidos(int mes) {
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			if(mes > 0) {
				String hql = "SELECT COUNT(t) FROM Turno t WHERE t.estadoTurno = 'Atendido' AND t.fecha BETWEEN :inicio AND :fin";
				Calendar calInicio = Calendar.getInstance();
				calInicio.set(2025, mes -1, 1);
				
				Calendar calFin = Calendar.getInstance();
				calFin.set(2025, mes -1, calInicio.getActualMaximum(Calendar.DAY_OF_MONTH));
				
				Date inicio = calInicio.getTime();
				Date fin = calFin.getTime();
				
				Long count = (Long) session.createQuery(hql)
				.setParameter("inicio", inicio)
				.setParameter("fin", fin).uniqueResult();
				
				session.getTransaction().commit();
				conexion.cerrarSession();
				return count;
			}
			String hql = "SELECT COUNT(t) FROM Turno t WHERE t.estadoTurno = 'Atendido'";
			Long count = (Long) session.createQuery(hql).uniqueResult();
			session.getTransaction().commit();
			conexion.cerrarSession();
			return count;
		}

		@Override
		public Double informePorcentAsistencias(int mes) {
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			if(mes > 0) {
				String hql = "SELECT AVG(CASE WHEN t.estadoTurno = 'Atendido' THEN 1 ELSE 0 END) FROM Turno t WHERE t.fecha BETWEEN :inicio AND :fin";
				Calendar calInicio = Calendar.getInstance();
				calInicio.set(2025, mes -1, 1);
				
				Calendar calFin = Calendar.getInstance();
				calFin.set(2025, mes -1, calInicio.getActualMaximum(Calendar.DAY_OF_MONTH));
				
				Date inicio = calInicio.getTime();
				Date fin = calFin.getTime();
				
				Double count = (Double) session.createQuery(hql)
				.setParameter("inicio", inicio)
				.setParameter("fin", fin).uniqueResult();
				
				session.getTransaction().commit();
				conexion.cerrarSession();
				if(count == null) {
					count = 0.0;
				}
				
				return count *= 100;
			}
			String hql = "SELECT AVG(CASE WHEN t.estadoTurno = 'Atendido' THEN 1.0 ELSE 0.0 END) FROM Turno t";
			Double count = (Double) session.createQuery(hql).uniqueResult();
			session.getTransaction().commit();
			conexion.cerrarSession();
			return count *= 100;
		}
		
		@Override
		public long informeEspecialidad(int id) {
			conexion = new Conexion();
			Session session= conexion.abrirConexion();
			session.beginTransaction();
			
			String hql = "SELECT COUNT(t) FROM Turno t WHERE t.especialidad.id = :id";
			Long count = (Long) session.createQuery(hql).setParameter("id", id).uniqueResult();
			session.getTransaction().commit();
			conexion.cerrarSession();
			return count;
		}
}
