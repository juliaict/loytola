package fi.hh.sw.loytola;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.DepartureCause;
import fi.hh.sw.loytola.domain.DepartureCauseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartureCauseRepositoryTest {
	@Autowired
    private DepartureCauseRepository drepository;
	
	
	@Test
	public void findByNameShouldReturnDepartureCause() {
		List<DepartureCause> departureCauses = drepository.findByName("Vanha omistaja löytynyt");
		
		assertThat(departureCauses).hasSize(1);
			
	}
		
	@Test
    public void createNewDepartureCause() {
   
    	DepartureCause departureCause = new DepartureCause("Omistaja löytynyt");
    	drepository.save(departureCause);
    	assertThat(departureCause.getDepartureCauseId()).isNotNull();
    } 
	
	@Test
    public void deleteDepartureCause() {
		DepartureCause departureCause = new DepartureCause("Omistaja löytynyt");
    	drepository.save(departureCause);
    	long iddepartureCause = departureCause.getDepartureCauseId();
    	drepository.delete(departureCause);
    	assertThat(drepository.findById(iddepartureCause)).isEmpty();
    } 
}
