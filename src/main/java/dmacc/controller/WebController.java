package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Movies;
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
	public String viewMovies(@RequestParam(name="filter", required=false) String filter, Model model) {
		if(filter == null) {
			List<Movies> movies = mRepo.findAll();
			model.addAttribute("movies", movies);
			return"viewMovies";
		}
		// RequestParam will handle if user wants to filter the movies by a certain attribute
		
		return"viewMovies";
	}
	
	
	
}
