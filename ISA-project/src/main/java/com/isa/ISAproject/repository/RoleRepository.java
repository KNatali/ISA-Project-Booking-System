package com.isa.ISAproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.ISAproject.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
