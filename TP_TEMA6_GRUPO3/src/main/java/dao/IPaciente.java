package dao;

import java.util.List;

import daoImp.Conexion;
import frgp.utn.edu.entidad.Paciente;

public interface IPaciente {
	public boolean AgregarPaciente(Paciente pacientes);
	public boolean Exist(String dni);
	public Paciente ReadOne(String dni);
	public boolean Update(Paciente pacientes);
	public boolean Delete(Paciente pacientes);
	public List<Paciente> ReadAll();
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
