package frgp.utn.edu.ar.Negocio;

import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Especialidad;

public interface IEspecialidadNegocio {
	public boolean AgregarEspecialidad(Especialidad especialidad);
	public boolean Exist(int id);
	public Especialidad ReadOne(int id);
	public boolean Update(Especialidad especialidad);
	public boolean Delete(Especialidad especialidad);
	public List<Especialidad> ReadAll();
	public Especialidad nombre(String n);
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
