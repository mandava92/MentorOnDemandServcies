package com.mentorondemand.user.core;

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
	@ExceptionHandler(ProgramException.class)
	public @ResponseBody Map<String, String> conflict(ProgramException exception, HttpServletRequest request) {
		Map<String, String> response = new HashMap<String, String>();
		String message = messageSource.getMessage(exception.getMessage(), exception.getArguments(), Locale.US);
		response.put("error", message);
		return response;
	}
}
