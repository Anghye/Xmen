package com.xmen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmen.delegate.IMutantDelegate;
import com.xmen.dto.MutantStats;
import com.xmen.dto.RequestDna;

import io.swagger.annotations.*;


@RequestMapping("/api/xmen")
@RestController
@CrossOrigin
public class MutantController {
	
	@Autowired
	private IMutantDelegate mutanteDelegate;
	
	
	
	@PostMapping("/mutant")
	@ApiOperation(value = "Method to validate DNA", notes = "Method to validate DNA")
	public boolean isMutant(@RequestBody RequestDna adn) {
		return mutanteDelegate.isMutant(adn.getAdn());
	}
	
	
	@GetMapping("/stats")
	@ApiOperation(value = "Method to get stats of mutant", notes = "Method to get stats of mutant")
	public MutantStats getMutantStats() {
		return mutanteDelegate.getMutantStats();
	}

}
