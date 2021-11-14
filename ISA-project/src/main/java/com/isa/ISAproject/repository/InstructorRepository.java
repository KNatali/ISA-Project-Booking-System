package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
