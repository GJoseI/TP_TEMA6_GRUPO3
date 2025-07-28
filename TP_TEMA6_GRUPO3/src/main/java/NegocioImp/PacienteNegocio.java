package NegocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Negocio.IPacienteNegocio;
import dao.IPaciente;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Paciente;

public class PacienteNegocio implements IPacienteNegocio {
	
	@Autowired
	private IPaciente daoPaciente;
	
	public boolean AgregarPaciente(Paciente p){
		return daoPaciente.AgregarPaciente(p);
	}

	public boolean Exist(String dni){
		return daoPaciente.Exist(dni);
	}
	public Paciente ReadOne(String dni){
		return daoPaciente.ReadOne(dni);
	}
	public boolean Update(Paciente p) {
		return daoPaciente.Update(p);
	}
	public boolean Delete(Paciente p) {
		return daoPaciente.Delete(p);
	}

	public List<Paciente> ReadAll(){
		return daoPaciente.ReadAll();
	}

	public Conexion getConexion() {
		return daoPaciente.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoPaciente.setConexion(conexion);
	}
}
