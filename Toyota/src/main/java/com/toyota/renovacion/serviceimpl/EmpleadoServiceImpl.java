package com.toyota.renovacion.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyota.renovacion.model.Empleado;
import com.toyota.renovacion.repository.IEmpleadoDAO;
import com.toyota.renovacion.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDAO dEmpleado;

	@Override
	@Transactional
	public boolean insertar(Empleado empleado) {
		Empleado objEmpleado = dEmpleado.save(empleado);
		if (objEmpleado == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public boolean modificar(Empleado empleado) {
		boolean flag = false;
		try {
			dEmpleado.save(empleado);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idEmpleado) {

		dEmpleado.deleteById(idEmpleado);

	}

	
	@Override
	@Transactional(readOnly=true)
	public Optional<Empleado> listarId(int idEmpleado) {
		return dEmpleado.findById(idEmpleado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Empleado> buscarNombre(String lastnameEmpleado) {

		return dEmpleado.buscarNombre(lastnameEmpleado);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Empleado> listar() {
		return dEmpleado.findAll();
	}

}
