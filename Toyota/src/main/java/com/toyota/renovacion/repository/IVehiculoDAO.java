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
	@Query("from Vehiculo v where v.nameModelo like %:nameModelo%")
	List<Vehiculo> buscarModelo(@Param("nameModelo") String nameModelo);
	
	@Query("from Vehiculo v where v.nameType like %:nameType%")
	List<Vehiculo> buscarTipo(@Param("nameType") String nameType);
	
	@Query("from Vehiculo v where v.namePlaca like %:namePlaca%")
	List<Vehiculo> buscarPlaca(@Param("namePlaca") String namePlaca);
	
	@Query("from Vehiculo v where v.numYear like %:numYear%")
	List<Vehiculo> buscarAnio(@Param("numYear") String numYear);
	
	@Query("from Vehiculo v where v.cliente.nameClient like %:nameClient%")
	List<Vehiculo> buscarCliente(@Param("nameClient") String nameClient);
}
