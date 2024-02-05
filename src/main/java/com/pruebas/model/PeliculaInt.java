package com.pruebas.model;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.persistence.Tuple;



public interface PeliculaInt extends CrudRepository<Pelicula,Long>  {

	
	@Query(name="Consulta1")
	List<String> con1();
	
	@Query(name="Consulta2")
	List<Tuple> con2();
	
	@Query(name="Consulta5")
	List<Tuple> con5();
	
	
}


