package com.toyota.renovacion.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Detalle_Mantenimiento")
public class Detalle_Mantenimiento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="idMantenimiento")	
	private Mantenimiento idMantenimiento;
	
	@Id
	@ManyToOne
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="idVehiculo")	
	private Vehiculo idVehiculo;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "FechaMant")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaMant;

	public Detalle_Mantenimiento() {
		super();
	}

	public Detalle_Mantenimiento(Mantenimiento idMantenimiento, Vehiculo idVehiculo,
			@NotNull @Past(message = "No puedes seleccionar un dia que no existe") Date fechaMant) {
		super();
		this.idMantenimiento = idMantenimiento;
		this.idVehiculo = idVehiculo;
		FechaMant = fechaMant;
	}

	public Mantenimiento getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(Mantenimiento idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Date getFechaMant() {
		return FechaMant;
	}

	public void setFechaMant(Date fechaMant) {
		FechaMant = fechaMant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
