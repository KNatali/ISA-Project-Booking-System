package com.isa.ISAproject.controller;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

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

import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.BoatFastReservationDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageFastReservationDTO;
import com.isa.ISAproject.dto.CottageReservationClientDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.EditCottageFastReservationDTO;
import com.isa.ISAproject.dto.ReserveBoatFastResrvationDTO;
import com.isa.ISAproject.dto.ReserveCottageFastReservation;
import com.isa.ISAproject.model.BoatFastReservation;
import com.isa.ISAproject.model.CottageFastReservation;
import com.isa.ISAproject.service.CottageFastReservationService;
import com.isa.ISAproject.service.CottageReservationService;


@CrossOrigin("*")
@RestController
public class CottageFastReservationController {

	@Autowired
	private CottageFastReservationService cottageFastReservationService;
	
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@RequestMapping(
			value="api/cottageOwners/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageFastReservationDTO>> getFastReservationsByCottageOwner(@PathVariable(name="id") Long cottageOwnerId){
		List<CottageFastReservationDTO> list=new ArrayList<>();
		list=this.cottageFastReservationService.getFastReservationsByCottageOwner(cottageOwnerId);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/cottageOwner/cottage/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageFastReservationDTO>> getFastReservationsByCottage(@PathVariable(name="id") Long cottageId){
		List<CottageFastReservationDTO> list=new ArrayList<>();
		list=this.cottageFastReservationService.getFastReservationsByCottage(cottageId);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/cottages/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageFastReservationDTO>> getFastReservationsByCottageClient(@PathVariable(name="id") Long id){
		List<CottageFastReservationDTO> list=new ArrayList<>();
		list=this.cottageFastReservationService.getFastReservationsByCottageClient(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/cottageReservation/addFastReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('COTTAGE_OWNER')")	
	public ResponseEntity<CottageFastReservationDTO>  addCottageFastReservation(@RequestBody CottageFastReservationDTO dto){
		CottageFastReservationDTO fastDTO=new CottageFastReservationDTO();
		try {
			fastDTO = this.cottageFastReservationService.addCottageFastReservation(dto);
		} catch (PessimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);	
	}
	
	@RequestMapping(value="api/cottageReservation/editFastReservation",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<CottageFastReservationDTO>  editCottageFastReservation(@RequestBody EditCottageFastReservationDTO dto) throws Exception{
		CottageFastReservationDTO fastDTO=this.cottageFastReservationService.editCottageFastReservation(dto);
		if(fastDTO==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/fastReservations/reserve",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<CottageReservationDTO> reserveFastReservation(@RequestBody ReserveCottageFastReservation dto){
		//CottageReservationDTO reservationDTO=this.cottageFastReservationService.convertToCottageReservationDTO(dto);
		CottageReservationClientDTO reservedDTO=this.cottageReservationService.convertReserveCottageFastReservation(dto);
		CottageReservationDTO created=this.cottageReservationService.addCottageReservationClient(reservedDTO);
		//treba izbrisati tu akciju
		CottageFastReservation fast=this.cottageFastReservationService.findById(dto.getId());
		this.cottageFastReservationService.delite(fast);
		return new ResponseEntity<>(created,HttpStatus.OK);
	}
}
