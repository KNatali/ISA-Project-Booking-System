package com.isa.ISAproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.dto.BoatRevisionDTO;
import com.isa.ISAproject.dto.SpecificRevisionDTO;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.BoatRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.service.AdventureRevisionService;
import com.isa.ISAproject.service.BoatReservationService;
import com.isa.ISAproject.service.BoatRevisionService;
import com.isa.ISAproject.service.RevisionService;

@CrossOrigin("*")
@RestController
public class BoatRevisionController {

	@Autowired
	private BoatRevisionService boatRevisionService;
	
	@Autowired 
	private BoatReservationService boatReservationService;
	
	@Autowired
	private RevisionService revisionService;

	@RequestMapping(value="api/admin/allBoatRevisions",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<BoatRevisionDTO>> getBoatRevisions(){
		List<BoatRevisionDTO> dtos=boatRevisionService.getAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	

	@RequestMapping(value="api/boatOwner/boat/allBoatRevisionsByBoat/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatRevisionDTO>> getBoatRevisionsByBoat(@PathVariable Long id){
		List<BoatRevisionDTO> dtos=boatRevisionService.getAllByAdventure(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptBoatRevision",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> acceptAdventureRevision(@RequestBody BoatRevisionDTO dto) throws MailException, InterruptedException{

		boatRevisionService.acceptBoatRevision(dto);
		return new ResponseEntity<>(HttpStatus.OK);	
		
		
	}
	
	@RequestMapping(value="api/admin/rejectBoatRevision",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rejectAdventureRevision(@RequestBody BoatRevisionDTO dto){

		boatRevisionService.rejectBoatRevision(dto);
		return new ResponseEntity<>(HttpStatus.OK);	
		
		
	}
	@RequestMapping(value="api/client/makeNewBoatRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<BoatRevisionDTO> saveNewBoatRevision(@RequestBody SpecificRevisionDTO specificRevisionDTO){
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
		
		BoatRevision newBoatRevision=new BoatRevision(adv, rev);
		BoatRevision saved=this.boatRevisionService.save(newBoatRevision);
		return new ResponseEntity<>(new BoatRevisionDTO(saved),HttpStatus.CREATED);
	}
}
