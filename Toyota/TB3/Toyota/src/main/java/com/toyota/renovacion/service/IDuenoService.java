package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Dueno;

public interface IDuenoService {

	public boolean insertar(Dueno dueno);
	public boolean modificar(Dueno dueno);
	public void eliminar(int idDueno);
	public Optional<Dueno> listarId(int idDueno);
	List<Dueno> listar();
	List<Dueno> buscarNombre(String lastnameDueno);
	
}