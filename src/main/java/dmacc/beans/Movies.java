package dmacc.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sterling Rhone - sprhone
 * Noah Hobbs - nhobbs
 * 202102 CIS175 26740
 * Apr 12, 2021
 * This class uses lombok and the spring framework
 */

@Data
@Entity
@NoArgsConstructor
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	private String movieName;
	private LocalDate movieShowDate;
	private LocalTime movieShowTime;
	private String movieRating;
	private int movieTimeMinutes;
	@Autowired
	private Auditorium aud;
	
	
	public Movies(String movieName, String movieRating, int movieTimeMinutes, Auditorium aud) {
		this.movieName = movieName;
		this.movieRating = movieRating;
		this.movieTimeMinutes = movieTimeMinutes;
		this.aud = aud;
	}
	
	

}
