package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.BoatBehavioralRule;

@Repository
public interface BoatBehavioralRuleRepository extends JpaRepository<BoatBehavioralRule, Long>{

}
