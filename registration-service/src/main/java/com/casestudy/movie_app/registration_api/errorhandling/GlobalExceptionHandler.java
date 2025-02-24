package com.casestudy.movie_app.registration_api.errorhandling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
				.getAllErrors().stream()
				.map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
