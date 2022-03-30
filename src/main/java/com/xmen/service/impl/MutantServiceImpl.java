package com.xmen.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmen.dto.MutantStats;
import com.xmen.entity.Dna;
import com.xmen.repository.DnaRepository;
import com.xmen.service.IMutantService;

@Service
public class MutantServiceImpl implements IMutantService{
	
	@Autowired
	private DnaRepository dnaRepository;
	

	@Override
	public boolean isMutant(String[] adn) {
		int count = 0;
        List<String> listAdn = getLinesDna(adn);
        for (String cadena : listAdn) {
            Pattern pat = Pattern.compile("([ATCG])\\1{3,}");
            Matcher mat = pat.matcher(cadena);
            count = mat.find() ? ++count : count;
            if(count>2) {
            	return true;
            }
        }
        return false;
	}
	
	@Override
	public MutantStats getMutantStats() {
		Integer total= dnaRepository.getDnaByValidationMutant(null);
		Integer mutant= dnaRepository.getDnaByValidationMutant(true);
		float ratio= total!=0? (float)mutant/total:0f;
		return MutantStats.builder().countHumanDna(total).countMutantDna(mutant).ratio(ratio).build();
		
	}

	@Override
	public Dna saveDna(String[] dna, boolean isMutant) {
		Dna dnaEntity= Dna.builder().cadenaDna(dna).validacionMutante(isMutant).build();
		return dnaRepository.save(dnaEntity);
	}

	/**
	 * Method to get the lines of the DNA
	 * @param adn
	 * @return List<String>
	 * @author  Anghye Plata
	 */
	private  List<String> getLinesDna(String[] adn) {
        List<String> lineasAdn= new ArrayList<>();
        lineasAdn.addAll(getListVertical(adn));
        lineasAdn.addAll(getListOblique(adn));
        lineasAdn.addAll(Arrays.asList(adn));
        return lineasAdn;
    }

	/**
	 * Method to get the vertical lines of the DNA
	 * @param adn
	 * @return List<String>
	 * @author  Anghye Plata
	 */
    private List<String> getListVertical(String[] adn) {
        List<String> listVertical= new ArrayList<>();
        for (int j = 0; j < adn[0].length(); j++) {
        	StringBuilder vertical = new StringBuilder();
            for (String cadena : adn) {
                vertical.append(cadena.charAt((cadena.length() - 1) - j));
            }
            listVertical.add(vertical.toString());
        }
        return listVertical;
    }

    /**
     * Method to get the oblique lines of the DNA
     * @param adn
     * @return List<String>
     * @author  Anghye Plata
     */
    private List<String> getListOblique(String[] adn) {
        int altura = adn.length;
        int ancho = adn[0].length();
        List<String> listO= new ArrayList<>();
        for ( int d = 1 - ancho; d <= altura - 1; d += 1) {
            StringBuilder obliquo = new StringBuilder();
            for (int v = Math.max(0, d), h = -Math.min(0, d); v < altura && h< ancho; v += 1, h += 1) {
                obliquo.append(adn[v].charAt(h));
            }
            listO.add(obliquo.toString());
        }
        return listO;
    }

}
