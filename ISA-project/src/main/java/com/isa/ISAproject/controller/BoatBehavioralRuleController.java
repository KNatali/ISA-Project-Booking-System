package com.isa.ISAproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.BoatBehavioralRuleDTO;
import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.service.BoatBehavioralRuleService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/boatOwner/boat")
public class BoatBehavioralRuleController {
	@Autowired
	private BoatBehavioralRuleService behavioralRuleService;
	
	@RequestMapping(value="boatRules/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatBehavioralRuleDTO>> getBoatRules(@PathVariable Long id){
		List<BoatBehavioralRuleDTO> item=behavioralRuleService.getBoatBehavioralRules(id);
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="boatRule/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> saveNewBehavioralRule(@RequestBody BoatBehavioralRuleDTO dto,@PathVariable Long id){
		this.behavioralRuleService.saveNewBehavioralRule(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="boatRuleEdit/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> editBehavioralRule(@RequestBody BoatBehavioralRuleDTO dto,@PathVariable Long id){
		this.behavioralRuleService.editBehavioralRule(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
