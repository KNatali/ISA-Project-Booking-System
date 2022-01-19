package com.isa.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.AppUser;



@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

	 AppUser findByUsername(String username);
}
