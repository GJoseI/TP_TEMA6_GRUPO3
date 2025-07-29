package frgp.utn.edu.ar.NegocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.Negocio.IEspecialidadNegocio;
import frgp.utn.edu.ar.dao.IEspecialidad;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Especialidad;

@Service("servicioEspecialidad")
public class EspecialidadNegocio implements IEspecialidadNegocio{
	
	@Autowired
	private IEspecialidad daoEspecialidad;
	
	public boolean AgregarEspecialidad(Especialidad especialidad) {
		return daoEspecialidad.AgregarEspecialidad(especialidad);
	}
	
	public boolean Exist(int id) {
		return daoEspecialidad.Exist(id);
	}
	public Especialidad ReadOne(int id) {
		return daoEspecialidad.ReadOne(id);
	}
	
	public Especialidad nombre(String n) {
		return daoEspecialidad.nombre(n);
	}
	
	public boolean Update(Especialidad especialidad) {
		return daoEspecialidad.Update(especialidad);
	}
	public boolean Delete(Especialidad especialidad){
		return daoEspecialidad.Delete(especialidad);
	}
	
	public List<Especialidad> ReadAll(){
		return daoEspecialidad.ReadAll();
	}
	
	public Conexion getConexion() {
		return daoEspecialidad.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoEspecialidad.setConexion(conexion);
	}

}
