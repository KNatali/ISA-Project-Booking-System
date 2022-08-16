package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.model.AppUser;

public class UserMapper {
	
	public UserMapper() {}
	
	public static UserDTO convertToDTO(AppUser u) {
		UserDTO userDTO=new UserDTO(
				u.getId(),
				u.getUsername(),
				u.getPassword(),
				u.getEmail(),
				u.getFirstName(),
				u.getLastName(),
				u.getAddress().getStreet(),
				u.getAddress().getState(),
				u.getAddress().getCity(),
				u.getMobile(),
				
				u.getRole(),
				u.getAddress().getLatitude(),
				u.getAddress().getLongitude()
				);
		return userDTO;
	}
}
