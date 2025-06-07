package Negocio;

import java.util.List;

import daoImp.Conexion;
import daoImp.daoMedicos;
import daoImp.daoPaciente;
import frgp.utn.edu.entidad.Medicos;
import frgp.utn.edu.entidad.Paciente;

public interface IPacienteNegocio {
	public boolean AgregarPaciente(Paciente p);
	public boolean Exist(String dni);
	public Paciente ReadOne(String dni);
	public boolean Update(Paciente p);
	public boolean Delete(Paciente p);
	public List<Paciente> ReadAll();
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}


