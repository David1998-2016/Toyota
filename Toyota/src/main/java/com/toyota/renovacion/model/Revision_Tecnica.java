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
@Table(name="Revision_Tecnica")
public class Revision_Tecnica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRT;
	
	@ManyToOne
	@JoinColumn(name="idFalla")	
	private Falla idFalla;
	

	@ManyToOne
	@JoinColumn(name="idVehiculo")	
	private Vehiculo idVehiculo;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Cantidad", nullable=false)
	private int Cantidad;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Descripcion", columnDefinition = "text", nullable=false)
	private String Descripcion;

	public Revision_Tecnica() {
		super();
	}

	public Revision_Tecnica(int idRT, Falla idFalla, Vehiculo idVehiculo,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") int cantidad,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String descripcion) {
		super();
		this.idRT = idRT;
		this.idFalla = idFalla;
		this.idVehiculo = idVehiculo;
		Cantidad = cantidad;
		Descripcion = descripcion;
	}

	public int getIdRT() {
		return idRT;
	}

	public void setIdRT(int idRT) {
		this.idRT = idRT;
	}

	public Falla getIdFalla() {
		return idFalla;
	}

	public void setIdFalla(Falla idFalla) {
		this.idFalla = idFalla;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
