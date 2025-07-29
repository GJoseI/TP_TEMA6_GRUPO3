package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Turno;

public interface ITurno {
	public boolean AgregarTurno(Turno turno);
	public boolean Exist(int id);
	public Turno ReadOne(int id);
	public boolean Update(Turno turno);
	public boolean Delete(Turno turno) ;
	public List<Turno> ReadAll() ;
	public List<Turno> FiltarxFecha(String facha);
	public List<Turno> FiltarxFechaxPciente(String facha, String dni);
	public List<Turno> FiltarPciente( String dni);
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
