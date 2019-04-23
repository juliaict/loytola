package fi.hh.sw.loytola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AnimalKind {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long animalKindId; 
	 private String name;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalKind")
		private List<Animal> animals;
	
	 public AnimalKind() {
		super();
			}

	public AnimalKind (String name) {
		super();
		this.name = name;
		
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public long getAnimalKindId() {
		return animalKindId;
	}

	public void setAnimalKindId(long animalKindId) {
		this.animalKindId = animalKindId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
	 
	 
	 
	 

