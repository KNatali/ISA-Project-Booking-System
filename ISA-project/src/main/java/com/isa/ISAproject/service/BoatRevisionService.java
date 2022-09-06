package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.BoatRevisionDTO;
import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.mapper.BoatReservationMapper;
import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.BoatRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.model.RevisionType;
import com.isa.ISAproject.repository.AdventureRevisionRepository;
import com.isa.ISAproject.repository.BoatRevisionRepository;
import com.isa.ISAproject.repository.RevisionRepository;

@Service
public class BoatRevisionService {
	
	@Autowired
	private BoatRevisionRepository boatRevisionRepository;
	@Autowired
	private RevisionRepository revisionRepository;
	@Autowired
	private EmailService emailService;
	
	
	public List<BoatRevisionDTO> getAll() {
		List<BoatRevision> revisions=boatRevisionRepository.findAll();
		List<BoatRevisionDTO> revisionsDTO=new  ArrayList<>();
		for (BoatRevision r : revisions) {
			if(r.getRevision().getType()== RevisionType.Unchecked) {
				RevisionDTO revision=new RevisionDTO(r.getRevision().getId(),r.getRevision().getGrade(),r.getRevision().getRevision(),r.getRevision().getType());
				
				BoatReservationDTO reservation=BoatReservationMapper.convertToDTO(r.getBoatReservation());
				BoatRevisionDTO rDTO=new BoatRevisionDTO(r.getId(),reservation,revision);
				revisionsDTO.add(rDTO);
			}
			
		}
		return revisionsDTO;
	}
	
	public List<BoatRevisionDTO> getAllByAdventure(Long boatId) {
		List<BoatRevision> revisions=boatRevisionRepository.findAll();
		List<BoatRevisionDTO> revisionsDTO=new  ArrayList<>();
		for (BoatRevision r : revisions) {
			if(r.getBoatReservation().getBoat().getId().equals(boatId)) {
				RevisionDTO revision=new RevisionDTO(r.getRevision().getId(),r.getRevision().getGrade(),r.getRevision().getRevision(),r.getRevision().getType());
				
				BoatReservationDTO reservation=BoatReservationMapper.convertToDTO(r.getBoatReservation());
				BoatRevisionDTO rDTO=new BoatRevisionDTO(r.getId(),reservation,revision);
				revisionsDTO.add(rDTO);
			}
			
		}
		return revisionsDTO;
	}
	
	public void acceptBoatRevision(BoatRevisionDTO dto) throws MailException, InterruptedException {
		BoatRevision adventureRevision=boatRevisionRepository.getById(dto.getId());
		Revision revision=revisionRepository.getById(adventureRevision.getRevision().getId());
		revision.setType(RevisionType.Accepted);
		revisionRepository.save(revision);
		emailService.sendMessage(adventureRevision.getBoatReservation().getBoat().getOwner().getEmail(),"CLient left revision about your adventure:"+adventureRevision.getBoatReservation().getBoat().getName()+". Check out your profile!");
		
		
	}
	
	public void rejectBoatRevision(BoatRevisionDTO dto) {
		BoatRevision adventureRevision=boatRevisionRepository.getById(dto.getId());
		Revision revision=revisionRepository.getById(adventureRevision.getRevision().getId());
		revision.setType(RevisionType.Rejected);
		revisionRepository.save(revision);
		
	}
	public BoatRevision save(BoatRevision newRevision) {
		return this.boatRevisionRepository.save(newRevision);
	}
	


}
