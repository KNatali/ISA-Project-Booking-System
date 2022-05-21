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
import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.model.CottageOwnerComplaint;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.service.CottageComplaintService;
import com.isa.ISAproject.service.CottageOwnerComplaintService;
import com.isa.ISAproject.service.CottageReservationService;

@CrossOrigin("*")
@RestController
public class CottageOwnerComplaintController {
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@Autowired
	private CottageOwnerComplaintService cottageOwnerComplaintService;
	
	@RequestMapping(value="api/client/makeNewCottageOwnerComplaint",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComplaintDTO> makeNewCottageComplaint(@RequestBody ComplaintDTO newComplaint ){
		//prvo treba da nadjem tu rezervaciju
		Optional<CottageReservation> cottageReservation=this.cottageReservationService.findById(newComplaint.getIdReservation());
		if (!cottageReservation.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		CottageReservation adv=cottageReservation.get();
		
		CottageOwnerComplaint newComplaint1=new CottageOwnerComplaint(newComplaint.getDescription(), adv);
		CottageOwnerComplaint savedComplaint=this.cottageOwnerComplaintService.save(newComplaint1);
		ComplaintDTO savedComplaintDTO=new ComplaintDTO(savedComplaint);
		//potrebno je jos sacuvati zalbu u listi yalbi kod te reyervacije
		adv.getCottageOwnerComplaints().add(savedComplaint);
		adv.setCottageOwnerComplaints(adv.getCottageOwnerComplaints());
		this.cottageReservationService.save(adv);
		return new ResponseEntity<>(savedComplaintDTO,HttpStatus.OK);
	}
}
