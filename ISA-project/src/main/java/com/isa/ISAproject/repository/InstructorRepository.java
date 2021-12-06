package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
	Instructor findByFirstNameAndLastName(String firstName, String lastName);
	List<Instructor> findByOrderByFirstName();
	List<Instructor> findByOrderByGradeDesc();
}
