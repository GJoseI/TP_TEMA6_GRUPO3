package frgp.utn.edu.ar.NegocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.Negocio.IMedicosNegocio;
import frgp.utn.edu.ar.dao.IMedicos;
import frgp.utn.edu.ar.daoImp.Conexion;
import frgp.utn.edu.ar.daoImp.daoMedicos;
import frgp.utn.edu.ar.entidad.Medicos;

@Service("servicioMedicos")
public class MedicosNegocio implements IMedicosNegocio {
	
	@Autowired
	private IMedicos daoMedicos;
	
	public boolean AgregarMedicos(Medicos medicos){
		return daoMedicos.AgregarMedicos(medicos);
	}

	public boolean Exist(int legajo){
		return daoMedicos.Exist(legajo);
	}
	
	public  Medicos ReadOne(int legajo) {
		return daoMedicos.ReadOne(legajo);
	}
	
	public boolean Update(Medicos medicos) {
		return daoMedicos.Update(medicos);
	}
	
	public boolean Delete(Medicos medicos){
		return daoMedicos.Delete(medicos);
	}

	public List<Medicos> ReadAll(){
		return daoMedicos.ReadAll();
	}

	public Conexion getConexion() {
		return daoMedicos.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoMedicos.setConexion(conexion);
	}
	
	public List<Medicos> FiltarXEspecilidad(int especialidad){
		return daoMedicos.FiltarXEspecilidad(especialidad);
	}
	
	public List<Medicos> FiltarXEspecilidadYLegajo(int legajo, int especialidad){
		return daoMedicos.FiltarXEspecilidadYLegajo(legajo, especialidad);
	}

}