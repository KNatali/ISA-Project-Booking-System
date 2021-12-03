package com.isa.ISAproject.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.AdventureService;
import com.isa.ISAproject.service.InstructorService;




@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/instructor/adventure")
public class InstructorAdventureController {
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private AdventureService adventureService;
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping(value="equipment/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureFishingEquipmentDTO>> getAdventureEquipment(@PathVariable Long id){
		List<AdventureFishingEquipmentDTO> item=adventureService.getAdventureEquipment(id);
		
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="rules/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureBehavioralRuleDTO>> getAdventureRules(@PathVariable Long id){
		List<AdventureBehavioralRuleDTO> item=adventureService.getAdventureRules(id);
		
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="additionalItems/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdditionalItemDTO>> getAdventureAdditionalItems(@PathVariable Long id){
		List<AdditionalItemDTO> item=adventureService.getAdventureAdditionalItems(id);
		
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
}
