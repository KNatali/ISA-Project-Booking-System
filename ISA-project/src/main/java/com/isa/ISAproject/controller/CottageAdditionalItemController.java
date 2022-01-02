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
import com.isa.ISAproject.service.CottageAdditionalItemService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/cottageOwner/cottage")
public class CottageAdditionalItemController {

	@Autowired
	private CottageAdditionalItemService additionalItemService;
	
	@RequestMapping(value="cottageAdditionalItems/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<AdditionalItemDTO>> getCottageAdditionalItems(@PathVariable Long id){
		List<AdditionalItemDTO> item=additionalItemService.getAdditionalIem(id);
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="cottageAdditionalItem/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> saveNewAdditionalItem(@RequestBody AdditionalItemDTO dto,@PathVariable Long id){
		this.additionalItemService.saveNewAdditonalItem(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="cottageAdditionalItemEdit/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> editAdditionalItem(@RequestBody AdditionalItemDTO dto,@PathVariable Long id){
		this.additionalItemService.editAdditionalItem(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="cottageAdditionalItem/{cottageId}/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> deleteAdditionnalItem(@PathVariable(name="cottageId") Long cottageId,@PathVariable(name="id") Long additionalItemId){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
