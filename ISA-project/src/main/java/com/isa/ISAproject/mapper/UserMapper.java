package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.model.User;

public class UserMapper {
	
	public UserMapper() {}
	
	public static UserDTO convertToDTO(User u) {
		UserDTO userDTO=new UserDTO(
				u.getId(),
				u.getPassword(),
				u.getEmail(),
				u.getFirstName(),
				u.getLastName(),
				u.getAddress().getStreet(),
				u.getAddress().getState(),
				u.getAddress().getCity(),
				u.getMobile(),
				u.getUsername(),
				u.getRole(),
				u.getAddress().getLatitude(),
				u.getAddress().getLongitude()
				);
		return userDTO;
	}
}
