package frgp.utn.edu.ar.Negocio;

import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Turno;

public interface ITurnoNegocio {
	public boolean AgregarTurno(Turno turno);
	public boolean Exist(int id);
	public Turno ReadOne(int id);
	public boolean Update(Turno turno);
	public boolean Delete(Turno turno) ;
	public List<Turno> ReadAll() ;
	public List<Turno> FiltarxFechaxPciente(String facha, String dni);
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
