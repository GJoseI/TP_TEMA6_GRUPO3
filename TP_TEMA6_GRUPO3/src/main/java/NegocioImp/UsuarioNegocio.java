package NegocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Negocio.IUsuarioNegocio;
import dao.IUsuario;
import daoImp.Conexion;
import frgp.utn.edu.entidad.Usuario;

public class UsuarioNegocio implements IUsuarioNegocio{

	@Autowired
	private IUsuario daoUsuario;
	
	public boolean AgregarUsuario(Usuario usuario)
	{
		return daoUsuario.AgregarUsuario(usuario);
	}

	public boolean Exist(String nombreUsuario){
		return daoUsuario.Exist(nombreUsuario);
	}
	public Usuario ReadOne(String nombreUsuario){
		return daoUsuario.ReadOne(nombreUsuario);
	}
	public boolean Update(Usuario usuario) {
		return daoUsuario.Update(usuario);
	}
	public boolean Delete(Usuario usuario){
		return daoUsuario.Delete(usuario);
	}

	public List<Usuario> ReadAll(){
		return daoUsuario.ReadAll();
	}

	public Conexion getConexion() {
		return daoUsuario.getConexion();
	}
	public void setConexion(Conexion conexion) {
		daoUsuario.setConexion(conexion);
	}
}
