package com.toyota.renovacion.seviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.toyota.renovacion.repository.IVehiculoDAO;

public class VehiculoServiceImpl {
	@Autowired
	private IVehiculoDAO dVehiculo;
}
