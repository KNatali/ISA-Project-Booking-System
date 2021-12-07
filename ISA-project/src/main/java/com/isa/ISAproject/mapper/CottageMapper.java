package com.isa.ISAproject.mapper;

import java.util.ArrayList;
import java.util.List;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.model.Cottage;


public class CottageMapper {
	public CottageMapper() {}
	public static CottageDTO convertToDTO(Cottage c) {
		AddressDTO addressDTO=AddressMapper.convertToDTO(c.getAddress());
		CottageOwnerProfileDTO cottageOwnerDTO=CottageOwnerMapper.convertToDTO(c.getCottageOwner());
		CottageDTO cottageDTO=new CottageDTO(
				c.getId(),
				c.getName(),
				addressDTO,
				c.getDescription(),
				c.getGrade(),
				c.getPrice(),
				cottageOwnerDTO,
				c.getMainPicture(),
				c.getMaxPersons(),
				c.getCancellation()
				);
		return cottageDTO;
	}
	
	public static List<CottageDTO> convertoToDTOs(List<Cottage> cottages){
		List<CottageDTO> cottagesDTO=new ArrayList<>();
		for (Cottage c : cottages) {
			CottageDTO dto=convertToDTO(c);
			cottagesDTO.add(dto);	
		}
		return cottagesDTO;
	}
}
