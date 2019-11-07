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
@Table(name="Falla")

public class Falla implements Serializable {
	
private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFalla;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "nameFalla", length=60, nullable=false)
	private String nameFalla;

	public Falla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Falla(int idFalla,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nameFalla) {
		super();
		this.idFalla = idFalla;
		this.nameFalla = nameFalla;
	}

	public int getIdFalla() {
		return idFalla;
	}

	public void setIdFalla(int idFalla) {
		this.idFalla = idFalla;
	}

	public String getNameFalla() {
		return nameFalla;
	}

	public void setNameFalla(String nameFalla) {
		this.nameFalla = nameFalla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
