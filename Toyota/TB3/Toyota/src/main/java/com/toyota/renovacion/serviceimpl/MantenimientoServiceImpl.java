package com.toyota.renovacion.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyota.renovacion.model.Mantenimiento;
import com.toyota.renovacion.repository.IMantenimientoDAO;
import com.toyota.renovacion.service.IMantenimientoService;

@Service
public class MantenimientoServiceImpl implements IMantenimientoService {

	@Autowired
	private IMantenimientoDAO dMantenimiento;

	@Override
	@Transactional
	public boolean insertar(Mantenimiento mantenimiento) {
		Mantenimiento objMantenimiento = dMantenimiento.save(mantenimiento);
		if (objMantenimiento == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public boolean modificar(Mantenimiento mantenimiento) {
		boolean flag = false;
		try {
			dMantenimiento.save(mantenimiento);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMantenimiento) {

		dMantenimiento.deleteById(idMantenimiento);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Mantenimiento> listarId(int idMantenimiento) {
		return dMantenimiento.findById(idMantenimiento);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Mantenimiento> buscarNombre(String nameMantenimiento) {

		return dMantenimiento.buscarNombre(nameMantenimiento);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Mantenimiento> listar() {
		return dMantenimiento.findAll();
	}

}
