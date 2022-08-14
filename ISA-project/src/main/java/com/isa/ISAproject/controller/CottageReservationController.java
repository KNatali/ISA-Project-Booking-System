package com.isa.ISAproject.controller;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageReservationClientDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.service.CottageReservationService;

@CrossOrigin("*")
@RestController
public class CottageReservationController {
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@RequestMapping(value="api/cottages-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<CottageReservation> res=this.cottageReservationService.oldReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	public List<CottageReservationDTO> convertToDTOList(List<CottageReservation> input){
		List<CottageReservationDTO> res=new ArrayList<>();
		for (CottageReservation cottageReservation : input) {
			res.add(new CottageReservationDTO(cottageReservation));
		}
		return res;
	}
	@RequestMapping(value="api/cottages-reservations/sort-by-price/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageReservationDTO>> sortByPrice(@PathVariable Long id){
		List<CottageReservation> res=this.cottageReservationService.sortByPrice(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages-reservations/sort-by-duration/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageReservationDTO>> sortByDuration(@PathVariable Long id){
		List<CottageReservation> res=this.cottageReservationService.sortByDuration(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages-reservations/sort-by-date/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageReservationDTO>> sortByDate(@PathVariable Long id){
		List<CottageReservation> res=this.cottageReservationService.sortByDate(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages-reservations/active/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageReservationDTO>> activeReservations(@PathVariable Long id){
		List<CottageReservation> res=this.cottageReservationService.activeReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/cottageReservation/addReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<CottageReservationDTO>  addCottageReservation(@RequestBody CottageReservationDTO dto) {
		CottageReservationDTO fastDTO;
		try {
			fastDTO = this.cottageReservationService.addCottageReservation( dto);
		} catch (PessimisticLockingFailureException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/cottageReservation/{id}",method = RequestMethod.GET)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<CottageReservationDTO>  findOne(@PathVariable Long id){
		Optional<CottageReservation> cottageReservation=this.cottageReservationService.findById(id);
		if (!cottageReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(new CottageReservationDTO(cottageReservation.get()), HttpStatus.OK);
	}

	@RequestMapping(value="api/cottageReservation/client/addReservation",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<CottageReservationDTO>  addCottageReservation(@RequestBody CottageReservationClientDTO dto) {
		CottageReservationDTO res=this.cottageReservationService.addCottageReservationClient(dto);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value = "api/cottageReservation/delete-by-client/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity cancleReservation(@PathVariable Long id){
		CottageReservation deletedRes=this.cottageReservationService.deleteReservation(id);
		if (deletedRes==null) {
			System.out.println("ima manje od 3 dana do pocetka rezervacije");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/cottageOwner/cottage/reservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageReservationDTO>> getReservationsByCottage(@PathVariable(name="id") Long boatId){
		List<CottageReservationDTO> list=new ArrayList<>();
		list=this.cottageReservationService.getReservationsByCottage(boatId);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
