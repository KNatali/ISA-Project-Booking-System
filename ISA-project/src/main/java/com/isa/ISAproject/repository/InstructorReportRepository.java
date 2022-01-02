package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.InstructorReport;

@Repository
public interface InstructorReportRepository extends JpaRepository<InstructorReport, Long> {

}
