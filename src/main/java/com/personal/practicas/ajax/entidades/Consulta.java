package com.personal.practicas.ajax.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private String sintomas;
	private String diagnostico;
	@ManyToOne(fetch = FetchType.EAGER)
	private Doctores idDoctor;
	@ManyToOne(fetch = FetchType.EAGER)
	private Pacientes paciente;
	
	public Consulta(){
		
	}

	

	public Consulta(int id, Date fecha, String sintomas, String diagnostico, Doctores idDoctor, Pacientes paciente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.idDoctor = idDoctor;
		this.paciente = paciente;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Doctores getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Doctores idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Pacientes getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}
	
	
	
}
