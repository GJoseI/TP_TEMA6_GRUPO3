package NegocioImp;

import java.util.List;

import Negocio.IMedicosNegocio;
import daoImp.Conexion;
import daoImp.daoMedicos;
import frgp.utn.edu.entidad.Medicos;

public class MedicosNegocio implements IMedicosNegocio {
	public boolean AgregarMedicos(Medicos medicos) 
	{
		daoMedicos med = new daoMedicos();
		return med.AgregarMedicos(medicos);
	}

	public boolean Exist(int legajo){
		daoMedicos med = new daoMedicos();
		return med.Exist(legajo);
	}
	public  Medicos ReadOne(int legajo) {
		daoMedicos med = new daoMedicos();
		return med.ReadOne(legajo);
	}
	public boolean Update(Medicos medicos) {
		daoMedicos med = new daoMedicos();
		return med.Update(medicos);
	}
	public boolean Delete(Medicos medicos){
		daoMedicos med = new daoMedicos();
		return med.Delete(medicos);
	}

	public List<Medicos> ReadAll(){
		daoMedicos med = new daoMedicos();
		return med.ReadAll();
	}

	public Conexion getConexion() {
		daoMedicos med = new daoMedicos();
		return med.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoMedicos med = new daoMedicos();
		med.setConexion(conexion);
	}
	
	public List<Medicos> FiltarXEspecilidad(int especialidad){
		daoMedicos med = new daoMedicos();
		return med.FiltarXEspecilidad(especialidad);
	
	}
	
	public List<Medicos> FiltarXEspecilidadYLegajo(int legajo, int especialidad){
		daoMedicos med = new daoMedicos();
		return med.FiltarXEspecilidadYLegajo(legajo, especialidad);
	}

}