package frgp.utn.edu.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="Nombre")
	private String Nombre;
	@Column(name="Apellido")
	private String Apellido; 
	@Column(name="DNI")
	private String DNI;
	@Column(name="teléfono")
	private String teléfono;
	@Column(name="dirección")
	private String dirección;
	@Column(name="localidad")
	private String localidad;
	@Column(name="provincia")
	private String provincia;
	@Column(name="fecha_nacimiento")
	private String fecha_nacimiento;
	@Column(name="correo_electrónico")
	private String correo_electrónico;
	
	public Paciente(String nombre, String apellido, String dNI, String teléfono, String dirección, String localidad,
			String provincia, String fecha_nacimiento, String correo_electrónico) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		this.teléfono = teléfono;
		this.dirección = dirección;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo_electrónico = correo_electrónico;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
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

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo_electrónico() {
		return correo_electrónico;
	}

	public void setCorreo_electrónico(String correo_electrónico) {
		this.correo_electrónico = correo_electrónico;
	}

	@Override
	public String toString() {
		return "Paciente [Nombre=" + Nombre + ", Apellido=" + Apellido + ", DNI=" + DNI + ", teléfono=" + teléfono
				+ ", dirección=" + dirección + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", correo_electrónico=" + correo_electrónico + "]";
	}

	
	
}
