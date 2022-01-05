package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.SystemEarnings;

@Repository
public interface SystemEarningsRepository extends JpaRepository<SystemEarnings, Long> {
}
