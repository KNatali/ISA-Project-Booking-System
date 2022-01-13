package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.NavigationEquipmentDTO;
import com.isa.ISAproject.mapper.NavigationEquipmentMapper;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.NavigationEquipment;
import com.isa.ISAproject.repository.BoatNavigationEquipmentRepository;
import com.isa.ISAproject.repository.BoatRepository;

@Service
public class BoatNavigationEquipmentService {

	@Autowired
	private BoatNavigationEquipmentRepository boatNavigationEquipmentRepository;
	@Autowired
	private BoatRepository boatRepository;
	
	public List<NavigationEquipmentDTO> getNavigationEquipment(Long id){
		Optional<Boat> boat=this.boatRepository.findById(id);
		Set<NavigationEquipment> list=boat.get().getNavigationEquipment();
		List<NavigationEquipmentDTO> listDTO=new ArrayList<>();
		for(NavigationEquipment n:list) { 
			NavigationEquipmentDTO nDTO=NavigationEquipmentMapper.convertToDTO(n);
			listDTO.add(nDTO);
		}
		return listDTO;
	}
	
	public void saveNewEquipment(Long id,NavigationEquipmentDTO eDTO) {
		NavigationEquipment n=NavigationEquipmentMapper.convertFromDTO(eDTO);
		
		Boat b=boatRepository.getById(id);
		this.boatNavigationEquipmentRepository.save(n);
		Set<NavigationEquipment> list=b.getNavigationEquipment();
		list.add(n);
		//a.setEquipment(list);
		
		this.boatRepository.save(b);		
	}
	
	public boolean editEquipment(Long id,NavigationEquipmentDTO eDTO) {
		NavigationEquipment n=boatNavigationEquipmentRepository.getById(eDTO.getId());
		NavigationEquipment edited=new NavigationEquipment();
		edited.setId(n.getId());
		edited.setName(eDTO.getName());
		this.boatNavigationEquipmentRepository.save(edited);
		Boat b=boatRepository.getById(id);
		
		Set<NavigationEquipment> list=b.getNavigationEquipment();
		list.remove(n);
		list.add(edited);		
		return true;
	}
	
	public boolean deleteEquipment (Long boatId,Long equipmentId) {
		NavigationEquipment n=this.boatNavigationEquipmentRepository.getById(equipmentId);
		Boat b=this.boatRepository.getById(boatId);
		if(n==null || b==null) {
			return false;
		}
		Set<NavigationEquipment> list=b.getNavigationEquipment();
		list.remove(n);
		
		this.boatNavigationEquipmentRepository.delete(n);
		this.boatRepository.save(b);
		return true;
	}
}
