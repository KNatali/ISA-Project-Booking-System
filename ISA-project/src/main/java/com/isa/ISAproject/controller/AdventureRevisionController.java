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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.RevisionDTO;
import com.isa.ISAproject.dto.SpecificRevisionDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.service.AdventureReservationService;
import com.isa.ISAproject.service.AdventureRevisionService;
import com.isa.ISAproject.service.RevisionService;

@CrossOrigin("*")
@RestController
public class AdventureRevisionController {
	
	@Autowired
	private AdventureRevisionService adventureRevisionService;
	
	@Autowired
	private AdventureReservationService adventureReservationService; 
	
	@Autowired
	private RevisionService revisionService;

	@RequestMapping(value="api/admin/allAdventureRevisions",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<AdventureRevisionDTO>> getAdventureRevisions(){
		List<AdventureRevisionDTO> dtos=adventureRevisionService.getAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	

	@RequestMapping(value="api/instructor/adventure/allAdventureRevisionsByAdventure/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureRevisionDTO>> getAdventureRevisionsByAdventure(@PathVariable Long id){
		List<AdventureRevisionDTO> dtos=adventureRevisionService.getAllByAdventure(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptAdventureRevision",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> acceptAdventureRevision(@RequestBody AdventureRevisionDTO dto) throws MailException, InterruptedException{

		adventureRevisionService.acceptAdventureRevision(dto);
		return new ResponseEntity<>(HttpStatus.OK);	
		
		
	}
	
	@RequestMapping(value="api/admin/rejectAdventureRevision",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rejectAdventureRevision(@RequestBody AdventureRevisionDTO dto){

		adventureRevisionService.rejectAdventureRevision(dto);
		return new ResponseEntity<>(HttpStatus.OK);	
		
		
	}/*
	//probacu da prosledim reyervaciju i recenziju i da ih pronadjem a onda tek da kreiraim adventre revizion
	@RequestMapping(value="api/client/makeNewAdventureRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdventureRevisionDTO> saveNewAdventureRevision(@RequestBody RevisionDTO revisionDTO,@RequestBody AdventureReservationDTO reservationDTO ){
		Optional<AdventureReservation> adventureReservation=this.adventureReservationService.findById(reservationDTO.getId());
		if (!adventureReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		AdventureReservation adv=adventureReservation.get();
		
		Optional<Revision> revision=this.revisionService.findById(revisionDTO.getId());
		if (!revision.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		Revision rev=revision.get();
		
		AdventureRevision newAdventureRevision=new AdventureRevision(adv, rev);
		AdventureRevision saved=this.adventureRevisionService.save(newAdventureRevision);
		return new ResponseEntity<>(new AdventureRevisionDTO(saved),HttpStatus.CREATED);
	}*/
	@RequestMapping(value="api/client/makeNewAdventureRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<AdventureRevisionDTO> saveNewAdventureRevision(@RequestBody SpecificRevisionDTO specificRevisionDTO){
		Optional<AdventureReservation> adventureReservation=this.adventureReservationService.findById(specificRevisionDTO.getId_reservation());
		if (!adventureReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		AdventureReservation adv=adventureReservation.get();
		
		Optional<Revision> revision=this.revisionService.findById(specificRevisionDTO.getId_revision());
		if (!revision.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		Revision rev=revision.get();
		
		AdventureRevision newAdventureRevision=new AdventureRevision(adv, rev);
		AdventureRevision saved=this.adventureRevisionService.save(newAdventureRevision);
		return new ResponseEntity<>(new AdventureRevisionDTO(saved),HttpStatus.CREATED);
	}
	
	/*
	@RequestMapping(value="api/client/makeNewAdventureRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdventureRevisionDTO> save(@RequestBody AdventureRevisionDTO newAdventureRevisionDTO){
		
		RevisionDTO revisionDTO=newAdventureRevisionDTO.getRevision(); 
		Revision revision=new Revision(revisionDTO.getId(),revisionDTO.getGrade(),revisionDTO.getRevision(),revisionDTO.getType());
		
		AdventureReservationDTO adventureReservationDTO=newAdventureRevisionDTO.getAdventureReservation();
		AdventureDTO adventureDTO=adventureReservationDTO.getAdventure();
		
		AddressDTO addressDTO=adventureDTO.getAddress();
		Address address=new Address(addressDTO.getId(),addressDTO.getStreet(),addressDTO.getState(),addressDTO.getCity(),addressDTO.getLatitude(),addressDTO.getLongitude());
		
		InstructorDTO insDTO=adventureDTO.getInstructor();
		
		Adventure adventure=new Adventure(adventureDTO.getId(),adventureDTO.getName(),address, adventureDTO.getDescription(), adventureDTO.getAverageGrade(), adventureDTO.getPrice(), ins, adventureDTO.getMainPicture(), adventureDTO.getMaxPersons());
		AdventureReservation adventureReservation=new AdventureReservation(adventureReservationDTO.getId(), adventureReservationDTO.getReservationStart(), adventureReservationDTO.getReservationEnd(), adventureReservationDTO.getAdventure(), adventureReservationDTO.getNumberOfPersons(), adventureReservationDTO.getPrice(), adventureReservationDTO.getAdditionalItems(), adventureReservationDTO.getClient(), null, adventureReservationDTO.getSystemEarning());
		AdventureRevision adventureRevision=new AdventureRevision(newAdventureRevisionDTO.getId(),ureReservation(),newAdventureRevisionDTO.getRevision());
		Revision savedRevision=this.revisionService.save(adventureRevision);
		return new ResponseEntity<>(new RevisionDTO(savedRevision),HttpStatus.CREATED);
	}*/
	

}
