package dmacc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Movies;
import dmacc.beans.ProgramUsers;
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
	public String editMovie(@RequestParam(name="movie", required=true) long movieId, Model model, ProgramUsers user) {
		Optional<Movies> movie = mRepo.findById(movieId);
		model.addAttribute("movie", movie);
		model.addAttribute("user", user);
		return"editMovie";
	}
	
}
