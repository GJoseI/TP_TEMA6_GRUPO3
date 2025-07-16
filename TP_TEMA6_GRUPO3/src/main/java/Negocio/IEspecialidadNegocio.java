package Negocio;

import java.util.List;

import daoImp.Conexion;
import frgp.utn.edu.entidad.Especialidad;

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
