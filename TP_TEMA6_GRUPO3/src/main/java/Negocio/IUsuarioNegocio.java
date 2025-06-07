package Negocio;

import java.util.List;

import daoImp.Conexion;
import frgp.utn.edu.entidad.Usuario;

public interface IUsuarioNegocio {
	public boolean AgregarUsuario(Usuario usuario);
	public boolean Exist(String nombreUsuario);
	public Usuario ReadOne(String nombreUsuario);
	public boolean Update(Usuario usuario);
	public boolean Delete(Usuario usuario)  ;
	public List<Usuario> ReadAll();
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
