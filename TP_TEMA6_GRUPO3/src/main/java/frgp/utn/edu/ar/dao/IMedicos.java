package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Medicos;

public interface IMedicos {
	public boolean AgregarMedicos(Medicos medicos);
	public boolean Exist(int legajo);
	public  Medicos ReadOne(int legajo);
	public boolean Update(Medicos medicos);
	public boolean Delete(Medicos medicos);
	public List<Medicos> ReadAll();
	public List<Medicos> FiltarXEspecilidad(int  especialidad);
	public List<Medicos> FiltarXEspecilidadYLegajo(int legajo, int  especialidad);
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
