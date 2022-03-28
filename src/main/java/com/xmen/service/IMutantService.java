package com.xmen.service;

import com.xmen.dto.MutantStats;
import com.xmen.entity.Dna;

public interface IMutantService {

	/**
	 * Method to validate DNA mutant
	 * @param adn
	 * @return boolean
	 * @author  Anghye Plata
	 */
	boolean isMutant(String[] adn);
	
	/**
	 * Method to get mutant stats
	 * @return MutantStats
	 * @author  Anghye Plata
	 */
	MutantStats getMutantStats();
	
	/**
	 * Method to save DNA
	 * @param adn
	 * @param validacion
	 * @author Anghye Plata
	 */
	Dna saveDna(String[] dna, boolean isMutant);

}
