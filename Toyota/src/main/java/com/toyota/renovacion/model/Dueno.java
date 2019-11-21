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
@Table(name="Dueno")

public class Dueno implements Serializable {
	
private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDueno;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "DNI", length=8, nullable=false)
	private String DNI;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "nameDueno", length=15, nullable=false)
	private String nameDueno;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "lastnameDueno", length=15, nullable=false)
	private String lastnameDueno;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "celDueno", length=9, nullable=false)
	private String celDueno;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "mailDueno", length=50, nullable=false)
	private String mailDueno;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "passDueno", length=255, nullable=false)
	private String passDueno;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "rolDueno", length=10, nullable=false)
	private String rolDueno;

	public Dueno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dueno(int idDueno,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String dNI,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nameDueno,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String lastnameDueno,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String celDueno,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String mailDueno,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String passDueno,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String rolDueno) {
		super();
		this.idDueno = idDueno;
		DNI = dNI;
		this.nameDueno = nameDueno;
		this.lastnameDueno = lastnameDueno;
		this.celDueno = celDueno;
		this.mailDueno = mailDueno;
		this.passDueno = passDueno;
		this.rolDueno = rolDueno;
	}

	public int getIdDueno() {
		return idDueno;
	}

	public void setIdDueno(int idDueno) {
		this.idDueno = idDueno;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNameDueno() {
		return nameDueno;
	}

	public void setNameDueno(String nameDueno) {
		this.nameDueno = nameDueno;
	}

	public String getLastnameDueno() {
		return lastnameDueno;
	}

	public void setLastnameDueno(String lastnameDueno) {
		this.lastnameDueno = lastnameDueno;
	}

	public String getCelDueno() {
		return celDueno;
	}

	public void setCelDueno(String celDueno) {
		this.celDueno = celDueno;
	}

	public String getMailDueno() {
		return mailDueno;
	}

	public void setMailDueno(String mailDueno) {
		this.mailDueno = mailDueno;
	}

	public String getPassDueno() {
		return passDueno;
	}

	public void setPassDueno(String passDueno) {
		this.passDueno = passDueno;
	}

	public String getRolDueno() {
		return rolDueno;
	}

	public void setRolDueno(String rolDueno) {
		this.rolDueno = rolDueno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
