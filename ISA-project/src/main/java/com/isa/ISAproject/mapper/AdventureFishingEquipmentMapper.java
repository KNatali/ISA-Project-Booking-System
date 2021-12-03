package com.isa.ISAproject.mapper;

import java.util.ArrayList;
import java.util.List;

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
	
}
