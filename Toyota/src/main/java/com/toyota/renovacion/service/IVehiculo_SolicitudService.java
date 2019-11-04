package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Vehiculo_Solicitud;

public interface IVehiculo_SolicitudService {
	public boolean insertar(Vehiculo_Solicitud vs);
	public boolean modificar(Vehiculo_Solicitud vs);
	public void eliminar(int idVeh);
	public Optional<Vehiculo_Solicitud> listarId(int idSol);
	List<Vehiculo_Solicitud> listar();
}
