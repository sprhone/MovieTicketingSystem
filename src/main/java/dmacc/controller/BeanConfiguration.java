package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Auditorium;
import dmacc.beans.EditForm;
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
		//Customer Bean
		bean.setUserType("Customer");
		bean.setUserName("Freddy Kruger");
		bean.setUserAccess("Base");
		return bean;
	}
	
	@Bean
	public ProgramUsers programUsers1() {
		ProgramUsers bean = new ProgramUsers();
		//Admin/manager bean
		bean.setUserType("Admin");
		bean.setUserName("Admin");
		bean.setUserAccess("Admin");
		Passwords psw = new Passwords();
		psw.setPassword("admin");
		bean.setUserPassword(psw);
		return bean;
	}
	
	@Bean
	public Auditorium  auditorium() {
		Auditorium bean = new Auditorium();
		return bean;
	}
	
	@Bean
	public EditForm editForm() {
		EditForm bean = new EditForm();
		return bean;
	}
}
