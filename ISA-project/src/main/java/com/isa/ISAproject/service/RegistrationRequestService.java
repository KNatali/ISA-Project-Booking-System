package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.mapper.UserMapper;
import com.isa.ISAproject.model.AppUser;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.RegistrationRequest;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.repository.RegistrationRequestRepository;
import com.isa.ISAproject.repository.UserRepository;

@Service
public class RegistrationRequestService {
	
	@Autowired
	private RegistrationRequestRepository registrationRequestRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<RegistrationRequestDTO> findAll() throws AccessDeniedException {
		List<RegistrationRequest> requests=registrationRequestRepository.findAll();
		List<RegistrationRequestDTO> requestsDTO=new ArrayList<>();
	 for (RegistrationRequest r : requests) {
		
			 UserDTO userDTO=UserMapper.convertToDTO(r.getUser());
			 RegistrationRequestDTO dto=new RegistrationRequestDTO(r.getId(),userDTO,r.getReason());
			 requestsDTO.add(dto);
		 
			
		
	 }
	 return requestsDTO;
	}
	
	public void activate(RegistrationRequestDTO requestDTO) {
		/*if(userDTO.getRole()=="Instructor") {
			Instructor instructor=instructorRepository.getById(userDTO.getId());
			
		}*/
		
		AppUser user=userRepository.getById(requestDTO.getUserDTO().getId());
		user.setEnabled(true);
		userRepository.save(user);
		RegistrationRequest request=this.registrationRequestRepository.getById(requestDTO.getId());
		this.registrationRequestRepository.delete(request);
		
	}
	
	public void reject(RegistrationRequestDTO requestDTO) {
		
		AppUser user=userRepository.getById(requestDTO.getUserDTO().getId());
	
		
		RegistrationRequest request=this.registrationRequestRepository.getById(requestDTO.getId());
		this.registrationRequestRepository.delete(request);
		userRepository.delete(user);
		
	}


}
