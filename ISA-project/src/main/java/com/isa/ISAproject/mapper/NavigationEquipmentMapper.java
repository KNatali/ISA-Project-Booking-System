package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.NavigationEquipmentDTO;
import com.isa.ISAproject.model.NavigationEquipment;

public class NavigationEquipmentMapper {
	public static NavigationEquipmentDTO convertToDTO(NavigationEquipment n) {
		NavigationEquipmentDTO neDTO=new NavigationEquipmentDTO(n.getId(),n.getName());
		return neDTO;
	}
	
	public static NavigationEquipment convertFromDTO(NavigationEquipmentDTO nDTO) {
		NavigationEquipment ne=new NavigationEquipment();
		ne.setId(nDTO.getId());
		ne.setName(nDTO.getName());
		return ne;
	}
}
