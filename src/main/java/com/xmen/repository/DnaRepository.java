package com.xmen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xmen.entity.Dna;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Integer> {
	
	@Query("select count(d) from Dna d "
			+ "where :validacion is null or d.validacionMutante=:validacion")
	Integer getDnaByValidationMutant(@Param("validacion") Boolean validacion);

}
