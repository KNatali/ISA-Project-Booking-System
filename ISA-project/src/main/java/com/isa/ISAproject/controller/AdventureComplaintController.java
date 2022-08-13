package com.isa.ISAproject.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureComplaintDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.ComplaintAnswerDTO;
import com.isa.ISAproject.dto.ComplaintDTO;
import com.isa.ISAproject.dto.EditAdventureFastReservationDTO;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureComplaint;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.ComplaintType;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AdventureComplaintService;
import com.isa.ISAproject.service.AdventureReservationService;

@CrossOrigin("*")
@RestController
public class AdventureComplaintController {
	
	@Autowired
	private AdventureComplaintService adventurComplaintService;
	
	@Autowired
	private AdventureReservationService adventureReservationService;
	
	@RequestMapping(value="api/admin/getAdventureComplaints",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<List<AdventureComplaintDTO>> getAdventureComplaints(){
		List<AdventureComplaintDTO> dtos=adventurComplaintService.getAdventureComplaints();
	
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/answerComplaint",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<?>  answerAdventureComplaint(@RequestBody ComplaintAnswerDTO dto){
		try {
			adventurComplaintService.answerComplaint(dto);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@RequestMapping(value="api/client/makeNewIntructorComplaint",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<ComplaintDTO> makeNewIntructorComplaint(@RequestBody ComplaintDTO newComplaint ){
		//prvo treba da nadjem tu rezervaciju
		Optional<AdventureReservation> adventureReservation=this.adventureReservationService.findById(newComplaint.getIdReservation());
		if (!adventureReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		AdventureReservation adv=adventureReservation.get();
		Adventure adventure=adv.getAdventure();
		Client client=adv.getClient();
		
		AdventureComplaint newComplaint1=new AdventureComplaint(newComplaint.getDescription(), client, adventure,ComplaintType.Default);
		AdventureComplaint savedComplaint=this.adventurComplaintService.save(newComplaint1);
		ComplaintDTO savedComplaintDTO=new ComplaintDTO(savedComplaint);
		//potrebno je jos sacuvati zalbu u listi yalbi kod te reyervacije
		adv.getAdventureComplaints().add(savedComplaint);
		adv.setAdventureComplaints(adv.getAdventureComplaints());
		this.adventureReservationService.save(adv);
		return new ResponseEntity<>(savedComplaintDTO,HttpStatus.OK);
	}
}
