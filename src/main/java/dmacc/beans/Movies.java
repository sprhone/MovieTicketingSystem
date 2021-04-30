package dmacc.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@Column(columnDefinition = "date")
	private LocalDate movieShowDate;
	@Column(columnDefinition = "time")
	private LocalTime movieShowTime;
	private String movieRating;
	private int movieTimeMinutes;
	@ManyToOne
	private Auditorium aud;
	
	
	public Movies(String movieName, String movieRating, int movieTimeMinutes, Auditorium aud) {
		//constructor with 4 args
		this.movieName = movieName;
		this.movieRating = movieRating;
		this.movieTimeMinutes = movieTimeMinutes;
		this.aud = aud;
	}


	public Movies(String movieName, LocalDate movieShowDate, LocalTime movieShowTime, String movieRating,
			int movieTimeMinutes, Auditorium aud) {
		super();
		//constructor with 6 args
		this.movieName = movieName;
		this.movieShowDate = movieShowDate;
		this.movieShowTime = movieShowTime;
		this.movieRating = movieRating;
		this.movieTimeMinutes = movieTimeMinutes;
		this.aud = aud;
	}
	
	

}
