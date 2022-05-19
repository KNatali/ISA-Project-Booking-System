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
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.service.BoatComplaintService;
import com.isa.ISAproject.service.BoatReservationService;

@CrossOrigin("*")
@RestController
public class BoatComplaintController {
	@Autowired
	private BoatReservationService boatReservationService;
	
	@Autowired
	private BoatComplaintService boatComplaintService;

	@RequestMapping(value="api/client/makeNewBoatComplaint",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComplaintDTO> makeNewBoatComplaint(@RequestBody ComplaintDTO newComplaint ){
		//prvo treba da nadjem tu rezervaciju
		Optional<BoatReservation> boatReservation=this.boatReservationService.findById(newComplaint.getIdReservation());
		if (!boatReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		BoatReservation adv=boatReservation.get();
		
		BoatComplaint newComplaint1=new BoatComplaint(newComplaint.getDescription(), adv);
		BoatComplaint savedComplaint=this.boatComplaintService.save(newComplaint1);
		ComplaintDTO savedComplaintDTO=new ComplaintDTO(savedComplaint);
		//potrebno je jos sacuvati zalbu u listi yalbi kod te reyervacije
		adv.getBoatComplaints().add(savedComplaint);
		adv.setBoatComplaints(adv.getBoatComplaints());
		this.boatReservationService.save(adv);
		return new ResponseEntity<>(savedComplaintDTO,HttpStatus.OK);
	}
}
