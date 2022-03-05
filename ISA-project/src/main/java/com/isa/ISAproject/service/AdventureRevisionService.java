package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.model.RevisionType;
import com.isa.ISAproject.repository.AdventureRevisionRepository;
import com.isa.ISAproject.repository.RevisionRepository;

@Service
public class AdventureRevisionService {
	@Autowired
	private AdventureRevisionRepository adventureRevisionRepository;
	@Autowired
	private RevisionRepository revisionRepository;
	@Autowired
	private EmailService emailService;
	
	
	public List<AdventureRevisionDTO> getAll() {
		List<AdventureRevision> revisions=adventureRevisionRepository.findAll();
		List<AdventureRevisionDTO> revisionsDTO=new  ArrayList<>();
		for (AdventureRevision r : revisions) {
			
			RevisionDTO revision=new RevisionDTO(r.getRevision().getId(),r.getRevision().getGrade(),r.getRevision().getRevision(),r.getRevision().getType());
			
			AdventureReservationDTO reservation=AdventureReservationMapper.convertToDTO(r.getAdventureReservation());
			AdventureRevisionDTO rDTO=new AdventureRevisionDTO(r.getId(),reservation,revision);
			revisionsDTO.add(rDTO);
			}
		return revisionsDTO;
	}
	
	public List<AdventureRevisionDTO> getAllByAdventure(Long adventureId) {
		List<AdventureRevision> revisions=adventureRevisionRepository.findAll();
		List<AdventureRevisionDTO> revisionsDTO=new  ArrayList<>();
		for (AdventureRevision r : revisions) {
			if(r.getAdventureReservation().getAdventure().getId()==adventureId) {
				RevisionDTO revision=new RevisionDTO(r.getRevision().getId(),r.getRevision().getGrade(),r.getRevision().getRevision(),r.getRevision().getType());
				
				AdventureReservationDTO reservation=AdventureReservationMapper.convertToDTO(r.getAdventureReservation());
				AdventureRevisionDTO rDTO=new AdventureRevisionDTO(r.getId(),reservation,revision);
				revisionsDTO.add(rDTO);
			}
			
		}
		return revisionsDTO;
	}
	
	public void acceptAdventureRevision(AdventureRevisionDTO dto) throws MailException, InterruptedException {
		AdventureRevision adventureRevision=adventureRevisionRepository.getById(dto.getId());
		Revision revision=revisionRepository.getById(adventureRevision.getRevision().getId());
		revision.setType(RevisionType.Accepted);
		revisionRepository.save(revision);
		emailService.sendMessage(adventureRevision.getAdventureReservation().getAdventure().getInstructor().getEmail(),"CLient left revision about your adventure:"+adventureRevision.getAdventureReservation().getAdventure().getName()+". Check out your profile!");
		
		
	}
	
	public void rejectAdventureRevision(AdventureRevisionDTO dto) {
		AdventureRevision adventureRevision=adventureRevisionRepository.getById(dto.getId());
		Revision revision=revisionRepository.getById(adventureRevision.getRevision().getId());
		revision.setType(RevisionType.Rejected);
		revisionRepository.save(revision);
		
	}
	
	public AdventureRevision save(AdventureRevision newRevision) {
		return this.adventureRevisionRepository.save(newRevision);
	}
	

	

}
