package fi.hh.sw.loytola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.hh.sw.loytola.domain.Room;


public interface RoomRepository extends CrudRepository<Room, Long>{
	List<Room> findByName(@Param("name") String name);
	int free=0;
	List<Room> findByFreeGreaterThan(int free);	
}
