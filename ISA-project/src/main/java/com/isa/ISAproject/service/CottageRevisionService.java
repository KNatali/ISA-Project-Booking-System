package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.CottageRevisionDTO;
import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.CottageRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.model.RevisionType;
import com.isa.ISAproject.repository.CottageRevisionRepository;
import com.isa.ISAproject.repository.RevisionRepository;

@Service
public class CottageRevisionService {

	@Autowired
	private CottageRevisionRepository cottageRevisionRepository;
	@Autowired
	private RevisionRepository revisionRepository;
	@Autowired
	private EmailService emailService;
	
	
	public List<CottageRevisionDTO> getAll() {
		List<CottageRevision> revisions=cottageRevisionRepository.findAll();
		List<CottageRevisionDTO> revisionsDTO=new  ArrayList<>();
		for (CottageRevision r : revisions) {
			if(r.getRevision().getType()== RevisionType.Unchecked) {
				RevisionDTO revision=new RevisionDTO(r.getRevision().getId(),r.getRevision().getGrade(),r.getRevision().getRevision(),r.getRevision().getType());
				
				CottageReservationDTO reservation=CottageReservationMapper.convertToDTO(r.getCottageReservation());
				CottageRevisionDTO rDTO=new CottageRevisionDTO(r.getId(),reservation,revision);
				revisionsDTO.add(rDTO);
			}
			
		}
		return revisionsDTO;
	}
	
	public List<CottageRevisionDTO> getAllByAdventure(Long boatId) {
		List<CottageRevision> revisions=cottageRevisionRepository.findAll();
		List<CottageRevisionDTO> revisionsDTO=new  ArrayList<>();
		for (CottageRevision r : revisions) {
			if(r.getCottageReservation().getCottage().getId()==boatId) {
				RevisionDTO revision=new RevisionDTO(r.getRevision().getId(),r.getRevision().getGrade(),r.getRevision().getRevision(),r.getRevision().getType());
				
				CottageReservationDTO reservation=CottageReservationMapper.convertToDTO(r.getCottageReservation());
				CottageRevisionDTO rDTO=new CottageRevisionDTO(r.getId(),reservation,revision);
				revisionsDTO.add(rDTO);
			}
			
		}
		return revisionsDTO;
	}
	
	public void acceptCottageRevision(CottageRevisionDTO dto) throws MailException, InterruptedException {
		CottageRevision adventureRevision=cottageRevisionRepository.getById(dto.getId());
		Revision revision=revisionRepository.getById(adventureRevision.getRevision().getId());
		revision.setType(RevisionType.Accepted);
		revisionRepository.save(revision);
		emailService.sendMessage(adventureRevision.getCottageReservation().getCottage().getCottageOwner().getEmail(),"CLient left revision about your adventure:"+adventureRevision.getCottageReservation().getCottage().getName()+". Check out your profile!");
		
		
	}
	
	public void rejectCottageRevision(CottageRevisionDTO dto) {
		CottageRevision adventureRevision=cottageRevisionRepository.getById(dto.getId());
		Revision revision=revisionRepository.getById(adventureRevision.getRevision().getId());
		revision.setType(RevisionType.Rejected);
		revisionRepository.save(revision);
		
	}
	public CottageRevision save(CottageRevision newRevision) {
		return this.cottageRevisionRepository.save(newRevision);
	}
}
