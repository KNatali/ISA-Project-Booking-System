package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.model.AdditionalItem;

public class AdditionalItemMapper {
	public static AdditionalItemDTO convertToDTO(AdditionalItem a) {
		AdditionalItemDTO aDTO=new AdditionalItemDTO(a.getId(),a.getName(),a.getPrice());
		return aDTO;
	}
	
	public static AdditionalItem convertFromDTO(AdditionalItemDTO aDTO) {
		AdditionalItem a=new AdditionalItem();
		a.setId(aDTO.getId());
		a.setName(aDTO.getName());
		a.setPrice(aDTO.getPrice());
		return a;
	}
}

