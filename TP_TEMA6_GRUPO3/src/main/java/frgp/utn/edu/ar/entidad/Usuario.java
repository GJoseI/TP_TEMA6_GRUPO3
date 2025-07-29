package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String Nombre_Usuario;
	private String Contraseña;
	private boolean  admin;
	@OneToOne(mappedBy="usuario", fetch=FetchType.EAGER)
	private Medicos medico;
	private boolean estado;
	
	public Usuario() {}
	
	public Usuario(String nombre_Usuario, String contraseña,boolean  adminn) {
		super();
		Nombre_Usuario = nombre_Usuario;
		Contraseña = contraseña;
		admin=adminn;
		this.estado=true;
	}
	
	public Usuario(String nombre_Usuario, String contraseña) {
		super();
		Nombre_Usuario = nombre_Usuario;
		Contraseña = contraseña;
		admin=false;
		this.estado=true;
	}
	
	
	
	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}
	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public Medicos getMedico() {
		return medico;
	}
	public void setMedico(Medicos medico) {
		this.medico = medico;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [Nombre_Usuario=" + Nombre_Usuario + ", Contraseña=" + Contraseña + "]";
	}
	
}
