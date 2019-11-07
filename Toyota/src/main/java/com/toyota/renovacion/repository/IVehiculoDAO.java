package com.toyota.renovacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Vehiculo;

@Repository
public interface IVehiculoDAO extends JpaRepository<Vehiculo, Integer>
{
	@Query("from Vehiculo v where v.dueno.lastnameDueno like %:lastnameDueno%")
	List<Vehiculo> buscarDueno(@Param("lastnameDueno") String lastnameDueno);
}
