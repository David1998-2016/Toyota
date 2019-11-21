package com.toyota.renovacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Dueno;

@Repository
public interface IDuenoDAO extends JpaRepository<Dueno, Integer>
{
	Dueno findByDNI(String DNI);
	
	@Query("from Dueno r where r.DNI like %:DNI%")
	List<Dueno> buscarNombre(@Param("DNI") String DNI);
	
}
