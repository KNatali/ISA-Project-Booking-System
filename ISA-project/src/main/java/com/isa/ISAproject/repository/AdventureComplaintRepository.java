package com.isa.ISAproject.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
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
import com.isa.ISAproject.model.ProfileDeleteRequest;
import com.isa.ISAproject.model.SystemEarnings;

@Repository
public interface AdventureComplaintRepository  extends JpaRepository<AdventureComplaint, Long>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from AdventureComplaint p where p.id = :id")
	
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
	public AdventureComplaint findOneById(@Param("id")Long id);
	
}
