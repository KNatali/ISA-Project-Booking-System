package com.isa.ISAproject.mapper;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.BoatReservation;

public class BoatReservationMapper {
	public BoatReservationMapper() {}
	
	public static BoatReservationDTO convertToDTO(BoatReservation b) {
		BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
		ClientProfileDTO client=new ClientProfileDTO(b.getClient());
		Set<AdditionalItemDTO> items=new HashSet<>();
		for (AdditionalItem i : b.getAdditionalItems()) {
			AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
			items.add(dto);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		BoatReservationDTO dto=new BoatReservationDTO(b.getId(), b.getReservationStart().format(formatter), b.getReservationEnd().format(formatter),boat,b.getPrice(),b.getMaxPersons(),client,null, items);
		return dto;
	}
}
