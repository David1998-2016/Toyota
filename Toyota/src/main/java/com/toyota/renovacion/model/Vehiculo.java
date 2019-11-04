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

@Entity
@Table(name="Vehiculo")
public class Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVehiculo;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Placa", length=6, nullable=false)
	private String Placa;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Modelo", length=15, nullable=false)
	private String Modelo;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Anio", nullable=false)
	private int Anio;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Precio", nullable=false)
	private int Precio;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Tipo", length=15, nullable=false)
	private String Tipo;
	
	@ManyToOne
	@JoinColumn(name="idDueno", nullable=false)	
	private Cliente Propietario;

	public Vehiculo() {
		super();
	}

	public Vehiculo(int idVehiculo,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String placa,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String modelo,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") int anio,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") int precio,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String tipo,
			Cliente propietario) {
		super();
		this.idVehiculo = idVehiculo;
		Placa = placa;
		Modelo = modelo;
		Anio = anio;
		Precio = precio;
		Tipo = tipo;
		Propietario = propietario;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public int getAnio() {
		return Anio;
	}

	public void setAnio(int anio) {
		Anio = anio;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public Cliente getPropietario() {
		return Propietario;
	}

	public void setPropietario(Cliente propietario) {
		Propietario = propietario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
