package com.toyota.renovacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Mantenimiento;

@Repository
public interface IMantenimientoDAO extends JpaRepository<Mantenimiento, Integer>
{
	@Query("from Mantenimiento m where m.nameMantenimiento like %:nameMantenimiento%")
	List<Mantenimiento> buscarNombre(@Param("nameMantenimiento") String nameMantenimiento);

}
