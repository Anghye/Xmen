package com.xmen.delegate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.xmen.delegate.impl.MutantDelegateImpl;
import com.xmen.dto.MutantStats;
import com.xmen.service.IMutantService;

class MutantDelegateTest {
	
	@Mock
	private IMutantService mutantService;
	
	@InjectMocks
	private MutantDelegateImpl mutantDelegate;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	void testIsMutant() {
		String dna[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		IMutantService mutantServiceSpy= Mockito.spy(mutantService);
		Mockito.doReturn(true).when(mutantServiceSpy).isMutant(dna);
		mutantDelegate.isMutant(dna);
		Mockito.verify(mutantService).isMutant(dna);
	}
	
	@Test
	void testStatsMutant() {
		IMutantService mutantServiceSpy= Mockito.spy(mutantService);
		Mockito.doReturn(MutantStats.builder().countHumanDna(1).countMutantDna(1).ratio(1f).build()).when(mutantServiceSpy).getMutantStats();
		mutantDelegate.getMutantStats();
		Mockito.verify(mutantService).getMutantStats();
		
	}

}
