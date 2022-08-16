package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.EmailMessageDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.exception.ResourceConflictException;
import com.isa.ISAproject.model.AppUser;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserService userService;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
	 */
	@Async
	public void sendNotificaitionAsync(UserDTO userRequest) throws MailException, InterruptedException {
		System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");
		//deo iz Authetication controller
		AppUser existUser = this.userService.findByUsername(userRequest.getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		AppUser user = this.userService.save(userRequest);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Potvrdi svoju registarciju");
		mail.setText("Pozdrav " + user.getFirstName() +",\n Klikni te na naredni kod kako biste aktivirali svoj nalog"+"\n http://localhost:4200/confirm-registration/"+user.getId()+ "\n\nhvala što želiš da postaneš naš član");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	public void sendNotificaitionSync(AppUser user) throws MailException, InterruptedException {
		System.out.println("Sync metoda se izvrsava u istom Threadu koji je i prihvatio zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getFirstName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	public void sendMessageSync(String email,String message) throws MailException, InterruptedException {
		System.out.println("Sync metoda se izvrsava u istom Threadu koji je i prihvatio zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		Thread.sleep(10000);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Fun Booking");
		mail.setText(message);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendAdminMessage(EmailMessageDTO dto) throws MailException, InterruptedException {
		
		Thread.sleep(10000);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(dto.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Fun Booking");
		mail.setText("Your request has been rejected. Here is the reason:"+dto.getMessage());
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	@Async
	public void sendAcceptRegistrationMessage(String email) throws MailException, InterruptedException {
		
		Thread.sleep(10000);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Fun Booking");
		mail.setText("Your registration request has been accepted. Now you can log in!");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	@Async
	public void sendMessage(String email,String message) throws MailException, InterruptedException {
		
		Thread.sleep(10000);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Fun Booking");
		mail.setText(message);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	

	
}
