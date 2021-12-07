package com.isa.ISAproject.controller;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.AdventureService;
import com.isa.ISAproject.service.InstructorService;





@CrossOrigin("*")
@RestController
public class InstructorController {
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private AdventureService adventureService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="api/instructors/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<InstructorProfileDTO> getById(@PathVariable Long id){
		Optional<Instructor> item=instructorService.findById(id);
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		InstructorProfileDTO itemDto=new InstructorProfileDTO(item.get());
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/instructors/changePassword/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<InstructorProfileDTO> changePassword(@RequestBody PasswordChangeDTO dto,@PathVariable Long id){
		InstructorProfileDTO instructorDTO=instructorService.changePassword(id, dto);
		if(instructorDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(instructorDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/instructors/{id}",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<InstructorProfileDTO> update(@RequestBody InstructorProfileDTO editedInstructorDTO,@PathVariable Long id){
		Optional<Instructor> itemOptionals=this.instructorService.findById(id);
		
		
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Instructor instructor=itemOptionals.get();
		instructor.setId(id);
		instructor.setFirstName(editedInstructorDTO.getFirstName());
		instructor.setLastName(editedInstructorDTO.getLastName());
		Optional<Address> a=this.addressService.findById(instructor.getAddress().getId());
			Address address=a.get();
				address.setId(instructor.getAddress().getId());
				address.setStreet(editedInstructorDTO.getStreet());
				address.setCity(editedInstructorDTO.getCity());
				address.setState(editedInstructorDTO.getState());
				this.addressService.save(address);
				
		instructor.setAddress(address);
		instructor.setEmail(editedInstructorDTO.getEmail());
		instructor.setMobile(editedInstructorDTO.getMobile());
		
		final Instructor savedInstructor=this.instructorService.save(instructor);
		
		
		return new ResponseEntity<>(new InstructorProfileDTO(savedInstructor),HttpStatus.OK);
	}
	@RequestMapping(value="api/instructors",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<InstructorProfileDTO>> findAll(){
		List<Instructor> instructors=this.instructorService.findAll();
		List<InstructorProfileDTO> dtos=this.convertIntoDTO(instructors);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	private List<InstructorProfileDTO> convertIntoDTO(List<Instructor> instructors){
		List<InstructorProfileDTO> dtos=new ArrayList<>();
		for (Instructor i : instructors) {
			dtos.add(new InstructorProfileDTO(i));
		}
		return dtos;
	}
	
	//adventures from this instructor
	@RequestMapping(
			value="api/instructors/adventures/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureDTO>> adventures(@PathVariable(name="id") Long id){
		
Optional<Instructor> itemOptionals=this.instructorService.findById(id);
		
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Instructor instructor=itemOptionals.get();
			Set<Adventure> adventures=instructor.getAdventures();
			List<AdventureDTO> adventuresDTO=new ArrayList<>();
			
			for(Adventure a:adventures) {
				AdventureDTO adventure=AdventureMapper.convertToDTO(a);
				adventuresDTO.add(adventure);
			}
			
			return new ResponseEntity<>(adventuresDTO,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/instructors/reservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureReservationDTO>> getReservations(@PathVariable(name="id") Long id){
		List<AdventureReservationDTO> list=new ArrayList<>();
		list=this.instructorService.getReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/instructors/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureFastReservationDTO>> getFastReservations(@PathVariable(name="id") Long id){
		List<AdventureFastReservationDTO> list=new ArrayList<>();
		list=this.instructorService.getFastReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/instructors/reservationClient/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<ClientProfileDTO> getReservationClient(@PathVariable(name="id") Long id){
		ClientProfileDTO dto=instructorService.getReservationClilent(id);
		if(dto==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/instructors/completedReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureReservationDTO>> getCompletedReservations(@PathVariable(name="id") Long id){
		List<AdventureReservationDTO> list=new ArrayList<>();
		list=this.instructorService.getCompletedReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/instructors/activeReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureReservationDTO>> getActiveReservations(@PathVariable(name="id") Long id){
		List<AdventureReservationDTO> list=new ArrayList<>();
		list=this.instructorService.getActiveReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/instructors/adventure/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<AdventureDTO> delete(@PathVariable Long id){
		AdventureDTO aDTO=this.adventureService.findById(id);
		if(aDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		this.adventureService.delete(id);
		return new ResponseEntity<>(aDTO,HttpStatus.OK);
	}
	@RequestMapping(value="api/instructors/sort-by-name", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<InstructorProfileDTO>> sortByFirstNameAndLastName(){
		List<Instructor> instructors=this.instructorService.sortByFirstName();
		return new ResponseEntity<>(this.convertIntoDTO(instructors),HttpStatus.OK);
	}
	@RequestMapping(value="api/instructors/sort-by-grade", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<InstructorProfileDTO>> sortByGrade(){
		List<Instructor> instructors=this.instructorService.sortByGrade();
		return new ResponseEntity<>(this.convertIntoDTO(instructors),HttpStatus.OK);
	}
	@RequestMapping(value="api/instructors/sort-by-city", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<InstructorProfileDTO>> sortByCity(){
		List<Instructor> instructors=this.instructorService.sortByCity();
		return new ResponseEntity<>(this.convertIntoDTO(instructors),HttpStatus.OK);
	}
	@RequestMapping(
			value="api/instructors/adventures/client/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureDTO>> adventuresForInstrucotr(@PathVariable(name="id") Long id){
		
		Optional<Instructor> itemOptionals=this.instructorService.findById(id);
		
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Instructor instructor=itemOptionals.get();
			Set<Adventure> adventures=instructor.getAdventures();
			List<AdventureDTO> adventuresDTO=new ArrayList<>();
			
			for(Adventure a:adventures) {
				AdventureDTO adventure=AdventureMapper.convertToDTO(a);
				adventuresDTO.add(adventure);
			}
			
			return new ResponseEntity<>(adventuresDTO,HttpStatus.OK);
	}
	
}
