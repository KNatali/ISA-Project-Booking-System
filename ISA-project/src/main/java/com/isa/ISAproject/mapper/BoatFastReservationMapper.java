package com.isa.ISAproject.mapper;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatFastReservationDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageFastReservationDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.BoatFastReservation;
import com.isa.ISAproject.model.CottageFastReservation;

public class BoatFastReservationMapper {
	public BoatFastReservationMapper() {}
	public static BoatFastReservationDTO convertToDTO(BoatFastReservation b) {
		BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
		Set<AdditionalItemDTO> items=new HashSet<>();
		for (AdditionalItem i : b.getAdditionalItems()) {
			AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
			items.add(dto);
			
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		BoatFastReservationDTO dto=new BoatFastReservationDTO(b.getId(),b.getReservationStart().format(formatter),b.getReservationEnd().format(formatter),b.getDuration(),b.getMaxPersons(),b.getPrice(),b.getValidityStart().format(formatter1),b.getValidityEnd().format(formatter1),boat,items);
		return dto;
	}
}
