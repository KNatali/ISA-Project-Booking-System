package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Boat;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	List<Address> findByOrderByCity();
}
