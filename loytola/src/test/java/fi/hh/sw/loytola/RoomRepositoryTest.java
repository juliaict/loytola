package fi.hh.sw.loytola;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.Room;
import fi.hh.sw.loytola.domain.RoomRepository;
import fi.hh.sw.loytola.domain.RoomKind;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomRepositoryTest {
	
		@Autowired
	    private RoomRepository rrepository;
		
		
		@Test
		public void findByNameShouldReturnRoom() {
			List<Room> rooms = rrepository.findByName("IK-1");
			
			assertThat(rooms).hasSize(1);
			assertThat(rooms.get(0).getCapacity()).isEqualTo(5);
			
		}
		
		@Test
	    public void createNewRoom() {
	   
			Room room = new Room("IK-2", 3, 3, new RoomKind("Isot koirat", 10 ));
	    	rrepository.save(room);
	    	assertThat(room.getRoomId()).isNotNull();
	    } 
		
		@Test
	    public void deleteRoom() {
			Room room = new Room("IK-2", 3, 3, new RoomKind("Isot koirat", 10));
	    	rrepository.save(room);
	    	long idroom = room.getRoomId();
	    	rrepository.delete(room);
	    	assertThat(rrepository.findById(idroom)).isEmpty();
	    } 
	}
