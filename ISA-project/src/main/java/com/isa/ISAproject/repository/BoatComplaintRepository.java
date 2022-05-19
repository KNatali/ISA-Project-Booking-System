package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatComplaint;

@Repository
public interface BoatComplaintRepository extends JpaRepository<BoatComplaint, Long>{

}
