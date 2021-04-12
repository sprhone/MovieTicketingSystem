package dmacc.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import lombok.Data;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Data
@Entity
@Embeddable
public class Passwords {
	private String password;
}
