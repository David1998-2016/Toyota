package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Mantenimiento;

public interface IMantenimientoService {
	
	public boolean insertar(Mantenimiento mantenimiento);
	public boolean modificar(Mantenimiento mantenimiento);
	public void eliminar(int idMantenimiento);
	public Optional<Mantenimiento> listarId(int idMantenimiento);
	List<Mantenimiento> listar();
	List<Mantenimiento> buscarNombre(String nameMantenimiento);
}
