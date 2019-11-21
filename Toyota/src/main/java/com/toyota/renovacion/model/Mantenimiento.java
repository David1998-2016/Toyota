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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Mantenimiento")
public class Mantenimiento implements Serializable {
	
private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMantenimiento;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "nameMantenimiento", length=60, nullable=false)
	private String nameMantenimiento;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "FechaMan")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaMan;
	
	@ManyToOne
	@JoinColumn(name="idVehiculo", nullable=false)	
	private Vehiculo idVehiculo;

	public Mantenimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mantenimiento(int idMantenimiento,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nameMantenimiento,
			@NotNull @Past(message = "No puedes seleccionar un dia que no existe") Date fechaMan, Vehiculo idVehiculo) {
		super();
		this.idMantenimiento = idMantenimiento;
		this.nameMantenimiento = nameMantenimiento;
		FechaMan = fechaMan;
		this.idVehiculo = idVehiculo;
	}

	public int getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public String getNameMantenimiento() {
		return nameMantenimiento;
	}

	public void setNameMantenimiento(String nameMantenimiento) {
		this.nameMantenimiento = nameMantenimiento;
	}

	public Date getFechaMan() {
		return FechaMan;
	}

	public void setFechaMan(Date fechaMan) {
		FechaMan = fechaMan;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	}
