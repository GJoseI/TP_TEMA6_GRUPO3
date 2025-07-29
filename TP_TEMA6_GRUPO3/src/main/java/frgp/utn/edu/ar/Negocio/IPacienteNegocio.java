package frgp.utn.edu.ar.Negocio;

import java.util.List;

import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.daoImp.daoMedicos;
import frgp.utn.edu.ar.daoImp.daoPaciente;
import frgp.utn.edu.ar.entidad.Medicos;
import frgp.utn.edu.ar.entidad.Paciente;

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


