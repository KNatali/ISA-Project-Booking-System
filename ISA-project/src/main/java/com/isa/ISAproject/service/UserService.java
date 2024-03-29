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
import com.isa.ISAproject.model.Admin;
import com.isa.ISAproject.model.AppUser;
import com.isa.ISAproject.model.Authority;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.Role;
import com.isa.ISAproject.repository.AdminRepository;
import com.isa.ISAproject.repository.BoatOwnerRepository;
import com.isa.ISAproject.repository.CottageOwnerRepository;
import com.isa.ISAproject.repository.InstructorRepository;
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
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;


	
	public AppUser findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public AppUser findById(Long id) throws AccessDeniedException {
		return userRepository.getById(id);
	}

	public List<UserDTO> findAll() throws AccessDeniedException {
		List<AppUser> users=userRepository.findAll();
		List<UserDTO> usersDTO=new ArrayList<>();
	 for (AppUser u : users) {
		 if(!(u.getRole().equalsIgnoreCase("SysAdmin") || u.getRole().equalsIgnoreCase("Admin")|| u.isDeleted())) {
			 UserDTO dto=new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getAddress().getStreet(),u.getAddress().getState(),u.getAddress().getCity(), u.getMobile(), u.getRole(),u.getAddress().getLatitude(),u.getAddress().getLongitude());
			usersDTO.add(dto);
		 }
			
	 }
	 return usersDTO;
	}

	
	public AppUser save(UserDTO userRequest) {
		AppUser u = new AppUser();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setFirstName(userRequest.getFirstName());
		u.setLastName(userRequest.getLastName());
		
		u.setEnabled(false);
		u.setEmail(userRequest.getEmail());
		
		Address address=new Address(userRequest.getStreet(),userRequest.getState(),userRequest.getCity(),userRequest.getLatitude(),userRequest.getLongitude());
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
		else if(u.getRole().equalsIgnoreCase("Admin")) {
			authorities = authorityService.findByName("ROLE_ADMIN");
			u.setAuthorities(authorities);
			Admin admin=new Admin(u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getAddress(),u.getMobile(),true,u.getRole(),authorities,true);
			Admin newAdmin=this.adminRepository.save(admin);
			u.setId(newAdmin.getId());
		}
		
		else if(u.getRole().equalsIgnoreCase("Instructor")) {
			authorities = authorityService.findByName("ROLE_INSTRUCTOR");
			u.setAuthorities(authorities);
			Instructor instructor=new Instructor(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getAddress(),u.getMobile(),false,u.getRole(),authorities,0,null,"");
			Instructor newInstructor=this.instructorRepository.save(instructor);
			u.setId(newInstructor.getId());
		}
		else if(u.getRole().equalsIgnoreCase("CottageOwner")) {
			authorities = authorityService.findByName("ROLE_COTTAGE_OWNER");
			u.setAuthorities(authorities);
			CottageOwner owner=new CottageOwner(u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getAddress(),u.getMobile(),false,u.getRole(),authorities,null);
			CottageOwner newOwner=this.cottageOwnerRepository.save(owner);
			u.setId(newOwner.getId());
		}
		else if(u.getRole().equalsIgnoreCase("BoatOwner")) {
			authorities = authorityService.findByName("ROLE_BOAT_OWNER");
			u.setAuthorities(authorities);
			BoatOwner owner=new BoatOwner(u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getAddress(),u.getMobile(),false,u.getRole(),authorities,null);
			BoatOwner newOwner=this.boatOwnerRepository.save(owner);
			u.setId(newOwner.getId());
		}
		System.out.println("id iz userService"+ u.getId());
		return u;
	}

}
