package fi.hh.sw.loytola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DepartureCause {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long departureCauseId; 
	 private String name;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "departureCause")
		private List<Animal> animals;
	 
	 public DepartureCause() {
		super();
	}

	
	public DepartureCause(String name) {
		super();
		this.name = name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}


	public long getDepartureCauseId() {
		return departureCauseId;
	}

	public void setDepartureCauseId(long departureCauseId) {
		this.departureCauseId = departureCauseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	 
}
