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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int numOfSeats = 0;
	private String roomName;
	
	
	public Auditorium(int numOfSeats, String roomName) {
		this.numOfSeats = numOfSeats;
		this.roomName = roomName;
	}
}
