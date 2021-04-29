package dmacc.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Auditorium;
import dmacc.beans.EditForm;
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
	public String editMovie(@RequestParam(name="movie", required=false) String movieId, Model model, ProgramUsers user) {
		List<Auditorium> auditoriums = aRepo.findAll();
		model.addAttribute("auditoriums", auditoriums);
		long movieID = Long.parseLong(movieId);
		if(movieID > 0) {
			Movies movie = mRepo.getOne(movieID);
			model.addAttribute("movie", movie);
		}
		else {
			Movies newMovie = new Movies();
			model.addAttribute("movie", newMovie);
		}
		model.addAttribute("user", user);
		return"editMovie";
	}
	
	@PostMapping("/saveEdit")
	public String saveEdit(Model model, ProgramUsers user, @ModelAttribute EditForm form1) {
		long id = Long.parseLong(form1.getId());
		String name = form1.getName();
		LocalDate date = LocalDate.parse(form1.getDate());
		LocalTime time = LocalTime.parse(form1.getTime());
		String rating = form1.getRating();
		int minutes =  Integer.parseInt(form1.getMinutes());
		long auditoriumNum = Long.parseLong(form1.getAuditorium());
		Auditorium auditorium = aRepo.getOne(auditoriumNum);
		
		if(!(id > 0)) {// create movie
			Movies newMovie = new Movies(name, date, time, rating, minutes, auditorium);
			mRepo.save(newMovie);
		}
		else { // edit existing movie
			Movies movieE = mRepo.getOne(id);
			movieE.setMovieName(name);
			movieE.setMovieRating(rating);
			movieE.setMovieShowDate(date);
			movieE.setMovieShowTime(time);
			movieE.setMovieTimeMinutes(minutes);
			movieE.setAud(auditorium);
			mRepo.save(movieE);
		}
		model.addAttribute("user", user);
		return "redirect:/viewMovies?";
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
		
		@PostMapping("/delete")
		public String deleteMovie(@ModelAttribute EditForm form2, ProgramUsers user) {
			mRepo.deleteById(Long.parseLong(form2.getId()));
			return "redirect:/viewMovies?";
		}
			
}
