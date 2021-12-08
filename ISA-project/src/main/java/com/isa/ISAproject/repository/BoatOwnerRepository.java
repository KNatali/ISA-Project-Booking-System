package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatOwner;

@Repository
public interface BoatOwnerRepository  extends JpaRepository<BoatOwner, Long> {

}
