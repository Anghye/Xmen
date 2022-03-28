package com.xmen.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.xmen.delegate.IMutantDelegate;
import com.xmen.dto.MutantStats;
import com.xmen.dto.RequestDna;

public class MutantControllerTest {
	
	@Mock
	private IMutantDelegate mutantDelegate;
	
	@InjectMocks
	private MutantController mutantController;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	void testIsMutant() {
		String dna[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		IMutantDelegate mutantServiceSpy= Mockito.spy(mutantDelegate);
		Mockito.doReturn(true).when(mutantServiceSpy).isMutant(dna);
		mutantController.isMutant(RequestDna.builder().adn(dna).build());
		Mockito.verify(mutantDelegate).isMutant(dna);
		
	}
	
	@Test
	void testStatsMutant() {
		IMutantDelegate mutantServiceSpy= Mockito.spy(mutantDelegate);
		Mockito.doReturn(MutantStats.builder().countHumanDna(1).countMutantDna(1).ratio(1f).build()).when(mutantServiceSpy).getMutantStats();
		mutantController.getMutantStats();
		Mockito.verify(mutantDelegate).getMutantStats();
		
	}
	
	

}
