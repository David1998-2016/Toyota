package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Empleado;

public interface IEmpleadoService {

	public boolean insertar(Empleado dueno);
	public boolean modificar(Empleado dueno);
	public void eliminar(int idDueno);
	public Optional<Empleado> listarId(int idDueno);
	List<Empleado> listar();
	List<Empleado> buscarNombre(String lastnameDueno);
	
}