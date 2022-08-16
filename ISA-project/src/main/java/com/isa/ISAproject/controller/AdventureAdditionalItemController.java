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

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.service.AdventureAdditionalItemService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/instructor/adventure")
public class AdventureAdditionalItemController {
	@Autowired
	private AdventureAdditionalItemService additionalItemService;
	
	
	@RequestMapping(value="additionalItems/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdditionalItemDTO>> getAdventureAdditionalItems(@PathVariable Long id){
		List<AdditionalItemDTO> item=additionalItemService.getAdditionalIem(id);
		
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="additionalItem/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> saveNewAdditionalItem(@RequestBody AdditionalItemDTO dto,@PathVariable Long id){
		this.additionalItemService.saveNewAdditonalItem(id, dto);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="additionalItemEdit/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> editAdditionalItem(@RequestBody AdditionalItemDTO dto,@PathVariable Long id){
		this.additionalItemService.editAdditionalItem(id, dto);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="additionalItem/{adventureId}/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> deleteAdditionnalItem(@PathVariable(name="adventureId") Long adventureId,@PathVariable(name="id") Long additionalItemId){
		/*if(this.additionalItemService.(adventureId,additionalItemId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		*/
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
