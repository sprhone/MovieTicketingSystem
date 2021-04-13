package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Auditorium;
import dmacc.beans.Movies;
import dmacc.beans.Passwords;
import dmacc.beans.ProgramUsers;

/**
 * Sterling Rhone - sprhone
 * Noah Hobbs - nhobbs
 * 202102 CIS175 26740
 * Apr 12, 2021
 */

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Movies movies() {
		Movies bean = new Movies();
		return bean;
	}
	
	@Bean
	public Passwords passwords() {
		Passwords bean = new Passwords();
		return bean;
	}
	
	@Bean
	public ProgramUsers programUsers() {
		ProgramUsers bean = new ProgramUsers();
		bean.setUserType("Customer");
		bean.setUserName("Freddy Kruger");
		bean.setUserAccess("Base");
		return bean;
	}
	
	@Bean
	public Auditorium  auditorium() {
		Auditorium bean = new Auditorium();
		return bean;
	}
}
