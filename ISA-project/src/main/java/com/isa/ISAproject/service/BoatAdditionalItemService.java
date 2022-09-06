package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.BoatRepository;

@Service
public class BoatAdditionalItemService {
	@Autowired
	private AdditionalItemRepository additionalItemRepository;
	
	@Autowired
	private BoatRepository boatRepository;
	
	public List<AdditionalItemDTO> getAdditionalIem(Long id){
		Boat boat=this.boatRepository.getById(id);
		Set<AdditionalItem> list=boat.getAdditionalItems();
		List<AdditionalItemDTO> listDTO=new ArrayList<>();
		for(AdditionalItem a:list) { 
			AdditionalItemDTO aDTO=AdditionalItemMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	
	public void saveNewAdditonalItem(Long id,AdditionalItemDTO eDTO) {
		AdditionalItem e=AdditionalItemMapper.convertFromDTO(eDTO);
		Boat b=boatRepository.getById(id);
		this.additionalItemRepository.save(e);
		Set<AdditionalItem> list=b.getAdditionalItems();
		list.add(e);
		this.boatRepository.save(b);		
	}
	
	public boolean editAdditionalItem(Long id,AdditionalItemDTO eDTO) {
		AdditionalItem e=additionalItemRepository.getById(eDTO.getId());
		AdditionalItem edited=new AdditionalItem();
		edited.setId(e.getId());
		edited.setName(eDTO.getName());
		edited.setPrice(eDTO.getPrice());
		Boat b=boatRepository.getById(id);
		this.additionalItemRepository.save(edited);
		Set<AdditionalItem> list=b.getAdditionalItems();
		list.remove(e);
		list.add(edited);
		return true;
	}
}
