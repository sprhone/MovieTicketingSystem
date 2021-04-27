package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Noah Hobbs - ndhobbs
 * 202102 CIS175 26740
 * Apr 12, 2021
 * This class is embedded into the movies class
 * It uses lombok and the spring framework
 */

@Data
@Entity
@NoArgsConstructor
public class Auditorium {
	private int numOfSeats;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long audId;
	private String roomName;
	
	
	public Auditorium(int numOfSeats, long audId, String roomName) {
		this.numOfSeats = numOfSeats;
		this.audId = audId;
		this.roomName = roomName;
	}
}
