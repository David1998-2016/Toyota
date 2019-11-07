package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Vehiculo;;

public interface IVehiculoService {
	
	public boolean insertar(Vehiculo vehiculo);
	public boolean modificar(Vehiculo vehiculo);
	public void eliminar(int idVehiculo);
	public Optional<Vehiculo> listarId(int idVehiculo);
	List<Vehiculo> listar();
	List<Vehiculo> buscarDueno(String lastnameDueno);
}
