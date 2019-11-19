package com.toyota.renovacion.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyota.renovacion.model.Falla;
import com.toyota.renovacion.repository.IFallaDAO;
import com.toyota.renovacion.service.IFallaService;

@Service
public class FallaServiceImpl implements IFallaService {

	@Autowired
	private IFallaDAO dFalla;

	@Override
	@Transactional
	public boolean insertar(Falla falla) {
		Falla objFalla = dFalla.save(falla);
		if (objFalla == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public boolean modificar(Falla falla) {
		boolean flag = false;
		try {
			dFalla.save(falla);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idFalla) {

		dFalla.deleteById(idFalla);

	}

	
	@Override
	@Transactional(readOnly=true)
	public Optional<Falla> listarId(int idFalla) {
		return dFalla.findById(idFalla);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Falla> buscarNombre(String nameFalla) {

		return dFalla.buscarNombre(nameFalla);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Falla> listar() {
		return dFalla.findAll();
	}

}
