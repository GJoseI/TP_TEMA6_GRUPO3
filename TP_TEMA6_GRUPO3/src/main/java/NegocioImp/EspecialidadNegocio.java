package NegocioImp;

import java.util.List;

import Negocio.IEspecialidadNegocio;
import daoImp.Conexion;
import daoImp.daoEspecialidad;
import frgp.utn.edu.entidad.Especialidad;

public class EspecialidadNegocio implements IEspecialidadNegocio{
	
	
	public boolean AgregarEspecialidad(Especialidad especialidad) 
	{
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.AgregarEspecialidad(especialidad);
	}
	
	public boolean Exist(int id) {
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.Exist(id);
	}
	public Especialidad ReadOne(int id) {
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.ReadOne(id);
	}
	public boolean Update(Especialidad especialidad) {
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.Update(especialidad);
	}
	public boolean Delete(Especialidad especialidad){
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.Delete(especialidad);
	}
	
	public List<Especialidad> ReadAll(){
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.ReadAll();
	}
	
	public Conexion getConexion() {
		daoEspecialidad Especialidad = new daoEspecialidad();
		return Especialidad.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoEspecialidad Especialidad = new daoEspecialidad();
		Especialidad.setConexion(conexion);
	}

}
