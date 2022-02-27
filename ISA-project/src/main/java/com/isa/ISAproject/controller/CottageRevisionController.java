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
import com.isa.ISAproject.dto.CottageRevisionDTO;
import com.isa.ISAproject.service.CottageRevisionService;


@CrossOrigin("*")
@RestController
public class CottageRevisionController {

	@Autowired
	private CottageRevisionService cottageRevisionService;

	@RequestMapping(value="api/admin/allCottageRevisions",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<CottageRevisionDTO>> getCottageRevisions(){
		List<CottageRevisionDTO> dtos=cottageRevisionService.getAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	

	@RequestMapping(value="api/instructor/adventure/allCottageRevisionsByCottage/{id}",method = RequestMethod.GET,
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
}
