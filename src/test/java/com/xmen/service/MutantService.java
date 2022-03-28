package com.xmen.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.xmen.dto.MutantStats;
import com.xmen.entity.Dna;
import com.xmen.repository.DnaRepository;
import com.xmen.service.impl.MutantServiceImpl;

@ExtendWith(MockitoExtension.class)
class MutantService {
	
	@Mock
	private DnaRepository dnaRepository;
	
	@InjectMocks
	private MutantServiceImpl mutantService;
	
	
	@Test
	void testStatsMutantIsZero() {
		when(dnaRepository.getDnaByValidationMutant(null)).thenReturn(0);
		when(dnaRepository.getDnaByValidationMutant(true)).thenReturn(0);
		assertEquals(MutantStats.builder().countHumanDna(0).countMutantDna(0).ratio(0f).build(), mutantService.getMutantStats());
	}
	
	@Test
	void testStatsMutant() {
		when(dnaRepository.getDnaByValidationMutant(null)).thenReturn(10);
		when(dnaRepository.getDnaByValidationMutant(true)).thenReturn(2);
		assertEquals(MutantStats.builder().countHumanDna(10).countMutantDna(2).ratio(0.2f).build(), mutantService.getMutantStats());
	}
	
	@Test
	void testIsMutant() {
		String dna[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		assertEquals(true, mutantService.isMutant(dna));
	}
	
	@Test
	void testSaveDna() {
		String dna[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Dna dnaEntity= Dna.builder().cadenaDna(dna).validacionMutante(true).build();
		when(dnaRepository.save(dnaEntity)).thenReturn(dnaEntity);
		assertEquals(dnaEntity, mutantService.saveDna(dna, true));
	}
	
	

}
