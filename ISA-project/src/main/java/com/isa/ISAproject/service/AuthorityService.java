package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Authority;
import com.isa.ISAproject.repository.AuthorityRepository;



@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	 public Authority findById(Long id) {
		 Authority auth = this.authorityRepository.getById(id);
		    return auth;
		  }

		
		  public List<Authority> findByName(String name) {
			List<Authority> authorities = this.authorityRepository.findByName(name);
		    return authorities;
		  }
	
	public List<Authority> getAllRolesAuthorities(String role) {
        List<Authority> allAuths = authorityRepository.findAll();

        List<Authority> rolesAuthorities = new ArrayList<>();


        for(Authority a : allAuths){
            if(a.getName().equals(role)){
                rolesAuthorities.add(a);
            }
        }

        return rolesAuthorities;
    }

}
