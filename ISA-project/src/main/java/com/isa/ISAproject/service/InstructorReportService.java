package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.InstructorReportDTO;
import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.mapper.UserMapper;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.InstructorReport;
import com.isa.ISAproject.model.ProfileDeleteRequest;
import com.isa.ISAproject.model.User;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.InstructorReportRepository;


@Service
public class InstructorReportService {
	
	@Autowired
	private InstructorReportRepository instructorReportRepository;
	@Autowired
	private AdventureReservationRepository adventureReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	public InstructorReportDTO saveReservationReport(InstructorReportDTO dto) {
		AdventureReservation reservation=adventureReservationRepository.getById(dto.getAdventureReservation().getId());
		
		InstructorReport report=new InstructorReport(dto.getId(),dto.getContent(),dto.isCheckAdmin(),dto.isPenal(),reservation);
		if(report.isPenal()) {
			Client client=clientRepository.getById(dto.getAdventureReservation().getClient().getId());
			client.setNumberOfPenals(client.getNumberOfPenals()+1);
			clientRepository.save(client);
		}
		
		//report.setAdventureReservation(reservation);
		this.instructorReportRepository.save(report);
		//reservation.setReport(report);
		//adventureReservationRepository.save(reservation);
		
	return dto;
		
	}
	
	public List<InstructorReportDTO> findAll() throws AccessDeniedException {
		List<InstructorReport> requests=instructorReportRepository.findAll();
		List<InstructorReportDTO> requestsDTO=new ArrayList<>();
		for (InstructorReport r : requests) {
			AdventureReservationDTO rDTO=AdventureReservationMapper.convertToDTO(r.getAdventureReservation());
			InstructorReportDTO dto=new InstructorReportDTO(r.getId(),r.getContent(),r.isCheckAdmin(),r.isPenal(),rDTO);
			requestsDTO.add(dto);
		
	 }
	 return requestsDTO;
	}

}
