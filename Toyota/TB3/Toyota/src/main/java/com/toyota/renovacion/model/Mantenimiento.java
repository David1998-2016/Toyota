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
public class Mantenimiento implements Serializable {
	
private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMantenimiento;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "nameMantenimiento", length=60, nullable=false)
	private String nameMantenimiento;

	public Mantenimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mantenimiento(int idMantenimiento,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nameMantenimiento) {
		super();
		this.idMantenimiento = idMantenimiento;
		this.nameMantenimiento = nameMantenimiento;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
