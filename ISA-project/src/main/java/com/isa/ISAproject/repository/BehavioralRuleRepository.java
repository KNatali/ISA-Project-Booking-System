package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.AdventureBehavioralRule;

@Repository
public interface BehavioralRuleRepository extends JpaRepository<AdventureBehavioralRule, Long>{

}
