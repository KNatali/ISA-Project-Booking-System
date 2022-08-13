package com.isa.ISAproject.repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.AdventureComplaint;
import com.isa.ISAproject.model.BoatComplaint;

@Repository
public interface BoatComplaintRepository extends JpaRepository<BoatComplaint, Long>{

	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from BoatComplaint p where p.id = :id")
	
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
	public BoatComplaint findOneById(@Param("id")Long id);
	
}
