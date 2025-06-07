package dao;

import java.util.List;

import daoImp.Conexion;
import frgp.utn.edu.entidad.Usuario;

public interface IUsuario {
	public boolean AgregarUsuario(Usuario usuario);
	public boolean Exist(String nombreUsuario);
	public Usuario ReadOne(String nombreUsuario);
	public boolean Update(Usuario usuario);
	public boolean Delete(Usuario usuario)  ;
	public List<Usuario> ReadAll();
	public Conexion getConexion();
	public void setConexion(Conexion conexion);
}
