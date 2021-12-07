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
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdminProfileDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Admin;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.AdminService;

@CrossOrigin("*")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AddressService addressService;
	

	@RequestMapping(value="api/admin/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AdminProfileDTO> getById(@PathVariable Long id){
		Optional<Admin> item=adminService.findById(id);
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		AdminProfileDTO itemDto=new AdminProfileDTO(item.get());
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/changePassword/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AdminProfileDTO> changePassword(@RequestBody PasswordChangeDTO dto,@PathVariable Long id){
		AdminProfileDTO adminDTO=adminService.changePassword(id, dto);
		if(adminDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(adminDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/{id}",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')" )
	public ResponseEntity<AdminProfileDTO> update(@RequestBody AdminProfileDTO editedInstructorDTO,@PathVariable Long id){
		Optional<Admin> itemOptionals=this.adminService.findById(id);
		
		
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Admin instructor=itemOptionals.get();
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
		
		final Admin savedInstructor=this.adminService.save(instructor);
		
		
		return new ResponseEntity<>(new AdminProfileDTO(savedInstructor),HttpStatus.OK);
	}
	@RequestMapping(value="api/admin",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<AdminProfileDTO>> findAll(){
		List<Admin> instructors=this.adminService.findAll();
		List<AdminProfileDTO> dtos=this.convertIntoDTO(instructors);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	private List<AdminProfileDTO> convertIntoDTO(List<Admin> admins){
		List<AdminProfileDTO> dtos=new ArrayList<>();
		for (Admin i : admins) {
			dtos.add(new AdminProfileDTO(i));
		}
		return dtos;
	}
	
	
}
