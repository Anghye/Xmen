package com.xmen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Data
@Builder
public class MutantStats {
	
	private Integer countMutantDna;
	
	private Integer countHumanDna;
	
	private float ratio;

}
