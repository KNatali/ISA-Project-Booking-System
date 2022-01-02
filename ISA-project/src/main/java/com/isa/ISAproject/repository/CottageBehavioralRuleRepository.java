package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageBehavioralRule;

@Repository
public interface CottageBehavioralRuleRepository extends JpaRepository<CottageBehavioralRule, Long>{

}
