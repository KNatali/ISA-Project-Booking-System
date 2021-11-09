package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Boat;
@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {

}
