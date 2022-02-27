package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageRevision;

@Repository
public interface CottageRevisionRepository  extends JpaRepository<CottageRevision, Long>{

}
