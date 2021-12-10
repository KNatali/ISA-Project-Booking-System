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

import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.service.CottageBehavioralRuleService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/cottageOwner/cottage")
public class CottageBehavioralRuleController {

	@Autowired
	private CottageBehavioralRuleService cottageBehavioralService;
	
	@RequestMapping(value="cottageRules/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageBehavioralRuleDTO>> getCottageRules(@PathVariable Long id){
		List<CottageBehavioralRuleDTO> item=cottageBehavioralService.getCottageBehavioralRules(id);
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="cottageRule/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> saveNewBehavioralRule(@RequestBody CottageBehavioralRuleDTO dto,@PathVariable Long id){
		this.cottageBehavioralService.saveNewBehavioralRule(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="cottageRuleEdit/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> editBehavioralRule(@RequestBody CottageBehavioralRuleDTO dto,@PathVariable Long id){
		this.cottageBehavioralService.editBehavioralRule(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
