package com.lti.mod.searchservice.exception;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionControllerAdvice {
	
	@Autowired
	MessageSource messageSource;
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(IndexFailed.class)
	public @ResponseBody Map<String, String> indexFailed(IndexFailed exception, HttpServletRequest request) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("error", exception.getMessage());
		return response;
	}
}
