package com.isa.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Role;
import com.isa.ISAproject.repository.RoleRepository;


@Service
public class RoleService {
	@Autowired
	  private RoleRepository roleRepository;

	
	  public Role findById(Long id) {
	    Role auth = this.roleRepository.getOne(id);
	    return auth;
	  }

	 
	  public Role findByName(String name) {
		Role role= this.roleRepository.findByName(name);
	    return role;
	  }
}
