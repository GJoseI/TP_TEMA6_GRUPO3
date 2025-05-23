package frgp.utn.edu.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medico")
public class Medicos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int legajo;
	private String nombre;
	private String apellido;
	private String sexo;
	private String fechaNac;
	private String direccion;
	private String localidad;
	private String email;
	private String telefono;
	@ManyToOne
	@JoinColumn(name="Id")
	private Especialidad especialidad;
	@OneToOne
	@JoinColumn(name="Usuario_c")
	private Usuario usuario;
	
	public Medicos(int legajo, String nombre, String apellido, String sexo, String fechaNac, String direccion,
			String localidad, String email, String telefono, Usuario usuario, Especialidad especialidad) {
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
		this.usuario = usuario;
		this.especialidad = especialidad;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Medicos() {}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
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
	
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Legajo= " + legajo + ", Nombre= " + nombre + ", Apellido= " + apellido + ", Sexo= " + sexo
				+ ", FechaNac= " + fechaNac + ", Direccion= " + direccion + ", Localidad= " + localidad + ", Email= "
				+ email + ", Telefono= " + telefono;
	};
	

}
