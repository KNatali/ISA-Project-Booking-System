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
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;

import com.isa.ISAproject.model.Boat;

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
				InstructorProfileDTO insDTO=new InstructorProfileDTO(a.getInstructor());
				AddressDTO addressDTO=new AddressDTO(a.getAddress().getId(),a.getAddress().getStreet(),a.getAddress().getState(),a.getAddress().getCity());
				AdventureDTO adventure=new AdventureDTO(a.getId(),a.getName(),addressDTO,a.getDescription(),a.getAverageGrade(),insDTO,a.getMainPicture(),a.getMaxPersons());
				adventuresDTO.add(adventure);
			}
			
			return new ResponseEntity<>(adventuresDTO,HttpStatus.OK);
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
	
}
