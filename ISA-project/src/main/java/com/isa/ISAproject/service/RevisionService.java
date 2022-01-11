package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.model.RevisionType;
import com.isa.ISAproject.repository.RevisionRepository;

@Service
public class RevisionService {
	
	@Autowired
	private RevisionRepository revisionRepository;
	
	public List<RevisionDTO> getAll() {
		List<Revision> revisions=revisionRepository.findAll();
		List<RevisionDTO> revisionsDTO=new  ArrayList<>();
		for (Revision r : revisions) {
			RevisionDTO rDTO=new RevisionDTO(r.getId(),r.getGrade(),r.getRevision(),r.getType());
			revisionsDTO.add(rDTO);
			}
		return revisionsDTO;
	}
	
	public void acceptRevision(RevisionDTO dto) {
		Revision revision=revisionRepository.getById(dto.getId());
		revision.setType(RevisionType.Accepted);
		revisionRepository.save(revision);
		
	}
	
	public void rejectRevision(RevisionDTO dto) {
		Revision revision=revisionRepository.getById(dto.getId());
		revision.setType(RevisionType.Rejected);
		revisionRepository.save(revision);
		
	}

}
