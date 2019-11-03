package com.toyota.renovacion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.edu.upc.spring.model.Race;

@Entity
@Table(name="Mantenimiento")
public class Vehiculo_Solicitud implements Serializable{

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolicitud;
	
	@Id
	@ManyToOne
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="idVehiculo")	
	private Vehiculo idVehiculo;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado", nullable=false)
	private Empleado idOperador;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado", nullable=false)
	private Empleado idTecnico;

	public Vehiculo_Solicitud() {
		super();
	}

	public Vehiculo_Solicitud(int idSolicitud, Vehiculo idVehiculo, Empleado idOperador, Empleado idTecnico) {
		super();
		this.idSolicitud = idSolicitud;
		this.idVehiculo = idVehiculo;
		this.idOperador = idOperador;
		this.idTecnico = idTecnico;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Empleado getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(Empleado idOperador) {
		this.idOperador = idOperador;
	}

	public Empleado getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Empleado idTecnico) {
		this.idTecnico = idTecnico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
