package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.controller.BeanConfiguration;
import dmacc.beans.Auditorium;
import dmacc.beans.Movies;
import dmacc.beans.ProgramUsers;
import dmacc.repository.MoviesRepository;
import dmacc.repository.ProgramUsersRepository;

@SpringBootApplication
public class MovieTicketingSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketingSystemApplication.class, args);
		
	}
	
	@Autowired
	ProgramUsersRepository pRepo;
	
	@Autowired
	MoviesRepository mRepo;
	
	@Override
	public void run(String...args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		ProgramUsers pu = appContext.getBean("programUsers", ProgramUsers.class);
		pu.setUserName("JimmyBobs");
		//pRepo.save(pu);
		
		ProgramUsers d = new ProgramUsers("Customer", "Base", "Jimmy Bobs");
		//pRepo.save(d);
		List<ProgramUsers> allMyUsers = pRepo.findAll();
		for(ProgramUsers people: allMyUsers) {
			System.out.println(people.toString());
		}
	
		
		((AbstractApplicationContext) appContext).close();
		
		
		

	}
}

