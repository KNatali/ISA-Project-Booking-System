package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageReservation;
@Repository
public interface CottageReservationRepository extends JpaRepository<CottageReservation, Long>{

}
