package com.toyota.renovacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Detalle_Mantenimiento;

public interface IDetalle_MantenimientoService {
	
	public boolean insertar(Detalle_Mantenimiento dm);
	public boolean modificar(Detalle_Mantenimiento dm);
	public void eliminar(int idDeM);
	public Optional<Detalle_Mantenimiento> listarId(int idDeM);
	List<Detalle_Mantenimiento> listar();
	List<Detalle_Mantenimiento> findByDate(Date DateMant);
}
