package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageOwnerComplaint;

@Repository
public interface CottageOwnerComplaintRepository  extends JpaRepository<CottageOwnerComplaint, Long>{

}
