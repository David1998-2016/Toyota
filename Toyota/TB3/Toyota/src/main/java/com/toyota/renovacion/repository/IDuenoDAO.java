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
	@Query("from Dueno d where d.lastnameDueno like %:lastnameDueno%")
	List<Dueno> buscarNombre(@Param("lastnameDueno") String lastnameDueno);	
	
}
