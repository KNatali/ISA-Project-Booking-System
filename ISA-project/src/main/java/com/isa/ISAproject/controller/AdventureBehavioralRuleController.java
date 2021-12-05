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

import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.service.AdventureBehavioralRuleService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/instructor/adventure")
public class AdventureBehavioralRuleController {
	@Autowired
	private AdventureBehavioralRuleService adventureBehavioralService;
	
	@RequestMapping(value="rules/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureBehavioralRuleDTO>> getAdventureRules(@PathVariable Long id){
		List<AdventureBehavioralRuleDTO> item=adventureBehavioralService.getAdventureBehavioralRules(id);
		
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="rule/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> saveNewBehavioralRule(@RequestBody AdventureBehavioralRuleDTO dto,@PathVariable Long id){
		this.adventureBehavioralService.saveNewBehavioralRule(id, dto);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="ruleEdit/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> editBehavioralRule(@RequestBody AdventureBehavioralRuleDTO dto,@PathVariable Long id){
		this.adventureBehavioralService.editBehavioralRule(id, dto);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
