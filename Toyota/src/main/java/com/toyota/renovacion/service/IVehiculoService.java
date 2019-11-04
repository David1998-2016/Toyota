package com.toyota.renovacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Vehiculo;
import com.toyota.renovacion.model.Cliente;

public interface IVehiculoService {
	public boolean insertar(Vehiculo veh);
	public boolean modificar(Vehiculo veh);
	public void eliminar(int idVeh);
	public Optional<Vehiculo> listarId(int idVeh);
	List<Vehiculo> listar();
	List<Vehiculo> buscarModelo(String nameModelo);
	List<Vehiculo> buscarTipo(String nameType);
	List<Vehiculo> buscarPlaca(String namePlaca);
	List<Vehiculo> buscarAnio(int numYear);
	List<Vehiculo> buscarCliente(int nameClient);
}
