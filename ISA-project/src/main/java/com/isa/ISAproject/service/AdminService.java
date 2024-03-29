package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdminProfileDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.exception.ResourceConflictException;
import com.isa.ISAproject.model.Admin;
import com.isa.ISAproject.model.AppUser;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdminRepository;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired 
	private UserService userService;
	
	
	public List<Admin> findAll() {
		return this.adminRepository.findAll();
	}
	public Page<Admin> findAll(Pageable page) {
		return adminRepository.findAll(page);
	}
	public Optional<Admin> findById(Long id) {
		return this.adminRepository.findById(id);
	}
	
	public AdminProfileDTO changePassword(Long id,PasswordChangeDTO dto) {
		Admin admin=adminRepository.getById(id);
		
		String newPasswordHash=passwordEncoder.encode(dto.getNewPassword());
		admin.setPassword(newPasswordHash);
		admin.setFirstLogin(false);
		adminRepository.save(admin);
		AdminProfileDTO adminDTO=new AdminProfileDTO(admin);
		return adminDTO;
	}
	
	public Admin save(Admin newAdmin) {
		return this.adminRepository.save(newAdmin);
	}
	
	public void deleteUser(Long id) {
		AppUser user=this.userRepository.getById(id);
		user.setDeleted(true);
		this.userRepository.save(user);
	}
	
	public boolean addNewAdmin(UserDTO dto) {
		AppUser existUser = this.userService.findByUsername(dto.getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(dto.getId(), "Username already exists");
			
		}

		AppUser user = this.userService.save(dto);
		return true;
	}

}
