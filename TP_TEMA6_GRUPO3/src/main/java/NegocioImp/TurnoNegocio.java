package NegocioImp;

import java.util.List;

import daoImp.Conexion;
import daoImp.daoTurno;
import frgp.utn.edu.entidad.Turno;

public class TurnoNegocio {

	public boolean AgregarTurno(Turno turno)
	{
		daoTurno t = new daoTurno();
		return t.AgregarTurno(turno);
	}

	public boolean Exist(int id){
		daoTurno t = new daoTurno();
		return t.Exist(id);
	}
	public Turno ReadOne(int id){
		daoTurno t = new daoTurno();
		return t.ReadOne(id);
	}
	public boolean Update(Turno turno) {
		daoTurno t = new daoTurno();
		return t.Update(turno);
	}
	public boolean Delete(Turno turno){
		daoTurno t = new daoTurno();
		return t.Delete(turno);
	}

	public List<Turno> ReadAll(){
		daoTurno t = new daoTurno();
		return t.ReadAll();
	}

	public Conexion getConexion() {
		daoTurno t = new daoTurno();
		return t.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoTurno t = new daoTurno();
		t.setConexion(conexion);
	}

}
