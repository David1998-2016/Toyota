package com.toyota.renovacion.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyota.renovacion.model.Vehiculo;
import com.toyota.renovacion.repository.IVehiculoDAO;
import com.toyota.renovacion.service.IVehiculoService;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	@Autowired
	private IVehiculoDAO dVehiculo;

	@Override
	@Transactional
	public boolean insertar(Vehiculo vehiculo) {
		Vehiculo objvehiculo = dVehiculo.save(vehiculo);
		if (objvehiculo == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public boolean modificar(Vehiculo vehiculo) {
		boolean flag = false;
		try {
			dVehiculo.save(vehiculo);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idVehiculo) {

		dVehiculo.deleteById(idVehiculo);

	}

	@Override
	public Optional<Vehiculo> listarId(int idVehiculo) {
		return dVehiculo.findById(idVehiculo);		
	}

	
	@Override
	public List<Vehiculo> listar() {

		return dVehiculo.findAll();

	}

	@Override
	public List<Vehiculo> buscarDueno(String lastnameDueno) {
		// TODO Auto-generated method stub
		return dVehiculo.buscarDueno(lastnameDueno);
	}
	
}
