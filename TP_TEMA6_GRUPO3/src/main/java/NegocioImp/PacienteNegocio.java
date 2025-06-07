package NegocioImp;

import java.util.List;

import Negocio.IPacienteNegocio;
import daoImp.Conexion;
import daoImp.daoPaciente;
import frgp.utn.edu.entidad.Paciente;

public class PacienteNegocio implements IPacienteNegocio {
	
	public boolean AgregarPaciente(Paciente p)
	{
		daoPaciente paciente = new daoPaciente();
		return paciente.AgregarPaciente(p);
	}

	public boolean Exist(String dni){
		daoPaciente paciente = new daoPaciente();
		return paciente.Exist(dni);
	}
	public Paciente ReadOne(String dni){
		daoPaciente paciente = new daoPaciente();
		return paciente.ReadOne(dni);
	}
	public boolean Update(Paciente p) {
		daoPaciente paciente = new daoPaciente();
		return paciente.Update(p);
	}
	public boolean Delete(Paciente p) {
		daoPaciente paciente = new daoPaciente();
		return paciente.Delete(p);
	}

	public List<Paciente> ReadAll(){
		daoPaciente paciente = new daoPaciente();
		return paciente.ReadAll();
	}

	public Conexion getConexion() {
		daoPaciente paciente = new daoPaciente();
		return paciente.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoPaciente paciente = new daoPaciente();;
		paciente.setConexion(conexion);
	}
}
