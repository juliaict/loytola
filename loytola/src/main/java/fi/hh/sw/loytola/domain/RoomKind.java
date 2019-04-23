package fi.hh.sw.loytola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RoomKind {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long roomKindId; 
	 private String name;
	 private int dateprice;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomKind")
		private List<Room> rooms;
	
	 public RoomKind() {
		super();
			}
 
	
	public RoomKind(String name, int dateprice) {
		super();
		this.name = name;
		this.dateprice = dateprice;
	}

	public List<Room> getRooms() {
		return rooms;
	}


	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}


	public long getRoomKindId() {
		return roomKindId;
	}


	public long getRoomKIndId() {
		return roomKindId;
	}

	public void setRoomKindId(long roomKindId) {
		this.roomKindId = roomKindId;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public int getDateprice() {
		return dateprice;
	}

	public void setDateprice(int dateprice) {
		this.dateprice = dateprice;
	}
	 
}
