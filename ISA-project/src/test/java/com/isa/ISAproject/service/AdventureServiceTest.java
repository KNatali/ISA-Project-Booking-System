package com.isa.ISAproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.assertj.core.internal.Iterables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static com.isa.ISAproject.constants.AdventureConstants.NEW_ADDRESS_STREET;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_ADDRESS_CITY;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_ADDRESS_STATE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_DESCRIPTION;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_PERCENTAGE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_PERSONS;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_PRICE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_GRADE;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_ID;
import static com.isa.ISAproject.constants.AdventureConstants.NEW_NAME;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ADDRESS_STREET;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ADDRESS_CITY;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ADDRESS_STATE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_DESCRIPTION;
import static com.isa.ISAproject.constants.AdventureConstants.DB_PERCENTAGE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_PERSONS;
import static com.isa.ISAproject.constants.AdventureConstants.DB_PRICE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_GRADE;
import static com.isa.ISAproject.constants.AdventureConstants.DB_ID;
import static com.isa.ISAproject.constants.AdventureConstants.DB_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_FIRST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_LAST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_EMAIL;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_MOBILE;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_PASSWORD;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_USERNAME;
import static com.isa.ISAproject.constants.InstructorConstants.NEW_ROLE;
import static com.isa.ISAproject.constants.InstructorConstants.DB_FIRST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.DB_LAST_NAME;
import static com.isa.ISAproject.constants.InstructorConstants.DB_EMAIL;
import static com.isa.ISAproject.constants.InstructorConstants.DB_MOBILE;
import static com.isa.ISAproject.constants.InstructorConstants.DB_PASSWORD;
import static com.isa.ISAproject.constants.InstructorConstants.DB_USERNAME;
import static com.isa.ISAproject.constants.InstructorConstants.DB_ROLE;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.mapper.AdventureFishingEquipmentMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureFishingEquipmentRepository;
import com.isa.ISAproject.repository.AdventureRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdventureServiceTest {

	

	@Mock
	private AdventureRepository adventureRepositoryMock;
	@Mock
	private AdventureFishingEquipmentRepository adventureFishingEquipmentRepositoryMock;
	
	@Mock
	private Adventure adventreMock;
	@Mock
	private AdventureDTO adventreDTOMock;
	@Mock
	private Instructor instructorMock;
	@Mock 
	private AdventureFishingEquipment adventureFishingEquipmentMock;
	@Mock
	private Address addressMock;
	
	@InjectMocks
	private AdventureService adventureService;
	
	@Test
	public void testFindAll() {
	
		Address address=new Address(NEW_ADDRESS_STREET,NEW_ADDRESS_CITY,NEW_ADDRESS_STATE,0,0);
		Instructor instructor=new Instructor(NEW_ID,NEW_USERNAME,NEW_PASSWORD,NEW_EMAIL,NEW_FIRST_NAME,NEW_LAST_NAME,address,NEW_MOBILE,true,NEW_ROLE,null,7,null,"");
		List<Adventure> adventures=new ArrayList<>();
		adventures.add(new Adventure(NEW_ID,NEW_NAME,address,NEW_DESCRIPTION,NEW_GRADE,NEW_PRICE,instructor,"",null,NEW_PERSONS,null,null,NEW_PERCENTAGE,null,null,null));
		
		// 1. 
		when(adventureRepositoryMock.findAll()).thenReturn(adventures);
		
		// 2. Akcija
		List<AdventureDTO> adventuresDTO = adventureService.findAll();
		
		// 3. Verifikacija: asertacije i/ili verifikacija interakcije sa mock objektima
		assertThat(adventuresDTO).hasSize(1);
		assertEquals(adventuresDTO.get(0).getId(), NEW_ID);
		assertEquals(adventuresDTO.get(0).getName(), NEW_NAME);
		assertEquals(adventuresDTO.get(0).getAddress().getStreet(), NEW_ADDRESS_STREET);
		verify(adventureRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(adventureRepositoryMock);
	}
	
	@Test
	public void testEditAdventure() {
		Address address=new Address(DB_ADDRESS_STREET,DB_ADDRESS_CITY,DB_ADDRESS_STATE,0,0);
		Instructor instructor=new Instructor(DB_ID,DB_USERNAME,DB_PASSWORD,DB_EMAIL,DB_FIRST_NAME,DB_LAST_NAME,address,DB_MOBILE,true,DB_ROLE,null,7,null,"");
		Adventure adventure=new  Adventure(DB_ID,DB_NAME,address,DB_DESCRIPTION,DB_GRADE,DB_PRICE,instructor,"",null,DB_PERSONS,null,null,DB_PERCENTAGE,null,null,null);
		when(adventureRepositoryMock.getById(DB_ID)).thenReturn(adventure);
		
		AddressDTO addressDTO=new AddressDTO(NEW_ID,NEW_ADDRESS_STREET,NEW_ADDRESS_STATE,NEW_ADDRESS_CITY,0,0);
		InstructorProfileDTO instructorDTO=new InstructorProfileDTO(instructor);
		AdventureDTO adventureUpdate=new AdventureDTO(NEW_ID,NEW_NAME,addressDTO,NEW_DESCRIPTION,NEW_GRADE,NEW_PRICE,instructorDTO,"",NEW_PERSONS,NEW_PERCENTAGE);
		
		when(adventureRepositoryMock.save(adventure)).thenReturn(adventure);
		
		adventureService.editAdventure(DB_ID, adventureUpdate);
		
		assertEquals(adventure.getName(), adventureUpdate.getName());
		assertEquals(adventure.getAddress().getStreet(), adventureUpdate.getAddress().getStreet());
		
		verify(adventureRepositoryMock, times(1)).getById(DB_ID);
        verify(adventureRepositoryMock, times(1)).save(adventure);
        verifyNoMoreInteractions(adventureRepositoryMock);
	
	}
	
	
	@Test
	public void testGetAdventureEquipment() {
		Address address=new Address(DB_ADDRESS_STREET,DB_ADDRESS_CITY,DB_ADDRESS_STATE,0,0);
		Instructor instructor=new Instructor(DB_ID,DB_USERNAME,DB_PASSWORD,DB_EMAIL,DB_FIRST_NAME,DB_LAST_NAME,address,DB_MOBILE,true,DB_ROLE,null,7,null,"");
		Adventure adventure=new  Adventure(DB_ID,DB_NAME,address,DB_DESCRIPTION,DB_GRADE,DB_PRICE,instructor,"",null,DB_PERSONS,null,null,DB_PERCENTAGE,null,null,null);
		Set<AdventureFishingEquipment> setEquipment=new HashSet<>();
		setEquipment.add(new AdventureFishingEquipment(NEW_ID, NEW_NAME));
		adventure.setEquipment(setEquipment);
		
		when(adventureRepositoryMock.getById(DB_ID)).thenReturn(adventure);
		
		List<AdventureFishingEquipmentDTO> equipmentDTO=adventureService.getAdventureEquipment(DB_ID);
		
		assertThat(equipmentDTO).hasSize(1);
		assertEquals(equipmentDTO.get(0).getId(), NEW_ID);
		assertEquals(equipmentDTO.get(0).getName(), NEW_NAME);
		
		verify(adventureRepositoryMock, times(1)).getById(DB_ID);
        verifyNoMoreInteractions(adventureRepositoryMock);
	
	
	}
	
}
