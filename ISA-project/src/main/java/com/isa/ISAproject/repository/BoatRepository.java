package com.isa.ISAproject.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.Instructor;
@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
	List<Boat> findByMotorNumber(int motorNumber);
	List<Boat> findByMotorPower(double motorPower);
	List<Boat> findByName(String name);
	List<Boat> findByMotorPowerAndMotorNumber(double motorPower, int motorNumber);
	List<Boat> findByOrderByName();
	List<Boat> findByPrice(double price);
	List<Boat> findByGrade(double grade);
	List<Boat> findByOrderByGradeDesc();
	List<Boat> findByOrderByPriceDesc();
	List<Boat> findByAddress(String address);
	List<Boat> findByOwner(BoatOwner owner);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from Boat p where p.id = :id")
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
	public Boat findOneById(@Param("id")Long id);
}

