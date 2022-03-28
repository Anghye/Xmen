package com.xmen.delegate;

import com.xmen.dto.MutantStats;

public interface IMutantDelegate {

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

}
