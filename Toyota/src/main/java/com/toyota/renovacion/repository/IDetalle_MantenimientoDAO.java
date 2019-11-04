package com.toyota.renovacion.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Detalle_Mantenimiento;

@Repository
public interface IDetalle_MantenimientoDAO extends JpaRepository<Detalle_Mantenimiento, Integer>
{
	@Query("from Pet p where p.race.nameRace like %:nameRace%")
	List<Detalle_Mantenimiento> buscarRaza(@Param("nameRace") String nameRace);
	
	@Query("from Pet p where p.namePet like %:namePet%")
	List<Detalle_Mantenimiento> buscarPet(@Param("namePet") String namePet);
	
	List<Detalle_Mantenimiento> findByDate(Date DateMant);
}
