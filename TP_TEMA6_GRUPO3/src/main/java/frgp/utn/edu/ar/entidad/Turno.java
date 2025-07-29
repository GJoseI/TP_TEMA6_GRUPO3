package frgp.utn.edu.ar.entidad;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Component
@Entity
@Table(name="Turno")
public class Turno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="DNI")
	private Paciente paciente;
	@ManyToOne
	@JoinColumn(name="legajo")
	private Medicos Medico;
	private Date fecha;
	private String hora;
	private String observacion;
	private String estadoTurno;
	private boolean estado;
	
	public Turno () {}
	public Turno(Medicos medico, Paciente paciente, Date fecha, String hora, String observacion, String estadoTurno) {
		super();
		Medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observacion = observacion;
		this.estadoTurno = estadoTurno;
		this.estado = true;
	}
	

	public Medicos getMedico() {
		return Medico;
	}

	public void setMedico(Medicos medico) {
		Medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservación() {
		return observacion;
	}

	public void setObservación(String observación) {
		this.observacion = observación;
	}

	public String getEstadoTurno() {
		return estadoTurno;
	}

	public void setEstadoTurno(String estadoTurno) {
		this.estadoTurno = estadoTurno;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Turno [Medico=" + Medico + ", paciente=" + paciente + ", fecha=" + fecha + ", hora=" + hora
				+ ", observación=" + observacion + ", estado=" + estadoTurno + "]";
	}
	
	

}
