package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Falla;

import pe.edu.upc.spring.model.Race;

public interface IFallaService {
	
	public boolean insertar(Falla fail);
	public boolean modificar(Falla fail);
	public void eliminar(int idFail);
	public Optional<Falla> listarId(int idFail);
	List<Falla> listar();
	List<Falla> buscarNombre(String nameFail);
}
