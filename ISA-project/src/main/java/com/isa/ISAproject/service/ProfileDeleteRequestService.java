package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.mapper.UserMapper;
import com.isa.ISAproject.model.ProfileDeleteRequest;
import com.isa.ISAproject.model.RegistrationRequest;
import com.isa.ISAproject.model.User;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.repository.ProfileDeleteRequestRepository;
import com.isa.ISAproject.repository.UserRepository;

@Service
public class ProfileDeleteRequestService {
	@Autowired
	private ProfileDeleteRequestRepository profileDeleteRequestRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ProfileDeleteRequestDTO sendProfileDeleteRequest(ProfileDeleteRequestDTO dto) {
		
		User existUser = this.userRepository.getById(dto.getUserDTO().getId());
		UserDTO userDTO=UserMapper.convertToDTO(existUser);
		ProfileDeleteRequest request=new ProfileDeleteRequest(dto.getId(),existUser,dto.getReason());
		this.profileDeleteRequestRepository.save(request);
		ProfileDeleteRequestDTO req=new ProfileDeleteRequestDTO(request.getId(),userDTO,request.getReason());
		return req;
	}
	
	public List<ProfileDeleteRequestDTO> findAll() throws AccessDeniedException {
		List<ProfileDeleteRequest> requests=profileDeleteRequestRepository.findAll();
		List<ProfileDeleteRequestDTO> requestsDTO=new ArrayList<>();
		for (ProfileDeleteRequest r : requests) {
			UserDTO userDTO=UserMapper.convertToDTO(r.getUser());
			ProfileDeleteRequestDTO dto=new ProfileDeleteRequestDTO(r.getId(),userDTO,r.getReason());
			requestsDTO.add(dto);
		
	 }
	 return requestsDTO;
	}
	
	public void acceptDeleteRequest(ProfileDeleteRequestDTO requestDTO) {
		User user=userRepository.getById(requestDTO.getUserDTO().getId());
		user.setEnabled(false);
		userRepository.save(user);
		//userRepository.delete(user);
		ProfileDeleteRequest request=this.profileDeleteRequestRepository.getById(requestDTO.getId());
		this.profileDeleteRequestRepository.delete(request);
		
	}
	
public void rejectDeleteRequest(ProfileDeleteRequestDTO requestDTO) {
		
		User user=userRepository.getById(requestDTO.getUserDTO().getId());
	
		
		ProfileDeleteRequest request=this.profileDeleteRequestRepository.getById(requestDTO.getId());
		this.profileDeleteRequestRepository.delete(request);
		
		
	}
}
