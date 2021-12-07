package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFishingEquipmentMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AdventureRepository;

@Service
public class AdventureAdditionalItemService {

	@Autowired
	private AdditionalItemRepository additionalItemRepository;
	
	@Autowired
	private AdventureRepository adventureRepository;
	
	public List<AdditionalItemDTO> getAdditionalIem(Long id){
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		Set<AdditionalItem> list=adventure.get().getAdditionalItems();
		List<AdditionalItemDTO> listDTO=new ArrayList<>();
		for(AdditionalItem a:list) { 
			AdditionalItemDTO aDTO=AdditionalItemMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	
	public void saveNewAdditonalItem(Long id,AdditionalItemDTO eDTO) {
		AdditionalItem e=AdditionalItemMapper.convertFromDTO(eDTO);

		Adventure a=adventureRepository.getById(id);
		
		this.additionalItemRepository.save(e);
		Set<AdditionalItem> list=a.getAdditionalItems();
		list.add(e);
		
		this.adventureRepository.save(a);
		
		
	}
	
	public boolean editAdditionalItem(Long id,AdditionalItemDTO eDTO) {
		AdditionalItem e=additionalItemRepository.getById(eDTO.getId());
		AdditionalItem edited=new AdditionalItem();
		edited.setId(e.getId());
		edited.setName(eDTO.getName());
		edited.setPrice(eDTO.getPrice());
		
		Adventure a=adventureRepository.getById(id);
		
		this.additionalItemRepository.save(edited);
		
		
		Set<AdditionalItem> list=a.getAdditionalItems();
		list.remove(e);
		list.add(edited);
			
		
		
		return true;
	}
}
