package com.education.error;

import java.net.http.HttpRequest;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.education.models.ResponseErrorModel;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(AppError.class)
	public ResponseEntity<ResponseErrorModel> execute(AppError e, HttpServletRequest request) {
		ResponseErrorModel error = new ResponseErrorModel();
		error.setMessage(e.getMsg());
		error.setTimestamp(Instant.now());
		error.setPatch(request.getRequestURI());
		error.setStatus(e.getStatus().value());
		return ResponseEntity.status(e.getStatus().value()).body(error);
	}
}
