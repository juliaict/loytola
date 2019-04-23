package fi.hh.sw.loytola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long roomId; 
	 private String name;
	 private int capacity;
	 private int free;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "roomKindId")
	 private RoomKind roomKind;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
		private List<Animal> animals;
	
	 public Room() {
		super();
			}

	 
	
	public Room(String name, int capacity, int free) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.free = free;
	}

	public Room(String name, int capacity, int free, RoomKind roomKind) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.free = free;
		this.roomKind = roomKind;
	}

	public List<Animal> getAnimals() {
		return animals;
	}



	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}



	public RoomKind getRoomKind() {
		return roomKind;
	}



	public void setRoomKind(RoomKind roomKind) {
		this.roomKind = roomKind;
	}



	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public Number getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}



	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", name=" + name + ", capacity=" + capacity + ", free=" + free + ", roomKind="
				+ roomKind + "]";
	}
	 
	
}
