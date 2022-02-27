package com.isa.ISAproject.controller;

import java.util.List;

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
import com.isa.ISAproject.service.AdventureRevisionService;
import com.isa.ISAproject.service.BoatRevisionService;

@CrossOrigin("*")
@RestController
public class BoatRevisionController {

	@Autowired
	private BoatRevisionService boatRevisionService;

	@RequestMapping(value="api/admin/allBoatRevisions",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<BoatRevisionDTO>> getBoatRevisions(){
		List<BoatRevisionDTO> dtos=boatRevisionService.getAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	

	@RequestMapping(value="api/instructor/adventure/allBoatRevisionsByBoat/{id}",method = RequestMethod.GET,
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
}
