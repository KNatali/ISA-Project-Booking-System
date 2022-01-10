package com.isa.ISAproject.mapper;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageOwnerReportDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.InstructorReportDTO;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.CottageReservation;

public class CottageReservationMapper {
	
	public CottageReservationMapper() {}
	
	public static CottageReservationDTO convertToDTO(CottageReservation c) {
		CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
		CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
		ClientProfileDTO client=new ClientProfileDTO(c.getClient());
		Set<AdditionalItemDTO> items=new HashSet<>();
		for (AdditionalItem i : c.getAdditionalItems()) {
			AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
			items.add(dto);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		CottageReservationDTO dto=new CottageReservationDTO(c.getId(), c.getReservationStart().format(formatter), c.getReservationEnd().format(formatter),cottage,c.getPrice(),c.getMaxPersons(),client,report, items);
		return dto;
	}
}
