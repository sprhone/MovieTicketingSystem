package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Data
@Entity
public class ProgramUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userType;	//Employee or Customer or Manager(can edit employees)
	private String userAccess;	//Do they get elevated access? Edit level or view only
	private String userName;
	@Autowired
	private Passwords userPassword;
}
