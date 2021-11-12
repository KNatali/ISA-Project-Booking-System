package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Adventure;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Long>{

}
