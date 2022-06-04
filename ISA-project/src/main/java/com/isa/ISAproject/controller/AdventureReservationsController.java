package com.isa.ISAproject.controller;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.PessimisticLockException;

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

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationCreateDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.service.AdventureReservationService;
import com.isa.ISAproject.service.AdventureService;
import com.isa.ISAproject.service.ClientService;

import javassist.NotFoundException;

@CrossOrigin("*")
@RestController
public class AdventureReservationsController {
	@Autowired
	private AdventureReservationService adventureReservationService;
	
	@Autowired
	private AdventureService adventureService;
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="api/adventureReservation/all",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<List<AdventureReservationDTO>> findAllResrvations(){
		List<AdventureReservation> list=this.adventureReservationService.findAll();
		List<AdventureReservationDTO> res=new ArrayList<>();
		for (AdventureReservation advReservation : list) {
			AdventureReservationDTO a=new AdventureReservationDTO(advReservation);
			a.setSystemEarning(advReservation.getSystemEarning());
			res.add(a);
		}
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value="api/adventureReservation/{id}",method = RequestMethod.GET)
	public ResponseEntity<AdventureReservationDTO>  findOne(@PathVariable Long id){
		Optional<AdventureReservation> adventureReservation=this.adventureReservationService.findById(id);
		if (!adventureReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(new AdventureReservationDTO(adventureReservation.get()), HttpStatus.OK);
	}

	
	
	@RequestMapping(value="api/adventure-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.oldReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	public List<AdventureReservationDTO> convertToDTOList(List<AdventureReservation> input){
		List<AdventureReservationDTO> res=new ArrayList<>();
		for (AdventureReservation advReservation : input) {
			res.add(new AdventureReservationDTO(advReservation));
		}
		return res;
	}

	@RequestMapping(value="api/adventure-reservations/active/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> activeReservations(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.activeReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/adventure-reservations/sort-by-price/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> sortByPrice(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.sortByPrice(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/adventure-reservations/sort-by-date/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> sortByDate(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.sortByDateStart(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/adventureReservation/addReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<AdventureReservationDTO>  addAdventureReservation(@RequestBody AdventureReservationDTO dto) {
		AdventureReservationDTO fastDTO;
		try {
			fastDTO = this.adventureReservationService.addAdventureReservation( dto);
		} catch (PessimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
		
	}
	@RequestMapping(value="api/adventureReservation/client/addReservation",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<AdventureReservationDTO>  addAdventureReservationClient(@RequestBody AdventureReservationCreateDTO dto) {
		AdventureReservationDTO adventureReservationDTO=this.adventureReservationService.convertFromAdventureReservationCreateDTO(dto);
		//AdventureReservationDTO created=this.adventureReservationService.addAdventureReservation(adventureReservationDTO);
		return this.addAdventureReservation(adventureReservationDTO);
	}
	@RequestMapping(value = "api/adventureReservation/delete-by-client/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<Void> cancleReservation(@PathVariable Long id){
		AdventureReservation deletedRes;
		deletedRes= this.adventureReservationService.deleteReservation(id);
		if (deletedRes==null) {
			System.out.println("ima manje od 3 dana do pocetka rezervacije");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
