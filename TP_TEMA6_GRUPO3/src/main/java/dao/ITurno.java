package dao;

import java.util.List;

import daoImp.Conexion;
import frgp.utn.edu.entidad.Turno;

public interface ITurno {
	public boolean AgregarTurno(Turno turno);
	public boolean Exist(int id);
	public Turno ReadOne(int id);
	public boolean Update(Turno turno);
	public boolean Delete(Turno turno) ;
	public List<Turno> ReadAll() ;
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
