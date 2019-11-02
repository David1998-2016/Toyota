package com.toyota.renovacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Mantenimiento")

public class Mantenimiento implements Serializable{

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMantenimiento;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "nombreMantenimiento", length=60, nullable=false)
	private String nombreMantenimiento;

	public Mantenimiento() {
		super();
	}

	public Mantenimiento(int idMantenimiento,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nombreMantenimiento) {
		super();
		this.idMantenimiento = idMantenimiento;
		this.nombreMantenimiento = nombreMantenimiento;
	}

	public int getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public String getNombreMantenimiento() {
		return nombreMantenimiento;
	}

	public void setNombreMantenimiento(String nombreMantenimiento) {
		this.nombreMantenimiento = nombreMantenimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
