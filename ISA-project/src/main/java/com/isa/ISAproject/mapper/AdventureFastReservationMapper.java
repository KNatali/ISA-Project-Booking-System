package com.isa.ISAproject.mapper;

import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.AdventureFastReservation;

public class AdventureFastReservationMapper {
	
	public AdventureFastReservationMapper() {}
	
	public static AdventureFastReservationDTO convertToDTO(AdventureFastReservation a) {
		AdventureDTO adventure=AdventureMapper.convertToDTO(a.getAdventure());
		Set<AdditionalItemDTO> items=new HashSet<>();
		for (AdditionalItem i : a.getAdditionalItems()) {
			AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
			items.add(dto);
			
		}
		AdventureFastReservationDTO dto=new AdventureFastReservationDTO(a.getId(),a.getReservationStart(),a.getDuration(),a.getMaxPersons(),a.getPrice(),a.getValidityEnd(),a.getValidityEnd(),adventure,items);
	return dto;
	}

}
