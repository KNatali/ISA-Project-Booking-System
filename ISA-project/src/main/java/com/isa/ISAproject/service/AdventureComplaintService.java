package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OptimisticLockException;
import javax.persistence.PessimisticLockException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.ISAproject.controller.UserController;
import com.isa.ISAproject.dto.AdventureComplaintDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.ComplaintAnswerDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.AdventureComplaint;
import com.isa.ISAproject.model.AppUser;
import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.ComplaintType;
import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.model.ProfileDeleteRequestType;
import com.isa.ISAproject.repository.AdventureComplaintRepository;
import com.isa.ISAproject.repository.BoatComplaintRepository;
import com.isa.ISAproject.repository.CottageComplaintRepository;
import com.isa.ISAproject.repository.UserRepository;

@Service
public class AdventureComplaintService {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private AdventureComplaintRepository adventureComplaintRespository;
	@Autowired
	private BoatComplaintRepository boatComplaintRespository;
	@Autowired
	private CottageComplaintRepository cottageComplaintRespository;
	
	@Autowired
	private UserRepository userRespository;

	@Autowired
	private EmailService emailService;
	
	public List<AdventureComplaintDTO> getAdventureComplaints(){
		List<AdventureComplaint> complaints=adventureComplaintRespository.findAll();
		List<AdventureComplaintDTO> res=new ArrayList<>();
		if(complaints!=null) {
			for (AdventureComplaint c : complaints) {
				if(c.getType()==ComplaintType.Default) {
					ClientProfileDTO client=new ClientProfileDTO(c.getClient());
					AdventureDTO adventure=AdventureMapper.convertToDTO(c.getAdventure());
					AdventureComplaintDTO cDTO=new AdventureComplaintDTO(c.getId(),c.getDescription(),client,adventure);
					res.add(cDTO);
				}
			}
		}
		
		return res;
	}
	
	@Transactional(readOnly = false)
	public void answerAdventureComplaints(AdventureComplaintDTO dto,String message) throws MailException, InterruptedException,PessimisticLockException {
		AdventureComplaint ac=adventureComplaintRespository.findOneById(dto.getId());
		ac.setType(ComplaintType.Answered);
		this.adventureComplaintRespository.save(ac);
		
		emailService.sendMessageSync(dto.getClient().getEmail(),message);
	
		emailService.sendMessageSync(dto.getAdventure().getInstructor().getEmail(),message);
		
	}
	
	@Transactional(readOnly = false)
	public void answerComplaint(ComplaintAnswerDTO dto) throws MailException, InterruptedException,PessimisticLockException {
		AppUser client=this.userRespository.getById(dto.getClientId());
		AppUser owner=this.userRespository.getById(dto.getOwnerId());
		if(dto.getType().equals(new String("Adventure"))) {
			
			AdventureComplaint ac=adventureComplaintRespository.findOneById(dto.getId());
			ac.setType(ComplaintType.Answered);
			this.adventureComplaintRespository.save(ac);
		}
		else if(dto.getType().equals(new String("Boat"))){
			BoatComplaint bc=boatComplaintRespository.findOneById(dto.getId());
			bc.setType(ComplaintType.Answered);
			this.boatComplaintRespository.save(bc);
		}
		else if(dto.getType().equals(new String("Cottage"))) {
			CottageComplaint cc=cottageComplaintRespository.findOneById(dto.getId());
			cc.setType(ComplaintType.Answered);
			this.cottageComplaintRespository.save(cc);
		}
		
		emailService.sendMessageSync(client.getEmail(),dto.getMessageClient());
		emailService.sendMessageSync(owner.getEmail(),dto.getMessageOwner());
		
	}
	
	
	public AdventureComplaint save(AdventureComplaint newAdventureComplaint) {
		return this.adventureComplaintRespository.save(newAdventureComplaint);
	}

}
