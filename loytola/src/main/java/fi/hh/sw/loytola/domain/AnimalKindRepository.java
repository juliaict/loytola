package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnimalKindRepository extends CrudRepository<AnimalKind, Long>{
	List<AnimalKind> findByName(@Param("name") String name);
}
