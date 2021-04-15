package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Noah Hobbs - ndhobbs
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Data
@Embeddable
@NoArgsConstructor
public class Auditorium {
	private int numOfSeats;
	private int roomNum;
	private String roomName;
	
	
	public Auditorium(int numOfSeats, int roomNum, String roomName) {
		this.numOfSeats = numOfSeats;
		this.roomNum = roomNum;
		this.roomName = roomName;
	}
}
