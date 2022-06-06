package com.isa.ISAproject.mapper;

import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.dto.NavigationEquipmentDTO;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.model.NavigationEquipment;

public class NavigationEquipmentMapper {
	public NavigationEquipmentMapper() {}
	
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
	
	public static Set<NavigationEquipment> convertFromDTOs(Set<NavigationEquipmentDTO> equipmentDTO){
		Set<NavigationEquipment> equipment=new HashSet<>();
		for (NavigationEquipmentDTO dto : equipmentDTO) {
			NavigationEquipment n=convertFromDTO(dto);
			equipment.add(n);
			
		}
		
		return equipment;
	}
}
