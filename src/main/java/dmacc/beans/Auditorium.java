package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Noah Hobbs - nhobbs
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Data
@Embeddable
public class Auditorium {
	private int numOfSeats;
	private int roomNum;
	private String roomName;
	
}
