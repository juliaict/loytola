package fi.hh.sw.loytola.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long animalId;
	 private String name;
	 private String description;
	 
	 private Date foundDate;
	 private Date departureDate;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "animalKindId")
	 private AnimalKind animalKind;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "roomId")
	 private Room room;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "breedId")
	 private Breed breed;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "sexId")
	 private Sex sex;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "departureCauseId")
	 private DepartureCause departureCause;
	
	 public Animal() {
		super();
			}

	public Animal(String name, String description, Date foundDate, AnimalKind animalKind, Room room, Breed breed,
			Sex sex) {
		super();
		this.name = name;
		this.description = description;
		this.foundDate = foundDate;
		this.animalKind = animalKind;
		this.room = room;
		this.breed = breed;
		this.sex = sex;
	}




	public AnimalKind getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(AnimalKind animalKind) {
		this.animalKind = animalKind;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public DepartureCause getDepartureCause() {
		return departureCause;
	}

	public void setDepartureCause(DepartureCause departureCause) {
		this.departureCause = departureCause;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	 
	 
	 
	 
}
