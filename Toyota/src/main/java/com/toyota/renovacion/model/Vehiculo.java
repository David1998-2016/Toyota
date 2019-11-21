package com.toyota.renovacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Vehiculo")

public class Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idVehiculo;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "placa", length=6, nullable=false)
	private String placa;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "modelo", length=8, nullable=false)
	private String modelo;
	
	@NotNull
	@Column(name="anio")
	private int anio;	
	
	@NotNull
	@Column(name="precio")
	private int precio;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "estado", length=8, nullable=false)
	private String estado;
	
	@Column(name = "tramite", length=10)
	private String tramite;
	
	@ManyToOne
	@JoinColumn(name="idDueno", nullable=false)	
	private Dueno dueno;

	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(int idVehiculo,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String placa,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String modelo,
			@NotNull int anio, @NotNull int precio,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String estado,
			String tramite, Dueno dueno) {
		super();
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
		this.estado = estado;
		this.tramite = tramite;
		this.dueno = dueno;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTramite() {
		return tramite;
	}

	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}