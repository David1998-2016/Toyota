package com.toyota.renovacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Empleado;

@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleado, Integer>
{
	@Query("from Empleado r where r.lastnameEmpleado like %:lastnameEmpleado%")
	List<Empleado> buscarNombre(@Param("lastnameEmpleado") String lastnameEmpleado);
}
