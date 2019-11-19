package com.toyota.renovacion.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyota.renovacion.model.Dueno;
import com.toyota.renovacion.repository.IDuenoDAO;
import com.toyota.renovacion.service.IDuenoService;

@Service
public class DuenoServiceImpl implements IDuenoService {

	@Autowired
	private IDuenoDAO dDueno;

	@Override
	@Transactional
	public boolean insertar(Dueno dueno) {
		Dueno objDueno = dDueno.save(dueno);
		if (objDueno == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public boolean modificar(Dueno dueno) {
		boolean flag = false;
		try {
			dDueno.save(dueno);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDueno) {

		dDueno.deleteById(idDueno);

	}

	
	@Override
	@Transactional(readOnly=true)
	public Optional<Dueno> listarId(int idDueno) {
		return dDueno.findById(idDueno);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Dueno> buscarNombre(String nameDueno) {

		return dDueno.buscarNombre(nameDueno);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Dueno> listar() {
		return dDueno.findAll();
	}

}
