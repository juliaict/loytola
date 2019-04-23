package fi.hh.sw.loytola;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.RoomKind;
import fi.hh.sw.loytola.domain.RoomKindRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomKindRepositoryTest {
	@Autowired
    private RoomKindRepository rkrepository;
	
	
	@Test
	public void findByNameShouldReturnRoomKind() {
		List<RoomKind> roomKinds = rkrepository.findByName("Pienet koirat");
		
		assertThat(roomKinds).hasSize(1);
		assertThat(roomKinds.get(0).getDateprice()).isEqualTo(10);
		
	}
		
	@Test
    public void createNewRoomKind() {
   
		RoomKind roomKind = new RoomKind("Kanit", 10);
    	rkrepository.save(roomKind);
    	assertThat(roomKind.getRoomKindId()).isNotNull();
    } 
	
	@Test
    public void deleteRoomKind() {
		RoomKind roomKind = new RoomKind("Kanit", 10);
    	rkrepository.save(roomKind);
    	long idroomKind = roomKind.getRoomKindId();
    	rkrepository.delete(roomKind);
    	assertThat(rkrepository.findById(idroomKind)).isEmpty();
    } 
}


