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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.CottageAddDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByPriceDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByPriceDTO;
import com.isa.ISAproject.dto.SearchForReservationDTO;
import com.isa.ISAproject.mapper.CottageMapper;
import com.isa.ISAproject.mapper.CottageOwnerMapper;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.service.CottageOwnerService;
import com.isa.ISAproject.service.CottageService;

@CrossOrigin("*")
@RestController
public class CottageController {
	@Autowired
	private CottageService cottageService;
	@Autowired
	private CottageOwnerService cottageOwnerService;
	
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
	@RequestMapping(value="api/cottages/delete/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')" )
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.cottageService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/add/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?>  addCottage(@RequestBody CottageAddDTO dto,@PathVariable Long id){
		this.cottageService.addCottage(id, dto);
			return new ResponseEntity<>(HttpStatus.OK);
	}	
	@RequestMapping( method = RequestMethod.GET,
			params = {"firstName","lastName"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageDTO>> findCottageByCottageOwnerName(@RequestParam String firstName,@RequestParam String lastName){
		CottageOwner cottageOwner=this.cottageOwnerService.findByFirstNameAndLastName(firstName, lastName);
		CottageOwnerProfileDTO coDTO=new CottageOwnerProfileDTO(cottageOwner);
		List<Cottage> cottages=this.cottageService.findByCottageOwner(cottageOwner);
		if(cottages==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<CottageDTO> res=CottageMapper.convertoToDTOs(cottages);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping( method = RequestMethod.GET,
			params = "cottageOwnerId",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageDTO>> findCottagesByCottageOwner(@RequestParam Long cottageOwnerId){
		Optional<CottageOwner> cottageOwnerOPT=this.cottageOwnerService.findById(cottageOwnerId);
		if(!cottageOwnerOPT.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		CottageOwner cottageOwner=cottageOwnerOPT.get();
		CottageOwnerProfileDTO coDTO=CottageOwnerMapper.convertToDTO(cottageOwner);
		List<Cottage> cottages=this.cottageService.findByCottageOwner(cottageOwner);
		if(cottages==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<CottageDTO> res=CottageMapper.convertoToDTOs(cottages);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/allAvailableCottages",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)	
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> findAllAvailableBoat(@RequestBody SearchForReservationDTO dto){
		List<Cottage> cottages=this.cottageService.findAllAvailableCottage(dto);
		if(cottages==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
		}
	}

	@RequestMapping(value="api/cottages/sort-by-grade", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> sortByGrade(@RequestBody List<CottageDTO> cottagesDTOS){
		List<Cottage> cottages=this.cottageService.sortByGradeAvailableCottage(cottagesDTOS);
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/sort-by-price", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> sortByPrice(@RequestBody List<CottageDTO> cottagesDTOS){
		List<Cottage> cottages=this.cottageService.sortByPriceAvailableCottage(cottagesDTOS);
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/find-available-by-grade", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> findAvailableByGrade(@RequestBody SearchAvailableCottageByGradeDTO dto){
		List<CottageDTO> res=this.cottageService.findAvailableByGrade(dto);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/find-available-by-price", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> findAvailableByPrice(@RequestBody SearchAvailableCottageByPriceDTO dto){
		List<CottageDTO> res=this.cottageService.findAvailableByPrice(dto);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
}
