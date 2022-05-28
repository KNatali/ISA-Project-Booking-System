package com.isa.ISAproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.ComplaintDTO;
import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatOwnerComplaint;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.service.BoatComplaintService;
import com.isa.ISAproject.service.BoatOwnerComplaintService;
import com.isa.ISAproject.service.BoatOwnerService;
import com.isa.ISAproject.service.BoatReservationService;

@CrossOrigin("*")
@RestController
public class BoatOwnerComplaintController {
	@Autowired
	private BoatReservationService boatReservationService;
	
	@Autowired
	private BoatOwnerService boatOwnerService;
	
	@Autowired
	private BoatOwnerComplaintService boatOwnerComplaintService;

	@RequestMapping(value="api/client/makeNewBoatOwnerComplaint",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComplaintDTO> makeNewBoatOwnerComplaint(@RequestBody ComplaintDTO newComplaint ){
		//prvo treba da nadjem tu rezervaciju
		Optional<BoatReservation> boatReservation=this.boatReservationService.findById(newComplaint.getIdReservation());
		if (!boatReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		BoatReservation adv=boatReservation.get();
		
		BoatOwnerComplaint newComplaint1=new BoatOwnerComplaint(newComplaint.getDescription(), adv);
		BoatOwnerComplaint savedComplaint=this.boatOwnerComplaintService.save(newComplaint1);
		ComplaintDTO savedComplaintDTO=new ComplaintDTO(savedComplaint);
		//potrebno je jos sacuvati zalbu u listi yalbi kod te reyervacije
		adv.getBoatOwnerComplaints().add(savedComplaint);
		adv.setBoatOwnerComplaints(adv.getBoatOwnerComplaints());
		this.boatReservationService.save(adv);
		return new ResponseEntity<>(savedComplaintDTO,HttpStatus.OK);
	}
}
