package frgp.utn.edu.entidad;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity
@Table(name="Turno")
public class Turno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="Medico_Ct")/// Columna de turnos entra la relacion entre Medico y turnos
	private Medicos Medico;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="paciente_c")
	private Paciente paciente;
	@Column(name="fecha")
	private String fecha;
	@Column(name="hora")
	private String hora;
	@Column(name="observación")
	private String observación;
	@Column(name="estado")
	private String estado;
	
	public Turno(Medicos medico, Paciente paciente, String fecha, String hora, String observación, String estado) {
		super();
		Medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observación = observación;
		this.estado = estado;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservación() {
		return observación;
	}

	public void setObservación(String observación) {
		this.observación = observación;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Turno [Medico=" + Medico + ", paciente=" + paciente + ", fecha=" + fecha + ", hora=" + hora
				+ ", observación=" + observación + ", estado=" + estado + "]";
	}
	
	

}
