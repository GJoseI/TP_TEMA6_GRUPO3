package frgp.utn.edu.ar.NegocioImp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.Negocio.ITurnoNegocio;
import frgp.utn.edu.ar.dao.ITurno;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.daoImp.daoTurno;
import frgp.utn.edu.ar.entidad.Turno;

@Service("servicioTurno")
public class TurnoNegocio implements ITurnoNegocio {
	
	@Autowired
	private ITurno daoTurno;

	public boolean AgregarTurno(Turno turno)
	{
		return daoTurno.AgregarTurno(turno);
	}

	public boolean Exist(int id){
		return daoTurno.Exist(id);
	}
	public boolean validarTurno(int legajoM, Date fecha, String hora) {
		return daoTurno.validarTurno(legajoM, fecha, hora);
	};
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
	
	public Conexion getConexion() {
		return daoTurno.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoTurno.setConexion(conexion);
	}

	@Override
	public int informeAusencias(int mes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int informeTotalTurnos(int mes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int informePacienteAtendidos(int mes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double informePorcentAsistencias(int mes) {
		// TODO Auto-generated method stub
		return 0;
	}

}
