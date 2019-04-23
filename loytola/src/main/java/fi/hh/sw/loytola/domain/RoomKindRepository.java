package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomKindRepository extends CrudRepository<RoomKind, Long>{
	List<RoomKind> findByName(@Param("name") String name);
}
