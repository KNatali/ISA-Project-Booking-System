package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatOwnerReport;


@Repository
public interface BoatOwnerReportRepository extends JpaRepository<BoatOwnerReport, Long>{

}
