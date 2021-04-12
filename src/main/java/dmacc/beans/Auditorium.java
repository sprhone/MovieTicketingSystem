package dmacc.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Noah Hobbs - nhobbs
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Data
@Entity
@Embeddable
public class Auditorium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long audId;
	private int numOfSeats;
	private int roomNum;
	private String roomName;
	
}
