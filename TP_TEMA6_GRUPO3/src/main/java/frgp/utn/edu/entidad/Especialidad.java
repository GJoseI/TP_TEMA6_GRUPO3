package frgp.utn.edu.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id; 

@Entity
public class Especialidad implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	private int Id;
	private String nombre;
	
	public Especialidad() {};
	
	public Especialidad(int id, String nombre) {
		super();
		Id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Especialidad [Id=" + Id + ", nombre=" + nombre + "]";
	}

}
