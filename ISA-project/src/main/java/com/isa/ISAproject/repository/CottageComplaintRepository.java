package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.CottageComplaint;

@Repository
public interface CottageComplaintRepository extends JpaRepository<CottageComplaint, Long>{

}
