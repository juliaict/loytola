package fi.hh.sw.loytola;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.sw.loytola.domain.Animal;
import fi.hh.sw.loytola.domain.AnimalKindRepository;
import fi.hh.sw.loytola.domain.AnimalRepository;
import fi.hh.sw.loytola.domain.BreedRepository;
import fi.hh.sw.loytola.domain.RoomRepository;
import fi.hh.sw.loytola.domain.SexRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalRepositoryTest {
	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
    private AnimalRepository arepository;
	
	@Autowired
    private BreedRepository brepository;
	
	@Autowired
    private SexRepository srepository;
	
	@Autowired
    private AnimalKindRepository akrepository;
	
	@Autowired
    private RoomRepository rrepository;
	
	
	@Test
	public void findByNameShouldReturnAnimal() {
		List<Animal> animals = arepository.findByName("Koira2019-1");
		
		assertThat(animals).hasSize(1);
		assertThat(animals.get(0).getAnimalKind()).isEqualTo("Koira");
		
	}
	
	@Test
    public void createNewAnimal() throws ParseException {
		Date dd = df.parse("23-04-2019");
		
		Animal animal =new Animal("Koira2019-1","musta värinen, arvioitu noin 3 vuotta vanha, valkoinen kaulus", dd, akrepository.findByName("Koira").get(0), rrepository.findByName("PK-1").get(0), brepository.findByName("Mopsi").get(0), srepository.findByName("naaras").get(0));
    	arepository.save(animal);
    	assertThat(animal.getAnimalId()).isNotNull();
    } 
	
	@Test
    public void deleteAnimal() throws ParseException {
		Date dd = df.parse("23-04-2019");
		
		Animal animal =new Animal("Koira2019-1","musta värinen, arvioitu noin 3 vuotta vanha, valkoinen kaulus", dd, akrepository.findByName("Koira").get(0), rrepository.findByName("PK-1").get(0), brepository.findByName("Mopsi").get(0), srepository.findByName("naaras").get(0));
    	arepository.save(animal);
    	long idanimal = animal.getAnimalId();
    	arepository.delete(animal);
    	assertThat(arepository.findById(idanimal)).isEmpty();
    } 
}

