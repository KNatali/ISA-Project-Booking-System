package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatReservation;
@Repository
public interface BoatReservationRepository extends JpaRepository<BoatReservation, Long>{
	List<BoatReservation> findByOrderByDateDesc();
	List<BoatReservation> findByOrderByPriceDesc();
	List<BoatReservation> findByOrderByDurationDesc();
	List<BoatReservation> findByOrderByReservationStartDesc();
	List<BoatReservation> findByBoat(Boat boat);
}
