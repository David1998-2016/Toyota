package com.toyota.renovacion.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Revision_Tecnica;

@Repository
public interface IRevision_TecnicaDAO extends JpaRepository<Revision_Tecnica, Integer>
{
	@Query("from Revision_Tecnica r where r.nameRace like %:nameRace%")
	List<Revision_Tecnica> buscarNombre(@Param("nameRace") String nameRace);
}
