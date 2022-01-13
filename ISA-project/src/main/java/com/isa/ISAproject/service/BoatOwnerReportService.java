package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.BoatOwnerReportDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.mapper.BoatReservationMapper;
import com.isa.ISAproject.model.BoatOwnerReport;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.repository.BoatOwnerReportRepository;
import com.isa.ISAproject.repository.BoatReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;

@Service
public class BoatOwnerReportService {
	@Autowired
	private BoatOwnerReportRepository boatOwnerReportRepository;
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	public BoatOwnerReportDTO saveReservationReport(BoatOwnerReportDTO dto) {
		BoatReservation reservation=boatReservationRepository.getById(dto.getBoatReservation().getId());
		
		BoatOwnerReport report=new BoatOwnerReport(dto.getId(),dto.getContent(),dto.isCheckAdmin(),dto.isPenal(),false,reservation);
		if(report.isPenal()) {
			Client client=clientRepository.getById(dto.getBoatReservation().getClient().getId());
			client.setNumberOfPenals(client.getNumberOfPenals()+1);
			report.setChecked(true);
			clientRepository.save(client);
		}
		
		this.boatOwnerReportRepository.save(report);		
	return dto;
		
	}
	
	public List<BoatOwnerReportDTO> findAll() throws AccessDeniedException {
		List<BoatOwnerReport> requests=boatOwnerReportRepository.findAll();
		List<BoatOwnerReportDTO> requestsDTO=new ArrayList<>();
		for (BoatOwnerReport r : requests) {
			if(r.isCheckAdmin() && !r.isChecked()) {
				BoatReservationDTO rDTO=BoatReservationMapper.convertToDTO(r.getBoatReservation());
				BoatOwnerReportDTO dto=new BoatOwnerReportDTO(r.getId(),r.getContent(),r.isCheckAdmin(),r.isPenal(),r.isChecked(),rDTO);
				requestsDTO.add(dto);
			}
		}
		return requestsDTO;
	}
	
	public void acceptReport(BoatOwnerReportDTO dto) {
		BoatOwnerReport report=boatOwnerReportRepository.getById(dto.getId());
		report.setChecked(true);
		Client client=clientRepository.getById(dto.getBoatReservation().getClient().getId());
		client.setNumberOfPenals(client.getNumberOfPenals()+1);
		clientRepository.save(client);		
		boatOwnerReportRepository.save(report);
	}
	
	public void rejectReport(BoatOwnerReportDTO dto) {
		BoatOwnerReport report=boatOwnerReportRepository.getById(dto.getId());
		report.setChecked(true);
		boatOwnerReportRepository.save(report);
	}
}
