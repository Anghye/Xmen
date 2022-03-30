package com.xmen.delegate;

import org.springframework.http.HttpStatus;

import com.xmen.dto.MutantStats;

public interface IMutantDelegate {

	/**
	 * Method to validate DNA mutant
	 * @param adn
	 * @return {@link HttpStatus}
	 * @author  Anghye Plata
	 */
	boolean isMutant(String[] adn);

	/**
	 * Method to get mutant stats
	 * @return MutantStats
	 * @author  Anghye Plata
	 */
	MutantStats getMutantStats();

}
