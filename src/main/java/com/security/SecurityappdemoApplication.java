package com.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.security.dao.TaskRepository;
import com.security.entities.AppRole;
import com.security.entities.AppUser;
import com.security.entities.Task;
import com.security.service.AccountService;

@SpringBootApplication
public class SecurityappdemoApplication implements CommandLineRunner {
	  @Autowired
		private AccountService accountService;
	@Autowired
    private TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityappdemoApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.saveUser(new AppUser("admin", "1234",1,null));
		accountService.saveUser(new AppUser("user", "1234",1,null));
		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("user", "USER");
		accountService.addRoleToUser("admin", "USER");

		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t));
			});
			taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
			});
			
	}
	

}
