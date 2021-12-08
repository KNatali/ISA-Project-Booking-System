package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.CottageReservation;
@Repository
public interface CottageReservationRepository extends JpaRepository<CottageReservation, Long>{
	List<CottageReservation> findByOrderByDateDesc();
	List<CottageReservation> findByOrderByPriceDesc();
	List<CottageReservation> findByOrderByDurationDesc();
}
