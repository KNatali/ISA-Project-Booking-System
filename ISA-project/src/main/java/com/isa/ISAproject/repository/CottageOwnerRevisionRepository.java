package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageOwnerRevision;

@Repository
public interface CottageOwnerRevisionRepository extends JpaRepository<CottageOwnerRevision, Long>{

}
