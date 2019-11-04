package com.toyota.renovacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toyota.renovacion.model.Falla;

@Repository
public interface IFallaDAO extends JpaRepository<Falla, Integer>{
	@Query("from Falla f where f.nameFail like %:nameFail%")
	List<Falla> buscarNombre(@Param("nameFail") String nameFail);

}
