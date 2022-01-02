package com.isa.ISAproject.mapper;

import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
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
		CottageFastReservationDTO dto=new CottageFastReservationDTO(c.getId(),c.getReservationStart(),c.getDuration(),c.getMaxPersons(),c.getPrice(),c.getValidityEnd(),c.getValidityEnd(),cottage,items);
	return dto;
	}
}
