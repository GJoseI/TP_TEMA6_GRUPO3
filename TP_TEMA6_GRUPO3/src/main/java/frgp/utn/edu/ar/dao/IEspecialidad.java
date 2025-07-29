package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Especialidad;

public interface IEspecialidad {
	public boolean AgregarEspecialidad(Especialidad especialidad);
	public boolean Exist(int id);
	public Especialidad ReadOne(int id);
	public boolean Update(Especialidad especialidad);
	public boolean Delete(Especialidad especialidad);
	public List<Especialidad> ReadAll();
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
	public Especialidad nombre (String n);
}
