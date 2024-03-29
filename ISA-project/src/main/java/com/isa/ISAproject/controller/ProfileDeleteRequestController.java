package com.isa.ISAproject.controller;

import java.util.List;

import javax.persistence.PessimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.mapper.UserMapper;
import com.isa.ISAproject.model.ProfileDeleteRequest;
import com.isa.ISAproject.model.AppUser;
import com.isa.ISAproject.service.ProfileDeleteRequestService;
import com.isa.ISAproject.service.UserService;

@CrossOrigin("*")
@RestController
public class ProfileDeleteRequestController {

	@Autowired
	private ProfileDeleteRequestService profileDeleteRequestService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/instructors/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> sendProfifleDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto){
	
		ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="api/admin/allProfileDeleteRequests",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<ProfileDeleteRequestDTO>> getUnverifiedRegistrationRequests(){
		List<ProfileDeleteRequestDTO> dtos=profileDeleteRequestService.findAllUnverified();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptProfileDeleteRequest",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<UserDTO> acceptProfileDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto){
		
		
		try {
			profileDeleteRequestService.acceptDeleteRequest(dto);
		} catch (PessimisticLockException e) 
		{
			return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.CONFLICT);
		}catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
			return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/rejectProfileDeleteRequest",method = RequestMethod.PUT,params= {"message"},consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<?> rejectProfileDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto,@RequestParam String message){

		try {
			profileDeleteRequestService.rejectDeleteRequest(dto,message);
		} catch (PessimisticLockException e) 
		{
			return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.CONFLICT);
		}catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
			return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);	
		
		
	}
	
	@RequestMapping(value="/api/cottageOwners/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> sendProfifleDeleteRequestCottageOwner(@RequestBody ProfileDeleteRequestDTO dto){
	
		ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/boatOwners/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> sendProfifleDeleteRequestBoatOwner(@RequestBody ProfileDeleteRequestDTO dto){
	
		ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	@RequestMapping(value="/api/client/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<?> sendProfifleDeleteRequestClient(@RequestBody ProfileDeleteRequestDTO dto){
	
		//ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		AppUser user=this.userService.findById(dto.getUserDTO().getId());
		UserDTO userDTO=UserMapper.convertToDTO(user);
		ProfileDeleteRequest req=new ProfileDeleteRequest(dto.getId(), user, dto.getReason(), dto.getType());
		ProfileDeleteRequest saved=this.profileDeleteRequestService.save(req);
		ProfileDeleteRequestDTO savedDTO=new ProfileDeleteRequestDTO(saved.getId(),userDTO,saved.getReason(),saved.getType());
		return new ResponseEntity<>(savedDTO,HttpStatus.OK);
	}
}
