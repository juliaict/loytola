package fi.hh.sw.loytola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Breed {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long breedId; 
	 private String name;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "breed")
		private List<Animal> animals;
	
	 public Breed() {
		super();
			}

	public Breed (String name) {
		super();
		this.name = name;
		}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public long getBreedId() {
		return breedId;
	}

	public void setBreedId(long breedId) {
		this.breedId = breedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
	 
	 
	 
	 

