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
import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.service.CottageComplaintService;
import com.isa.ISAproject.service.CottageReservationService;

@CrossOrigin("*")
@RestController
public class CottageComplaintController {
	
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@Autowired
	private CottageComplaintService cottageComplaintService;
	
	@RequestMapping(value="api/client/makeNewCottageComplaint",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComplaintDTO> makeNewCottageComplaint(@RequestBody ComplaintDTO newComplaint ){
		//prvo treba da nadjem tu rezervaciju
		Optional<CottageReservation> cottageReservation=this.cottageReservationService.findById(newComplaint.getIdReservation());
		if (!cottageReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		CottageReservation adv=cottageReservation.get();
		
		CottageComplaint newComplaint1=new CottageComplaint(newComplaint.getDescription(), adv);
		CottageComplaint savedComplaint=this.cottageComplaintService.save(newComplaint1);
		ComplaintDTO savedComplaintDTO=new ComplaintDTO(savedComplaint);
		//potrebno je jos sacuvati zalbu u listi yalbi kod te reyervacije
		adv.getCottageComplaints().add(savedComplaint);
		adv.setCottageComplaints(adv.getCottageComplaints());
		this.cottageReservationService.save(adv);
		return new ResponseEntity<>(savedComplaintDTO,HttpStatus.OK);
	}
}
