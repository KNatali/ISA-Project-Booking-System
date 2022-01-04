package com.isa.ISAproject.mapper;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.InstructorReportDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.AdventureReservation;

public class AdventureReservationMapper {
	public AdventureReservationMapper() {}
	
	public static AdventureReservationDTO convertToDTO(AdventureReservation a) {
		AdventureDTO adventure=AdventureMapper.convertToDTO(a.getAdventure());
		ClientProfileDTO client=new ClientProfileDTO(a.getClient());
		Set<AdditionalItemDTO> items=new HashSet<>();
		for (AdditionalItem i : a.getAdditionalItems()) {
			AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
			items.add(dto);
			
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		AdventureReservationDTO dto=new AdventureReservationDTO(a.getId(), a.getReservationStart().format(formatter), a.getReservationEnd().format(formatter),adventure,a.getPrice(),a.getNumberOfPersons(),client, items);
	return dto;
	}
	
	
	
	

}
