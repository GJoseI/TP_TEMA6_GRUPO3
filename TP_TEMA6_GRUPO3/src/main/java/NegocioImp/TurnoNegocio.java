package NegocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ITurno;
import daoImp.Conexion;
import daoImp.daoTurno;
import frgp.utn.edu.entidad.Turno;

public class TurnoNegocio {
	
	@Autowired
	private ITurno daoTurno;

	public boolean AgregarTurno(Turno turno)
	{
		return daoTurno.AgregarTurno(turno);
	}

	public boolean Exist(int id){
		return daoTurno.Exist(id);
	}
	public Turno ReadOne(int id){
		return daoTurno.ReadOne(id);
	}
	public boolean Update(Turno turno) {
		return daoTurno.Update(turno);
	}
	public boolean Delete(Turno turno){
		return daoTurno.Delete(turno);
	}

	public List<Turno> ReadAll(){
		return daoTurno.ReadAll();
	}

	public List<Turno> FiltarxFecha(String facha){
		return daoTurno.FiltarxFecha(facha);
	}
	
	public List<Turno> FiltarxFechaxPciente(String facha, String dni){
		return daoTurno.FiltarxFechaxPciente( facha,  dni);
	}
	
	public List<Turno> FiltarPciente(String dni){
		return daoTurno.FiltarPciente( dni);
	}
	
	public Conexion getConexion() {
		return daoTurno.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoTurno.setConexion(conexion);
	}

}
