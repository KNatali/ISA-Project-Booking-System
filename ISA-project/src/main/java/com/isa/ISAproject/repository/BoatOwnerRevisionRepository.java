package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatOwnerRevision;

@Repository
public interface BoatOwnerRevisionRepository extends JpaRepository<BoatOwnerRevision, Long> {

}
