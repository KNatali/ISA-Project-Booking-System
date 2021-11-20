package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageOwner;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Long> {
	CottageOwner findByFirstNameAndLastName(String firstName, String lastName);
}
