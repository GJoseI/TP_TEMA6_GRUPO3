package frgp.utn.edu.entidad;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String DNI;
	private String nombre;
	private String apellido; 
	private String telefono;
	private String dirección;
	private String localidad;
	private String provincia;
	private LocalDate fecha_nacimiento;
	private String correo_electronico;
	private boolean estado;
	
	
	public Paciente () {};
	public Paciente(String nombre, String apellido, String DNI, String telefono, String dirección, String localidad,
			String provincia, LocalDate fecha_nacimiento, String correo_electronico) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.telefono = telefono;
		this.dirección = dirección;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo_electronico = correo_electronico;
		this.estado=true;
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String teléfono) {
		this.telefono = teléfono;
	}

	public String getDireccion() {
		return dirección;
	}

	public void setDireccion(String dirección) {
		this.dirección = dirección;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Paciente [Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" + DNI + ", teléfono=" + telefono
				+ ", dirección=" + dirección + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", correo_electrónico=" + correo_electronico + "]";
	}

	
	
}
