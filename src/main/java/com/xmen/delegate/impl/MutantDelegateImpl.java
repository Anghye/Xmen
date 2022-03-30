package com.xmen.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmen.delegate.IMutantDelegate;
import com.xmen.dto.MutantStats;
import com.xmen.exception.XmenException;
import com.xmen.service.IMutantService;

@Service
public class MutantDelegateImpl implements IMutantDelegate{
	
	@Autowired
	private IMutantService mutanteService;
 
	@Override
	public boolean isMutant(String[] adn) {
		boolean isMutant = mutanteService.isMutant(adn);
		if (isMutant) {
			mutanteService.saveDna(adn, isMutant);
			return isMutant;
		}
		throw new XmenException(HttpStatus.FORBIDDEN);
	}
	
	

	@Override
	public MutantStats getMutantStats() {
		return mutanteService.getMutantStats();
	}

}
