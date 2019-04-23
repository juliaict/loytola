package fi.hh.sw.loytola;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.Breed;
import fi.hh.sw.loytola.domain.BreedRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BreedRepositoryTest {
	@Autowired
    private BreedRepository brepository;
	
	
	@Test
	public void findByNameShouldReturnBreed() {
		List<Breed> breeds = brepository.findByName("Mopsi");
		
		assertThat(breeds).hasSize(1);
			
	}
		
	@Test
    public void createNewBreed() {
   
		Breed breed = new Breed("Taksa");
    	brepository.save(breed);
    	assertThat(breed.getBreedId()).isNotNull();
    } 
	
	@Test
    public void deleteBreed() {
		Breed breed = new Breed("Taksa");
    	brepository.save(breed);
    	long idbreed = breed.getBreedId();
    	brepository.delete(breed);
    	assertThat(brepository.findById(idbreed)).isEmpty();
    } 
}
