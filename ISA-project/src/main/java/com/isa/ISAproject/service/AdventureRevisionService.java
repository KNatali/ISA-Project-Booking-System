package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
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
	

}
