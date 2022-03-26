package com.isa.ISAproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.CottageOwnerRevisionDTO;
import com.isa.ISAproject.dto.CottageRevisionDTO;
import com.isa.ISAproject.dto.SpecificRevisionDTO;
import com.isa.ISAproject.model.CottageOwnerRevision;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.CottageRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.service.CottageOwnerRevisionService;
import com.isa.ISAproject.service.CottageReservationService;
import com.isa.ISAproject.service.CottageRevisionService;
import com.isa.ISAproject.service.RevisionService;

@CrossOrigin("*")
@RestController
public class CottageOwnerRevisionController {
	@Autowired
	private CottageOwnerRevisionService cottageOwnerRevisionService;
	
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@Autowired 
	private RevisionService revisionService;
	
	@RequestMapping(value="api/client/makeNewCottageOwnerRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CottageOwnerRevisionDTO> saveNewCottageOwnerRevision(@RequestBody SpecificRevisionDTO specificRevisionDTO){
		Optional<CottageReservation> cottageReservation=this.cottageReservationService.findById(specificRevisionDTO.getId_reservation());
		if (!cottageReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		CottageReservation cott=cottageReservation.get();
		
		Optional<Revision> revision=this.revisionService.findById(specificRevisionDTO.getId_revision());
		if (!revision.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		Revision rev=revision.get();
		
		CottageOwnerRevision newCottageOwnerRevision=new CottageOwnerRevision(cott, rev);
		CottageOwnerRevision saved=this.cottageOwnerRevisionService.save(newCottageOwnerRevision);
		return new ResponseEntity<>(new CottageOwnerRevisionDTO(saved),HttpStatus.CREATED);
	}

}
