package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatRevision;

@Repository
public interface BoatRevisionRepository  extends JpaRepository<BoatRevision, Long> {

}
