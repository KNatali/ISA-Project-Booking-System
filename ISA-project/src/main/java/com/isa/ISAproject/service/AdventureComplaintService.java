package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OptimisticLockException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.controller.UserController;
import com.isa.ISAproject.dto.AdventureComplaintDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.AdventureComplaint;
import com.isa.ISAproject.repository.AdventureComplaintRepository;

@Service
public class AdventureComplaintService {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private AdventureComplaintRepository adventureComplaintRespository;
	@Autowired
	private EmailService emailService;
	
	public List<AdventureComplaintDTO> getAdventureComplaints(){
		List<AdventureComplaint> complaints=adventureComplaintRespository.findAll();
		List<AdventureComplaintDTO> res=new ArrayList<>();
		if(complaints!=null) {
			for (AdventureComplaint c : complaints) {
				ClientProfileDTO client=new ClientProfileDTO(c.getClient());
				AdventureDTO adventure=AdventureMapper.convertToDTO(c.getAdventure());
				AdventureComplaintDTO cDTO=new AdventureComplaintDTO(c.getId(),c.getDescription(),client,adventure);
				res.add(cDTO);
			}
		}
		
		
		return res;
		
	}
	
	public void answerAdventureComplaints(AdventureComplaintDTO dto,String message) throws MailException, InterruptedException,OptimisticLockException {
		
				
					System.out.println("Thread id: " + Thread.currentThread().getId());
					emailService.sendMessage(dto.getClient().getEmail(),message);
				
					
				
		
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendMessage(dto.getAdventure().getInstructor().getEmail(),message);
	
		
	
		AdventureComplaint ac=adventureComplaintRespository.getById(dto.getId());
		adventureComplaintRespository.delete(ac);
		
		
		
		
	}

}
