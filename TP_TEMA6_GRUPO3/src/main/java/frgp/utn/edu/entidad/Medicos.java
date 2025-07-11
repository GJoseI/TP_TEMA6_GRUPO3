package frgp.utn.edu.entidad;

import java.io.Serializable;
import java.time.LocalDate;

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
	private LocalDate fechaNac;
	private String diasLab;
	private String horarioLab;
	private String direccion;
	private String localidad;
	private String email;
	private String telefono;
	private boolean estado;
	@ManyToOne
	@JoinColumn(name="Id")
	private Especialidad especialidad;
	@OneToOne
	@JoinColumn(name="Usuario_c")
	private Usuario usuario;
	
	public Medicos(int legajo, String nombre, String apellido, String sexo, LocalDate fechaNac, String diasLab, String horarioLab, String direccion,
			String localidad, String email, String telefono, Usuario usuario, Especialidad especialidad) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.diasLab = diasLab;
		this.horarioLab = horarioLab;
		this.direccion = direccion;
		this.localidad = localidad;
		this.email = email;
		this.telefono = telefono;
		this.usuario = usuario;
		this.especialidad = especialidad;
		this.estado=true;
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

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDiasLab() {
		return diasLab;
	}

	public void setDiasLab(String diasLab) {
		this.diasLab = diasLab;
	}

	public String getHorarioLab() {
		return horarioLab;
	}

	public void setHorarioLab(String horarioLab) {
		this.horarioLab = horarioLab;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Legajo= " + legajo + ", Nombre= " + nombre + ", Apellido= " + apellido + ", Sexo= " + sexo
				+ ", FechaNac= " + fechaNac + ", Direccion= " + direccion + ", Localidad= " + localidad + ", Email= "
				+ email + ", Telefono= " + telefono;
	};
	

}
