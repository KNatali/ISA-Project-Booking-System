package com.isa.ISAproject.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.mapper.UserMapper;
import com.isa.ISAproject.model.User;
import com.isa.ISAproject.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
		// Ukoliko nema, server ce vratiti gresku 403 Forbidden
		// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
		@GetMapping("/user/{userId}")
		
		public User loadById(@PathVariable Long userId) {
			return this.userService.findById(userId);
		}
		
		@GetMapping(value="/getLoggedIn", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    UserDTO getLoggedInUser(Principal user) {
			
			
	        User loggedIn = userService.findByUsername(user.getName());
	        return UserMapper.convertToDTO(loggedIn);

	    }

		@GetMapping("/user/all")
		@PreAuthorize("hasRole('ADMIN')")
		public List<User> loadAll() {
			return this.userService.findAll();
		}

		@GetMapping("/whoami")
		
		public User user(Principal user) {
			return this.userService.findByUsername(user.getName());
		}
		
		@GetMapping("/foo")
	    public Map<String, String> getFoo() {
	        Map<String, String> fooObj = new HashMap<>();
	        fooObj.put("foo", "bar");
	        return fooObj;
	    }
}
