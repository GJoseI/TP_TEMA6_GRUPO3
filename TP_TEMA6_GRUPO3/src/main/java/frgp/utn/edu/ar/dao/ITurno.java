package frgp.utn.edu.ar.dao;

import java.util.Date;
import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.entidad.Turno;

public interface ITurno {
	public boolean AgregarTurno(Turno turno);
	public boolean Exist(int id);
	public boolean validarTurno(int legajoM, Date fecha, String hora);
	public Turno ReadOne(int id);
	public long informeAusencias(int mes);
	public long informeTotalTurnos(int mes);
	public long informePacienteAtendidos(int mes);
	public Double informePorcentAsistencias(int mes);
	public boolean Update(Turno turno);
	public boolean Delete(Turno turno) ;
	public List<Turno> ReadAll() ;
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
