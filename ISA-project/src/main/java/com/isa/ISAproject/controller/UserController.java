package com.isa.ISAproject.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.isa.ISAproject.dto.AdminProfileDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.exception.ResourceConflictException;
import com.isa.ISAproject.mapper.UserMapper;
import com.isa.ISAproject.model.Admin;
import com.isa.ISAproject.model.RegistrationRequest;
import com.isa.ISAproject.model.AppUser;
import com.isa.ISAproject.repository.RegistrationRequestRepository;
import com.isa.ISAproject.service.EmailService;
import com.isa.ISAproject.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE,
consumes=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
@Autowired
private RegistrationRequestRepository reservationRequestRepository;
	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
		// Ukoliko nema, server ce vratiti gresku 403 Forbidden
		// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
		@GetMapping("/user/{userId}")
		
		public AppUser loadById(@PathVariable Long userId) {
			return this.userService.findById(userId);
		}
		
		@GetMapping(value="/getLoggedIn", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    UserDTO getLoggedInUser(Principal user) {
			
			
			AppUser loggedIn = userService.findByUsername(user.getName());
	        return UserMapper.convertToDTO(loggedIn);

	    }

		/*@RequestMapping(value="/user/all",method = RequestMethod.GET,produces=
				MediaType.APPLICATION_JSON_VALUE)
		@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
		public ResponseEntity<List<UserDTO>> getAll(){
			
			List<UserDTO> dto=this.userService.findAll();
			
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		*/

		
		@GetMapping("/foo")
	    public Map<String, String> getFoo() {
	        Map<String, String> fooObj = new HashMap<>();
	        fooObj.put("foo", "bar");
	        return fooObj;
	    }
		@GetMapping
		public String getNew(Model model) {
			model.addAttribute("user", new AppUser());
			return "registration";
		}

		
		@RequestMapping(value="/register",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> register(@RequestBody RegistrationRequestDTO dto){
		
			AppUser existUser = this.userService.findByUsername(dto.getUserDTO().getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(dto.getUserDTO().getId(), "Username already exists");
		}

		AppUser user = this.userService.save(dto.getUserDTO());
		RegistrationRequest request=new RegistrationRequest(dto.getId(),user,dto.getReason());
	this.reservationRequestRepository.save(request);
		RegistrationRequestDTO req=new RegistrationRequestDTO(request.getId(),dto.getUserDTO(),request.getReason());
		return new ResponseEntity<>(HttpStatus.OK);
		
		
		}
		
		@PostMapping("/signup/async")
		public String signUpAsync(@RequestBody UserDTO user){

			//slanje emaila
			try {
				System.out.println("Thread id: " + Thread.currentThread().getId());
				emailService.sendNotificaitionAsync(user);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}

			return "success";
		}
		
		@PostMapping("/signup/sync")//ceka se da se prva radnja zavrsi
		public String signUpSync(UserDTO user){
			System.out.println("Thread id: " + Thread.currentThread().getId());
			//slanje emaila
			try {
				emailService.sendNotificaitionSync(user);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}

			return "success";
		}
		
}
