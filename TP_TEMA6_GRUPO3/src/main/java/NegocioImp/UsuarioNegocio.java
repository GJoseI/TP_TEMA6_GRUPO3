package NegocioImp;

import java.util.List;

import Negocio.IUsuarioNegocio;
import daoImp.Conexion;
import daoImp.daoUsuario;
import frgp.utn.edu.entidad.Usuario;

public class UsuarioNegocio implements IUsuarioNegocio{

	public boolean AgregarUsuario(Usuario usuario)
	{
		daoUsuario s = new daoUsuario();
		return s.AgregarUsuario(usuario);
	}

	public boolean Exist(String nombreUsuario){
		daoUsuario s = new daoUsuario();
		return s.Exist(nombreUsuario);
	}
	public Usuario ReadOne(String nombreUsuario){
		daoUsuario s = new daoUsuario();
		return s.ReadOne(nombreUsuario);
	}
	public boolean Update(Usuario usuario) {
		daoUsuario s = new daoUsuario();
		return s.Update(usuario);
	}
	public boolean Delete(Usuario usuario){
		daoUsuario s = new daoUsuario();
		return s.Delete(usuario);
	}

	public List<Usuario> ReadAll(){
		daoUsuario s = new daoUsuario();
		return s.ReadAll();
	}

	public Conexion getConexion() {
		daoUsuario s = new daoUsuario();
		return s.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoUsuario s = new daoUsuario();
		s.setConexion(conexion);
	}
}
