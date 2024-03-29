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

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.BoatAddDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.CottageAddDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.SearchAvailableBoatByPriceOrGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByPriceDTO;
import com.isa.ISAproject.dto.SearchForReservationDTO;
import com.isa.ISAproject.dto.UnsubscribedItemDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.service.BoatService;

import net.bytebuddy.asm.Advice.This;


@CrossOrigin("*")
@RestController
public class BoatController {
	@Autowired
	private BoatService boatService;
	
	@RequestMapping(value="api/boats",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<BoatDTO>> findAll(){
		List<Boat> boats=boatService.findAll();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	public List<BoatDTO> convert(List<Boat> boats){
		List<BoatDTO> res=new ArrayList<>();
		for (Boat boat: boats) {
			res.add(new BoatDTO(boat));
		}
		return res;
	}
	@RequestMapping(value="api/boats/{id}",method = RequestMethod.GET)
	public ResponseEntity<BoatDTO>  findOne(@PathVariable Long id){
		Optional<Boat> boat=this.boatService.getOne(id);
		if (!boat.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(new BoatDTO(boat.get()), HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "motorNumber",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByMotorNumber(@RequestParam int motorNumber){
		List<Boat> boats=this.boatService.findByMotorNumber(motorNumber);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "motorPower",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByMotorPower(@RequestParam double motorPower){
		List<Boat> boats=this.boatService.findByMotorPower(motorPower);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = {"motorPower","motorNumber"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByMotorPower(@RequestParam double motorPower,@RequestParam int motorNumber){
		List<Boat> boats=this.boatService.findByMotorPowerAndMotorNumber(motorPower, motorNumber);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-name", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> sortByName(){
		List<Boat> boats=this.boatService.sortByName();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-grade", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> sortByGrade(){
		List<Boat> boats=this.boatService.sortByGrade();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-grade", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> sortByGrade(@RequestBody List<BoatDTO> boatsDTOS){
		List<Boat> boats=this.boatService.sortByGradeAvailableBoat(boatsDTOS);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-price", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> sortByPrice(@RequestBody List<BoatDTO> boatsDTOS){
		List<Boat> boats=this.boatService.sortByPriceAvailableBoat(boatsDTOS);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-city", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> sortByCity(){
		List<Boat> boats=this.boatService.sortByCity();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/additional-items",method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdditionalItemDTO>> findAllAdditionalItems(){
		List<AdditionalItem> items=this.boatService.findAllAdditionalItems();
		return new ResponseEntity<>(this.convertAdditionalItemsToDtoList(items),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/delete/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN') || hasRole('BOAT_OWNER')" )
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.boatService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public List<AdditionalItemDTO> convertAdditionalItemsToDtoList(List<AdditionalItem> items){
		List<AdditionalItemDTO> res=new ArrayList<>();
		for (AdditionalItem item: items) {
			res.add(new AdditionalItemDTO(item));
		}
		return res;
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByName(@RequestParam String name){
		List<Boat> cottages=this.boatService.findByName(name);
		return new ResponseEntity<>(this.convert(cottages),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "city",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByCity(@RequestParam String city){
		List<Boat> boats=this.boatService.findByCity(city);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/add/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?>  addBoat(@RequestBody BoatAddDTO dto,@PathVariable Long id){
		this.boatService.addBoat(id, dto);
			return new ResponseEntity<>(HttpStatus.OK);
	}

	//enpoint koji vraca listu brodova koji su slobodni u datom periodu
	@RequestMapping(value="api/boats/allAvailableBoats",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)	
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> findAllAvailableBoat(@RequestBody SearchForReservationDTO dto){
		List<Boat> boats=this.boatService.findAllAvailableBoat(dto);
		if(boats==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
		}
	}
	@RequestMapping(value="api/boats/find-available-by-grade", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> findAvailableByGrade(@RequestBody SearchAvailableBoatByPriceOrGradeDTO dto){
		List<BoatDTO> res=this.boatService.findAvailableByGrade(dto);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/find-available-by-price", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>> findAvailableByPrice(@RequestBody SearchAvailableBoatByPriceOrGradeDTO dto){
		List<BoatDTO> res=this.boatService.findAvailableByPrice(dto);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/subscribed/{clientId}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatDTO>>  getALlSubscribedBoats(@PathVariable Long clientId){
		List<BoatDTO> boats=this.boatService.getALlSubscribedBoats(clientId);
		return new ResponseEntity<>(boats,HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/unsubscribed", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<Void>  UnsubscribedBoats(@RequestBody UnsubscribedItemDTO dto){
		boolean success;
		success=this.boatService.unsubscribedBoat(dto);
		if(!success) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/subscribed", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<Void>  subscribedBoats(@RequestBody UnsubscribedItemDTO dto){
		boolean success;
		success=this.boatService.subscribedBoat(dto);
		if(!success) {
			System.out.println("already subscribed on this entity");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
