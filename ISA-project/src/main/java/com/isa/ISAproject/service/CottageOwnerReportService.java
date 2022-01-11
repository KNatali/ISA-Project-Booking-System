package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.CottageOwnerReportDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.CottageOwnerReport;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.CottageOwnerReportRepository;
import com.isa.ISAproject.repository.CottageReservationRepository;

@Service
public class CottageOwnerReportService {
	@Autowired
	private CottageOwnerReportRepository cottageOwnerReportRepository;
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	public CottageOwnerReportDTO saveReservationReport(CottageOwnerReportDTO dto) {
		CottageReservation reservation=cottageReservationRepository.getById(dto.getCottageReservation().getId());
		
		CottageOwnerReport report=new CottageOwnerReport(dto.getId(),dto.getContent(),dto.isCheckAdmin(),dto.isPenal(),false,reservation);
		if(report.isPenal()) {
			Client client=clientRepository.getById(dto.getCottageReservation().getClient().getId());
			client.setNumberOfPenals(client.getNumberOfPenals()+1);
			report.setChecked(true);
			clientRepository.save(client);
		}
		
		this.cottageOwnerReportRepository.save(report);		
	return dto;
		
	}
	
	public List<CottageOwnerReportDTO> findAll() throws AccessDeniedException {
		List<CottageOwnerReport> requests=cottageOwnerReportRepository.findAll();
		List<CottageOwnerReportDTO> requestsDTO=new ArrayList<>();
		for (CottageOwnerReport r : requests) {
			if(r.isCheckAdmin() && !r.isChecked()) {
				CottageReservationDTO rDTO=CottageReservationMapper.convertToDTO(r.getCottageReservation());
				CottageOwnerReportDTO dto=new CottageOwnerReportDTO(r.getId(),r.getContent(),r.isCheckAdmin(),r.isPenal(),r.isChecked(),rDTO);
				requestsDTO.add(dto);
			}
		}
		return requestsDTO;
	}
	
	public void acceptReport(CottageOwnerReportDTO dto) {
		CottageOwnerReport report=cottageOwnerReportRepository.getById(dto.getId());
		report.setChecked(true);
		Client client=clientRepository.getById(dto.getCottageReservation().getClient().getId());
		client.setNumberOfPenals(client.getNumberOfPenals()+1);
		clientRepository.save(client);		
		cottageOwnerReportRepository.save(report);
	}
	
	public void rejectReport(CottageOwnerReportDTO dto) {
		CottageOwnerReport report=cottageOwnerReportRepository.getById(dto.getId());
		report.setChecked(true);
		cottageOwnerReportRepository.save(report);
	}
}
