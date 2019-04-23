package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.hh.sw.loytola.domain.Sex;


public interface SexRepository extends CrudRepository<Sex, Long>{
	List<Sex> findByName(@Param("name") String name);
}
