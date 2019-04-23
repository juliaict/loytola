package fi.hh.sw.loytola;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.Sex;
import fi.hh.sw.loytola.domain.SexRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SexRepositoryTest {
	@Autowired
    private SexRepository srepository;
	
	
	@Test
	public void findByNameShouldReturnSex() {
		List<Sex> sexs = srepository.findByName("uros");
		assertThat(sexs).hasSize(1);
	}
		
	@Test
    public void createNewSex() {
   
		Sex sex = new Sex("Tuntematon");
    	srepository.save(sex);
    	assertThat(sex.getSexId()).isNotNull();
    } 
	
	@Test
    public void deleteSex() {
		Sex sex = new Sex("Tuntematon");
    	srepository.save(sex);
    	long idsex = sex.getSexId();
    	srepository.delete(sex);
    	assertThat(srepository.findById(idsex)).isEmpty();
    } 
}