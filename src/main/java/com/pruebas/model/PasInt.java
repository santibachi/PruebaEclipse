package com.pruebas.model;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.Tuple;

public interface PasInt extends CrudRepository<Pas,Long>  {

	@Query(name="Consulta3")
	List<Tuple> con3(@Param("genero") String genero);
	
	@Query(name="Consulta4")
	
	List<Tuple> con4();
	
	@Query(name="Consulta6")
	List<Tuple> con6();
	
	@Query(name="Consulta7")
	List<Tuple> con7(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
