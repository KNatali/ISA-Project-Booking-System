package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageFastReservation;

@Repository
public interface CottageFastReservationRepository extends JpaRepository<CottageFastReservation, Long>{

}
