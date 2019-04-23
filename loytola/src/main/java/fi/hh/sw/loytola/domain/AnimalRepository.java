package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.hh.sw.loytola.domain.Animal;


public interface AnimalRepository extends CrudRepository<Animal, Long>{
	List<Animal> findByName(@Param("name") String name);
}
