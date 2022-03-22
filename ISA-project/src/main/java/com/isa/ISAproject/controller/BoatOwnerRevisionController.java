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

import com.isa.ISAproject.dto.BoatOwnerRevisionDTO;
import com.isa.ISAproject.dto.BoatRevisionDTO;
import com.isa.ISAproject.dto.SpecificRevisionDTO;
import com.isa.ISAproject.model.BoatOwnerRevision;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.BoatRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.service.BoatOwnerRevisionService;
import com.isa.ISAproject.service.BoatReservationService;
import com.isa.ISAproject.service.BoatRevisionService;
import com.isa.ISAproject.service.RevisionService;

@CrossOrigin("*")
@RestController
public class BoatOwnerRevisionController {
	
	@Autowired
	private BoatOwnerRevisionService boatOwnerRevisionService;
	
	@Autowired 
	private BoatReservationService boatReservationService;
	
	@Autowired
	private RevisionService revisionService;
	
	@RequestMapping(value="api/client/makeNewBoatOwnerRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BoatOwnerRevisionDTO> saveNewBoatOwnerRevision(@RequestBody SpecificRevisionDTO specificRevisionDTO){
		Optional<BoatReservation> boatReservation=this.boatReservationService.findById(specificRevisionDTO.getId_reservation());
		if (!boatReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		BoatReservation adv=boatReservation.get();
		
		Optional<Revision> revision=this.revisionService.findById(specificRevisionDTO.getId_revision());
		if (!revision.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		Revision rev=revision.get();
		
		BoatOwnerRevision newBoatOwnerRevision=new BoatOwnerRevision(adv, rev);
		BoatOwnerRevision saved=this.boatOwnerRevisionService.save(newBoatOwnerRevision);
		return new ResponseEntity<>(new BoatOwnerRevisionDTO(saved),HttpStatus.CREATED);
	}

}
