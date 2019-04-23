package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.hh.sw.loytola.domain.Breed;


public interface BreedRepository extends CrudRepository<Breed, Long>{
	List<Breed> findByName(@Param("name") String name);
}
