package com.mentorondemand.user.core;

public class ProgramException extends RuntimeException{

	private Object []arguments = new Object[0];

	public ProgramException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgramException(String messageCode, String... messageArguments) {
		super(messageCode);
		this.arguments = messageArguments;
	}

	public ProgramException(String message) {
		super(message);
	}

	public Object[] getArguments() {
		return arguments;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}


}
