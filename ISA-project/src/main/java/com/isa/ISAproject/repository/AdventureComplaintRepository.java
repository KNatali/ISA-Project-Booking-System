package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isa.ISAproject.dto.AdventureComplaintDTO;
import com.isa.ISAproject.dto.SystemEarningsDTO;
import com.isa.ISAproject.model.AdventureComplaint;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.model.SystemEarnings;

@Repository
public interface AdventureComplaintRepository  extends JpaRepository<AdventureComplaint, Long>{

	
	
}
