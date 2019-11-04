package com.toyota.renovacion.service;

import java.util.List;
import java.util.Optional;

import com.toyota.renovacion.model.Revision_Tecnica;

public interface IRevision_TecnicaService {
	public boolean insertar(Revision_Tecnica rt);
	public boolean modificar(Revision_Tecnica rt);
	public void eliminar(int idVeh);
	public Optional<Revision_Tecnica> listarId(int idRT);
	List<Revision_Tecnica> listar();
}
