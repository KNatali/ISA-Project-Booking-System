package com.isa.ISAproject.mapper;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageFastReservationDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.CottageFastReservation;


public class CottageFastReservationMapper {
	public CottageFastReservationMapper() {}
	public static CottageFastReservationDTO convertToDTO(CottageFastReservation c) {
		CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
		Set<AdditionalItemDTO> items=new HashSet<>();
		for (AdditionalItem i : c.getAdditionalItems()) {
			AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
			items.add(dto);
			
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		CottageFastReservationDTO dto=new CottageFastReservationDTO(c.getId(),c.getReservationStart().format(formatter),c.getReservationEnd().format(formatter),c.getDuration(),c.getMaxPersons(),c.getPrice(),c.getValidityStart().format(formatter1),c.getValidityEnd().format(formatter1),cottage,items);
		return dto;
	}
}
