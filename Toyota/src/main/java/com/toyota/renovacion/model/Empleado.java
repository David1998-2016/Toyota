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
@Table(name="Empleado")

public class Empleado implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpleado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "DNIe", length=8, nullable=false)
	private String DNIe;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "nameEmpleado", length=15, nullable=false)
	private String nameEmpleado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "lastnameEmpleado", length=15, nullable=false)
	private String lastnameEmpleado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "celEmpleado", length=9, nullable=false)
	private String celEmpleado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "mailEmpleado", length=50, nullable=false)
	private String mailEmpleado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "passEmpleado", nullable=false)
	private String passEmpleado;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "rolEmpleado", length=10, nullable=false)
	private String rolEmpleado;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String dNIe,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nameEmpleado,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String lastnameEmpleado,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String celEmpleado,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String mailEmpleado,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String passEmpleado,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String rolEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
		DNIe = dNIe;
		this.nameEmpleado = nameEmpleado;
		this.lastnameEmpleado = lastnameEmpleado;
		this.celEmpleado = celEmpleado;
		this.mailEmpleado = mailEmpleado;
		this.passEmpleado = passEmpleado;
		this.rolEmpleado = rolEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDNIe() {
		return DNIe;
	}

	public void setDNIe(String dNIe) {
		DNIe = dNIe;
	}

	public String getNameEmpleado() {
		return nameEmpleado;
	}

	public void setNameEmpleado(String nameEmpleado) {
		this.nameEmpleado = nameEmpleado;
	}

	public String getLastnameEmpleado() {
		return lastnameEmpleado;
	}

	public void setLastnameEmpleado(String lastnameEmpleado) {
		this.lastnameEmpleado = lastnameEmpleado;
	}

	public String getCelEmpleado() {
		return celEmpleado;
	}

	public void setCelEmpleado(String celEmpleado) {
		this.celEmpleado = celEmpleado;
	}

	public String getMailEmpleado() {
		return mailEmpleado;
	}

	public void setMailEmpleado(String mailEmpleado) {
		this.mailEmpleado = mailEmpleado;
	}

	public String getPassEmpleado() {
		return passEmpleado;
	}

	public void setPassEmpleado(String passEmpleado) {
		this.passEmpleado = passEmpleado;
	}

	public String getRolEmpleado() {
		return rolEmpleado;
	}

	public void setRolEmpleado(String rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
