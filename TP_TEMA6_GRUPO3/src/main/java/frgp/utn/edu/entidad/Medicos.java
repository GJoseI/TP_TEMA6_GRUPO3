package frgp.utn.edu.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicos")
public class Medicos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="legajo")
	private String legajo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="sexo")
	private String sexo;
	@Column(name="fechaNac")
	private String fechaNac;
	@Column(name="direccion")
	private String direccion;
	@Column(name="localidad")
	private String localidad;
	@Column(name="email")
	private String email;
	@Column(name="telefono")
	private String telefono;
	
	public Medicos(String legajo, String nombre, String apellido, String sexo, String fechaNac, String direccion,
			String localidad, String email, String telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.localidad = localidad;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Medicos() {}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Medicos [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", fechaNac=" + fechaNac + ", direccion=" + direccion + ", localidad=" + localidad + ", email="
				+ email + ", telefono=" + telefono + "]";
	};
	

}
