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
@Table(name="Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "DNI", length=10, nullable=false)	
	private String DNI;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Nombre", length=30, nullable=false)	
	private String Nombre;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Apellido", length=30, nullable=false)	
	private String Apellido;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Telefono", length=9, nullable=false)	
	private String Telefono;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Correo", length=100, nullable=false)	
	private String Correo;
	
	@NotEmpty(message="No puede estar vacio")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "Pass", length=16, nullable=false)	
	private String Pass;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String dNI,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nombre,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String apellido,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String telefono,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String correo,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String pass) {
		super();
		this.idCliente = idCliente;
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Correo = correo;
		Pass = pass;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
	
}
