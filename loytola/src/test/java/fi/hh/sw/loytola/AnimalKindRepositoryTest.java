package fi.hh.sw.loytola;



	import static org.assertj.core.api.Assertions.assertThat;


	import java.util.List;

	import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.AnimalKind;
	import fi.hh.sw.loytola.domain.AnimalKindRepository;

	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class AnimalKindRepositoryTest {
		@Autowired
	    private AnimalKindRepository akrepository;
		
				
		@Test
		public void findByNimeShouldReturnAnimalKind() {
			List<AnimalKind> animalKinds = akrepository.findByName("Koira");
			
			assertThat(animalKinds).hasSize(1);
				
		}
		
		@Test
	    public void createNewAnimal() {
			
			AnimalKind animalKind = new AnimalKind("Kani");
	    	akrepository.save(animalKind);
	    	assertThat(animalKind.getAnimalKindId()).isNotNull();
	    } 
		
		@Test
	    public void deleteAnimalKind() {
			AnimalKind animalKind = new AnimalKind("Kani");
	    	akrepository.save(animalKind);
	    	long idanimalKind = animalKind.getAnimalKindId();
	    	akrepository.delete(animalKind);
	    	assertThat(akrepository.findById(idanimalKind)).isEmpty();
	    } 
	}

