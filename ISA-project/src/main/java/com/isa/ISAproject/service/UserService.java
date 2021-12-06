package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.dto.UserRequest;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Authority;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Role;
import com.isa.ISAproject.model.User;
import com.isa.ISAproject.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientService clientService;;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AddressService addressService;


	
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	public List<User> findAll() throws AccessDeniedException {
		return userRepository.findAll();
	}

	
	public User save(UserDTO userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setFirstName(userRequest.getFirstName());
		u.setLastName(userRequest.getLastName());
		
		u.setEnabled(false);
		u.setEmail(userRequest.getEmail());
		
		Address address=new Address(userRequest.getStreet(),userRequest.getState(),userRequest.getCity());
		Address newAddress=this.addressService.save(address);
		
		u.setAddress(newAddress);
		u.setMobile(userRequest.getMobile());
		u.setRole(userRequest.getRole());

		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		List<Authority> authorities=new ArrayList<>();
		//User newUser=new User();
		Client newClient=new Client();
		if(u.getRole().equalsIgnoreCase("Client")) {
			authorities = authorityService.findByName("ROLE_CLIENT");
			u.setAuthorities(authorities);
			Client client=new Client(u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getAddress(),u.getMobile(),u.isEnabled(),u.getRole(),authorities);
			newClient=this.clientService.save(client);
			u.setId(newClient.getId());
		}
		System.out.println("id iz userService"+ u.getId());
		return u;
	}

}
