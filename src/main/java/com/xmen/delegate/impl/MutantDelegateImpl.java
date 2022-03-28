package com.xmen.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmen.delegate.IMutantDelegate;
import com.xmen.dto.MutantStats;
import com.xmen.service.IMutantService;

@Service
public class MutantDelegateImpl implements IMutantDelegate{
	
	@Autowired
	private IMutantService mutanteService;
 
	@Override
	public boolean isMutant(String[] adn) {
		boolean isMutant= mutanteService.isMutant(adn);
		mutanteService.saveDna(adn, isMutant);
		return isMutant;
	}
	
	@Override
	public MutantStats getMutantStats() {
		return mutanteService.getMutantStats();
	}

}
