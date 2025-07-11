package Negocio;

import java.util.List;

import daoImp.Conexion;
import frgp.utn.edu.entidad.Medicos;

public interface IMedicosNegocio {
	public boolean AgregarMedicos(Medicos medicos);
	public boolean Exist(int legajo);
	public  Medicos ReadOne(int legajo);
	public boolean Update(Medicos medicos);
	public boolean Delete(Medicos medicos);
	public List<Medicos> ReadAll();
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
