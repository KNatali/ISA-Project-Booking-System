package com.isa.ISAproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.repository.AdventureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdventureServiceTest {

	@Mock
	private AdventureRepository adventureRepositoryMock;
	
	@Mock
	private Adventure adventreMock;
	@Mock
	private AdventureDTO adventreDTOMock;
	@Mock
	private Address addressMock;
	
	@InjectMocks
	private AdventureService adventureService;
	
	@Test
	public void testFindAll() {
	
		Address address=new Address("Vidovdanska","Rs","Gradiska",0,0);
		List<Adventure> adventures=new ArrayList<>();
		adventures.add(new Adventure((long) 1,"Star fish",address,"ds",8,200,null,"",null,3,null,null,10,null,null,null));
		
		// 1. 
		when(adventureRepositoryMock.findAll()).thenReturn(adventures);
		
		// 2. Akcija
		List<AdventureDTO> adventuresDTO = adventureService.findAll();
		
		// 3. Verifikacija: asertacije i/ili verifikacija interakcije sa mock objektima
		assertThat(adventuresDTO).hasSize(1);
		assertEquals(adventuresDTO.get(0).getName(), "Star fish");
		
		/*
		Možemo verifikovati ponašanje mokovanih objekata pozivanjem verify* metoda.
		 */
		verify(adventureRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(adventureRepositoryMock);
	}
}
