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

import com.isa.ISAproject.dto.AdventureAddDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByGradeDTO;
import com.isa.ISAproject.dto.SearchForReservationDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.InstructorMapper;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.service.AdventureService;
import com.isa.ISAproject.service.InstructorService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/adventures")
public class AdventureController {
	@Autowired
	private AdventureService adventureService;
	
	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping(method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<AdventureDTO>> findAll(){
		List<AdventureDTO> adventuresDTO=adventureService.findAll();
		
		return new ResponseEntity<>(adventuresDTO,HttpStatus.OK);
	}
	@RequestMapping(value="/delete/{id}",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN') || hasRole('INSTRUCTOR')" )
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.adventureService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<AdventureDTO>  findOne(@PathVariable Long id){
		AdventureDTO adventureDTO=this.adventureService.findById(id);
		if (adventureDTO!=null) {
			
			return new ResponseEntity<>(adventureDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/add/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?>  addAdventure(@RequestBody AdventureAddDTO dto,@PathVariable Long id){
		this.adventureService.addAdventure(id, dto);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@RequestMapping( method = RequestMethod.GET,
			params = {"firstName","lastName"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdventureDTO>> findAdventureByInstructorName(@RequestParam String firstName,@RequestParam String lastName){
		Instructor instructor=this.instructorService.findByFirstNameAndLastName(firstName, lastName);
		InstructorProfileDTO insDTO=new InstructorProfileDTO(instructor);
		List<Adventure> adventures=this.adventureService.findByInstructor(instructor);
		if(adventures==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AdventureDTO> res=AdventureMapper.convertoToDTOs(adventures);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@RequestMapping( method = RequestMethod.GET,
			params = "instructorId",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<List<AdventureDTO>> findAdventuresByInstructor(@RequestParam Long instructorId){
		Optional<Instructor> instructorOPT=this.instructorService.findById(instructorId);
		if(!instructorOPT.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Instructor instructor=instructorOPT.get();
		InstructorProfileDTO insDTO=InstructorMapper.convertToDTO(instructor);
		List<Adventure> adventures=this.adventureService.findByInstructor(instructor);
		if(adventures==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AdventureDTO> res=AdventureMapper.convertoToDTOs(adventures);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping( method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdventureDTO>> findByName(@RequestParam String name){
		List<Adventure> adventures=this.adventureService.findByName(name);
		return new ResponseEntity<>(this.convert(adventures),HttpStatus.OK);
	}
	public List<AdventureDTO> convert(List<Adventure> adventures){
		List<AdventureDTO> res=new ArrayList<>();
		for (Adventure adv: adventures) {
			res.add(new AdventureDTO(adv));
		}
		return res;
	}
	@RequestMapping( method = RequestMethod.GET,
			params = "city",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdventureDTO>> findByCity(@RequestParam String city){
		List<Adventure> adventures=this.adventureService.findByCity(city);
		return new ResponseEntity<>(this.convert(adventures),HttpStatus.OK);
	}
	@RequestMapping(value="/allAvailableAdventures",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)	
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureDTO>> findAllAvailableAdventure(@RequestBody SearchForReservationDTO dto){
		List<Adventure> adventures=this.adventureService.findAllAvailableAdventure(dto);
		if(adventures==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(this.convert(adventures),HttpStatus.OK);
		}
	}
	@RequestMapping(value="/sort-by-grade", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureDTO>> sortByGrade(@RequestBody List<AdventureDTO> adventuresDTOS){
		List<Adventure> adventures=this.adventureService.sortByGradeAvailableAdventure(adventuresDTOS);
		return new ResponseEntity<>(this.convert(adventures),HttpStatus.OK);
	}
	@RequestMapping(value="/sort-by-price", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureDTO>> sortByPrice(@RequestBody List<AdventureDTO> adventuresDTOS){
		List<Adventure> adventures=this.adventureService.sortByPriceAvailableAdventure(adventuresDTOS);
		return new ResponseEntity<>(this.convert(adventures),HttpStatus.OK);
	}
	@RequestMapping(value="/find-available-by-grade", method = RequestMethod.POST,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureDTO>> findAvailableByGrade(@RequestBody SearchAvailableAdventureByGradeDTO dto){
		List<AdventureDTO> adventures=this.adventureService.findAvailableByGrade(dto);
		return new ResponseEntity<>(adventures,HttpStatus.OK);
	}

}
