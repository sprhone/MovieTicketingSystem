package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
}
