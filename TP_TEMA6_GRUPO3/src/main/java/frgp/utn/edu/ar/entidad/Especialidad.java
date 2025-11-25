package frgp.utn.edu.ar.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.Id; 

@Component
@Entity
public class Especialidad implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	private int id;
	private String nombre;
	private boolean estado;
	public Especialidad() {};
	
	public Especialidad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado= true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Especialidad [Id=" + id + ", nombre=" + nombre + "]";
	}

}
