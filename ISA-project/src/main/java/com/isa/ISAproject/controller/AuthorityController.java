package com.isa.ISAproject.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.model.Authority;
import com.isa.ISAproject.service.AuthorityService;

@RestController
@CrossOrigin

@RequestMapping(value = "/authscntr")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	
	@GetMapping(value = "/getRolesAuths", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Authority> getAuthorityByRole(@RequestParam("role") String role) throws ParseException {
        return authorityService.getAllRolesAuthorities(role);
    }
}
