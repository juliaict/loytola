package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.hh.sw.loytola.domain.DepartureCause;


public interface DepartureCauseRepository extends CrudRepository<DepartureCause, Long>{
	List<DepartureCause> findByName(@Param("name") String name);
}
