package com.isa.ISAproject.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.service.RevisionService;

@CrossOrigin("*")
@RestController
public class RevisionController {
	@Autowired 
	private RevisionService revisionService;
	
	@RequestMapping(value="api/revision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RevisionDTO> save(@RequestBody RevisionDTO newRevisionDTO){
		Revision revision=new Revision(newRevisionDTO.getId(),newRevisionDTO.getGrade(),newRevisionDTO.getRevision(),newRevisionDTO.getType());
		Revision savedRevision=this.revisionService.save(revision);
		return new ResponseEntity<>(new RevisionDTO(savedRevision),HttpStatus.CREATED);
	}

}
