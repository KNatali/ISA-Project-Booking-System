package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import com.isa.ISAproject.model.Boat;
@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
	List<Boat> findByMotorNumber(int motorNumber);
	List<Boat> findByMotorPower(double motorPower);
	List<Boat> findByMotorPowerAndMotorNumber(double motorPower, int motorNumber);
	List<Boat> findByOrderByName();
}
