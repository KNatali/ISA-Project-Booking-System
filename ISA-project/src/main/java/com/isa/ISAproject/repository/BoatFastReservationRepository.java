package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatFastReservation;

@Repository
public interface BoatFastReservationRepository extends JpaRepository<BoatFastReservation, Long>{

}
