package dmacc.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Auditorium;
import dmacc.beans.Movies;
import dmacc.beans.ProgramUsers;
import dmacc.repository.AuditoriumRepository;
import dmacc.repository.MoviesRepository;
import dmacc.repository.ProgramUsersRepository;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Controller
public class WebController {
	@Autowired
	MoviesRepository mRepo;
	
	@Autowired
	ProgramUsersRepository pRepo;
	
	@Autowired
	AuditoriumRepository aRepo;
	
	@GetMapping("/viewMovies")
	public String viewMovies(@RequestParam(name="filter", required=false) String filter, Model model, ProgramUsers user) {
		if(filter == null) {
			List<Movies> movies = mRepo.findAll();
			model.addAttribute("movies", movies);
			model.addAttribute("user", user);
			return"viewMovies";
		}
		// RequestParam will handle if user wants to filter the movies by a certain attribute
		return"viewMovies";
	}
	
	@GetMapping("/editMovie")
	public String editMovie(@RequestParam(name="movie", required=false) long movieId, Model model, ProgramUsers user) {
		if(movieId > 0) {
			Optional<Movies> movie = mRepo.findById(movieId);
			model.addAttribute("movie", movie);
		}
		else {
			Movies newMovie = new Movies();
			model.addAttribute("movie", newMovie);
		}
		model.addAttribute("user", user);
		return"editMovie";
	}
	
	@GetMapping("/saveEdit")
	public String saveEdit(Movies movie, Model model, ProgramUsers user) {
		String name = model.getAttribute("name").toString();
		LocalDate date = LocalDate.parse(model.getAttribute("date").toString());
		LocalTime time = LocalTime.parse(model.getAttribute("time").toString());
		String rating = model.getAttribute("rating").toString();
		int minutes =  Integer.parseInt(model.getAttribute("minutes").toString());
		long auditoriumNum = Integer.parseInt(model.getAttribute("auditorium").toString());
		Auditorium auditorium = aRepo.getOne(auditoriumNum);
		
		if(!(movie.getMovieId() > 0)) {// create movie
			Movies newMovie = new Movies(name, date, time, rating, minutes/*, auditorium*/);
			mRepo.save(newMovie);
		}
		else { // edit existing movie
			movie.setMovieName(name);
			movie.setMovieRating(rating);
			movie.setMovieShowDate(date);
			movie.setMovieShowTime(time);
			movie.setMovieTimeMinutes(minutes);
			//movie.setAud(auditorium);
			mRepo.save(movie);
		}
		model.addAttribute("user", user);
		return "viewMovies?";
	}
			
		@GetMapping("/addCustomer")
		public String addNewCustomer (Model model) {
			ProgramUsers pu = new ProgramUsers();
			model.addAttribute("newProgramUser", pu);
			return "addCustomer";
		}
		
		@PostMapping("/addCustomer")
		public String addNewCustomer(@ModelAttribute ProgramUsers pu, Model model) {
			pRepo.save(pu);
			return addNewCustomer(model);
		}
}
