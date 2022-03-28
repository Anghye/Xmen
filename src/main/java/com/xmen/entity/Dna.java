package com.xmen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="DNA")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dna {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name= "cadena_dna")
	private String[] cadenaDna;
	
	@Column(name="validacion_mutante", columnDefinition = "BOOLEAN")
	private boolean validacionMutante;
	
	
	
	
	

}
