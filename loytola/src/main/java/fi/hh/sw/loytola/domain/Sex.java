package fi.hh.sw.loytola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sex {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long sexId; 
	 private String name;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "sex")
		private List<Animal> animals;
	 
	 public Sex() {
		super();
			}

	
	public Sex(String name) {
		super();
		this.name = name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}


	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getSexId() {
		return sexId;
	}

	public void setSexId(long sexId) {
		this.sexId = sexId;
	}

	public String getName() {
		return name;
	}

	public void setNAme(String name) {
		this.name = name;
	}


}
