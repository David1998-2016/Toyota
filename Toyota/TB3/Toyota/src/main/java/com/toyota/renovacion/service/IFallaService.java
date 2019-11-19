package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Falla;

public interface IFallaService {

	public boolean insertar(Falla falla);
	public boolean modificar(Falla falla);
	public void eliminar(int idFalla);
	public Optional<Falla> listarId(int idFalla);
	List<Falla> listar();
	List<Falla> buscarNombre(String nameFalla);
	
}