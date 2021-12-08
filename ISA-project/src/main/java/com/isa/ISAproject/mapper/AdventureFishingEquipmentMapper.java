package com.isa.ISAproject.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFishingEquipment;

public class AdventureFishingEquipmentMapper {

	public  AdventureFishingEquipmentMapper() {}
	
	public static AdventureFishingEquipmentDTO convertToDTO(AdventureFishingEquipment equipment ) {
		AdventureFishingEquipmentDTO equipmentDTO=new AdventureFishingEquipmentDTO(
				equipment.getId(), 
				equipment.getName());
		
		return equipmentDTO;
	}
	
	public static List<AdventureFishingEquipmentDTO> convertoToDTOs(List<AdventureFishingEquipment> equipment){
		List<AdventureFishingEquipmentDTO> equipmentDTO=new ArrayList<>();
		for (AdventureFishingEquipment a : equipment) {
			AdventureFishingEquipmentDTO dto=convertToDTO(a);
			equipmentDTO.add(dto);
			
		}
		
		return equipmentDTO;
	}
	
	public static AdventureFishingEquipment convertFromDTO(AdventureFishingEquipmentDTO dto) {
		AdventureFishingEquipment equipment=new AdventureFishingEquipment(dto.getId(),dto.getName());
		return equipment;
		
	}
	
	public static Set<AdventureFishingEquipment> converFromDTOs(Set<AdventureFishingEquipmentDTO> equipmentDTO){
		Set<AdventureFishingEquipment> equipment=new HashSet<>();
		for (AdventureFishingEquipmentDTO dto : equipmentDTO) {
			AdventureFishingEquipment a=convertFromDTO(dto);
			equipment.add(a);
			
		}
		
		return equipment;
	}
}
