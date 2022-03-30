package com.xmen.controller.advisor;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xmen.dto.NoData;
import com.xmen.exception.XmenException;

@RestControllerAdvice
public class XmenAdvisor {
	
	@ExceptionHandler(XmenException.class)
	public ResponseEntity<NoData> handle(XmenException exception) {
			return ResponseEntity.status(exception.getStatus()).body(null);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<NoData> handle(DataAccessException exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(null);
	}

}
