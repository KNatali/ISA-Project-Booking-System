package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.service.CottageService;

@CrossOrigin("*")
@RestController
public class CottageController {
	@Autowired
	private CottageService cottageService;
	
	@RequestMapping(value="api/cottages",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<CottageDTO>> findAll(){
		List<Cottage> cottages=cottageService.findAll();
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	public List<CottageDTO> convert(List<Cottage> cottages){
		List<CottageDTO> res=new ArrayList<>();
		for (Cottage cottage : cottages) {
			res.add(new CottageDTO(cottage));
		}
		return res;
	}/*
	@RequestMapping(value="api/cottages/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cottage>  findOne(@PathVariable Long id){
		Optional<Cottage> cottage=this.cottageService.getOne(id);
		if (cottage.isPresent()) {
			return new ResponseEntity<>(cottage.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	@RequestMapping(value="api/cottages/{id}",method = RequestMethod.GET)
	public ResponseEntity<CottageDTO>  findOne(@PathVariable Long id){
		Optional<Cottage> cottage=this.cottageService.getOne(id);
		if (cottage.isPresent()) {
			return new ResponseEntity<>(new CottageDTO(cottage.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="api/cottages", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageDTO>> findByName(@RequestParam String name){
		List<Cottage> cottages=this.cottageService.findByName(name);
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages", method = RequestMethod.GET,
			params = "city",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageDTO>> findByCity(@RequestParam String city){
		List<Cottage> cottages=this.cottageService.findByCity(city);
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/sort-by-name", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> sortByName(){
		List<Cottage> cottages=this.cottageService.sortByName();
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/sort-by-grade", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> sortByGrade(){
		List<Cottage> cottages=this.cottageService.sortByGrade();
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/sort-by-city", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> sortByCity(){
		List<Cottage> cottages=this.cottageService.sortByCity();
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
}
