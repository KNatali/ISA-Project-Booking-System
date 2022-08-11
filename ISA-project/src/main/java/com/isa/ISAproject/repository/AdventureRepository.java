package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Instructor;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Long>{
	List<Adventure> findByInstructor(Instructor instructor);
	List<Adventure> findByName(String name);
	List<Adventure> findByAverageGrade(double averageGrade);
	List<Adventure> findByPrice(double price);
	List<Adventure> findByOrderByAverageGradeDesc();
	List<Adventure> findByOrderByPriceDesc();
}
