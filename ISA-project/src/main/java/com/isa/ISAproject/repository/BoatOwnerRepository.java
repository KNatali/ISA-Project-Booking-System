package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatOwner;

@Repository
public interface BoatOwnerRepository  extends JpaRepository<BoatOwner, Long> {
	BoatOwner findByFirstNameAndLastName(String firstName, String lastName);
	List<BoatOwner> findByOrderByFirstName();
	List<BoatOwner> findByOrderByGradeDesc();
}
