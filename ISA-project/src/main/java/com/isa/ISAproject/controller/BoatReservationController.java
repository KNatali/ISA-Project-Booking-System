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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatReservationCreateDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.mapper.BoatReservationMapper;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.service.BoatReservationService;
import com.isa.ISAproject.service.BoatService;
import com.isa.ISAproject.service.ClientService;

@CrossOrigin("*")
@RestController
public class BoatReservationController {
	@Autowired
	private BoatReservationService boatReservationService;
	
	@Autowired
	private BoatService boatService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="api/boat-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<BoatReservation> res=this.boatReservationService.oldReservationForClinet(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	public List<BoatReservationDTO> convertToDTOList(List<BoatReservation> input){
		List<BoatReservationDTO> res=new ArrayList<>();
		for (BoatReservation boatReservation : input) {
			res.add(new BoatReservationDTO(boatReservation));
		}
		return res;
	}
	@RequestMapping(value="api/boat-reservations/sort-by-price/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatReservationDTO>> sortByPrice(@PathVariable Long id){
		List<BoatReservation> res=this.boatReservationService.sortByPrice(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/boat-reservations/sort-by-duration/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatReservationDTO>> sortByDuration(@PathVariable Long id){
		List<BoatReservation> res=this.boatReservationService.sortByDuration(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/boat-reservations/sort-by-date/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatReservationDTO>> sortByDate(@PathVariable Long id){
		List<BoatReservation> res=this.boatReservationService.sortByDate(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/boat-reservations/active/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatReservationDTO>> activeReservations(@PathVariable Long id){
		List<BoatReservation> res=this.boatReservationService.activeReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/boatReservation/addReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<BoatReservationDTO>  addBoatReservation(@RequestBody BoatReservationDTO dto) {
		BoatReservationDTO fastDTO;
		try {
			fastDTO = this.boatReservationService.addBoatReservation( dto);
		} catch (PessimisticLockingFailureException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
	}
	@RequestMapping(value="api/boatReservation/client/addReservation",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<BoatReservationDTO>  addBoatReservation(@RequestBody BoatReservationCreateDTO dto) {
		//hocu da napravim BoatREservation dto
		BoatReservationDTO res=this.boatReservationService.addBoatReservationClient(dto);
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}
	@RequestMapping(value="api/boatReservation/{id}",method = RequestMethod.GET)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<BoatReservationDTO>  findOne(@PathVariable Long id){
		Optional<BoatReservation> boatReservation=this.boatReservationService.findById(id);
		if (!boatReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(new BoatReservationDTO(boatReservation.get()), HttpStatus.OK);
	}

	@RequestMapping(value = "api/boatReservation/delete-by-client/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<Void> cancleReservation(@PathVariable Long id){
		BoatReservation deletedRes=this.boatReservationService.deleteReservation(id);
		if (deletedRes==null) {
			System.out.println("ima manje od 3 dana do pocetka rezervacije");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
