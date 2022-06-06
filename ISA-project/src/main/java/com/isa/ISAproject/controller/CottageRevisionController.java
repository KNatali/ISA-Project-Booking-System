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
import com.isa.ISAproject.dto.CottageRevisionDTO;
import com.isa.ISAproject.dto.SpecificRevisionDTO;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.CottageRevision;
import com.isa.ISAproject.model.Revision;
import com.isa.ISAproject.service.CottageReservationService;
import com.isa.ISAproject.service.CottageRevisionService;
import com.isa.ISAproject.service.RevisionService;


@CrossOrigin("*")
@RestController
public class CottageRevisionController {

	@Autowired
	private CottageRevisionService cottageRevisionService;
	
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@Autowired 
	private RevisionService revisionService;

	@RequestMapping(value="api/admin/allCottageRevisions",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<CottageRevisionDTO>> getCottageRevisions(){
		List<CottageRevisionDTO> dtos=cottageRevisionService.getAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	

	@RequestMapping(value="api/cottageOwner/cottage/allCottageRevisionsByCottage/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageRevisionDTO>> getCottageRevisionsByCottage(@PathVariable Long id){
		List<CottageRevisionDTO> dtos=cottageRevisionService.getAllByAdventure(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptCottageRevision",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> acceptCottageRevision(@RequestBody CottageRevisionDTO dto) throws MailException, InterruptedException{

		cottageRevisionService.acceptCottageRevision(dto);
		return new ResponseEntity<>(HttpStatus.OK);	
		
		
	}
	
	@RequestMapping(value="api/admin/rejectCottageRevision",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rejectCottageRevision(@RequestBody CottageRevisionDTO dto){

		cottageRevisionService.rejectCottageRevision(dto);
		return new ResponseEntity<>(HttpStatus.OK);	
		
		
	}
	@RequestMapping(value="api/client/makeNewCottageRevision",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CottageRevisionDTO> saveNewCottageRevision(@RequestBody SpecificRevisionDTO specificRevisionDTO){
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
		
		CottageRevision newCottageRevision=new CottageRevision(cott, rev);
		CottageRevision saved=this.cottageRevisionService.save(newCottageRevision);
		return new ResponseEntity<>(new CottageRevisionDTO(saved),HttpStatus.CREATED);
	}
}
