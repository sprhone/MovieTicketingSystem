package dmacc.beans;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditForm {
	private String id;
	private String name;
	private String date;
	private String time;
	private String rating;
	private String minutes;
	private String auditorium;
	public EditForm(String id, String name, String date, String time, String rating, String minutes, String auditorium) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.rating = rating;
		this.minutes = minutes;
		this.auditorium = auditorium;
	}
}
