package frgp.utn.edu.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="Nombre_Usuario")
	private String Nombre_Usuario;
	@Column(name="Contraseña")
	private String Contraseña;
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Medico_c")
	private Medicos Medico;
	
	
	
	public Usuario(String nombre_Usuario, String contraseña) {
		super();
		Nombre_Usuario = nombre_Usuario;
		Contraseña = contraseña;
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
		return Medico;
	}
	public void setMedico(Medicos medico) {
		Medico = medico;
	}


	@Override
	public String toString() {
		return "Usuario [Nombre_Usuario=" + Nombre_Usuario + ", Contraseña=" + Contraseña + "]";
	}
	
}
