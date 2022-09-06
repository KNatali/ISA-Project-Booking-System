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
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.CottageRepository;

@Service
public class CottageAdditionalItemService {
	@Autowired
	private AdditionalItemRepository additionalItemRepository;
	
	@Autowired
	private CottageRepository cottageRepository;
	
	public List<AdditionalItemDTO> getAdditionalIem(Long id){
		Cottage cottage=this.cottageRepository.getById(id);
		Set<AdditionalItem> list=cottage.getItems();
		List<AdditionalItemDTO> listDTO=new ArrayList<>();
		for(AdditionalItem a:list) { 
			AdditionalItemDTO aDTO=AdditionalItemMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	
	public void saveNewAdditonalItem(Long id,AdditionalItemDTO eDTO) {
		AdditionalItem e=AdditionalItemMapper.convertFromDTO(eDTO);
		Cottage c=cottageRepository.getById(id);
		this.additionalItemRepository.save(e);
		Set<AdditionalItem> list=c.getItems();
		list.add(e);
		this.cottageRepository.save(c);		
	}
	
	public boolean editAdditionalItem(Long id,AdditionalItemDTO eDTO) {
		AdditionalItem e=additionalItemRepository.getById(eDTO.getId());
		AdditionalItem edited=new AdditionalItem();
		edited.setId(e.getId());
		edited.setName(eDTO.getName());
		edited.setPrice(eDTO.getPrice());
		Cottage c=cottageRepository.getById(id);
		this.additionalItemRepository.save(edited);
		Set<AdditionalItem> list=c.getItems();
		list.remove(e);
		list.add(edited);
		return true;
	}
}
